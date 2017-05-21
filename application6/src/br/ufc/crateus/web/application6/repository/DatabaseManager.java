package br.ufc.crateus.web.application6.repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseManager {
	private static EntityManagerFactory emf;

	public static void init() {
		emf = Persistence.createEntityManagerFactory("sigaa");

	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public static void close() {
		emf.close();
	}

}
