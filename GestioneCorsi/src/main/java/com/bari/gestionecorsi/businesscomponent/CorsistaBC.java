package com.bari.gestionecorsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.bari.gestionecorsi.architecture.dao.CorsistaDAO;
import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.architecture.dbaccess.DBAccess;
import com.bari.gestionecorsi.businesscomponent.idgenerator.CorsistaIdGenerator;
import com.bari.gestionecorsi.businesscomponent.model.Corsista;




public class CorsistaBC {
	private Connection conn;
	
	public CorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public void createOrUpdate(Corsista corsista) throws ClassNotFoundException, IOException, DAOException {
		if (corsista.getIdCorsista() > 0)
			CorsistaDAO.getFactory().update(conn, corsista);
		else {
			corsista.setIdCorsista(CorsistaIdGenerator.getInstance().getNextId());
			CorsistaDAO.getFactory().create(conn, corsista);
		}
	}
	
	public void delete(Corsista corsista) throws DAOException {
		CorsistaDAO.getFactory().delete(conn, corsista);
	}
	
	public Corsista[] getAll() throws DAOException {
		return CorsistaDAO.getFactory().getAll(conn);
	}
	
	public Corsista getById(long id) throws DAOException {
		return CorsistaDAO.getFactory().getById(conn, id);
	}
	
}

