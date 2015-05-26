/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.Stateless;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.*;
/**
 *
 * @author anshenoy
 */
@Stateless
public class MessageFacade implements MessageFacadeRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 @Resource(name = "jms/HelloWorldQueue")
    private Queue helloWorldQueue;
    @Resource(mappedName = "jms/HelloWorldQueueFactory")
    private ConnectionFactory helloWorldQueueFactory;

@EJB
    private SingletonHelloWorldBean singletonHelloWorldBean;

private ObjectMessage createJMSMessageForjmsHelloWorldQueue(Session session, Serializable messageData) throws JMSException {
        // TODO create and populate message to send
        ObjectMessage om = session.createObjectMessage(messageData);
        return om;
    }

    private void sendJMSMessageToHelloWorldQueue(Serializable messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = helloWorldQueueFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(helloWorldQueue);
            messageProducer.send(createJMSMessageForjmsHelloWorldQueue(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    System.err.println( "Cannot close session"+ e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

public GreetingRequest sayHello() {
        GreetingRequest result = singletonHelloWorldBean.sayHello();
        try {
            sendJMSMessageToHelloWorldQueue(result);
            System.out.println("MessageFacade.sayHello: sent message - " + result);
        } catch (JMSException ex) {
            System.err.println("MessageFacade.sayHello: error sending message - " + ex);
        }
        return result;
    }

}

