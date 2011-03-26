<%-- 
    Document   : vueRechercherProjet
    Created on : 22 févr. 2011, 17:35:47
    Author     : vincent
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<input type="checkbox" name="etatRecherche" id="INIT" value="INIT" /> <label for="INIT">Initi&eacute;</label>
			<input type="checkbox" name="etatRecherche" id="ENCOURS" value="ENCOURS" checked="checked" /> <label for="ENCOURS">En cours</label>
			<input type="checkbox" name="etatRecherche" id="TERMINE" value="TERMINE" /> <label for="TERMINE">Termin&eacute;</label>
			<input type="checkbox" name="etatRecherche" id="ANNULE" value="ANNULE" /> <label for="ANNULE">Annul&eacute;</label>
			<input type="checkbox" name="archivage" id="ARCHIVE" value="oui" /> <label for="ARCHIVE">Archiv&eacute;</label><br />
			<select name="typeRecherche" id="typeRecherche">
				<option value="numero" selected="selected">Num&eacute;ro</option>
				<option value="responsable">Responsable</option>
			</select>
			<input type="text" name="rechercheProjet" id="rechercheProjet" />
			<input type="submit" value="Rechercher" name="btnSearch" />
		</form><br />
		<c:set var="projets" value="${lesProjets}"/>
		<table border="1px">
			<thead>
				<tr>
					<th>Num&eacute;ro</th>
					<th>Libell&eacute;</th>
					<th>Responsable</th>
					<th>Charge pr&eacute;vue</th>
					<th>Charge consomm&eacute;e</th>
					<th>Etat</th>
					<th>D&eacute;tail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${projets}">
				<tr>
					<td>
						<c:if test="${p.archivage == 'oui'}">
							<label style="color: red">
						</c:if>
						<c:if test="${p.archivage == 'non'}">
							<label>
						</c:if>
						${p.numero}</label>
					</td>
					<td>
						<c:if test="${p.archivage == 'oui'}">
							<label style="color: red">
						</c:if>
						<c:if test="${p.archivage == 'non'}">
							<label>
						</c:if>
						${p.libelle}</label>
					</td>
					<td>
						<c:if test="${p.archivage == 'oui'}">
							<label style="color: red">
						</c:if>
						<c:if test="${p.archivage == 'non'}">
							<label>
						</c:if>
						${p.responsable.initiales}</label>
					</td>
					<td>
						<c:if test="${p.archivage == 'oui'}">
							<label style="color: red">
						</c:if>
						<c:if test="${p.archivage == 'non'}">
							<label>
						</c:if>
						${p.chargeGlobalPrevue}</label>
					</td>
					<td>
						<c:if test="${p.archivage == 'oui'}">
							<label style="color: red">
						</c:if>
						<c:if test="${p.archivage == 'non'}">
							<label>
						</c:if>
						${p.chargeGlobalConsommee}</label>
					</td>
					<td>
						<c:if test="${p.archivage == 'oui'}">
							<label style="color: red">
						</c:if>
						<c:if test="${p.archivage == 'non'}">
							<label>
						</c:if>
						${p.etatProj.etat}</label>
					</td>
					<td><a href="GestionProjetServlet?action=detailsProjet&projet=${p.id}">D&eacute;tail</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<label style="font-size: 9pt; font-style: italic;">Une ligne en rouge signifie que le projet est archivé.</label>
		<br /><br /><a href="../index.jsp">Accueil</a>
    </body>
</html>
