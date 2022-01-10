package com.stone.will.demo.services;

import com.stone.will.demo.persistence.PasswordRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PasswordServiceTest {

    @Mock
    private PasswordRepository passwordRepo;

    @Mock
    private UserService userService;

    @InjectMocks
    private PasswordService passService;

    private String testText = "Labas";

    @Test
    void decrypt() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeySpecException, InvalidKeyException {
        String tmpString = passService.encrypt(testText);
        Assertions.assertEquals("Labas", passService.decrypt(tmpString));
    }
}