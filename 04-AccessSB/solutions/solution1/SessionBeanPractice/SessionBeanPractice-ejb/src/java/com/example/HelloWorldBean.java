/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.Stateless;

@Stateless  
public class HelloWorldBean implements HelloWorldBeanRemote {
    
   @Override
    public String sayHello() {
       return "Hello EJB World";
                
    }
     
}
