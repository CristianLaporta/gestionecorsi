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
<title>Gestione Corsi</title>
</head>
<header>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top navbar">
		<div class="container-fluid">
			<img id="logo" src="assets/img/logo.png" alt="">
			<div class="nav">
				<p class="link">
					<a href="#">
						<i class="bi bi-person-circle"></i>
						 <%= session.getAttribute("admin") %>
					</a>
				</p>
				<p class="link">
					<a href="logout.jsp">Logout <i class="bi bi-door-closed-fill"></i></a>
				</p>
			</div>
			<ul class="navd">
				<li class="link">
					<a href="inserisci.jsp">Inserisci Corsista</a>
				</li>
				<li class="link">
					<a class="active" href="admin.jsp">Visualizza Statistiche</a>
				</li>
				<li class="link dropdown">
					<a class="dropdown-toggle" role="button" data-bs-toggle="dropdown" href="#">Corsi</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="gestiscicorsi.jsp">Gestisci Corsi</a></li>
						<li><a class="dropdown-item" href="inseriscicorsi.jsp">Nuovo Corso</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
</header>
<body>
	
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
		%>
			<tr>
				<th><%=c.getIdCorso() %></th>
				<th><%=c.getNomeCorso() %></th>
				<th><%=c.getDataInizioCorso() %></th>
				<th><%=c.getDataFineCorso() %></th>
				<th><%=c.getCostoCorso() %></th>
				<th><%=c.getCommentiCorso() %></th>
				<th><%=c.getAulaCorso() %></th>
				<th><%=c.getPostiDisponibili() %></th>
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
		%>
	</table>
</body>
</html>
<%
	} else {
		response.sendRedirect("nonloggato.jsp");
		}
%>
