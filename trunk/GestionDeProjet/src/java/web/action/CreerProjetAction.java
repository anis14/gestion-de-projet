/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import metier.entites.Employe;
import metier.entites.Projet;
import metier.services.EmployeService;
import metier.services.ProjetService;

/**
 *
 * @author vincent
 */
public class CreerProjetAction implements Action {

	private String type;

	public CreerProjetAction(String type) {
		this.type = type;
	}

	public String execute(HttpServletRequest request) {
		if (type.equalsIgnoreCase("resp")) {
			List<Employe> lesEmployes = new EmployeService().recupererResponsables();
			request.setAttribute("lesEmployes", lesEmployes);

			return "projet/vueCreerProjet.jsp";
		} else if (type.equalsIgnoreCase("proj")) {
			Employe unEmploye = new Employe();
				unEmploye.setId(Integer.parseInt(request.getParameter("responsable")));

			Projet leProjet = new Projet();
				leProjet.setNumero(request.getParameter("numProjet"));
				leProjet.setResponsable(unEmploye);
				leProjet.setLibelle(request.getParameter("libelle"));
				leProjet.setChargeGlobalPrevue(Double.parseDouble(request.getParameter("chargesPrevues")));
				leProjet.setArchivage(request.getParameter("archiver"));
				leProjet.setCommentaire(request.getParameter("comm"));

			leProjet =  new ProjetService().enregistrerProjet(leProjet);
			request.setAttribute("projet", leProjet);

			return "projet/vueConfirmerCreerProjet.jsp";
		}

		return "";
	}
	
}
