/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.services;

import java.util.List;
import metier.dao.ProjetDAO;
import metier.entites.Etat;
import metier.entites.Projet;

/**
 *
 * @author vincent
 */
public class ProjetService {

	public List<Projet> recupererProjets(List<Etat> etats, String archive) {
		return new ProjetDAO().recupererProjets(etats, archive);
	}

	public List<Projet> rechercherProjetsParNumero(String num, List<Etat> etats, String archive) {
		return new ProjetDAO().rechercherProjetsParNumero(num, etats, archive);
	}

	public List<Projet> rechercherProjetsParResp(String resp, List<Etat> etats, String archive) {
		return new ProjetDAO().rechercherProjetsParResp(resp, etats, archive);
	}

	public Projet detailsProjet(int id) {
		return new ProjetDAO().detailsProjet(id);
	}

	public Projet enregistrerProjet(Projet unProjet) {
		unProjet.setChargeGlobalConsommee(0);
		unProjet.setEtatProj(Etat.INIT);
		
		return new ProjetDAO().enregistrerProjet(unProjet);
	}

}
