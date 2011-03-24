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

	private String type, archive;
	private List<Etat> etats;

	public RechercherProjetAction(String type, List<Etat> etats, String archive) {
		this.type = type;
		this.etats = etats;
		this.archive = archive;
	}

	public String execute(HttpServletRequest request) {
		List<Projet> lesProjets = null;

		if (type.equalsIgnoreCase("")) {
			lesProjets = new ProjetService().recupererProjets(etats, archive);
			request.setAttribute("lesProjets", lesProjets);
		} else if (type.equalsIgnoreCase("numero")) {
			lesProjets = new ProjetService().rechercherProjetsParNumero(request.getParameter("rechercheProjet"), etats, archive);
			request.setAttribute("lesProjets", lesProjets);
		} else if (type.equalsIgnoreCase("responsable")) {
			lesProjets = new ProjetService().rechercherProjetsParResp(request.getParameter("rechercheProjet"), etats, archive);
			request.setAttribute("lesProjets", lesProjets);
		}
		
		return "projet/vueRechercherProjet.jsp";
	}
}
