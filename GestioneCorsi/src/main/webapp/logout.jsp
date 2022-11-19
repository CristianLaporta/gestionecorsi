<%
	if(session.getAttribute("admin") != null ) {
		session.invalidate();
		Cookie ck = new Cookie("userLogged", "");
        response.addCookie(ck); 
		response.sendRedirect("index.jsp");
	}
%>


