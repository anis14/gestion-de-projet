/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.dao;

import java.util.List;
import metier.entites.Employe;

/**
 *
 * @author vincent
 */
public class EmployeDAO extends DAO {

	public EmployeDAO() {
		super();
		em = getEntityManager();
	}

	public List<Employe> recupererResponsables() {
		String requete = "SELECT DISTINCT r FROM Projet p JOIN p.responsable r";
		List<Employe> lesEmployes = (List<Employe>)em.createQuery(requete).getResultList();

		return lesEmployes;
	}

	Employe recupererResponsableParID(int id) {
		String requete = "SELECT e FROM Employe e WHERE e.id = "+id;
		Employe lEmploye = (Employe)em.createQuery(requete).getSingleResult();

		return lEmploye;
	}

	public List<Employe> recupererEmployes() {
		String requete = "SELECT e FROM Employe e";
		List<Employe> lesEmployes = (List<Employe>)em.createQuery(requete).getResultList();

		return lesEmployes;
	}

	public Employe recupererEmployeParId(int idEmploye) {
		String requete = "SELECT e FROM Employe e WHERE e.id = "+idEmploye;
		Employe lEmploye = (Employe)em.createQuery(requete).getSingleResult();

		return lEmploye;
	}
	
}
