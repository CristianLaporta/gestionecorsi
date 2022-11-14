package com.bari.gestionecorsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.architecture.dbaccess.DBAccess;



public class DocenteBC {
	
	private Connection conn;
	
	public DocenteBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

}
