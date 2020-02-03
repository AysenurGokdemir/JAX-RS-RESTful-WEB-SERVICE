package com.aysenur.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aysenur.dao.impl.CompanyDAOImpl;
import com.aysenur.model.Company;

@Path("/company")
public class CompanyService {
	@GET
	@Path("/all")
	//@Produces ("application/xml,  application/json ; charset=utf-8")
	@Produces ({MediaType.APPLICATION_JSON + ";charset=utf-8"})	
	public List<Company> getCompany() {
		CompanyDAOImpl nesne = new CompanyDAOImpl();
		return nesne.dataRead();
	}

}
