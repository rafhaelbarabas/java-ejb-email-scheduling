package com.github.rafhaelbarabas.services;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.github.rafhaelbarabas.dao.EmailScheduleDAO;
import com.github.rafhaelbarabas.entities.EmailScheduling;

@Stateless
public class EmailSchedulingService {

	private static final Logger LOG = Logger.getLogger(EmailSchedulingService.class.getName());

	@Inject
	private EmailScheduleDAO dao;

	public List<EmailScheduling> list() {
		return dao.list();
	}

	public void create(EmailScheduling emailScheduling) {
		emailScheduling.setScheduled(false);
		dao.create(emailScheduling);
	}

	public List<EmailScheduling> listUnscheduled() {
		return dao.listUnscheduled();
	}

	public void setScheduled(EmailScheduling emailScheduling) {
		emailScheduling.setScheduled(true);
		dao.update(emailScheduling);
	}

	public void send(EmailScheduling emailScheduling) {
		try {
			Thread.sleep(5000);
			LOG.info("Sending e-mail: " + emailScheduling);
			LOG.info("success...");			
		} catch (Exception e) {
			LOG.warning("Fail to send e-mail. Caused by: " + e.getMessage());
		}
	}
}
