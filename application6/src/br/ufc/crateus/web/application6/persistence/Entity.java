package br.ufc.crateus.web.application6.persistence;

import javax.persistence.EntityManager;

public class Entity {

	private static EntityManager eM;

	public static final void init(EntityManager em) {
		eM = em;
		eM.getTransaction().begin();
	}

	public static EntityManager getEm() {
		return eM;
	}

	public static void close() {
		eM.close();
		eM = null;
	}

}
