/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.dao;

import java.util.List;
import metier.entites.Tache;

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
	
}
