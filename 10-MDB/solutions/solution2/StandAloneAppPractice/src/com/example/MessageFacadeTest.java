/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.Hashtable;
import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.naming.*;
import com.example.MessageFacadeRemote;



/**
 *
 * @author anshenoy
 */
public class MessageFacadeTest {
     


    public static void main(String[] args)throws NamingException 
    {
        
         String jndiPath="java:global/SessionBeanPractice/SessionBeanPractice-ejb/MessageFacade";
     
       final Context cxt = getInitialContext();
      MessageFacadeRemote messageFacade = (MessageFacadeRemote) cxt.lookup(jndiPath);
        GreetingRequest result = messageFacade.sayHello();
          
            System.out.println("MessageFacadeTest.main: facade said - " + result);
        } 
        
                
  private static InitialContext getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://localhost:7001");
        return new InitialContext(env);
    }

}   

        
      

