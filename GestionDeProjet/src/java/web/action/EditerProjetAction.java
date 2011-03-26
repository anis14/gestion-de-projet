/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import metier.entites.Employe;
import metier.entites.Etat;
import metier.entites.Projet;
import metier.services.EmployeService;
import metier.services.ProjetService;

/**
 *
 * @author vincent
 */
public class EditerProjetAction implements Action {

	private String type;

	public EditerProjetAction(String type) {
		this.type = type;
	}

	public String execute(HttpServletRequest request) {
		if (type.equalsIgnoreCase("vue")) {
			int idProjet = Integer.parseInt(request.getParameter("projet"));
			Projet leProjet = new ProjetService().recupererProjetParId(idProjet);
			List<Employe> lesEmployes = new EmployeService().recupererResponsables();
			request.setAttribute("lesEmployes", lesEmployes);
			request.setAttribute("projet", leProjet);

			return "projet/vueEditerProjet.jsp";
		} else if (type.equalsIgnoreCase("edit")) {
			Employe unEmploye = new Employe();
				unEmploye.setId(Integer.parseInt(request.getParameter("responsable")));

			Projet leProjet = new Projet();
				leProjet.setId(Integer.parseInt(request.getParameter("projet")));
				leProjet.setNumero(request.getParameter("numProjet"));
				leProjet.setResponsable(unEmploye);
				leProjet.setLibelle(request.getParameter("libelle"));
				leProjet.setChargeGlobalPrevue(Double.parseDouble(request.getParameter("chargesPrevues")));
				leProjet.setChargeGlobalConsommee(Double.parseDouble(request.getParameter("chargesConsommees")));
				leProjet.setArchivage(request.getParameter("archiver"));
				leProjet.setCommentaire(request.getParameter("comm"));

			String etat = request.getParameter("etat");

			if (etat != null && etat.equalsIgnoreCase("terminer"))
				leProjet.setEtatProj(Etat.TERMINE);
			else if (etat != null && etat.equalsIgnoreCase("annuler"))
				leProjet.setEtatProj(Etat.ANNULE);
			else if (leProjet.getChargeGlobalConsommee() == 0)
				leProjet.setEtatProj(Etat.INIT);
			else if (leProjet.getChargeGlobalConsommee() > 0)
				leProjet.setEtatProj(Etat.ENCOURS);

			Projet projet = new ProjetService().editerProjet(leProjet);
			request.setAttribute("projet", projet);

			return "projet/vueDetailsProjet.jsp";
		}

		return "";
	}
}
