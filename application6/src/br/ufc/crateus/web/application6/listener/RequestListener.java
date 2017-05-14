package br.ufc.crateus.web.application6.listener;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import br.ufc.crateus.web.application6.repository.DatabaseManager;

@WebListener
public class RequestListener implements ServletRequestListener {

	public RequestListener() {
		// TODO Auto-generated constructor stub
	}

	public void requestInitialized(ServletRequestEvent requestEvent) {
		requestEvent.getServletContext().setAttribute("EntityManager", DatabaseManager.getEmf().createEntityManager());

		System.out.println("entrou");
	}

	public void requestDestroyed(ServletRequestEvent requestEvent) {
		EntityManager em = (EntityManager) requestEvent.getServletContext().getAttribute("EntityManager");
		em.close();
		System.out.println("saiu");

	}

}
