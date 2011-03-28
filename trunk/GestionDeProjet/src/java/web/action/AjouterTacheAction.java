/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import javax.servlet.http.HttpServletRequest;
import metier.entites.Projet;
import metier.services.ProjetService;

/**
 *
 * @author vincent
 */
public class AjouterTacheAction implements Action {
	
	private int idProjet;
	private String type;

	public AjouterTacheAction(int idProjet, String type) {
		this.idProjet = idProjet;
		this.type = type;
	}

	public String execute(HttpServletRequest request) {
		if (type.equalsIgnoreCase("vue")) {
			Projet leProjet = new ProjetService().recupererProjetParId(idProjet);
			request.setAttribute("projet", leProjet);

			return "tache/vueAjouterTache.jsp";
		} else if (type.equalsIgnoreCase("edit")) {
		}

		return "";
	}

}
