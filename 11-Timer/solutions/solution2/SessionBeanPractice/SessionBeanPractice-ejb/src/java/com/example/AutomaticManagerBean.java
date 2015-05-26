/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
/**
 *
 * @author Administrator
 */
@Stateless
public class AutomaticManagerBean implements AutomaticManagerBeanRemote {

   @EJB
    private AutomaticSayHelloBean automaticSayHelloBean;
    @Resource
    private TimerService timerService;
    private int threshold;

    public void manageTimer(int interval, int threshold) {
        this.threshold = threshold;
        int currentCount = automaticSayHelloBean.getNotificationCount();
        if (currentCount >= threshold) {
            automaticSayHelloBean.cancelTimer();
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
            automaticSayHelloBean.cancelTimer();
            timer.cancel();
            System.out.println("AutomaticManagerBean.monitorAutomaticTimer: canceled timers");
        }
    }
}

    

