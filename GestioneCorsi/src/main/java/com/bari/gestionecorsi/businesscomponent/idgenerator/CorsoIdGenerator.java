package com.bari.gestionecorsi.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bari.gestionecorsi.architecture.dao.DAOConstants;
import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.architecture.dbaccess.DBAccess;

public class CorsoIdGenerator implements IdGeneratorInterface, DAOConstants{
	private static CorsoIdGenerator idGen;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private CorsoIdGenerator() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public static CorsoIdGenerator getInstance() throws ClassNotFoundException, DAOException, IOException {
		if(idGen == null)
			idGen = new CorsoIdGenerator();
		return idGen;
	}

	@Override
	public long getNextId() throws DAOException, IOException, ClassNotFoundException {
		long id = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_CORSOSEQ);
			rs.next();
			id = rs.getLong(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return id;
	}
}
