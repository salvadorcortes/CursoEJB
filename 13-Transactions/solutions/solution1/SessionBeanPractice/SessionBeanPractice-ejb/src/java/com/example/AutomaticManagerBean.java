/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import javax.transaction.UserTransaction;

/**
 *
 * @author Administrator
 */
@TransactionManagement(TransactionManagementType.BEAN)
@Stateless
public class AutomaticManagerBean implements AutomaticManagerBeanRemote {

   @EJB
    private AutomaticSayHelloBean automaticSayHelloBean;
    @Resource
    private TimerService timerService;
    @Resource private SessionContext context;
    private int threshold;

    public void manageTimer(int interval, int threshold) {
        this.threshold = threshold;
        int currentCount = automaticSayHelloBean.getNotificationCount();
        if (currentCount >= threshold) {
            //automaticSayHelloBean.cancelTimer();
            try{
            cancelAutomaticTimer();
            }
            catch(Exception e){
               System.err.println("com.example.AutoMaticManagerBean.manageTimer: Could not execute cancelAutomaticTimer");
                
                e.printStackTrace(); 
            }
            System.out.println("AutomaticManagerBean.manageTimer: exceeded threshold; canceled timer");
        } else {

            timerService.createIntervalTimer(interval, interval, null);
            System.out.println("AutomaticManagerBean.manageTimer: created interval timer");
        }
    }

    @Timeout
    private void monitorAutomaticTimer(Timer timer) {
        int currentCount = automaticSayHelloBean.getNotificationCount();
        System.out.println("AutomaticManagerBean.monitorAutomaticTimer: currentCount - " + currentCount);
        if (currentCount >= threshold) {
           // automaticSayHelloBean.cancelTimer();
            try{
            cancelAutomaticTimer();
            }
            catch(Exception e){
               System.err.println("com.example.AutoMaticManagerBean.manageTimer: Could not execute cancelAutomaticTimer");
                
                e.printStackTrace();  
            }
            timer.cancel();
            System.out.println("AutomaticManagerBean.monitorAutomaticTimer: canceled timers");
        }
    }
    private void cancelAutomaticTimer() throws Exception {
    UserTransaction ut = context.getUserTransaction();
    ut.begin();
    automaticSayHelloBean.cancelTimer();
    ut.commit();
}

}

    

