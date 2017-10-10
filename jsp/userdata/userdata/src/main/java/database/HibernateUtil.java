package database;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.reflection.ReflectionManager;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.internal.MetadataImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.event.service.internal.EventListenerRegistryImpl;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.jpa.event.internal.core.JpaPostDeleteEventListener;
import org.hibernate.jpa.event.internal.core.JpaPostInsertEventListener;
import org.hibernate.jpa.event.internal.core.JpaPostLoadEventListener;
import org.hibernate.jpa.event.internal.core.JpaPostUpdateEventListener;
import org.hibernate.jpa.event.internal.jpa.CallbackBuilderLegacyImpl;
import org.hibernate.jpa.event.internal.jpa.CallbackRegistryImpl;
import org.hibernate.jpa.event.spi.jpa.CallbackBuilder;
import org.hibernate.jpa.event.spi.jpa.ListenerFactory;
import org.hibernate.jpa.event.spi.jpa.ListenerFactoryBuilder;
import org.hibernate.mapping.PersistentClass;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml")
					.build();

			Metadata metaData = new MetadataSources(standardRegistry)
					.getMetadataBuilder()
					.build();

			sessionFactory = metaData.getSessionFactoryBuilder().build();
		} catch (Throwable th) {
			System.err.println("Initial SessionFactory creation failed: " + th);
			throw new ExceptionInInitializerError(th);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}