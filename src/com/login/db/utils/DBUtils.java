/**
 * 
 */
package com.login.db.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author rathoras
 *
 */
public class DBUtils {
	private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();					
		} catch (Throwable th) {
			System.err.println("Enitial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/*@Autowired
	static SessionFactory sessionFactory;
	public static Session getSession(){
	      return sessionFactory.getCurrentSession();
	   }*/

	/*public static SessionFactory createSessionFactory() {
	  Configuration configuration = new Configuration();
	  configuration.configure();
	serviceRegistry = new StandardServiceRegistryImpl().applySettings(configuration.getProperties()).build();
	  sessionFactory = configuration.configure().buildSessionFactory(serviceRegistry);
	  return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
	    return createSessionFactory();
	}*/
}
