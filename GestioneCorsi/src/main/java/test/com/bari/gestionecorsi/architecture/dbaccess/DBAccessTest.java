package test.com.bari.gestionecorsi.architecture.dbaccess;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.architecture.dbaccess.DBAccess;



public class DBAccessTest {

	@Test
	public void test() {
		try {
			DBAccess.getConnection();
		} catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			fail("errore nel tentativo di connessione: " + e.getMessage());
		} finally {
			try {
				DBAccess.closeConnection();
			} catch (DAOException e) {
				e.printStackTrace();
				fail("errore nella chiusura della connessione: " + e.getMessage());
			}
		}
	}

}
