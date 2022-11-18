package com.bari.gestionecorsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import com.bari.gestionecorsi.architecture.dao.CorsoDAO;
import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.architecture.dbaccess.DBAccess;
import com.bari.gestionecorsi.businesscomponent.idgenerator.CorsoIdGenerator;
import com.bari.gestionecorsi.businesscomponent.model.Corso;

public class CorsoBC {
	private Connection conn;
	
	public CorsoBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(Corso corso) throws DAOException, ClassNotFoundException, IOException {
		corso.setIdCorso(CorsoIdGenerator.getInstance().getNextId());
		CorsoDAO.getFactory().create(conn, corso);
	}
	
	public void update(Corso corso) throws DAOException {
		CorsoDAO.getFactory().update(conn, corso);
	}
	
	public void delete(Corso corso) throws DAOException {
		CorsoDAO.getFactory().delete(conn, corso);
	}
	
	public Corso getById(long id) throws DAOException {
		return CorsoDAO.getFactory().getById(conn, id);
	}
	
	public Corso[] getCorsi() throws DAOException {
		return CorsoDAO.getFactory().getAll(conn);
	}
	
	public int getPostiCorso(long id) throws DAOException {
		return CorsoDAO.getFactory().getPosti(conn, id);
	}
	
	public Date getUltimoCorso() throws DAOException {
		return CorsoDAO.getFactory().getUltimoCorso(conn);
	}
}
