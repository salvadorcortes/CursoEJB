#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import ${package}.model.Person;

/**
 * Session Bean implementation class PersonEJB
 */
@Stateless
@LocalBean
@Remote(PersonEJBRemote.class)
@Local(PersonEJBLocal.class)
public class PersonEJB implements PersonAsyncRemote{
	
	@Resource SessionContext myContext;
	
	@PostConstruct
	private void init(){
		System.out.println("Se inicia PersonEJB" );
	}
	


	public void addPerson(Person person) {
		
		person.setId(2);
		System.out.println(person.getId());
		
	}

	@PreDestroy
	private void clean(){
		System.out.println("se termino..." );
	}


	@Asynchronous
	@Override
	public Future<String> longProcess() {
		String msg = "exito";
		
		try {
			
			while(myContext.wasCancelCalled() == false){
				Thread.sleep(10000);
				System.out.println("working.....");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new AsyncResult<String>(msg);
	}


	@Asynchronous
	@Override
	public void initial() {
		
		
		
	}

}
