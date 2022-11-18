package com.bari.gestionecorsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.bari.gestionecorsi.businesscomponent.model.Corso;

public class CorsoDAO implements GenericDAO<Corso>, DAOConstants {
	private CachedRowSet rowSet;

	private CorsoDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public static CorsoDAO getFactory() throws DAOException {
		return new CorsoDAO();
	}

	@Override
	public void create(Connection conn, Corso entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getIdCorso());
			rowSet.updateString(2, entity.getNomeCorso());
			rowSet.updateDate(3, new java.sql.Date(entity.getDataInizioCorso().getTime()));
			rowSet.updateDate(4, new java.sql.Date(entity.getDataFineCorso().getTime()));
			rowSet.updateDouble(5, entity.getCostoCorso());
			rowSet.updateString(6, entity.getCommentiCorso());
			rowSet.updateString(7, entity.getAulaCorso());
			rowSet.updateInt(8, entity.getPostiDisponibili());
			rowSet.updateDouble(9, entity.getIdDocente());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, Corso entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_CORSO);
			ps.setString(1, entity.getNomeCorso());
			ps.setDate(2, new java.sql.Date(entity.getDataInizioCorso().getTime()));
			ps.setDate(3, new java.sql.Date(entity.getDataFineCorso().getTime()));
			ps.setDouble(4, entity.getCostoCorso());
			ps.setString(5, entity.getCommentiCorso());
			ps.setString(6, entity.getAulaCorso());
			ps.setLong(7, entity.getIdDocente());
			ps.setInt(8, entity.getPostiDisponibili());
			ps.setLong(9, entity.getIdCorso());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void delete(Connection conn, Corso entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setLong(1, entity.getIdCorso());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Corso getById(Connection conn, long id) throws DAOException {
		Corso corso = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSO_BYID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				corso = new Corso();
				corso.setIdCorso(rs.getLong(1));
				corso.setNomeCorso(rs.getString(2));
				corso.setDataInizioCorso(rs.getDate(3));
				corso.setDataFineCorso(rs.getDate(4));
				corso.setCostoCorso(rs.getDouble(5));
				corso.setCommentiCorso(rs.getString(6));
				corso.setAulaCorso(rs.getString(7));
				corso.setPostiDisponibili(rs.getInt(8));
				corso.setIdDocente(rs.getLong(9));
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corso;
	}

	@Override
	public Corso[] getAll(Connection conn) throws DAOException {
		Corso[] corsi = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSO);
			rs.last();

			corsi = new Corso[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Corso corso = new Corso();
				corso.setIdCorso(rs.getLong(1));
				corso.setNomeCorso(rs.getString(2));
				corso.setDataInizioCorso(rs.getDate(3));
				corso.setDataFineCorso(rs.getDate(4));
				corso.setCostoCorso(rs.getDouble(5));
				corso.setCommentiCorso(rs.getString(6));
				corso.setAulaCorso(rs.getString(7));
				corso.setPostiDisponibili(rs.getInt(8));
				corso.setIdDocente(rs.getLong(9));
				corsi[i] = corso;
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}

	public int getPosti(Connection conn, long id) throws DAOException {
		int posti = 0;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_POSTICORSO);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				posti = rs.getInt(1);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return posti;
	}

	public Date getUltimoCorso(Connection conn) throws DAOException {
		Date data = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_ULTIMOCORSO);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				data = new java.util.Date(rs.getDate(1).getTime());

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return data;
	}
	
	public int getMediaCorsi(Connection conn) throws DAOException {
		int media = 0;
		int conta = 0;
		ArrayList<Integer> giorni = new ArrayList<Integer>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_DATE_MEDIA);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				giorni.add(getWorkingDaysBetweenTwoDates(new java.util.Date(rs.getDate(1).getTime()), new java.util.Date(rs.getDate(2).getTime())));
				System.out.println(new java.util.Date(rs.getDate(1).getTime()) + " "+  new java.util.Date(rs.getDate(2).getTime()));
				conta ++;
				System.out.println(conta);
			}

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		for(int giorno : giorni) {
			media += giorno;
		}
		
		media = media/giorni.size();
		
		return media;
	}

	private int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {

		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int workDays = 0;

		// Return 1 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 1;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do {
			// excluding start date
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++workDays;
			}
		} while (startCal.getTimeInMillis() <= endCal.getTimeInMillis()); // excluding end date

		return workDays;
	}

	
}
