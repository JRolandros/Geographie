package fr.esigelec.projectHibernate.dao.hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		// La SessionFactory est initialisée une seule fois pour toute l'application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configuration à partir du fichier hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry
					).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy( registry );
		}
		return sessionFactory;
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}