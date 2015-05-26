/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;


import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;
import weblogic.messaging.util.List;

/**
 *
 * @author admin
 */
@Named(value = "customerController")
@SessionScoped
public class CustomerController implements Serializable{

    /**
     * Creates a new instance of CustomerController
     */
    public CustomerController() {
       
         
    }
    @Inject
    private Customer customer;
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String saveCustomer() {
//write code to save customer information in database
        
        //customer.setFirstName("Paromita");
        return "saved";
    }
    public void retrieveCustomer(){
        
  }
      
    
        //return "customerList";
        
    
}
