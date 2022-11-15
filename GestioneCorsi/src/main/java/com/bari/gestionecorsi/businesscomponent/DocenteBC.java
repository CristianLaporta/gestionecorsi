package com.bari.gestionecorsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.architecture.dao.DocenteDAO;
import com.bari.gestionecorsi.architecture.dbaccess.DBAccess;
import com.bari.gestionecorsi.businesscomponent.model.Docente;

public class DocenteBC {
	
	private Connection conn;
	
	public DocenteBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	
	public void Update(Docente docente) throws DAOException, ClassNotFoundException, IOException {	
		DocenteDAO.getFactory().update(conn, docente); 
	}

	public Docente[] getArticoli() throws DAOException {
		return DocenteDAO.getFactory().getAll(conn);
	}
	
	public void delete(Docente docente) throws DAOException {
		DocenteDAO.getFactory().delete(conn, docente);
	}

	public Docente findById (long id) throws DAOException {
		return DocenteDAO.getFactory().getById(conn, id);
	}
}

