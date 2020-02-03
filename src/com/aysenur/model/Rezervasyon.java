package com.aysenur.model;

public class Rezervasyon {

	int id;
	int companyId;
	String state;
	String ekstservice;
	String note;
	public Rezervasyon() {
		
	}
	public Rezervasyon(int id, int companyId, String state, String ekstservice, String note) {
		
		this.id = id;
		this.companyId = companyId;
		this.state = state;
		this.ekstservice = ekstservice;
		this.note = note;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEkstservice() {
		return ekstservice;
	}
	public void setEkstservice(String ekstservice) {
		this.ekstservice = ekstservice;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
