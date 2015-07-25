/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.certificatic.practicas.seguridad.ejb;

import java.security.Principal;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;

/**
 * 
 * @author sanborn
 */
@Stateless
@LocalBean
@RolesAllowed({ "oro", "plata", "bronce" })
public class SessionBeanSeguridad {

	@Resource
	protected SessionContext sc;

	public String Saludo() {
		System.out.println("");
		// seguridad programatica
		Principal principal = sc.getCallerPrincipal();
		System.out.println("El rol que me llamo fue: " + principal.getName());
		try {
			System.out.println(sc.isCallerInRole("bronce"));
			System.out.println(sc.isCallerInRole("plata"));
			System.out.println(sc.isCallerInRole("oro"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "Hola soy ejb metodo Saludo llamado por: " + principal.getName();
	}
	// Add business logic below. (Right-click in editor and choose
	// "Insert Code > Add Business Method")
}