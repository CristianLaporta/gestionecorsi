package test.com.bari.gestionecorsi.businesscomponent.security;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bari.gestionecorsi.businesscomponent.security.Algoritmo;

class AlgoritmoTest {

	@Test
	void testConversione() {
		String pass = Algoritmo.convertiMD5("password");
		assertNotNull(pass);
		System.out.println(pass);
	}
}
