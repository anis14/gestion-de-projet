<%-- 
    Document   : vueEditerProjet
    Created on : 22 févr. 2011, 17:34:55
    Author     : vincent
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edition d'un projet</title>
    </head>
    <body>
        <h1>Edition d'un projet</h1>
		<c:set var="projet" value="${projet}"/>
		<form method="POST" action="../GestionProjetServlet?action=editerProjet&projet=${projet.id}">
			<label for="numProjet">Num&eacute;ro du projet</label> : <input type="text" id="numProjet" name="numProjet" value="${projet.numero}" /><br />
			Responsable :
			<c:set var="employes" value="${lesEmployes}"/>
			<select name="responsable" id="responsable">
				<c:forEach var="e" items="${employes}">
					<c:if test="${projet.responsable.id == e.id}">
						<option value="${e.id}" selected="selected">
							${e.nom} ${e.prenom}
						</option>
					</c:if>
					<c:if test="${projet.responsable.id != e.id}">
						<option value="${e.id}">
							${e.nom} ${e.prenom}
						</option>
					</c:if>
				</c:forEach>
			</select>
			<br />
			<label for="libelle">Libell&eacute;</label> : <input type="text" id="libelle" name="libelle" value="${projet.libelle}" /><br />
			<label for="chargesPrevues">Charges pr&eacute;vues (jours hommes)</label> : <input type="text" id="chargesPrevues" name="chargesPrevues" value="${projet.chargeGlobalPrevue}" /><br />
			<label for="chargesConsommees">Charges consomm&eacute;es (jours hommes)</label> : <input type="text" id="chargesConsommees" name="chargesConsommees" value="${projet.chargeGlobalConsommee}" />
			<br /><br />
			Archiver :
			<c:if test="${projet.archivage == 'non'}">
				<input type="radio" id="archOui" name="archiver" value="oui" /> <label for="archOui">Oui</label>
				<input type="radio" id="archNon" name="archiver" value="non" checked="checked" /> <label for="archNon">Non</label><br /><br />
			</c:if>
			<c:if test="${projet.archivage == 'oui'}">
				<input type="radio" id="archOui" name="archiver" value="oui" checked="checked" /> <label for="archOui">Oui</label>
				<input type="radio" id="archNon" name="archiver" value="non" /> <label for="archNon">Non</label><br /><br />
			</c:if>
			<label for="comm">Commentaire</label> :<br />
			<textarea cols="50" rows="10" id="comm" name="comm">${projet.commentaire}</textarea><br/><br />
			<c:if test="${projet.etatProj.etat != 'Terminé' && projet.etatProj.etat != 'Annulé'}">
				<label for="terminer">Terminer le projet</label> : <input type="radio" id="terminer" name="etat" value="terminer" /><br />
				<label for="annuler">Annuler le projet</label> : <input type="radio" id="annuler" name="etat" value="annuler" /><br /><br />
			</c:if>
			<input type="submit" value="Modifier" name="btnEdit" onclick="return confirm('Confirmer les modifications ?')" />
			<input type="reset" value="Annuler" name="btnReset" />
		</form>
		<br /><br />
		<a href="GestionProjetServlet?action=detailsProjet&projet=${projet.id}">Retour aux d&eacute;tails</a><br />
		<a href="../index.jsp">Accueil</a>
    </body>
</html>
