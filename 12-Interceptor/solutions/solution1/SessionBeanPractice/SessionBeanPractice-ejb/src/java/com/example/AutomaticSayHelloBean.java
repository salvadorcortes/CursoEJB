/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ejb.*;
import javax.interceptor.Interceptors;

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
    

  private int timerNotifications;
  private boolean cancelTimer;
@Interceptors(com.example.interceptors.PMInterceptor.class)
  @Schedule(second="*/5", minute="*", hour="*")
  private void sayHello(Timer timer) {
    GreetingRequest request = singletonHelloWorldBean.sayHello();
    timerNotifications++;
    System.out.println("AutomaticSayHelloBean.sayHello: - " + request);

    if(cancelTimer) {
      timer.cancel();
      System.out.println("AutomaticSayHelloBean.sayHello: canceled timer");
    }
  }

  public int getNotificationCount() {
    return timerNotifications;
  }

  public void cancelTimer() {
    cancelTimer = true;
  }
    
}
