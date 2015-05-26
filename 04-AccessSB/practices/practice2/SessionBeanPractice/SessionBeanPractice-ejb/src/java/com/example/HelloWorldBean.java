/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.Stateless;

/**
 *
 * @author Administrator
 */

@Stateless(mappedName = "HelloBean")  
public class HelloWorldBean implements HelloWorldBeanRemote {

    @Override
    public String sayHello() {
        return "Hello EJB World";
                
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
