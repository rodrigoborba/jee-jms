package com.borba.javaee.servlets;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.borba.javaee.jms.MyMessageProducer;

@Singleton
@Startup
public class App {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	MyMessageProducer producer;
	
	@PostConstruct
	public void start() throws IOException {
		String message = "Hello message from JavaEE server using JMS";
		producer.sendMessage(message);
		System.out.println("Published the message " + message);
		
	}

}
