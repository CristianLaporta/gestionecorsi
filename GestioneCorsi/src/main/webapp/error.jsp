<%@page import="com.bari.gestionecorsi.architecture.dao.DAOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
isErrorPage="true"%>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<p class="thome">
	<a href="index.jsp"><i class="bi bi-arrow-left-circle-fill"></i>
		Torna alla Home</a>
</p>
<body class="align">
	<div class="gradient"></div>
	<video autoplay muted loop id="myVideo">
		<source src="assets/video/backgroundlogin.mp4" type="video/mp4">
	</video>
	<div class="grid">
<div class="container">
	<div class="page-header">
		<h3>Pagina di errore</h3>
	</div>
<%
	if(exception instanceof ClassNotFoundException) {
%>

<div class="panel panel-danger">
	<div class="panel-heading">
		<h5>Driver non trovato/supportato</h5>
	</div>
	<div class="panel-body">
     	<h5><%= exception.getClass().getName() %></h5>
	<p>Motivo:&nbsp;<%= exception.getMessage() %></p>
	<button onclick="window.history.back()" class="btn btn-default">Indietro</button>
	</div>
</div>
</div>

<%
	} else if(exception instanceof DAOException) {
%>
<div class="panel panel-danger">
	<div class="panel-heading">
		<H5>Eccezione SQL</H5>
	</div>
	<div class="panel-body">
    <h5><%= exception.getClass().getName() %></h5>
	<p>Motivo:&nbsp;<%= exception.getMessage() %></p>
	<button onclick="window.history.back()" class="btn btn-default">Indietro</button>
	</div>
</div>
</div>
<%
	} else {
%>
<div class="panel panel-danger">
	<div class="panel-heading">
		<h5>Eccezione non prevista</h5>
	</div>
	<div class="panel-body">
    <h5><%= exception.getClass().getName() %></h5>
	<p>Motivo:&nbsp;<%= exception.getMessage() %></p>
	<p>StackTrace:&nbsp;<% exception.printStackTrace(new PrintWriter(out)); %></p>
	</div>
</div>
<%
	}
%>


</body>
</html>
