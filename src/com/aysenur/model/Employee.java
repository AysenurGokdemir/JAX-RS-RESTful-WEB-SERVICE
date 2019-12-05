package com.aysenur.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name ="employee")

	public class Employee {

		private int employeeiId;
		private int employeeNo;
		private String employeeName;
		private String employeeSurname;
		
		public Employee() {
		}

		public Employee(int employeeiId, int employeeNo, String employeeName, String employeeSurname) {
			
			this.employeeiId = employeeiId;
			this.employeeNo = employeeNo;
			this.employeeName = employeeName;
			this.employeeSurname = employeeSurname;
		}
		@XmlElement
		public int getEmployeeiId() {
			return employeeiId;
		}

		public void setEmployeeiId(int employeeiId) {
			this.employeeiId = employeeiId;
		}
		@XmlElement
		public int getEmployeeNo() {
			return employeeNo;
		}

		public void setEmployeeNo(int employeeNo) {
			this.employeeNo = employeeNo;
		}
		@XmlElement
		public String getEmployeeName() {
			return employeeName;
		}

		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		@XmlElement
		public String getEmployeeSurname() {
			return employeeSurname;
		}

		public void setEmployeeSurname(String employeeSurname) {
			this.employeeSurname = employeeSurname;
		}
		@Override
		public String toString() {
			return "Employee [employeeiId=" + employeeiId + ", employeeNo=" + employeeNo + ", employeeName="
					+ employeeName + ", employeeSurname=" + employeeSurname + "]";
		}
	
}
