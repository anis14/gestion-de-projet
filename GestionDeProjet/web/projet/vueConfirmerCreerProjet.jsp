<%-- 
    Document   : vueConfirmerCreerProjet
    Created on : 16 mars 2011, 14:30:58
    Author     : Thorgrim
--%>

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
		<% Projet projet = (Projet)request.getAttribute("projet"); %>
		<label style="font-weight: bold">Num&eacute;ro :</label> <% out.println(projet.getNumero()); %><br />
		<label style="font-weight: bold;">Responsable :</label> <% out.println(projet.getResponsable().getInitiales()); %><br />
		<label style="font-weight: bold;">Libell&eacute; :</label> <% out.println(projet.getLibelle()); %><br />
		<label style="font-weight: bold;">Charges pr&eacute;vues :</label> <% out.println(projet.getChargeGlobalPrevue()); %><br />
		<label style="font-weight: bold;">Charges consomm&eacute;es :</label> <% out.println(projet.getChargeGlobalConsommee()); %><br />
		<label style="font-weight: bold;">Etat :</label> <% out.println(projet.getEtatProj().getEtat()); %><br />
		<label style="font-weight: bold;">Archiver :</label> <% out.println(projet.getArchivage()); %><br />
		<label style="font-weight: bold;">Commentaire :</label> <% out.println(projet.getCommentaire()); %>
		<br /><br /><a href="../index.jsp">Accueil</a>
    </body>
</html>
