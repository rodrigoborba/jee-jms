package com.borba.javaee.servlets;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.borba.javaee.jms.MyMessageProducer;

@Singleton
@Startup
public class App {
	
	@EJB
	MyMessageProducer producer;
	
	@PostConstruct
	public void start() {
		String message = "Hello message from JavaEE server using JMS";
		producer.sendMessage(message);
		System.out.println("Published the message " + message);
		
	}

}
