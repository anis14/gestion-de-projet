/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.entites;

import java.io.Serializable;

/**
 *
 * @author vincent
 */
public enum Nature implements Serializable {
	PGT("Participation à un Groupe de Travail"),
	AF("Analyse de la solution à mettre en oeuvre à partir du cahier des charges ou des spécifications détaillées"),
	DEV("Développement d'une application"),
	ITG("Intégration d'une application"),
	RC("Participation aux phases suivant celle de l'intégration"),
	AU("Assistance aux utilisateurs"),
	GANO("Gestion des annomalies du SI"), // ne peut être utilisé que pour le code projet MAINT
	ADPJ("Administration de projet"),
	ADPS("Administration personnelle"), // ne peut être utilisé que si le code projet est GESTI
	ACQC("Acquisition de connaissance"),
	COMM("Communication"), // ne peut être utilisé que si le code projet est GESTI
	CORRI("Activité effectuée dans le cadre d'une maintenance"), // ne peut être utilisé que pour le code projet MAINT
	INDISPO("Indisponible"),
	ABS("Absent");

	private final String code;

	private Nature(String unCode) {
		code = unCode;
	}

	public String getCode() {
		return code;
	}

	public String toStringForSQL() {
		return getClass().getName()+"."+toString();
	}

}
