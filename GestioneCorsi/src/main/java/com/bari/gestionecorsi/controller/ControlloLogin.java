package com.bari.gestionecorsi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bari.gestionecorsi.businesscomponent.security.Algoritmo;
import com.bari.gestionecorsi.businesscomponent.utilities.Login;

@WebServlet("/controlloLogin")
public class ControlloLogin extends HttpServlet {
	private static int contatore = 5;
	private static final long serialVersionUID = -1671832123101461032L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = Algoritmo.convertiMD5(request.getParameter("password"));
		
		HttpSession session = request.getSession();
		String adminpass = null;
		
		if(username != null && password != null) {
			try {
				Login l = new Login();
				adminpass = l.getAdminPass(username);
				if(adminpass != null) {
					if(adminpass.equals(password)) {
						contatore = 5;
						session.setAttribute("admin", username);
						Cookie ck = new Cookie("userLogged", "true");
						response.addCookie(ck);
						System.out.println("NewCookie: " + ck.getName() + " " + ck.getValue());
						response.sendRedirect("userLogin");
					} else {
						decrementoContatore(session, response);
					}
				} else {
					decrementoContatore(session, response);
				}
			} catch(Exception exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		}
	}
	
	private void decrementoContatore(HttpSession session, HttpServletResponse response) throws ServletException {
		contatore--;
		session.setAttribute("cont", contatore);
		try {
			if(contatore == 0){
				response.sendRedirect("accessonegato.jsp");
				session.invalidate();
				contatore = 5;
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}

}