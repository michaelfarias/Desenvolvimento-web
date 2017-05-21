package br.ufc.crateus.web.application6.listener;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import br.ufc.crateus.web.application6.persistence.Entity;
import br.ufc.crateus.web.application6.repository.DatabaseManager;

@WebListener
public class RequestListener implements ServletRequestListener {

	public RequestListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void requestInitialized(ServletRequestEvent requestEvent) {
		requestEvent.getServletRequest().setAttribute("em", DatabaseManager.getEmf().createEntityManager());
		Entity.init((EntityManager) requestEvent.getServletRequest().getAttribute("em"));
		System.out.println("inicio");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent requestEvent) {
		Entity.close();
		System.out.println("fim");
	}

}
