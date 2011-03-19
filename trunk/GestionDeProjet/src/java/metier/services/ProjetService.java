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

	public List<Projet> recupererProjets(Etat etat) {
		return new ProjetDAO().recupererProjets(etat);
	}

	public List<Projet> rechercherProjetsParNumero(String num, Etat etat) {
		return new ProjetDAO().rechercherProjetsParNumero(num, etat);
	}

	public List<Projet> rechercherProjetsParResp(String resp, Etat etat) {
		return new ProjetDAO().rechercherProjetsParResp(resp, etat);
	}

}
