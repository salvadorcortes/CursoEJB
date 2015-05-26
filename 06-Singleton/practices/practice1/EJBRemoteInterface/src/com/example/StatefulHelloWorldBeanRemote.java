/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.Remote;
import com.example.GreetingRequest;
import javax.ejb.Stateful;
import java.util.*;

/**
 *
 * @author Administrator
 */
@Remote
public interface StatefulHelloWorldBeanRemote {
    

    GreetingRequest sayHello();

    GreetingRequest[] sayGoodBye();
    
}
