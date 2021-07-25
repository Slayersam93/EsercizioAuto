package it.epicode.be.Garage.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static EntityManagerFactory getEntityManagerFactory() {

		return entityManagerFactory;

	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}

	public static void apriSessione() {
		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("Garage");
			entityManager = entityManagerFactory.createEntityManager();

		} catch (Throwable ex) {

			System.err.println("Initial EntityManagerFactory creation failed." + ex);

			throw new ExceptionInInitializerError(ex);

		}
	}

	public static void chiudiSessione() {

		entityManager.close();
		entityManagerFactory.close();
	}

}
