package mx.certificatic.ejb.practica3.service;

import java.util.concurrent.Future;

import javax.ejb.Remote;

@Remote
public interface PersonAsyncRemote {
	
	public Future<String> longProcess();
	
	public void initial();
	
}
