<%-- 
    Document   : vueDetailsProjet
    Created on : 22 févr. 2011, 17:35:32
    Author     : vincent
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>D&eacute;tail projet</title>
    </head>
    <body>
		<c:set var="projet" value="${projet}"/>
        <h1>D&eacute;tail du projet ${projet.numero}</h1>
		Num&eacute;ro : ${projet.numero}<br />
		Responsable : ${projet.responsable.initiales}<br />
		Etat : ${projet.etatProj.etat}
		<h1>D&eacute;tail des t&acirc;ches</h1>
		<table border="1px">
			<thead>
				<tr>
					<th>Nature</th>
					<th>Employ&eacute;</th>
					<th>Charge pr&eacute;vue</th>
					<th>Charge effectu&eacute;e</th>
					<th>P&eacute;riode</th>
					<th>% consomm&eacute;</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<br /><br />
		<a href="GestionProjetServlet?action=editerProjetVue&projet=${projet.id}">Editer projet</a><br />
		<a href="../index.jsp">Accueil</a>
    </body>
</html>
