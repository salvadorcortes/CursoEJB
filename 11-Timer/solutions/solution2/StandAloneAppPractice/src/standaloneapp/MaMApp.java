/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package standaloneapp;

import com.example.AutomaticManagerBeanRemote;
import java.util.Hashtable;
import javax.naming.*;


/**
 *
 * @author Administrator
 */
public class MaMApp {
   private static AutomaticManagerBeanRemote automaticManagerBean;

    public static void main(String[] args) {
       String jndiPath = "java:global/SessionBeanPractice/SessionBeanPractice-ejb/AutomaticManagerBean"; 
        
           
        
        try {
            final Context cxt = getInitialContext();

            System.out.println("standaloneapp.StatefulHelloWorldBeanTest.main: looking up bean at: "
                    + jndiPath);
          automaticManagerBean = (AutomaticManagerBeanRemote) cxt.lookup(jndiPath);
            System.out.println("standaloneapp.StatefulHelloWorldBeanTest.main: found HelloWorldBean");
            System.out.println("standaloneapp.StatefulHelloWorldBeanTest.main: calling sayHello");
            automaticManagerBean.manageTimer(1000 * 60, 50);
              System.out.println("MaMApp.main: started management process");
           

        } catch (Exception e) {
            System.err.println("standaloneapp.Main.main: Could not find StatefulHelloWorldBeanRemote");
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

    



