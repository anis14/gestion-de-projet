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
			e1.setInitiales("MM");
			e1.setNom("Morillon");
			e1.setPrenom("Maxime");

		Projet p1 = new Projet();
			p1.setNumero("P0001");
			p1.setArchivage("non");
			p1.setLibelle("Développement d'une application");
			p1.setResponsable(e1);
			p1.setChargeGlobalConsommee(0);
			p1.setChargeGlobalPrevue(50);
			p1.setEtatProj(Etat.INIT);

		Nature n1 = new Nature();
			n1.setCode("PGT");
			n1.setLibelle("Participation à un Groupe de Travail");

		Nature n2 = new Nature();
			n2.setCode("AF");
			n2.setLibelle("Analyse de la solution à mettre en oeuvre à partir du cahier des charges ou des spécifications détaillées");

		Nature n3 = new Nature();
			n3.setCode("DEV");
			n3.setLibelle("Développement d'une application");

		Nature n4 = new Nature();
			n4.setCode("ITG");
			n4.setLibelle("Intégration d'une application");

		Nature n5 = new Nature();
			n5.setCode("RC");
			n5.setLibelle("Participation aux phases suivant celle de l'intégration");

		Nature n6 = new Nature();
			n6.setCode("AU");
			n6.setLibelle("Assistance aux utilisateurs");

		// ne peut être utilisé que pour le code projet MAINT
		Nature n7 = new Nature();
			n7.setCode("GANO");
			n7.setLibelle("Gestion des annomalies du SI");

		Nature n8 = new Nature();
			n8.setCode("ADPJ");
			n8.setLibelle("Administration de projet");

		// ne peut être utilisé que si le code projet est GESTI
		Nature n9 = new Nature();
			n9.setCode("ADPS");
			n9.setLibelle("Administration personnelle");

		Nature n10 = new Nature();
			n10.setCode("ACQC");
			n10.setLibelle("Acquisition de connaissance");

		// ne peut être utilisé que si le code projet est GESTI
		Nature n11 = new Nature();
			n11.setCode("COMM");
			n11.setLibelle("Communication");

		// ne peut être utilisé que pour le code projet MAINT
		Nature n12 = new Nature();
			n12.setCode("CORRI");
			n12.setLibelle("Activité effectuée dans le cadre d'une maintenance");

		Nature n13 = new Nature();
			n13.setCode("INDISPO");
			n13.setLibelle("Indisponible");

		Nature n14 = new Nature();
			n14.setCode("ABS");
			n14.setLibelle("Absent");

		em.persist(e1);
		em.persist(p1);

		em.persist(n1);
		em.persist(n2);
		em.persist(n3);
		em.persist(n4);
		em.persist(n5);
		em.persist(n6);
		em.persist(n7);
		em.persist(n8);
		em.persist(n9);
		em.persist(n10);
		em.persist(n11);
		em.persist(n12);
		em.persist(n13);
		em.persist(n14);

		em.getTransaction().commit();
		em.close();
		emf.close();
    }
}
