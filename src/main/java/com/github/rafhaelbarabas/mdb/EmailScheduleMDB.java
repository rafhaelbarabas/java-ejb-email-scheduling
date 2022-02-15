package com.github.rafhaelbarabas.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import com.github.rafhaelbarabas.entities.EmailScheduling;
import com.github.rafhaelbarabas.services.EmailSchedulingService;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/EmailQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class EmailScheduleMDB implements MessageListener {

	@Inject
	private EmailSchedulingService service;

	@Override
	public void onMessage(Message message) {
		try {
			EmailScheduling emailScheduling = message.getBody(EmailScheduling.class);
			service.send(emailScheduling);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

}
