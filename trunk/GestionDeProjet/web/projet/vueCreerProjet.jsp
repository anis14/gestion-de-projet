<%-- 
    Document   : vueCreerProjet
    Created on : 22 févr. 2011, 17:36:02
    Author     : vincent
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<label for="numProjet">Num&eacute;ro du projet</label> : <input type="text" id="numProjet" name="numProjet" /><br />
			Responsable :
			<c:set var="employes" value="${lesEmployes}"/>
			<select name="responsable" id="responsable">
				<c:forEach var="e" items="${employes}">
					<option value="${e.id}">
						${e.nom} ${e.prenom}
					</option>
				</c:forEach>
			</select>
			<br />
			<label for="libelle">Libell&eacute;</label> : <input type="text" id="libelle" name="libelle" /><br />
			<label for="chargesPrevues">Charges pr&eacute;vues (jours hommes)</label> : <input type="text" id="chargesPrevues" name="chargesPrevues" /><br /><br />
			Archiver : 
			<input type="radio" id="archOui" name="archiver" value="oui" /> <label for="archOui">Oui</label>
			<input type="radio" id="archNon" name="archiver" value="non" checked="checked" /> <label for="archNon">Non</label><br /><br />
			<label for="comm">Commentaire</label> :<br />
			<textarea cols="50" rows="10" id="comm" name="comm"></textarea>
			<br /><br />
			<input type="submit" value="Enregistrer" name="btnSave" onclick="return confirm('Confirmer l\'enregistrement ?')" />
			<input type="reset" value="Annuler" name="btnReset" />
		</form>
		<br /><br /><a href="../index.jsp">Accueil</a>
    </body>
</html>
