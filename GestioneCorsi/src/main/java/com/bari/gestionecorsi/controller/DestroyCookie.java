package com.bari.gestionecorsi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

@WebServlet("/logOut")
public class DestroyCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DestroyCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());		

			Cookie ck = new Cookie("userLogged", "false");
	        response.addCookie(ck); 
		        System.out.println("CookieDestroied: " + ck.getName() + " " + ck.getValue());
		        	response.sendRedirect("index.jsp");
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
