/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package métier.dao;

import javax.persistence.EntityManager;

/**
 *
 * @author Vincent
 */
public class DAO {
	@javax.persistence.PersistenceContext(unitName = "GestionDeProjetPU")
	protected static EntityManager em;
}
