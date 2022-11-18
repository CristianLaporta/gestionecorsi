<%@page import="com.bari.gestionecorsi.businesscomponent.model.Docente"%>
<%@page
	import="com.bari.gestionecorsi.businesscomponent.facade.AdminFacade"%>
<%
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
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/admin.css">
<title>Inserisci Corsi</title>
</head>
<body>
	<header>
		<jsp:include page="nav.jsp" />
	</header>
	<div class="container">
		<header class="page-header">
			<h3>Inserire i dati per aggiungere nuovo corso</h3>
		</header>
		<form action="/<%=application.getServletContextName()%>/aggiungiCorso"
			method="post" class="form-horizontal" id="userForm">
			<div class="form-group">
				<label class="col-md-1 control-label">Nome</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-text"><i class="bi bi-person"></i></span>
						<input type="text" name="nome" id="nome" placeholder="Nome..."
							class="form-control">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Data Inizio</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group date">
						<span class="input-group-text"><i
							class="bi bi-calendar-day"></i></span> <input type="date"
							name="dataInizio" placeholder="DD/MM/YYYY" class="form-control"
							id="dataInizio">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Data Fine</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group date">
						<span class="input-group-text"><i
							class="bi bi-calendar-day"></i></span> <input type="date"
							name="dataFine" placeholder="DD/MM/YYYY" class="form-control"
							id="dataFine">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Costo</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-text"><i
							class="bi bi-currency-euro"></i></span> <input type="number"
							name="costo" placeholder="Costo..." class="form-control"
							id="costo">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Commenti</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-text"><i class="bi bi-body-text"></i></span>
						<input type="text" name="commenti" placeholder="Commenti..."
							class="form-control" id="commenti">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Aula</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-text"><i class="bi bi-hospital"></i></span>
						<input type="text" name="aula" placeholder="Aula..."
							class="form-control" id="aula">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Posti</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-text"><i class="bi bi-door-open"></i></span>
						<input type="number" name="posti" value="12" class="form-control"
							id="posti" disabled>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Docente</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-text"><i class="bi bi-person"></i></span>
						<select class="form-select" aria-label="Default select example"
							name="idDocente">
							<option selected disabled>Docenti disponibili</option>
							<%
							Docente[] docenti = AdminFacade.getInstance().getDocenti();
							for (Docente c : docenti) {
							%>
							<option value="<%=c.getIdDocente()%>"><%=c.getNomeDocente()%></option>
							<%
							}
							%>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 col-md-offset-1" style="margin-top: 1em;">
					<button type="submit" class="btn btn-warning">
						Inserisci Corso&nbsp;&nbsp;<span class="glyphicon glyphicon-send"></span>
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