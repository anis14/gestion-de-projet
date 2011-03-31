/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.services;

import java.util.List;
import metier.dao.EmployeDAO;
import metier.entites.Employe;

/**
 *
 * @author vincent
 */
public class EmployeService {

	public List<Employe> recupererResponsables() {
		return new EmployeDAO().recupererResponsables();
	}

	public List<Employe> recupererEmployes() {
		return new EmployeDAO().recupererEmployes();
	}

	public Employe recupererEmployeParId(int idEmploye) {
		return new EmployeDAO().recupererEmployeParId(idEmploye);
	}
	
}
