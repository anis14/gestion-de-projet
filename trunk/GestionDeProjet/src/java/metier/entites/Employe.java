/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.entites;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author vincent
 */
@Entity
public class Employe implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(nullable=false, length=2)
	private String initiales;

	@Column(nullable=false, length=30)
	private String nom;

	@Column(nullable=false, length=30)
	private String prenom;

	public Employe() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInitiales() {
		return initiales;
	}

	public void setInitiales(String initiales) {
		this.initiales = initiales;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
