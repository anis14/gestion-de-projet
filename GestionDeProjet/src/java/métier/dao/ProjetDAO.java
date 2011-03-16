/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package métier.dao;

import java.util.List;
import métier.entités.Projet;

/**
 *
 * @author vincent
 */
public class ProjetDAO extends DAO {

	public List<Projet> recupererProjets()
	{
		String requete = "SELECT p FROM Projet p";
		List<Projet> lesProjets = (List<Projet>)em.createQuery(requete).getResultList();

		return lesProjets;
	}

	public List<Projet> rechercherProjetsParNumero(String numero)
	{
		String requete = "SELECT p FROM Projet p WHERE p.numero = "+numero;
		List<Projet> lesProjets = (List<Projet>)em.createQuery(requete).getResultList();

		return lesProjets;
	}

	public List<Projet> rechercherProjetsParResp(String initiales)
	{
		// A FAIRE
		String requete = "SELECT p FROM Projet p WHERE p.responsable = "+initiales;
		List<Projet> lesProjets = (List<Projet>)em.createQuery(requete).getResultList();

		return lesProjets;
	}
}
