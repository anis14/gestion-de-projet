/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.services;

import java.util.List;
import metier.dao.TacheDAO;
import metier.entites.Tache;

/**
 *
 * @author vincent
 */
public class TacheService {

	public List<Tache> detailsTachesProjet(int idProjet) {
		return new TacheDAO().detailsTachesProjet(idProjet);
	}
	
}
