/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.*;

/**
 *
 * @author Administrator
 */
@Singleton
@LocalBean
@Startup
public class AutomaticSayHelloBean {

    @EJB
    private SingletonHelloWorldBean singletonHelloWorldBean;

    @Schedule(second = "*/5", minute = "*", hour = "*")
    public void sayHello(Timer timer) {
        GreetingRequest request = singletonHelloWorldBean.sayHello();
        System.out.println("AutomaticSayHelloBean.sayHello: - " + request);
    }
}
