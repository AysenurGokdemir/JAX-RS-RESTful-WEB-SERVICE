package com.aysenur.model;

/**
 * @author Aysenur
 *
 */
public class Company {
	
	int companyId;
	String companyName;
	String companyDistance;
	String companyService;
	String companyServiceTime;
	
	public Company() {}

	public Company(int companyId, String companyName, String companyDistance, String companyService,
			String companyServiceTime) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyDistance = companyDistance;
		this.companyService = companyService;
		this.companyServiceTime = companyServiceTime;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDistance() {
		return companyDistance;
	}

	public void setCompanyDistance(String companyDistance) {
		this.companyDistance = companyDistance;
	}

	public String getCompanyService() {
		return companyService;
	}

	public void setCompanyService(String companyService) {
		this.companyService = companyService;
	}

	public String getCompanyServiceTime() {
		return companyServiceTime;
	}

	public void setCompanyServiceTime(String companyServiceTime) {
		this.companyServiceTime = companyServiceTime;
	}

}