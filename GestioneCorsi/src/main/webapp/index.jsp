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
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css">
        <title>Home Page</title>
    </head>
    
    <body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark fixed-top navbar">
            <div class="container-fluid">
                <img id="logo" src="assets/img/logo.png" alt="">
                <div class="nav">
                    <p class="link"> <a href="login.jsp">Accedi</a><i class=" bi bi-arrow-right-circle-fill"></i></p>
                </div>
            </div>
        </nav>
    </header>
        <div class="banner">
            <div class="gradient"></div>
            <video autoplay muted loop id="myVideo">
                <source src="assets/video/background.mp4" type="video/mp4">
            </video>
            <h1>Progetto Gestione corsi </h1>
            <h3>Progetto realizzato in Java in modalit&agrave; monolitica, in merito alla gestione di alcuni corsi da parte
                di docenti e corsisti. <br> <br> <button type="button" onclick="window.location.href='about.jsp'"  class="btn btn-outline-primary">Sviluppatori</button>
            </h3>
    
        </div>
    </body>
    <footer>
        <p class="footerc">&copy;Copyright by Betacom, sede: Bari</p>
    </footer>
    
    </html>