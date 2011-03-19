<%-- 
    Document   : vueRechercherProjet
    Created on : 22 févr. 2011, 17:35:47
    Author     : vincent
--%>

<%@page import="metier.entites.Projet"%>
<%@page import="java.util.List"%>
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
			<select name="etatRecherche" id="etatRecherche">
				<option value="INIT">Initi&eacute;</option>
				<option value="ENCOURS" selected="selected">En cours</option>
				<option value="TERMINE">Termin&eacute;</option>
				<option value="ANNULE">Annul&eacute;</option>
			</select>
			<select name="typeRecherche" id="typeRecherche">
				<option value="numero" selected="selected">Num&eacute;ro</option>
				<option value="responsable">Responsable</option>
			</select>
			<input type="text" name="rechercheProjet" id="rechercheProjet"/>
			<input type="submit" value="Rechercher" name="btnSearch"/>
		</form><br />
		<% List<Projet> projets = (List<Projet>)request.getAttribute("lesProjets");
			if (projets != null) { %>
				<table border="1px">
					<thead>
						<tr>
							<th>Num&eacute;ro</th>
							<th>Responsable</th>
							<th>Charge pr&eacute;vue</th>
							<th>Charge consomm&eacute;e</th>
							<th>D&eacute;tail</th>
						</tr>
					</thead>
					<tbody>
				<% for (Projet p : projets) { %>
					<tr>
						<td><% out.println(p.getNumero()); %></td>
						<td><% out.println(p.getResponsable().getInitiales()); %></td>
						<td><% out.println(p.getChargeGlobalPrevue()); %></td>
						<td><% out.println(p.getChargeGlobalConsommee()); %></td>
						<td><a href="">D&eacute;tail</a></td>
					</tr>
				<% } %>
				</tbody>
				</table>
			<% } %>
		<br /><br /><a href="../index.jsp">Accueil</a>
    </body>
</html>
