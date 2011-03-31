/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import metier.dao.TacheDAO;
import metier.entites.Etat;
import metier.entites.Nature;
import metier.entites.Projet;
import metier.entites.Tache;

/**
 *
 * @author vincent
 */
public class TacheService {

	public List<Tache> detailsTachesProjet(int idProjet) {
		return new TacheDAO().detailsTachesProjet(idProjet);
	}

	public List<Nature> recupererNatures() {
		return new TacheDAO().recupererNatures();
	}

	public Projet ajouterTache(Tache uneTache) {
		uneTache.setEtatTache(Etat.INIT);
		uneTache.setChargeEffective(0);
		uneTache.setConsomme(0);
		
		Date d = uneTache.getDateDebut();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, (int)uneTache.getChargePrevisionnelle());
		uneTache.setDateFin(c.getTime());

		return new TacheDAO().ajouterTache(uneTache);
	}

	public Nature recupererNatureParId(int idNature) {
		return new TacheDAO().recupererNatureParId(idNature);
	}
	
}
