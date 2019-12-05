package com.aysenur.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.aysenur.dao.impl.EmployeeDAOImpl;
import com.aysenur.model.Employee;

@Path("/employee")
public class EmployeeRESTfulService {
	
	//  http://localhost:9999/_RESTful_JDBC_CRUD/rest/employee
	@GET
	@Path("/all")
//	@Produces ("application/xml,  application/json ; charset=utf-8")
	@Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON + ";charset=utf-8"})	
	public List<Employee> getEmployee() {
		EmployeeDAOImpl nesne = new EmployeeDAOImpl();
		return nesne.dataRead();
		
	}
	// http://localhost:9999/_RESTful_JDBC_CRUD/rest/employee/3
	@GET
	@Path("/{employeeId}")
	@Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON + ";charset=utf-8"})	
	public Employee getEmployeeById(@PathParam("employeeId") int employeeId) {
		
		EmployeeDAOImpl nesne =new EmployeeDAOImpl();
		
		
		return nesne.dataRead(employeeId);
	}
	
	// http://localhost:9999/_RESTful_JDBC_CRUD/rest/employee
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON + ";charset=utf-8"})
	public Response postEmployee(Employee employee) {
		
		EmployeeDAOImpl nesne = new EmployeeDAOImpl();
		boolean postState=nesne.dataAdd(employee);
		if (postState==false) 
			
			return Response.status(201).build(); 	//added
			else
				return Response.status(204).build();
			
		}
	
	// http://localhost:9999/_RESTful_JDBC_CRUD/rest/employee/4
	@PUT
	@Path("/{employeeId}")
	@Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON + ";charset=utf-8"})	
	@Consumes ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON + ";charset=utf-8"}) 
	public Employee EmployeeEdit( @PathParam ("employeeId") int employeeId, Employee employee) {
		
		
		EmployeeDAOImpl nesne = new EmployeeDAOImpl();
		boolean editState = nesne.dataEdit(employee, employeeId);
		
		if(editState == true)
			return employee;
		else
			return null;
	}  	
	
//  http://localhost:9999/_RESTful_JDBC_CRUD/rest/employee/Id=3
	@DELETE
	@Path("/{employeeId}")
	public Response musteriSil(@PathParam ("employeeId") int employeeId ) {
		
		EmployeeDAOImpl nesne = new EmployeeDAOImpl();
		boolean deleteState = nesne.dataDelete(employeeId);
		
		if(deleteState == false)
			return Response.status(200).build();
		else
			return Response.status(204).build();

	}  	
		
	}
	
	
	

