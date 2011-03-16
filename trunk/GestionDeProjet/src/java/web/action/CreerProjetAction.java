/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author vincent
 */
public class CreerProjetAction implements Action {

	public String execute(HttpServletRequest request) {
		String nomProjet = request.getParameter("nomProjet");
		return "projet/vueConfirmerCreerProjet.jsp";
	}
}
