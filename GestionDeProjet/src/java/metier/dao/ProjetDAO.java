/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.dao;

import java.util.List;
import metier.entites.Etat;
import metier.entites.Projet;

/**
 *
 * @author vincent
 */
public class ProjetDAO extends DAO {

	public ProjetDAO() {
		super();
		em = getEntityManager();
	}

	public List<Projet> recupererProjets(Etat etat) {
		String requete = "SELECT p FROM Projet p WHERE p.etatProj = "+etat.toStringForSQL();
		List<Projet> lesProjets = (List<Projet>)em.createQuery(requete).getResultList();

		return lesProjets;
	}

	public List<Projet> rechercherProjetsParNumero(String numero, Etat etat) {
		String requete = "SELECT p FROM Projet p WHERE p.numero LIKE '%"+numero+"%' AND p.etatProj = "+etat.toStringForSQL();
		List<Projet> lesProjets = (List<Projet>)em.createQuery(requete).getResultList();

		return lesProjets;
	}

	public List<Projet> rechercherProjetsParResp(String initiales, Etat etat) {
		String requete = "SELECT p FROM Projet p JOIN p.responsable r WHERE r.initiales = '"+initiales+"' AND p.etatProj = "+etat.toStringForSQL();
		List<Projet> lesProjets = (List<Projet>)em.createQuery(requete).getResultList();

		return lesProjets;
	}
	
}
