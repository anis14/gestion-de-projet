<%-- 
    Document   : vueRechercherProjet
    Created on : 22 févr. 2011, 17:35:47
    Author     : vincent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rechercher un projet</title>
    </head>
    <body>
        <h1>Rechercher un projet</h1>
		<form method="POST" action="GestionProjetServlet?action=rechercherProjet">
			<input type="text" name="rechercheProjet" id="rechercheProjet"/>
			<input type="submit" value="Rechercher" name="btnSearch"/>
		</form>
    </body>
</html>
