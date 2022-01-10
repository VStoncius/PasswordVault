# Password Vault

This is a demo project by Vilius Stoncius. 

You can create users and save passwords for your websites using this application.

All API calls made to localhost:8080/users/** do not require authentication (to let you create a user or check if one exists). 
However to create or delete a password you need to authenticate against
***localhost:8080/users/authenticate*** with valid username and password combination to receive JWT token, which will be used to authenticate while calling 
localhost:8080/passwords/** APIs. JWT token is valid for 15 minutes. After which you will need to call localhost:8080/users/authenticate again. 

User passwords are saved in hased form, while website passwords are encrypted before saving to database using symmetric-key encryption.

Database source, server port, password encryption/decryption secrets as well as JWT secret can be configured by editing application.yml file

For testing you can import ***PasswordVault.postman_collection.json*** file into postman application.
