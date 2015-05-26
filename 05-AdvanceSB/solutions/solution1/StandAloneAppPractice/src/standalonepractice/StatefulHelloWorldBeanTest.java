/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package standalonepractice;

import com.example.GreetingRequest;
import com.example.StatefulHelloWorldBeanRemote;
import java.util.Hashtable;
import javax.naming.*;

/**
 *
 * @author Administrator
 */
public class StatefulHelloWorldBeanTest {
private static StatefulHelloWorldBeanRemote bean;

    public static void main(String[] args) {
        String jndiPath = "java:global/SessionBeanPractice/SessionBeanPractice-ejb/StatefulHelloWorldBean";

        try {
            final Context cxt = getInitialContext();

            System.out.println("standaloneapp.StatefulHelloWorldBeanTest.main: looking up bean at: "
                    + jndiPath);
            bean = (StatefulHelloWorldBeanRemote) cxt.lookup(jndiPath);
            System.out.println("standaloneapp.StatefulHelloWorldBeanTest.main: found HelloWorldBean");
            System.out.println("standaloneapp.StatefulHelloWorldBeanTest.main: calling sayHello");
            GreetingRequest greeting = bean.sayHello();
            System.out.println("standaloneapp.StatefulHelloWorldBeanTest.main: HelloWorldBean said: " + greeting);
            for (int i = 0; i < 5; i++) {
                bean.sayHello();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                }
            }
            
            GreetingRequest[] greetings = bean.sayGoodBye();
            for (GreetingRequest gr : greetings) {
                System.out.println(gr);
            }
        } catch (Exception e) {
            System.err.println("standaloneapp.StatefulHelloWorldBeanTest.main: Could not find StatefulHelloWorldBeanRemote");
            System.err.println("standaloneapp.StatefulHelloWorldBeanTest.main: JNDI path used for lookup: " + jndiPath);
            e.printStackTrace();
        }
    }

    private static InitialContext getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://localhost:7001");
        return new InitialContext(env);
    }
}
