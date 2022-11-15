package test.com.bari.gestionecorsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bari.gestionecorsi.architecture.dao.CorsistaCorsoDAO;
import com.bari.gestionecorsi.architecture.dao.CorsistaDAO;
import com.bari.gestionecorsi.architecture.dao.CorsoDAO;
import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.architecture.dbaccess.DBAccess;
import com.bari.gestionecorsi.businesscomponent.model.Corsista;
import com.bari.gestionecorsi.businesscomponent.model.CorsistaCorso;
import com.bari.gestionecorsi.businesscomponent.model.Corso;
import com.bari.gestionecorsi.businesscomponent.utilities.ControlloPosti;

class CorsistaCorsoDAOTest {
	private static Corsista corsista;
	private static Corso corso;	
	private static CorsistaCorso corsistaCorso;
	private static Connection conn;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//CORSISTA CREATE
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setIdCorsista(1);
		corsista.setNomeCorsista("Giovanni");
		corsista.setCognomeCorsista("Moccia");
		corsista.setPrecedentiCorsista("SI");
		System.out.println("Creato corsista: "+corsista.toString());
		//CORSO CREATE
		corso = new Corso();
		corso.setIdCorso(1);
		corso.setNomeCorso("Java DevOps");
		corso.setDataInizioCorso(new GregorianCalendar(2022, 9, 27).getTime());
		corso.setDataFineCorso(new GregorianCalendar(2023, 1, 13).getTime());
		corso.setCostoCorso(500);
		corso.setCommentiCorso("Academy formazione java");
		corso.setAulaCorso("2a");
		corso.setPostiDisponibili(10);
		corso.setIdDocente(1);
		System.out.println("Creato corso: "+corso.toString());
		//CORSISTACORSO CREATE
		corsistaCorso = new CorsistaCorso();
		corsistaCorso.setIdCorsista(1);
		corsistaCorso.setIdCorso(1);
	}
	
	@Test
	void testCreate() {
		try{
			CorsistaDAO.getFactory().create(conn, corsista);
			CorsoDAO.getFactory().create(conn, corso);
			CorsistaCorsoDAO.getFactory().create(conn, corsistaCorso);
			System.out.println("Creata tabella: "+corsistaCorso.toString());
			int posti = 0;
			ControlloPosti controllo = new ControlloPosti();
			posti = controllo.controllaPosti(1);
			System.out.println(posti);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CorsoDAO.getFactory().delete(conn, corso);
			System.out.println("Eliminato corso: "+corso.toString());
			CorsistaDAO.getFactory().delete(conn, corsista);
			System.out.println("Eliminato corsista: "+corsista.toString());
			DBAccess.closeConnection();
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}

}
