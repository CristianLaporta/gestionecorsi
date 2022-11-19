<%@page import="com.bari.gestionecorsi.architecture.dao.DAOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
</head>
<body class="align">
	<p class="thome">
		<a href="index.jsp"><i class="bi bi-arrow-left-circle-fill"></i>
			Torna alla Home</a>
	</p>
	<div class="gradient"></div>
	<video autoplay muted loop id="myVideo">
		<source src="assets/video/backgroundlogin.mp4" type="video/mp4">
	</video>
	<%
		if(exception instanceof ClassNotFoundException) {
	%>
	<div class="card" style="width: 18rem;">
		<div class="card-body">
			<h5 class="card-title">Driver non trovato/supportato</h5>
			<h6 class="card-subtitle mb-2 text-muted"
				style="border-top: 2px solid #000; padding-top: 10px;"><%= exception.getClass().getName()%></h6>
			<p class="card-text">Motivo:&nbsp;<%= exception.getMessage() %></p>
		</div>
	</div>
	<%
		} else if(exception instanceof DAOException) {
	%>
	<div class="card" style="width: 18rem;">
		<div class="card-body">
			<h5 class="card-title">Eccezione SQL</h5>
			<h6 class="card-subtitle mb-2 text-muted"
				style="border-top: 2px solid #000; padding-top: 10px;"><%= exception.getClass().getName() %></h6>
			<p class="card-text">Motivo:&nbsp;<%= exception.getMessage() %></p>
		</div>
	</div>
	<%
		} else {
	%>
	<div class="card" style="width: 18rem;">
		<div class="card-body">
			<h5 class="card-title">Eccezione non prevista</h5>
			<h6 class="card-subtitle mb-2 text-muted"
				style="border-top: 2px solid #000; padding-top: 10px;"><%= exception.getClass().getName() %></h6>
			<p class="card-text">Motivo:&nbsp;<%= exception.getMessage() %></p>
			<p class="card-text">StackTrace:&nbsp;<% exception.printStackTrace(new PrintWriter(out)); %></p>
		</div>
	</div>
	<%
		}
	%>
</body>
</html>