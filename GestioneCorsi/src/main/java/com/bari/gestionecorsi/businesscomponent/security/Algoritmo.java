package com.bari.gestionecorsi.businesscomponent.security;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Algoritmo {
	public static String convertiMD5(String password) {
		try {
			// oggetto di java Security
			MessageDigest md = MessageDigest.getInstance("MD5");// con metodo getInstance prende il nome dell'algoritmo
																// da utilizzare
			// viene restituito array di byte
			byte[] array = md.digest(password.getBytes(Charset.forName("UTF-8")));// charset non è indispensabile ma può
																					// essere utile se ho un charset
																					// personalizzato
			StringBuffer buffer = new StringBuffer();
			// regola del sale: stringa casuale e complessa con caratteri non ripetuti. si
			// usa insieme all'agoritmo in quanto potrebbe essere facilemte recuperabile con
			// reverse enginering
			String salt = "Rd6$1NpW9i7sL%3Tx";
			for(int i=0;i<array.length;i++) {
				buffer.append(String.format("%x", array[i])+salt.toCharArray()[i]);
			}
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
}
