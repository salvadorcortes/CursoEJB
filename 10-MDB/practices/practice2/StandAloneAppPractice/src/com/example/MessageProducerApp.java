
package com.example;
import java.util.Hashtable;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author anshenoy
 */
public class MessageProducerApp {

    
    
   
    public static void main(String[] args) throws NamingException {
        
        String jndiPath="java:global/SessionBeanPractice/SessionBeanPractice-ejb/SingletonHelloWorldBean";
     
       final Context cxt = getInitialContext();
  SingletonHelloWorldBeanRemote singletonHelloWorldBean = (SingletonHelloWorldBeanRemote) cxt.lookup(jndiPath);
        GreetingRequest result = singletonHelloWorldBean.sayHello();
        System.out.println("result is "+result);
        String resultStr = result.toString();
        try {
            sendJMSMessageToHelloWorldQueue(resultStr);
            System.out.println("MessageProducerApp.main: sent message - " + resultStr);
        } catch (JMSException ex) {
            System.err.println("MessageProducerApp.main: failed to send message - " + ex);
        }
    }
            
       
       


     

   
    

       
    
 private static InitialContext getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://localhost:7001");
        return new InitialContext(env);
    }
 private static Message createJMSMessageForjmsHelloWorldQueue(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData.toString());
        return tm;
    }

    private static void sendJMSMessageToHelloWorldQueue(Object messageData) throws JMSException, NamingException {
        Connection connection = null;
        Session session = null;
        try {
        final Context cxt = getInitialContext(); 
     ConnectionFactory helloWorldQueueFactory = (ConnectionFactory)cxt.lookup("jms/HelloWorldQueueFactory");
      
     Queue helloWorldQueue=(Queue)cxt.lookup("jms/HelloWorldQueue"); 
            connection = helloWorldQueueFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(helloWorldQueue);
            messageProducer.send(createJMSMessageForjmsHelloWorldQueue(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    System.err.println("Cannot close session - " + e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

}



 

