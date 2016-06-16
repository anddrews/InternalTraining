package com.epam.by.bll;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.*;

public class MDBSender {
	final String QUEUE_LOOKUP = "queue/MyQueue";
	final String CONNECTION_FACTORY = "ConnectionFactory";
	
	private QueueSession session;
	private QueueSender sender;
	private TextMessage message;
	
	public MDBSender(String factory, String providerURL) throws NamingException, JMSException {
		Properties properties=new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, factory);
		properties.put(Context.PROVIDER_URL, providerURL);
		Context context= new InitialContext(properties);
		QueueConnectionFactory connectionFactory = (QueueConnectionFactory) context.lookup(CONNECTION_FACTORY);
		QueueConnection connection = connectionFactory.createQueueConnection();
		session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		Queue queue = (Queue) context.lookup(QUEUE_LOOKUP);
		sender = session.createSender(queue);
		message = session.createTextMessage();

	}
	
	public void sendMessage(String messageText) throws JMSException{
		message.setText(messageText);
		sender.send(message);
	}
	
	public void sessionClose() throws JMSException{
		session.close();
	}
	
	
}
