package com.bari.gestionecorsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.bari.gestionecorsi.architecture.dao.CorsistaCorsoDAO;
import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.architecture.dbaccess.DBAccess;
import com.bari.gestionecorsi.businesscomponent.model.CorsistaCorso;

public class CorsistaCorsoBC {
		private Connection conn;
		
		public CorsistaCorsoBC() throws ClassNotFoundException, DAOException, IOException {
			conn = DBAccess.getConnection();
		}
		
		
		public void create(CorsistaCorso corsistaCorso) throws DAOException, ClassNotFoundException, IOException {	
			CorsistaCorsoDAO.getFactory().create(conn, corsistaCorso); 
		}
		
		public int getPostiOccupati(long id) throws DAOException {
			return CorsistaCorsoDAO.getFactory().getPostiOccupati(conn, id);
		}
		
		public int getCorsiFreq(long id) throws DAOException {
			return CorsistaCorsoDAO.getFactory().getCorsiFreq(conn, id);
		}

	

}
