package com.github.rafhaelbarabas.controllers;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.rafhaelbarabas.entities.EmailScheduling;
import com.github.rafhaelbarabas.services.EmailSchedulingService;

@Path("emails")
public class EmailSchedulingController {

	@Inject
	private EmailSchedulingService service;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response list() {
		return Response.ok(service.list()).build();
	}

	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response create(EmailScheduling emailScheduling) {
		service.create(emailScheduling);
		return Response.status(201).build();
	}

}
