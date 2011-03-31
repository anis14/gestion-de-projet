/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.dao;

import java.util.List;
import metier.entites.Nature;
import metier.entites.Projet;
import metier.entites.Tache;
import metier.services.ProjetService;

/**
 *
 * @author vincent
 */
public class TacheDAO extends DAO {

	public List<Tache> detailsTachesProjet(int idProjet) {
		String requete = "SELECT t FROM Tache t JOIN t.projet p WHERE p.id = "+idProjet;
		List<Tache> lesTaches = (List<Tache>)em.createQuery(requete).getResultList();

		return lesTaches;
	}

	public List<Nature> recupererNatures() {
		String requete = "SELECT n FROM Nature n";
		List<Nature> lesNatures = (List<Nature>)em.createQuery(requete).getResultList();

		return lesNatures;
	}

	public Projet ajouterTache(Tache uneTache) {
		Projet leProjet = new ProjetService().recupererProjetParId(uneTache.getProjet().getId());

		em.getTransaction().begin();
		em.persist(uneTache);
		em.getTransaction().commit();
		em.close();

		return leProjet;
	}

	public Nature recupererNatureParId(int idNature) {
		String requete = "SELECT n FROM Nature n WHERE n.id = "+idNature;
		Nature laNature = (Nature)em.createQuery(requete).getSingleResult();

		return laNature;
	}
	
}
