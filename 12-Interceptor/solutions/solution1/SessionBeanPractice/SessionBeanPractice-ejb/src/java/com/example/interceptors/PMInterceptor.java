/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.interceptors;

import javax.interceptor.AroundTimeout;
import javax.interceptor.InvocationContext;

/**
 *
 * @author parodutt
 */
public class PMInterceptor {
    private long numberOfInvocations;
    @AroundTimeout
public Object monitorInvocations(InvocationContext ic) throws Exception {
try {
Object returnValue = ic.proceed();
numberOfInvocations++;
System.out.println("PMInterceptor.monitorInvocations: invocation count- "+ numberOfInvocations);
return returnValue;
} catch (Exception ex) {
System.err.println("PMInterceptor.monitorInvocations: error occurred - " + ex);

}
return null;
}

}
