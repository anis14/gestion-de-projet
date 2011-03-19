/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.entites.Etat;
import web.action.*;

/**
 *
 * @author Thorgrim
 */
public class GestionProjetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String vue = "index.jsp";
		Action classeAction = null;
		Etat etat;

		if (request.getParameter("etatRecherche") == null) {
			etat = Etat.ENCOURS;
		} else {
			etat = Etat.valueOf(request.getParameter("etatRecherche"));
		}

		if (action.equalsIgnoreCase("ajouterTache"))
			classeAction = new AjouterTacheAction();
		else if (action.equalsIgnoreCase("creerProjet"))
			classeAction = new CreerProjetAction();
		else if (action.equalsIgnoreCase("detailsProjet"))
			classeAction = new DetailsProjetAction();
		else if (action.equalsIgnoreCase("detailsTache"))
			classeAction = new DetailsTacheAction();
		else if (action.equalsIgnoreCase("editerProjet"))
			classeAction = new EditerProjetAction();
		else if (action.equalsIgnoreCase("afficherProjet") || request.getParameter("rechercheProjet").isEmpty())
			classeAction = new RechercherProjetAction("", etat);
		else if (action.equalsIgnoreCase("rechercherProjet") && !request.getParameter("rechercheProjet").isEmpty()
				&& request.getParameter("typeRecherche").equalsIgnoreCase("numero"))
			classeAction = new RechercherProjetAction("numero", etat);
		else if (action.equalsIgnoreCase("rechercherProjet") && !request.getParameter("rechercheProjet").isEmpty()
				&& request.getParameter("typeRecherche").equalsIgnoreCase("responsable"))
			classeAction = new RechercherProjetAction("responsable", etat);
		
		if (classeAction != null)
			vue = classeAction.execute(request);

		RequestDispatcher rd = request.getRequestDispatcher(vue);

		if (rd != null)
			rd.forward(request, response);
	}
	
}