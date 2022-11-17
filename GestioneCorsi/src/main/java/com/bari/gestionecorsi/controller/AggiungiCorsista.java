package com.bari.gestionecorsi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bari.gestionecorsi.businesscomponent.facade.AdminFacade;
import com.bari.gestionecorsi.businesscomponent.model.Corsista;
import com.bari.gestionecorsi.businesscomponent.utilities.Validator;

/**
 * Servlet implementation class AggiungiCorsista
 */
@WebServlet("/aggiungiCorsista")
public class AggiungiCorsista extends HttpServlet {
	private static final long serialVersionUID = 2157686077894055323L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Corsista corsista = getCorsista(request, response);
		if (corsista != null) {
			try {
				AdminFacade.getInstance().createOrUpdate(corsista);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
			response.sendRedirect("admin.jsp");
		}
		
	}
	
	private Corsista getCorsista(HttpServletRequest request, HttpServletResponse response) {
		Corsista corsista = null;
		try {
			long id = 0;
			String nome = request.getParameter("nome_corsista");
			String cognome = request.getParameter("cognome_corsista");
			String precedenti = request.getParameter("precedenti");
			
			if(Validator.getInstance().validString(nome)==true && Validator.getInstance().validString(cognome) == true) {
				System.out.println(id);
				System.out.println(nome);
				System.out.println(cognome);
				System.out.println(precedenti);
				corsista = new Corsista();
				corsista.setNomeCorsista(nome);
				corsista.setCognomeCorsista(cognome);
				corsista.setPrecedentiCorsista(precedenti);
			}else {
				System.out.println("error");
				response.sendRedirect("inserisci.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return corsista;
	}
	
	

}
