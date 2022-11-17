<%@page import="com.bari.gestionecorsi.businesscomponent.model.Corso"%>
<%@page
	import="com.bari.gestionecorsi.businesscomponent.facade.AdminFacade"%>
<%
int i = 1;
if (session.getAttribute("admin") != null) {
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
					<a href="logout.jsp">Logout <i class="bi bi-door-closed-fill"></i></a>
				</p>
			</div>
			<div class="navd">
				<p class="link">
					<a class="active" href="inserisci.jsp">Inserisci Corsista</a>
				</p>
				<p class="link">
					<a href="admin.jsp">Visualizza Statistiche</a>
				</p>
				<p class="link">
					<a href="#">Elimina Corsi</a>
				</p>
			</div>
		</div>
	</nav>
</header>
<body>

	<div class="container">

		<header class="page-header">
			<h3>Inserire i dati per la registrazione</h3>
		</header>
		<form
			action="/<%=application.getServletContextName()%>/aggiungiCorsista"
			method="post" class="form-horizontal" id="userForm">
			<div class="form-group">
				<label class="col-md-1 control-label">Nome</label>

				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input type="text"
							name="nome_corsista" id="nome_corsista" placeholder="Nome..."
							class="form-control">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Cognome</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input type="text"
							name="cognome_corsista" id="cognome_corsista"
							placeholder="Cognome..." class="form-control">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Precedenti</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="form-check form-check-inline">
						<input type="radio" name="precedenti" value="si" id="precedentiSi"
							class="form-check-input"><label for="precedentiSi"
							class="form-check-label">Si</label>
					</div>
					<div class="form-check form-check-inline">
						<input type="radio" name="precedenti" value="no" id="precedentiNo"
							class="form-check-input"><label for="precedentiNo"
							class="form-check-label">No</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Corso</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <select class="form-select"
							aria-label="Default select example">
							<option selected disabled>Corsi disponibili</option>
							<%
							Corso[] corsi = AdminFacade.getInstance().getCorsi();
							for (Corso c : corsi) {
							%>
							<option value="<%=c.getIdCorso()%>"><%=c.getNomeCorso()%></option>
							<%
							}
							%>
						</select>
					</div>
				</div>
			</div>



			<!-- div class row azzera la griglia row crando una nuova riga con una nuova griglia -->

			<div class="row">
				<div class="col-md-4 col-md-offset-1" style="margin-top: 1em;">
					<button type="submit" class="btn btn-warning">
						Registra Corsista&nbsp;&nbsp;<span
							class="glyphicon glyphicon-send"></span>
					</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
<%
} else {
response.sendRedirect("nonloggato.jsp");
}
%>