<%@page import="com.bari.gestionecorsi.businesscomponent.model.Docente"%>
<%@page import="com.bari.gestionecorsi.businesscomponent.model.Corso"%>
<%@page import="com.bari.gestionecorsi.businesscomponent.facade.AdminFacade"%>
<%
	if(session.getAttribute("admin") != null){	
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- CSS only -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/admin.css">
<title>Corsi con Posti Disponibili</title>
</head>
<body>
	<header>
		<jsp:include page="nav.jsp" />
	</header>
	<table class="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Data Inizio</th>
				<th>Data Fine</th>
				<th>Costo</th>
				<th>Commenti</th>
				<th>Aula</th>
				<th>Posti Disponibili</th>
				<th>Nome Docente</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody class="table-group-divider">
		<%
			Corso[] corsi = null;
			corsi = AdminFacade.getInstance().getCorsi();
			for (Corso c : corsi) {
				int posti = AdminFacade.getInstance().getPostiOccupati(c.getIdCorso());
				if(posti>0) {
		%>
			<tr>
				<th><%=c.getIdCorso() %></th>
				<th><%=c.getNomeCorso() %></th>
				<th><%=c.getDataInizioCorso() %></th>
				<th><%=c.getDataFineCorso() %></th>
				<th><%=c.getCostoCorso() %></th>
				<th><%=c.getCommentiCorso() %></th>
				<th><%=c.getAulaCorso() %></th>
				<th><%= posti%></th>
				<%
					Docente d = AdminFacade.getInstance().getDocenteById(c.getIdDocente());
				%>
				<th><%= d.getNomeDocente() %> </th>
				<th>
					<form action="/<%= application.getServletContextName()%>/rimuoviCorso?id=<%= c.getIdCorso() %>" method="post">
						<button type="submit" class="btn btn-danger btn-sm">
							<span class="glyphicon glyphicon-trash"> Elimina</span>
						</button>
					</form>
				</th>
			</tr>
		</tbody>
		<%
				}
			}
		%>
	</table>
</body>
</html>
<%
	} else {
		response.sendRedirect("nonloggato.jsp");
		}
%>
