/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package métier.entités;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author vincent
 */
@Entity
public class Projet implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(nullable=false)
	private String numero;
	@Column(nullable=false)
	private String libelle;
	@Column(nullable=false)
	private String etatProj;
	@Column(nullable=false)
	private String archivage;
	@Column(nullable=false)
	private String commentaire;
	@Column(nullable=false)
	private double chargeGlobalPrevue;
	@Column(nullable=false)
	private double chargeGlobalConsommee;
	@Column(nullable=false)
	private double chargeNonPlanifiee;
	@Column(nullable=false)
	private int responsable;

	public Projet() {}

	public String getArchivage() {
		return archivage;
	}

	public void setArchivage(String archivage) {
		this.archivage = archivage;
	}

	public double getChargeGlobalConsommee() {
		return chargeGlobalConsommee;
	}

	public void setChargeGlobalConsommee(double chargeGlobalConsommee) {
		this.chargeGlobalConsommee = chargeGlobalConsommee;
	}

	public double getChargeGlobalPrevue() {
		return chargeGlobalPrevue;
	}

	public void setChargeGlobalPrevue(double chargeGlobalPrevue) {
		this.chargeGlobalPrevue = chargeGlobalPrevue;
	}

	public double getChargeNonPlanifiee() {
		return chargeNonPlanifiee;
	}

	public void setChargeNonPlanifiee(double chargeNonPlanifiee) {
		this.chargeNonPlanifiee = chargeNonPlanifiee;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getEtatProj() {
		return etatProj;
	}

	public void setEtatProj(String etatProj) {
		this.etatProj = etatProj;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getResponsable() {
		return responsable;
	}

	public void setResponsable(int responsable) {
		this.responsable = responsable;
	}
}
