package test.com.bari.gestionecorsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.architecture.dao.DocenteDAO;
import com.bari.gestionecorsi.architecture.dbaccess.DBAccess;
import com.bari.gestionecorsi.businesscomponent.model.Docente;

@TestMethodOrder(OrderAnnotation.class)
class DocenteDAOTest {

	private static Docente docente;
	private static Connection conn;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		docente = new Docente();
		docente.setIdDocente(4);
		docente.setNomeDocente("Maria");
		docente.setCognomeDocente("Rossi");
		docente.setCvDocente("Docente Angular");
	}
	
	@Test
	@Order(1)
	void testUpdate() {
		try {
			DocenteDAO.getFactory().update(conn, docente);
			System.out.println("Docente aggiornato:");
			Docente d = DocenteDAO.getFactory().getById(conn, 4);
			System.out.println(d.toString());
		} catch (Exception exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}
	
	
	@Test
	@Order(2)
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
			System.out.println("Docente eliminato");
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}
}
