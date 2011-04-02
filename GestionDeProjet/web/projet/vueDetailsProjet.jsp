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
		Responsable : ${projet.responsable.nom} ${projet.responsable.prenom}<br />
		Etat : ${projet.etatProj.etat}<br />
		Libell&eacute; : ${projet.libelle}<br />
		Charges pr&eacute;vues : ${projet.chargeGlobalPrevue}<br />
		Charge(s) consomm&eacute;e(s) : ${projet.chargeGlobalConsommee}<br />
		Commentaire : ${projet.commentaire}<br />
		<h1>D&eacute;tail des t&acirc;ches</h1>
		<table border="1px">
			<thead>
				<tr>
					<th>Nature</th>
					<th>Employ&eacute;</th>
					<th>Charge pr&eacute;vue</th>
					<th>Charge effectu&eacute;e</th>
					<th>Date de d&eacute;but</th>
					<th>Date de fin</th>
					<th>% consomm&eacute;</th>
					<th>Etat</th>
					<th>Descriptif</th>
					<th>Remarque</th>
					<th>Editer</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="t" items="${taches}">
				<tr>
					<td>${t.nature.code}</td>
					<td>${t.employe.initiales}</td>
					<td>${t.chargePrevisionnelle}</td>
					<td>${t.chargeEffective}</td>
					<td>${t.dateDebut.date}-${t.dateDebut.month+1}-${t.dateDebut.year+1900}</td>
					<td>${t.dateFin.date}-${t.dateFin.month+1}-${t.dateFin.year+1900}</td>
					<td>${t.consomme}</td>
					<td>${t.etatTache.etat}</td>
					<td>${t.descriptif}</td>
					<td>${t.remarque}</td>
					<td><a href="GestionProjetServlet?action=editerTacheVue&tache=${t.id}&projet=${projet.id}">Editer</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<br /><br />
		<a href="GestionProjetServlet?action=editerProjetVue&projet=${projet.id}">Editer projet</a><br />
		<a href="GestionProjetServlet?action=ajouterTacheVue&projet=${projet.id}">Ajouter une tache</a><br />
		<a href="../index.jsp">Accueil</a>
    </body>
</html>
