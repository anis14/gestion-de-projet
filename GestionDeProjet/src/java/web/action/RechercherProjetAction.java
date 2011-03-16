/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import métier.entités.Projet;
import métier.services.ProjetService;

/**
 *
 * @author Thorgrim
 */
public class RechercherProjetAction implements Action {

	public String execute(HttpServletRequest request) {
		List<Projet> lesProjets = null;

		if (request.getParameter("rechercheProjet") == null)
		{
			lesProjets = new ProjetService().recupererProjets();
			request.setAttribute("lesProjets", lesProjets);
		}
		
		return "vueRechercheProjet.jsp";
	}
}
