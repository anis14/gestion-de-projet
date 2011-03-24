/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
		String archive;
		Action classeAction = null;
		List<Etat> lesEtats = new ArrayList<Etat>();

		if (request.getParameterValues("etatRecherche") != null) {
			String[] etats = request.getParameterValues("etatRecherche");

			for (int i = 0; i < etats.length; i++) {
				Etat unEtat = Etat.valueOf(etats[i]);
				lesEtats.add(unEtat);
			}
		} else {
			lesEtats.add(Etat.ENCOURS);
		}

		if (request.getParameter("archivage") != null) {
			archive = "oui";
		} else {
			archive = "non";
		}

		if (action.equalsIgnoreCase("ajouterTache"))
			classeAction = new AjouterTacheAction();
		else if (action.equalsIgnoreCase("creerProjet"))
			classeAction = new CreerProjetAction();
		else if (action.equalsIgnoreCase("detailsProjet"))
			classeAction = new DetailsProjetAction(Integer.parseInt(request.getParameter("projet")));
		else if (action.equalsIgnoreCase("detailsTache"))
			classeAction = new DetailsTacheAction();
		else if (action.equalsIgnoreCase("editerProjet"))
			classeAction = new EditerProjetAction();
		else if (action.equalsIgnoreCase("afficherProjet") || request.getParameter("rechercheProjet").isEmpty())
			classeAction = new RechercherProjetAction("", lesEtats, archive);
		else if (action.equalsIgnoreCase("rechercherProjet") && !request.getParameter("rechercheProjet").isEmpty()
				&& request.getParameter("typeRecherche").equalsIgnoreCase("numero"))
			classeAction = new RechercherProjetAction("numero", lesEtats, archive);
		else if (action.equalsIgnoreCase("rechercherProjet") && !request.getParameter("rechercheProjet").isEmpty()
				&& request.getParameter("typeRecherche").equalsIgnoreCase("responsable"))
			classeAction = new RechercherProjetAction("responsable", lesEtats, archive);
		
		if (classeAction != null)
			vue = classeAction.execute(request);

		RequestDispatcher rd = request.getRequestDispatcher(vue);

		if (rd != null)
			rd.forward(request, response);
	}
	
}
