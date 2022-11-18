package com.bari.gestionecorsi.businesscomponent.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bari.gestionecorsi.architecture.dao.DAOException;
import com.bari.gestionecorsi.businesscomponent.facade.AdminFacade;
import com.bari.gestionecorsi.businesscomponent.model.Docente;

public class Validator {
	private static Validator valid;

	private Validator() {
	}

	public static Validator getInstance() {
		if (valid == null)
			valid = new Validator();
		return valid;
	}
	
	
	public boolean validString(String string) {
		Pattern p = Pattern.compile("[a-zA-Z]{1,30}", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(string);
		boolean b = m.matches();
		return b;
	}
	
	public boolean validDate(Date data) {
		Pattern p = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\\d\\d", Pattern.CASE_INSENSITIVE); //^\\d{2}/\\d{2}/\\d{4}$
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String dataF = df.format(data);
		Matcher m = p.matcher(dataF);
		boolean b = m.matches();
		return b;
	}
	
	public boolean validComment(String string) {
		Pattern p = Pattern.compile("(\\w)(\\s+)([\\.,]){1,200}", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(string);
		boolean b = m.matches();
		return b;
	}
	
	public boolean validAula(String string) {
		Pattern p = Pattern.compile("(\\w)(\\s+)([\\.,]){1,30}", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(string);
		boolean b = m.matches();
		return b;
	}
	
	public boolean validDocente(Docente doc) throws ClassNotFoundException, DAOException, IOException {
		long id = doc.getIdDocente();
		if (AdminFacade.getInstance().getDocenteById(id) != null)
			return true;
		return false;
	}

}

