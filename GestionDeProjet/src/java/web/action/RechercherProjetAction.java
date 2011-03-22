/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import metier.entites.Etat;
import metier.entites.Projet;
import metier.services.ProjetService;

/**
 *
 * @author Thorgrim
 */
public class RechercherProjetAction implements Action {

	private String type;
	private Etat etat;

	public RechercherProjetAction(String type, Etat etat) {
		this.type = type;
		this.etat = etat;
	}

	public String execute(HttpServletRequest request) {
		List<Projet> lesProjets = null;

		if (type.equalsIgnoreCase("")) {
			lesProjets = new ProjetService().recupererProjets(etat);
			request.setAttribute("lesProjets", lesProjets);
		} else if (type.equalsIgnoreCase("numero")) {
			lesProjets = new ProjetService().rechercherProjetsParNumero(request.getParameter("rechercheProjet"), etat);
			request.setAttribute("lesProjets", lesProjets);
		} else if (type.equalsIgnoreCase("responsable")) {
			lesProjets = new ProjetService().rechercherProjetsParResp(request.getParameter("rechercheProjet"), etat);
			request.setAttribute("lesProjets", lesProjets);
		}
		
		return "projet/vueRechercherProjet.jsp";
	}
}
