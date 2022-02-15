package com.github.rafhaelbarabas.jobs;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import com.github.rafhaelbarabas.services.EmailSchedulingService;

@Singleton
public class SendEmailScheduledJob {

	@Inject
	private EmailSchedulingService service;

	@Inject
	@JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
	private JMSContext jmsContext;

	@Resource(mappedName = "java:/jms/queue/EmailQueue")
	private Queue queue;

	@Schedule(hour = "*", minute = "*", second = "*/10")
	public void sendEmail() {
		service.listUnscheduled().forEach(email -> {
			jmsContext.createProducer().send(queue, email);
			service.setScheduled(email);
		});
	}
}
