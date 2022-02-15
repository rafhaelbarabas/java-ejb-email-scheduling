package com.github.rafhaelbarabas.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.github.rafhaelbarabas.entities.EmailScheduling;

@Stateless
public class EmailScheduleDAO {

	@PersistenceContext
	private EntityManager em;

	public EmailScheduleDAO() {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EmailScheduleDS");
		this.em = emFactory.createEntityManager();
	}

	public List<EmailScheduling> list() {
		String sql = "SELECT es FROM EmailScheduling es";
		List<EmailScheduling> resultList = em.createQuery(sql, EmailScheduling.class).getResultList();
		return resultList;
	}
	
	public List<EmailScheduling> listUnscheduled(){
		String sql = "SELECT es FROM EmailScheduling es WHERE es.scheduled = false";
		return em.createQuery(sql, EmailScheduling.class).getResultList();
	}
	
	public void update(EmailScheduling emailScheduling) {
		em.merge(emailScheduling);
	}
	
	public void create(EmailScheduling emailScheduling) {
		em.persist(emailScheduling);
	}
}
