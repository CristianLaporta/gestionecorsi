package com.bari.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.bari.gestionecorsi.businesscomponent.model.Corsista;


public class CorsistaDAO implements GenericDAO<Corsista>, DAOConstants{
private CachedRowSet rowSet;
	
	private CorsistaDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public static CorsistaDAO getFactory() throws DAOException {
		return new CorsistaDAO();
	}
	
	@Override
	public void create(Connection conn, Corsista entity) throws DAOException{
		try {
			rowSet.setCommand(SELECT_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getIdCorsista());
			rowSet.updateString(2, entity.getNomeCorsista());
			rowSet.updateString(3, entity.getCognomeCorsista());
			rowSet.updateString(4, entity.getPrecedentiCorsista());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	@Override
	public void update(Connection conn, Corsista entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_CORSISTA);
			ps.setString(1, entity.getNomeCorsista());
			ps.setString(2,  entity.getCognomeCorsista());
			ps.setString(3,  entity.getPrecedentiCorsista());
			ps.setLong(4, entity.getIdCorsista());
			ps.execute();
			conn.commit();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
	}
	
	@Override
	public void delete(Connection conn, Corsista entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSISTA);
			ps.setLong(1, entity.getIdCorsista());
			ps.execute();
			conn.commit();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	@Override
	public Corsista[] getAll(Connection conn) throws DAOException {
		Corsista[] dCorsista = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTA);
			rs.last();
			
			dCorsista = new Corsista[rs.getRow()];
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				Corsista dc = new Corsista();
				dc.setIdCorsista(rs.getLong(1));
				dc.setNomeCorsista(rs.getString(2));
				dc.setCognomeCorsista(rs.getString(3));
				dc.setPrecedentiCorsista(rs.getString(4));
				dCorsista[i] = dc;
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return dCorsista;
	}

	@Override
	public Corsista getById(Connection conn, long id) throws DAOException {
		return CorsistaDAO.getFactory().getById(conn, id);
	}
	
	
	
}
