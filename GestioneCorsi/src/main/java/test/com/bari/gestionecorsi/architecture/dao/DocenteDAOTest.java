package test.com.bari.gestionecorsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.architecture.dao.DocenteDAO;
import com.bari.gestionecorsi.architecture.dbaccess.DBAccess;
import com.bari.gestionecorsi.businesscomponent.model.Docente;

class DocenteDAOTest {

	private static Docente docente;
	private static Connection conn;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		docente = new Docente();
		docente.setIdDocente(5);
		docente.setNomeDocente("Marco");
		docente.setCognomeDocente("Rossi");
		docente.setCvDocente("Docente Java");
	}
	
	@Test
	void testUpdate() {
		try {
			docente = new Docente();
			docente.setIdDocente(5);
			docente.setNomeDocente("Marco");
			docente.setCognomeDocente("Rossi");
			docente.setCvDocente("Docente Angular");
			DocenteDAO.getFactory().update(conn, docente);
			System.out.println("Corso aggiornato:");
			Docente d = DocenteDAO.getFactory().getById(conn, 5);
			System.out.println(d.toString());
		} catch (Exception exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}
	
	@Test
	void testGetAll() {
		try {
			Docente[] docenti = DocenteDAO.getFactory().getAll(conn);
			assertNotNull(docenti);
		} catch (Exception exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			DocenteDAO.getFactory().delete(conn, docente);
			System.out.println("Corso eliminato");
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}

	

}
