/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package standaloneapppractice;

import com.example.HelloWorldBeanRemote;
import java.util.Hashtable;
import javax.naming.*;

/**
 *
 * @author Administrator
 */
public class StandAloneAppPractice {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
       
     String jndiPath="java:global/SessionBeanPractice/SessionBeanPractice-ejb/HelloWorldBean";
        try {
            final Context cxt = getInitialContext();

            System.out.println("standaloneapp.Main.main: looking up bean at: "
                    + jndiPath);
            HelloWorldBeanRemote bean = (HelloWorldBeanRemote) cxt.lookup(jndiPath);
            System.out.println("standaloneapp.Main.main: found HelloWorldBean");
            System.out.println("standaloneapp.Main.main: calling sayHello");
            String greeting = bean.sayHello();
            System.out.println("standaloneapp.Main.main: HelloWorldBean said: "
                    + greeting);
        } catch (Exception e) {
            System.err.println("standaloneapp.Main.main: Could not find HelloWorldBeanRemote");
            System.err.println("standaloneapp.Main.main: JNDI path used for lookup: " + jndiPath);
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

