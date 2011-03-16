/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package métier.services;

import java.util.List;
import métier.dao.ProjetDAO;
import métier.entités.Projet;

/**
 *
 * @author vincent
 */
public class ProjetService {

	public List<Projet> recupererProjets() {
		return new ProjetDAO().recupererProjets();
	}
}
