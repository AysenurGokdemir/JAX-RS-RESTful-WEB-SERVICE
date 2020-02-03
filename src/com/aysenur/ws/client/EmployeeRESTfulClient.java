package com.aysenur.ws.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class EmployeeRESTfulClient {

	public static void main(String[] args) {
		
		
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(" http://localhost:9999/_RESTful_JDBC_CRUD/rest/employee/all");
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		
			if (response.getStatus() == 200) {
				
				System.out.println(response.getEntity(String.class));
		
			}else{
				System.out.println("ERROR WARNING ! : HTTP STATUS CODE: " + response.getStatus());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
