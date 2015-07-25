/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.certificatic.practicas.seguridad.ejb;

import java.security.Principal;
import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;

/**
 * 
 * @author sanborn
 */
@Stateless
@LocalBean
@RunAs("oro")
public class SessionBeanRunAs {
	@EJB
	SessionBeanSeguridad ejbSeguridad;
	@Resource
	protected SessionContext sc;

	public String Saludo() {
		Principal principal = sc.getCallerPrincipal();
		System.out.println("El rol que me llamo fue: " + principal.getName());
		try {
			System.out.println(sc.isCallerInRole("bronce"));
			System.out.println(sc.isCallerInRole("plata"));
			System.out.println(sc.isCallerInRole("oro"));
		} catch (Exception e) {
		}
		// return
		// "Hola soy ejb metodo Saludo llamado por: "+principal.getName();
		return ejbSeguridad.Saludo();
	}
}