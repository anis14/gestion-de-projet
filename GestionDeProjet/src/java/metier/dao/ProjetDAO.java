/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.dao;

import java.util.List;
import metier.entites.Employe;
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

	public List<Projet> recupererProjets(List<Etat> etats, String archive) {
		String rq = "SELECT p FROM Projet p WHERE p.archivage = '"+archive+"' AND (p.etatProj = "+etats.get(0).toStringForSQL();
		String requete = requete(rq, etats);
		
		List<Projet> lesProjets = (List<Projet>)em.createQuery(requete).getResultList();
		em.close();

		return lesProjets;
	}

	public List<Projet> rechercherProjetsParNumero(String numero, List<Etat> etats, String archive) {
		String rq = "SELECT p FROM Projet p WHERE p.numero LIKE '%"+numero+"%' AND p.archivage = '"+archive+"' AND (p.etatProj = "+etats.get(0).toStringForSQL();
		String requete = requete(rq, etats);

		List<Projet> lesProjets = (List<Projet>)em.createQuery(requete).getResultList();
		em.close();

		return lesProjets;
	}

	public List<Projet> rechercherProjetsParResp(String initiales, List<Etat> etats, String archive) {
		String rq = "SELECT p FROM Projet p JOIN p.responsable r WHERE r.initiales = '"+initiales+"' AND p.archivage = '"+archive+"' AND (p.etatProj = "+etats.get(0).toStringForSQL();
		String requete = requete(rq, etats);

		List<Projet> lesProjets = (List<Projet>)em.createQuery(requete).getResultList();
		em.close();

		return lesProjets;
	}

	public Projet detailsProjet(int id) {
		String requete = "SELECT p FROM Projet p WHERE p.id = "+id;
		Projet leProjet = (Projet)em.createQuery(requete).getSingleResult();

		return leProjet;
	}

		public String requete(String rq, List<Etat> etats) {
		String requete = rq;

		switch (etats.size()) {
			case 1:
				requete += ")";
				break;
			case 2:
				requete += " OR p.etatProj = "+etats.get(1).toStringForSQL()+")";
				break;
			case 3:
				requete += " OR p.etatProj = "+etats.get(1).toStringForSQL();
				requete += " OR p.etatProj = "+etats.get(2).toStringForSQL()+")";
				break;
			case 4:
				requete += " OR p.etatProj = "+etats.get(1).toStringForSQL();
				requete += " OR p.etatProj = "+etats.get(2).toStringForSQL();
				requete += " OR p.etatProj = "+etats.get(3).toStringForSQL()+")";
				break;
			default:
				requete = "SELECT p FROM Projet p";
				break;
		}

		return requete;
	}

	public Projet enregistrerProjet(Projet unProjet) {
		Employe lEmploye = new EmployeDAO().recupererResponsableParID(unProjet.getResponsable().getId());
		unProjet.setResponsable(lEmploye);
		
		em.getTransaction().begin();
		em.persist(unProjet);
		em.getTransaction().commit();
		em.close();

		return unProjet;
	}

	public Projet recupererProjetParId(int idProjet) {
		String requete = "SELECT p FROM Projet p WHERE p.id = "+idProjet;
		Projet leProjet = (Projet)em.createQuery(requete).getSingleResult();

		return leProjet;
	}

	public Projet editerProjet(Projet unProjet) {
		Employe lEmploye = new EmployeDAO().recupererResponsableParID(unProjet.getResponsable().getId());
		unProjet.setResponsable(lEmploye);

		em.getTransaction().begin();
		Projet leProjet = em.find(Projet.class, unProjet.getId());
			leProjet.setNumero(unProjet.getNumero());
			leProjet.setArchivage(unProjet.getArchivage());
			leProjet.setLibelle(unProjet.getLibelle());
			leProjet.setChargeGlobalConsommee(unProjet.getChargeGlobalConsommee());
			leProjet.setChargeGlobalPrevue(unProjet.getChargeGlobalPrevue());
			leProjet.setCommentaire(unProjet.getCommentaire());
			leProjet.setEtatProj(unProjet.getEtatProj());
			leProjet.setResponsable(unProjet.getResponsable());
		em.persist(leProjet);
		em.getTransaction().commit();
		em.close();

		return unProjet;
	}

}
