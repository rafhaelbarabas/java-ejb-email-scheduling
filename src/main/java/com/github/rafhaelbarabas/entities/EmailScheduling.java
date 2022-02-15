package com.github.rafhaelbarabas.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmailScheduling implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String subject;

	private String message;

	private Boolean scheduled = Boolean.FALSE;

	public EmailScheduling() {
	}

	public EmailScheduling(Long id, String email, String subject, String message, Boolean scheduled) {
		this.id = id;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.scheduled = scheduled;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getScheduled() {
		return scheduled;
	}

	public void setScheduled(Boolean scheduled) {
		this.scheduled = scheduled;
	}
	
	public String toString() {
		return this.email;
	}

}
