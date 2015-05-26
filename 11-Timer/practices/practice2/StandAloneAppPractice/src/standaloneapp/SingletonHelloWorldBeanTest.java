/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package standaloneapp;

/**
 *
 * @author Administrator
 */



import com.example.GreetingRequest;
import com.example.SingletonHelloWorldBeanRemote;
import java.util.Hashtable;
import javax.naming.*;

public class SingletonHelloWorldBeanTest {

    private static SingletonHelloWorldBeanRemote helloWorldBean;

    public static void main(String[] args) {
   String jndiPath = "java:global/SessionBeanPractice/SessionBeanPractice-ejb/SingletonHelloWorldBean";
        try {
            final Context cxt = getInitialContext();
            
            System.out.println("SingletonHelloWorldBeanTest.main: looking up bean at: " + jndiPath);
            helloWorldBean = (SingletonHelloWorldBeanRemote)cxt.lookup(jndiPath);
            System.out.println("SingletonHelloWorldBeanTest.main: found SingletonHelloWorldBean: ");
            System.out.println("SingletonHelloWorldBeanTest.main: calling sayHello");
            GreetingRequest greeting = helloWorldBean.sayHello();
            System.out.println("SingletonHelloWorldBeanTest.main: bean said: " + greeting);
            GreetingRequest[] audit = helloWorldBean.auditRequests();
            System.out.println("SingletonHelloWorldBeanTest.main: number of sayHello requests made on Singleton: " + audit.length);
        } catch (NamingException ex) {
            System.err.println("SingletonHelloWorldBeanTest.main: Could not find SingletonHelloWorldBean");
            System.err.println("SingletonHelloWorldBeanTest.main: JNDI path used for lookup: " + jndiPath);
            ex.printStackTrace();
        }
    }
private static InitialContext getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://localhost:7001");
        return new InitialContext(env);
    }
}

