package com.salsa.card;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;

public class OfyHelper implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent event) {
		ObjectifyService.register(Card.class);
		ObjectifyService.register(Set.class);
	}

	public void contextDestroyed(ServletContextEvent event) {
		
	}
}