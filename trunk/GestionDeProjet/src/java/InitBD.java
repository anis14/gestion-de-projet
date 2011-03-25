/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.persistence.*;
import metier.entites.*;

/**
 *
 * @author vincent
 */
public class InitBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionDeProjetPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Employe e1 = new Employe();
			e1.setInitiales("TB");
			e1.setNom("Truc");
			e1.setPrenom("Bidule");

		Projet p1 = new Projet();
			p1.setNumero("P0001");
			p1.setArchivage("non");
			p1.setLibelle("bonjour");
			p1.setCommentaire("bouh");
			p1.setResponsable(e1);
			p1.setChargeGlobalConsommee(0);
			p1.setChargeGlobalPrevue(50);
			p1.setEtatProj(Etat.INIT);

		em.persist(e1);
		em.persist(p1);
		em.getTransaction().commit();
		em.close();
		emf.close();
    }
}
