/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vincent
 */
public class DAO {
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionDeProjetPU");
	protected static EntityManager em = null;

	protected EntityManager getEntityManager() {
		if (em == null || !em.isOpen())
			em = emf.createEntityManager();

		return em;
	}
}
