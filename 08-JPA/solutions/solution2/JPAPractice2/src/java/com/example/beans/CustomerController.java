/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;

import com.example.ejb.CustomerManager;
import com.example.entity.CustomerEntity;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
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
    private CustomerEntity customer;
    
    @EJB
    private CustomerManager custmanager;
    
    @Inject   
   private CustList customerData;

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
public void setCustomerData(CustList  customerdata) {
        this.customerData = customerdata;
    }
    public CustList  getCustomerData() {
        return customerData;
    }
    public String saveCustomer() {
//write code to save customer information in database
        custmanager.saveCustomer(customer);
       
        return "saved";
    }
    public String retrieveCustomer(){
       java.util.List<CustomerEntity> customerentityData=custmanager.retrieveCustomer();
        
        for (CustomerEntity ce:customerentityData) {
       
        customerData.add(ce);
         }
     
      
    
        return "CustomerList";
        
    }
}
