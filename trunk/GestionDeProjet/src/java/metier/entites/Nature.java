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
public class Nature implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(nullable=false)
	private String code;

	@Column(nullable=false)
	private String libelle;

	public Nature() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
