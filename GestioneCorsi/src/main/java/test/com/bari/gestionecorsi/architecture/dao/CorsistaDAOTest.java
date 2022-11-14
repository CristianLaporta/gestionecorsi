package test.com.bari.gestionecorsi.architecture.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.bari.gestionecorsi.architecture.dao.CorsistaDAO;
import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.architecture.dbaccess.DBAccess;
import com.bari.gestionecorsi.businesscomponent.model.Corsista;




class CorsistaDAOTest {
	private static Corsista corsista;
	private static Connection conn;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setIdCorsista(6);
		corsista.setNomeCorsista("Giovanni");
		corsista.setCognomeCorsista("Moccia");
		corsista.setPrecedentiCorsista("SI");
	}
	
	@Test
	@Order(1)
	void testCreate() {
		try{
			CorsistaDAO.getFactory().create(conn, corsista);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testUpdateGetByID() {
		try{
			corsista = new Corsista();
			corsista.setIdCorsista(6);
			corsista.setNomeCorsista("Marco");
			corsista.setCognomeCorsista("S20");
			corsista.setPrecedentiCorsista("NO");
			CorsistaDAO.getFactory().update(conn, corsista);
			System.out.println("Aggiornato corsista: ");
			Corsista cors = CorsistaDAO.getFactory().getById(conn, 6);
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
			Corsista[] corsisti = CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(corsisti);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CorsistaDAO.getFactory().delete(conn, corsista);
			System.out.println("Eliminato corsista: ");
			DBAccess.closeConnection();
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
		
	}
	

}
