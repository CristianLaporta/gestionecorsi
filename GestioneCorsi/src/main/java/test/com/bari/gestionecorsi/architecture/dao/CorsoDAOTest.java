package test.com.bari.gestionecorsi.architecture.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.bari.gestionecorsi.architecture.dao.CorsoDAO;
import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.architecture.dbaccess.DBAccess;
import com.bari.gestionecorsi.businesscomponent.model.Corso;

@TestMethodOrder(OrderAnnotation.class)
class CorsoDAOTest {
	private static Connection conn;
	private static Corso corso;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corso = new Corso();
		corso.setIdCorso(1);
		corso.setNomeCorso("Java DevOps");
		corso.setDataInizioCorso(new GregorianCalendar(2022, 9, 27).getTime());
		corso.setDataFineCorso(new GregorianCalendar(2023, 1, 13).getTime());
		corso.setCostoCorso(500);
		corso.setCommentiCorso("Academy formazione java");
		corso.setAulaCorso("2a");
		corso.setIdDocente(1);

	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			CorsoDAO.getFactory().create(conn, corso);
			System.out.println(corso.toString());
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testUpdate() {
		try{
			corso = new Corso();
			corso.setIdCorso(1);
			corso.setNomeCorso("Java DevOps");
			corso.setDataInizioCorso(new GregorianCalendar(2022, 9, 26).getTime());
			corso.setDataFineCorso(new GregorianCalendar(2023, 1, 14).getTime());
			corso.setCostoCorso(540);
			corso.setCommentiCorso("Academy formazione java");
			corso.setAulaCorso("2a");
			corso.setIdDocente(3);
			CorsoDAO.getFactory().update(conn, corso);
			System.out.println("Aggiornato corsista: ");
			Corso cors = CorsoDAO.getFactory().getById(conn, 1);
			System.out.println(cors.toString());
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
	
	@Test
	@Order(3)
	void testgetAll() {
		try {
			Corso[] corsi = CorsoDAO.getFactory().getAll(conn);
			assertNotNull(corsi);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CorsoDAO.getFactory().delete(conn, corso);
			System.out.println("Eliminato corso");
			DBAccess.closeConnection();
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}

}
