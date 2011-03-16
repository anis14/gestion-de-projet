/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package métier.entités;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author vincent
 */
@Entity
@Table(name="taches")
public class Tache implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(nullable=false)
	private int projet;
	@Column(nullable=false)
	private int nature;
	@Column(nullable=false)
	private int employe;
	@Column(nullable=false)
	private int consomme;
	@Column(nullable=false)
	private String descriptif;
	@Column(nullable=false)
	private String remarque;
	@Column(nullable=false)
	private String etatTache;
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

	public int getEmploye() {
		return employe;
	}

	public void setEmploye(int employe) {
		this.employe = employe;
	}

	public String getEtatTache() {
		return etatTache;
	}

	public void setEtatTache(String etatTache) {
		this.etatTache = etatTache;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNature() {
		return nature;
	}

	public void setNature(int nature) {
		this.nature = nature;
	}

	public int getProjet() {
		return projet;
	}

	public void setProjet(int projet) {
		this.projet = projet;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
}
