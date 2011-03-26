<%-- 
    Document   : vueConfirmerCreerProjet
    Created on : 16 mars 2011, 14:30:58
    Author     : Thorgrim
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="metier.entites.Projet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projet enregistré</title>
    </head>
    <body>
        <h3>Le projet a été enregistré avec succés !</h3>
		<c:set var="projet" value="${projet}"/>
		<label style="font-weight: bold">Num&eacute;ro :</label> ${projet.numero}<br />
		<label style="font-weight: bold;">Responsable :</label> ${projet.responsable.initiales}<br />
		<label style="font-weight: bold;">Libell&eacute; :</label> ${projet.libelle}<br />
		<label style="font-weight: bold;">Charges pr&eacute;vues :</label> ${projet.chargeGlobalPrevue}<br />
		<label style="font-weight: bold;">Charges consomm&eacute;es :</label> ${projet.chargeGlobalConsommee}<br />
		<label style="font-weight: bold;">Etat :</label> ${projet.etatProj.etat}<br />
		<label style="font-weight: bold;">Archiver :</label> ${projet.archivage}<br />
		<label style="font-weight: bold;">Commentaire :</label> ${projet.commentaire}
		<br /><br /><a href="../index.jsp">Accueil</a>
    </body>
</html>
