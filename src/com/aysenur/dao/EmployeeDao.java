package com.aysenur.dao;

import java.sql.Connection;
import java.util.List;

import com.aysenur.model.Employee;

public interface EmployeeDao {
	public Connection connectionToDatabase(); 
	public List<Employee> dataRead();
	public Employee dataRead(int employeeId);
	public boolean dataAdd(Employee employee);
	public boolean dataEdit(Employee employee, int employeeId);
	public boolean dataDelete(int employeeId);
}
