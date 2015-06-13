package com.certificatic.practica1.ejb;

import javax.ejb.Remote;

@Remote
public interface SaludaEJBRemote {
	 public String saludaMundo(String nombre);
}
