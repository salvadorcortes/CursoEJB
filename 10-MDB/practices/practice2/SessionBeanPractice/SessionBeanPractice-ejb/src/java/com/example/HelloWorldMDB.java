/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.logging.*;
import javax.annotation.*;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;
/**
 *
 * @author anshenoy
 */
@MessageDriven(mappedName = "jms/HelloWorldQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class HelloWorldMDB implements MessageListener {
    
    public HelloWorldMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        if(message instanceof TextMessage) {
      try {
        TextMessage textMessage = (TextMessage) message;
        String messageValue = textMessage.getText();
        System.out.println("HelloWorldMDB.onMessage: received text message - " + messageValue);
      } catch (JMSException ex) {
        Logger.getLogger(HelloWorldMDB.class.getName()).log(Level.SEVERE, null, ex);
      }
        }
      
  }

    
  

  @PreDestroy
  private void destroy() {
    System.out.println("HelloWorldMDB: @PreDestroy");
  }

  @PostConstruct
  private void postConstruct() {
    System.out.println("HelloWorldMDB: @PostConstruct");
  }
}

    
