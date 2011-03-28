<%-- 
    Document   : vueAjouterTache
    Created on : 22 févr. 2011, 17:37:03
    Author     : vincent
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter une tache</title>
    </head>
    <body>
		<c:set var="p" value="${projet}"/>
        <h1>Ajouter une tache au projet ${p.numero}</h1>
		<form method="POST" action="../GestionProjetServlet?action=ajouterTache">
			Nature :
			<select name="nature" id="nature">
				<option value=""></option>
			</select>
			<br /><br />
			<input type="submit" value="Ajouter" name="btnAdd" onclick="return confirm('Confirmer l\'ajout ?')" />
			<input type="reset" value="Annuler" name="btnReset" />
		</form>
    </body>
</html>
