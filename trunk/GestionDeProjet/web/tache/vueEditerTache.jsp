<%-- 
    Document   : vueEditerTache
    Created on : 22 févr. 2011, 17:37:13
    Author     : vincent
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edition d'une tache</title>
    </head>
    <body>
		<c:set var="tache" value="${tache}"/>
		<c:set var="p" value="${projet}"/>
        <h1>Edition d'une tache</h1>
		<form method="POST" action="../GestionProjetServlet?action=editerTache&tache=${tache.id}&projet=${p.id}">
			Nature :
			<select name="nature" id="nature">
				<c:forEach var="n" items="${lesNatures}">
					<c:if test="${tache.nature.id == n.id}">
						<option value="${n.id}" selected="selected">${n.code}</option>
					</c:if>
					<c:if test="${tache.nature.id != n.id}">
						<option value="${n.id}">${n.code}</option>
					</c:if>
				</c:forEach>
			</select>
			<br />
			<label for="desc">Description</label> : <input type="text" name="desc" id="desc" value="${tache.descriptif}" /><br />
			Employ&eacute; :
			<select name="employe" id="employe">
				<c:forEach var="e" items="${lesEmployes}">
					<c:if test="${tache.employe.id == e.id}">
						<option value="${e.id}" selected="selected">${e.initiales}</option>
					</c:if>
					<c:if test="${tache.employe.id != e.id}">
						<option value="${e.id}">${e.initiales}</option>
					</c:if>
				</c:forEach>
			</select>
			<br />
			<label for="chargePrevue">Charge pr&eacute;visionnelle</label> : <input type="text" name="chargePrevue" id="chargePrevue" value="${tache.chargePrevisionnelle}" /><br />
			<label for="chargeEff">Charge effective</label> : <input type="text" name="chargeEff" id="chargeEff" value="${tache.chargeEffective}" /><br />
			<label for="consomme">Consomm&eacute; (en %)</label> : <input type="text" name="consomme" id="consomme" value="${tache.consomme}" /><br />
			<label for="dateDebut">Date début</label> :
			<c:set var="jour" value="${jour}"/>
			<select name="jourD" id="jourD">
				<c:forEach var="i" begin="1" end="31" step="1">
					<c:if test="${jour == i}">
						<option value="${i}" selected="selected">${i}</option>
					</c:if>
					<c:if test="${jour != i}">
						<option value="${i}">${i}</option>${date}
					</c:if>
				</c:forEach>
			</select>
			<c:set var="mois" value="${mois}"/>
			<select name="moisD" id="moisD">
				<c:forEach var="i" begin="1" end="12" step="1">
					<c:if test="${mois == i}">
						<option value="${i}" selected="selected">${i}</option>
					</c:if>
					<c:if test="${mois != i}">
						<option value="${i}">${i}</option>
					</c:if>
				</c:forEach>
			</select>
			<c:set var="annee" value="${annee}"/>
			<select name="anneeD" id="anneeD">
				<c:forEach var="i" begin="2011" end="2100" step="1">
					<c:if test="${annee == i}">
						<option value="${i}" selected="selected">${i}</option>
					</c:if>
					<c:if test="${annee != i}">
						<option value="${i}">${i}</option>
					</c:if>
				</c:forEach>
			</select>
			<br />
			<label for="rq">Remarque</label> :<br />
			<textarea cols="50" rows="10" id="rq" name="rq">${tache.remarque}</textarea><br /><br />
			<c:if test="${tache.etatTache.etat != 'Terminé' && tache.etatTache.etat != 'Annulé'}">
				<label for="terminer">Terminer le projet</label> : <input type="radio" id="terminer" name="etat" value="terminer" /><br />
				<label for="annuler">Annuler le projet</label> : <input type="radio" id="annuler" name="etat" value="annuler" /><br /><br />
			</c:if>
			<input type="submit" value="Modifier" name="btnEdit" onclick="return confirm('Confirmer les modifications ?')" />
			<input type="reset" value="Annuler" name="btnReset" />
		</form>
		<br /><br />
		<a href="GestionProjetServlet?action=detailsProjet&projet=${p.id}">Retour aux d&eacute;tails</a><br />
		<a href="../index.jsp">Accueil</a>
    </body>
</html>
