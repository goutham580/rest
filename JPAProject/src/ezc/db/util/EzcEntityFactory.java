package ezc.db.util;

import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;

/**
 * Application Lifecycle Listener implementation class EzcEntityFactory
 *
 */
@WebListener
public class EzcEntityFactory implements ServletContextListener {

    private static EntityManagerFactory emf;
    /**
     * Default constructor. 
     */
    public EzcEntityFactory() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        InitialContext ctx;
        DataSource ds=null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DefaultDB");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, DataSource> properties = new HashMap<String, DataSource>();
        properties.put(PersistenceUnitProperties.NON_JTA_DATASOURCE, ds);
        emf = Persistence.createEntityManagerFactory("JPAProject", properties);

    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
        emf.close(); 
    }
    public static EntityManager createEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("Context is not initialized yet.");
        }
        return emf.createEntityManager();
    }
}
