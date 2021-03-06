package br.ufc.crateus.web.application6.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.ufc.crateus.web.application6.repository.DatabaseManager;

@WebListener
public class AppListener implements ServletContextListener {

	public AppListener() {
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		DatabaseManager.close();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		DatabaseManager.init();
	}

}
