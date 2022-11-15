package com.bari.gestionecorsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.bari.gestionecorsi.architecture.dao.CorsistaDAO;
import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.architecture.dbaccess.DBAccess;
import com.bari.gestionecorsi.businesscomponent.model.Corsista;
public class CorsistaCorsoBC {
	
		
		private Connection conn;
		
		public CorsistaCorsoBC() throws ClassNotFoundException, DAOException, IOException {
			conn = DBAccess.getConnection();
		}
		
		
		public void Update(Corsista corsista) throws DAOException, ClassNotFoundException, IOException {	
			CorsistaDAO.getFactory().update(conn, corsista); 
		}

		public Corsista[] getArticoli() throws DAOException {
			return CorsistaDAO.getFactory().getAll(conn);
		}
		
		public void delete(Corsista corsista) throws DAOException {
			CorsistaDAO.getFactory().delete(conn, corsista);
		}

		public Corsista findById (long id) throws DAOException {
			return CorsistaDAO.getFactory().getById(conn, id);
		}

}
