package com.bari.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.bari.gestionecorsi.businesscomponent.model.Docente;


public class DocenteDAO implements GenericDAO<Docente>, DAOConstants{
	
	public static DocenteDAO getFactory() throws DAOException {
		return new DocenteDAO();
	}

	private CachedRowSet rowSet;
	
	private DocenteDAO() throws DAOException {
		
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void create(Connection conn, Docente entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_DOCENTE);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getIdDocente());
			rowSet.updateString(2, entity.getNomeDocente());	
			rowSet.updateString(3, entity.getCognomeDocente());
			rowSet.updateString(4, entity.getCvDocente());	
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		
	}

	@Override
	public void update(Connection conn, Docente entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_DOCENTE);
			ps.setString(1, entity.getNomeDocente());
			ps.setString(2, entity.getCognomeDocente());
			ps.setString(3, entity.getCvDocente());
			ps.setLong(4, entity.getIdDocente());
			ps.execute();
			conn.commit();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}

	@Override
	public void delete(Connection conn, Docente entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_DOCENTE);
			ps.setLong(1, entity.getIdDocente());
			ps.execute();
			conn.commit();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}

	@Override
	public Docente getById(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Docente[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
