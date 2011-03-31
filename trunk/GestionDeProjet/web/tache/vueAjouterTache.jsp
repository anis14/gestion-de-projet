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
		<form method="POST" action="../GestionProjetServlet?action=ajouterTache&projet=${p.id}">
			<c:if test="${p.numero != 'DDT'}">
				Nature :
				<select name="nature" id="nature">
					<c:forEach var="n" items="${lesNatures}">
						<option value="${n.id}">${n.code}</option>
					</c:forEach>
				</select>
			</c:if>
			<c:if test="${p.numero == 'DDT'}">
				<input type="hidden" name="nature" id="nature" value="15" />
			</c:if>
			<br />
			<label for="desc">Description</label> : <input type="text" name="desc" id="desc" /><br />
			Employe : 
			<select name="employe" id="employe">
				<c:forEach var="e" items="${lesEmployes}">
					<option value="${e.id}">${e.initiales}</option>
				</c:forEach>
			</select>
			<br />
			<label for="chargePrevu">Charge prévisionnelle</label> : <input type="text" name="chargePrevu" id="chargePrevu" /><br />
			<label for="dateDebut">Date début</label> :
			<select name="jourD" id="jourD">
				<c:forEach var="i" begin="1" end="31" step="1">
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
			<select name="moisD" id="moisD">
				<c:forEach var="i" begin="1" end="12" step="1">
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
			<select name="anneeD" id="anneeD">
				<c:forEach var="i" begin="2011" end="2100" step="1">
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
			<br />
			<label for="rq">Remarque</label> :<br />
			<textarea cols="50" rows="10" id="rq" name="rq"></textarea>
			<br /><br />
			<input type="submit" value="Ajouter" name="btnAdd" onclick="return confirm('Confirmer l\'ajout ?')" />
			<input type="reset" value="Annuler" name="btnReset" />
		</form>
		<br /><br />
		<a href="GestionProjetServlet?action=detailsProjet&projet=${p.id}">Retour aux d&eacute;tails</a><br />
		<a href="../index.jsp">Accueil</a>
    </body>
</html>
