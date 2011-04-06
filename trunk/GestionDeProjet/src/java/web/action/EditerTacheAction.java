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
import metier.entites.Employe;
import metier.entites.Etat;
import metier.entites.Nature;
import metier.entites.Projet;
import metier.entites.Tache;
import metier.services.EmployeService;
import metier.services.ProjetService;
import metier.services.TacheService;

/**
 *
 * @author Thorgrim
 */
public class EditerTacheAction implements Action {

	private String type;
	private int idTache;
	private int idProjet;

	public EditerTacheAction(int idTache, int idProjet, String type) {
		this.idTache = idTache;
		this.idProjet = idProjet;
		this.type = type;
	}

	public String execute(HttpServletRequest request) {
		if (type.equalsIgnoreCase("vue")) {
			Projet leProjet = new ProjetService().recupererProjetParId(idProjet);
			Tache laTache = new TacheService().recupererTacheParId(idTache);

			SimpleDateFormat formatDate = new SimpleDateFormat("ddMMyyyy");
			String date = formatDate.format(laTache.getDateDebut());
			String jour = "";
			String mois = "";

			if (date.charAt(0) != '0')
				jour = date.substring(0, 2);
			else
				jour = date.substring(1, 2);

			if (date.charAt(2) != '0')
				mois = date.substring(2, 4);
			else
				mois = date.substring(3, 4);

			String annee = date.substring(4);

			List<Employe> lesEmployes = new EmployeService().recupererEmployes();
			List<Nature> lesNatures = new TacheService().recupererNatures();
			request.setAttribute("projet", leProjet);
			request.setAttribute("tache", laTache);
			request.setAttribute("jour", jour);
			request.setAttribute("mois", mois);
			request.setAttribute("annee", annee);
			request.setAttribute("lesNatures", lesNatures);
			request.setAttribute("lesEmployes", lesEmployes);

			return "tache/vueEditerTache.jsp";
		} else if (type.equalsIgnoreCase("edit")) {
			Employe lEmploye = new EmployeService().recupererEmployeParId(Integer.parseInt(request.getParameter("employe")));
			Nature laNature = new TacheService().recupererNatureParId(Integer.parseInt(request.getParameter("nature")));
			Projet leProjet = new ProjetService().recupererProjetParId(Integer.parseInt(request.getParameter("projet")));

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
				laTache.setId(Integer.parseInt(request.getParameter("tache")));
				laTache.setChargeEffective(Double.parseDouble(request.getParameter("chargeEff")));
				laTache.setChargePrevisionnelle(Double.parseDouble(request.getParameter("chargePrevue")));
				laTache.setConsomme(Integer.parseInt(request.getParameter("consomme")));
				laTache.setDateDebut(date);
				laTache.setDescriptif(request.getParameter("desc"));
				laTache.setEmploye(lEmploye);
				laTache.setNature(laNature);
				laTache.setProjet(leProjet);
				laTache.setRemarque(request.getParameter("rq"));

			String etat = request.getParameter("etat");

			if (etat != null && etat.equalsIgnoreCase("terminer"))
				laTache.setEtatTache(Etat.TERMINE);
			else if (etat != null && etat.equalsIgnoreCase("annuler"))
				laTache.setEtatTache(Etat.ANNULE);
			else if(laTache.getConsomme() == 0)
				laTache.setEtatTache(Etat.INIT);
			else if (laTache.getConsomme() > 0)
				laTache.setEtatTache(Etat.ENCOURS);

			List<Tache> lesTaches = new TacheService().detailsTachesProjet(leProjet.getId());
			Tache tache = new TacheService().editerTache(laTache);

			if (tache != null) {
				request.setAttribute("taches", lesTaches);
				request.setAttribute("projet", leProjet);
			}

			return "projet/vueDetailsProjet.jsp";
		}

		return "";
	}

}
