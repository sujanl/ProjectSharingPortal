package com.javaboys.projectSharingPortol.utility;

import java.util.Base64;

public class PasswordEncryptDecrypt {
	public static String doEncrypt(String password) {
		byte[] encryptedPassword = Base64.getEncoder().encode(password.getBytes());
		return new String(encryptedPassword);
		
	}
	public static String doDecrypt(String encryptedPassword) {
		byte[] password= Base64.getDecoder().decode(encryptedPassword.getBytes());
		return new String(password);
	}
}
