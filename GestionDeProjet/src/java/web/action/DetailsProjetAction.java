/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import metier.entites.Projet;
import metier.entites.Tache;
import metier.services.ProjetService;
import metier.services.TacheService;

/**
 *
 * @author vincent
 */
public class DetailsProjetAction implements Action {

	private int idProjet;

	public DetailsProjetAction(int idProjet) {
		this.idProjet = idProjet;
	}

	public String execute(HttpServletRequest request) {
		if (idProjet > 0) {
			Projet leProjet = new ProjetService().detailsProjet(idProjet);
			List<Tache> lesTaches = new TacheService().detailsTachesProjet(idProjet);
			request.setAttribute("projet", leProjet);
			request.setAttribute("taches", lesTaches);
		}

		return "projet/vueDetailsProjet.jsp";
	}

}
