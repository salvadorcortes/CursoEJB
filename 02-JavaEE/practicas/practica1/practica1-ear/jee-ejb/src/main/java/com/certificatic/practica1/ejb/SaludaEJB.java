package com.certificatic.practica1.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SaludaEJB
 */
@Stateless
@LocalBean
public class SaludaEJB implements SaludaEJBRemote, SaludaEJBLocal {

    /**
     * Default constructor. 
     */
    public SaludaEJB() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String saludaMundo(String nombre) {
        return "Hola "+nombre;
    }

}
