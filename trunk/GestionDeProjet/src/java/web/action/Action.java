/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Thorgrim
 */
public interface Action {
	public String execute(HttpServletRequest request);
}
