/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ejb;

import com.example.beans.Customer;
import com.example.entity.CustomerEntity;
import java.util.List;
import javax.ejb.Stateful;;
import javax.ejb.LocalBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
@Stateful
@LocalBean



public class CustomerManager {
     @PersistenceContext(unitName = "JPAPractice1PU")
    private EntityManager em;
   //  @Inject
  //  private Customer customer;
   
 

     public CustomerManager() {
        
     }
     public String saveCustomer(CustomerEntity customer){
//        CustomerEntity custentity = new CustomerEntity();
//        custentity.setFirstname(customer.getFirstName());
//        custentity.setLastname(customer.getLastName());
//        em.persist(custentity);
        em.persist(customer);
        return "saved";
    }
      public List<CustomerEntity> retrieveCustomer(){
          
 

        //javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      //  cq.select(cq.from(CustomerEntity));
     //  customerentityData=em.createQuery(cq).getResultList();
       Query q = em.createQuery("SELECT c FROM CustomerEntity c",CustomerEntity.class);
		 return q.getResultList();
              
   
    }
          
      
 
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
