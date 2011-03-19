/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.entites;

import java.io.Serializable;

/**
 *
 * @author Vincent
 */
public enum Etat implements Serializable {
	INIT("Initié"), ENCOURS("En cours"), TERMINE("Terminé"), ANNULE("Annulé");

	private final String etat;

	private Etat(String unEtat) {
		etat = unEtat;
	}

	public String getEtat() {
		return etat;
	}

	public String toStringForSQL()	{
		return getClass().getName()+"."+toString();
	}

}
