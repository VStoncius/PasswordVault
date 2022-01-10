package com.stone.will.demo.services;

import com.stone.will.demo.DTO.GetPasswordRequest;
import com.stone.will.demo.DTO.WebsitePasswordDTO;
import com.stone.will.demo.model.ActiveUser;
import com.stone.will.demo.model.WebSitePassword;
import com.stone.will.demo.persistence.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

@Service
public class PasswordService {

    @Autowired
    private PasswordRepository passwordRepo;

    @Autowired
    private UserService userService;

    private String key = "sugar";

    private IvParameterSpec iv = generateIv();

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    public WebsitePasswordDTO addPassword(String username, WebSitePassword passwordForm) {
        try {
            passwordForm.setPassword(encrypt(passwordForm.getPassword()));
            passwordForm.setOwner(userService.getUser(username));
            passwordRepo.save(passwordForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new WebsitePasswordDTO(passwordForm);
    }

    public void deletePassword(String username, String website) {
        try {
            ActiveUser user = userService.getUser(username);
            WebSitePassword tempPassword = passwordRepo.findByWebsite(website);
            if (tempPassword != null){
                if (tempPassword.getOwner().getId() == user.getId()){
                    passwordRepo.delete(tempPassword);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebsitePasswordDTO getPassword(GetPasswordRequest passwordRequest) {
        WebSitePassword tempPass = null;
        WebsitePasswordDTO response = null;
        try {
            tempPass = passwordRepo.findByWebsite(passwordRequest.getWebsite());
            if (tempPass != null && tempPass.getOwner() != userService.getUser(passwordRequest.getUsername())){
                tempPass = null;
            }
            else{
                response = new WebsitePasswordDTO(tempPass);
                response.setPassword(decrypt(tempPass.getPassword()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public String encrypt(String input) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, getKeyFromPassword(key, "test"), iv);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder()
                .encodeToString(cipherText);
    }

    public String decrypt(String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, getKeyFromPassword(key, "test"), iv);
        byte[] plainText = cipher.doFinal(Base64.getDecoder()
                .decode(cipherText));
        return new String(plainText);
    }

    private static SecretKey getKeyFromPassword(String password, String salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
        SecretKey secret = new SecretKeySpec(factory.generateSecret(spec)
                .getEncoded(), "AES");
        return secret;
    }
}
