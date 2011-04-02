/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import metier.dao.EmployeDAO;
import metier.dao.TacheDAO;
import metier.entites.Employe;
import metier.entites.Nature;
import metier.entites.Projet;
import metier.entites.Tache;
import metier.services.EmployeService;
import metier.services.ProjetService;
import metier.services.TacheService;

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
			List<Employe> lesEmployes = new EmployeService().recupererEmployes();
			List<Nature> lesNatures = new TacheService().recupererNatures();
			request.setAttribute("lesNatures", lesNatures);
			request.setAttribute("projet", leProjet);
			request.setAttribute("lesEmployes", lesEmployes);

			return "tache/vueAjouterTache.jsp";
		} else if (type.equalsIgnoreCase("add")) {
			Nature laNature = new TacheService().recupererNatureParId(Integer.parseInt(request.getParameter("nature")));
			Employe lEmploye = new EmployeService().recupererEmployeParId(Integer.parseInt(request.getParameter("employe")));
			Projet leProjet = new Projet();
				leProjet.setId(idProjet);

			String dateDebut = request.getParameter("jourD");
				dateDebut += "-"+request.getParameter("moisD");
				dateDebut += "-"+request.getParameter("anneeD");

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date date = null;
			
			try {
				date = sdf.parse(dateDebut);
			} catch (ParseException ex) {
				Logger.getLogger(AjouterTacheAction.class.getName()).log(Level.SEVERE, null, ex);
			}

			Tache laTache = new Tache();
				laTache.setNature(laNature);
				laTache.setDescriptif(request.getParameter("desc"));
				laTache.setEmploye(lEmploye);
				laTache.setChargePrevisionnelle(Double.parseDouble(request.getParameter("chargePrevu")));
				laTache.setDateDebut(date);
				laTache.setRemarque(request.getParameter("rq"));
				laTache.setProjet(leProjet);

			List<Tache> lesTaches = new TacheService().detailsTachesProjet(idProjet);
			lesTaches.add(laTache);
			leProjet = new TacheService().ajouterTache(laTache);
			request.setAttribute("taches", lesTaches);
			request.setAttribute("projet", leProjet);

			return "projet/vueDetailsProjet.jsp";
		}

		return "";
	}

}
