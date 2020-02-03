package com.aysenur.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.aysenur.dao.impl.RezervasyonDAOImpl;
import com.aysenur.model.Rezervasyon;

@Path("/rez")
public class RezervasyonService {
	@POST
	@Path("/register")
	@Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public Response postRez(Rezervasyon rez) {

		RezervasyonDAOImpl nesne = new RezervasyonDAOImpl();
		boolean postState = nesne.dataAdd(rez);
		if (postState == false)

			return Response.status(201).build(); // added
		else
			return Response.status(204).build();

	}

}
