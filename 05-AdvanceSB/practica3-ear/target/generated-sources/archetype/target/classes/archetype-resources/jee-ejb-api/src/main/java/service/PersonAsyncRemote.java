#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import java.util.concurrent.Future;

import javax.ejb.Remote;

@Remote
public interface PersonAsyncRemote {
	
	public Future<String> longProcess();
	
	public void initial();
	
}
