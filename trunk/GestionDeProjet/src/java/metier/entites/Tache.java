/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author vincent
 */
@Entity
public class Tache implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@OneToOne
	@JoinColumn(name="projet_fk", nullable=false)
	private Projet projet;

	@OneToOne
	@JoinColumn(name="nature_fk", nullable=false)
	private Nature nature;

	@OneToOne
	@JoinColumn(name="employe_fk", nullable=false)
	private Employe employe;

	@Column(nullable=false)
	private int consomme;

	@Column(nullable=false)
	private String descriptif;

	@Column(nullable=true)
	private String remarque;

	@Column(nullable=false)
	@Enumerated(value=EnumType.STRING)
	private Etat etatTache;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateDebut;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateFin;

	@Column(nullable=false)
	private double chargeEffective;
	
	@Column(nullable=false)
	private double chargePrevisionnelle;

	public Tache() {}

	public double getChargeEffective() {
		return chargeEffective;
	}

	public void setChargeEffective(double chargeEffective) {
		this.chargeEffective = chargeEffective;
	}

	public double getChargePrevisionnelle() {
		return chargePrevisionnelle;
	}

	public void setChargePrevisionnelle(double chargePrevisionnelle) {
		this.chargePrevisionnelle = chargePrevisionnelle;
	}

	public int getConsomme() {
		return consomme;
	}

	public void setConsomme(int consomme) {
		this.consomme = consomme;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Etat getEtatTache() {
		return etatTache;
	}

	public void setEtatTache(Etat etatTache) {
		this.etatTache = etatTache;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Nature getNature() {
		return nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	
}
