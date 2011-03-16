<%-- 
    Document   : vueCreerProjet
    Created on : 22 févr. 2011, 17:36:02
    Author     : vincent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cr&eacute;ation d'un projet</title>
    </head>
    <body>
        <h1>Cr&eacute;ation d'un projet</h1>
		<form method="POST" action="../GestionProjetServlet?action=creerProjet">
			<label for="nomProjet">Nom du projet</label> : <input type="text" id="nomProjet" name="nomProjet"/><br />
			<label for="chargesPrevues">Charges prévues (jours hommes)</label> : <input type="text" id="chargesPrevues" name="chargesPrevues"/><br />
			<input type="submit" value="Enregistrer" name="btnSave"/>
			<input type="reset" value="Annuler" name="btnReset"/>
		</form>
    </body>
</html>
