package com.aysenur.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aysenur.dao.IBaseDao;
import com.aysenur.model.Employee;


/**
 * @author Aysenur
 *
 */
public class EmployeeDAOImpl implements IBaseDao<Employee>{

	static Connection con = null;

	@Override
	public Connection connectionToDatabase() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firmaveritabani", "root", "15260555");

			if (!con.isClosed()) {
				System.out.println("WITH JDBC TO MYSQL SUCCESSFUL.");
			} else {
				System.out.println("can not connected.");
			}

		} catch (Exception e) {
			System.out.println("Error: " + e);
		} finally {
			System.out.println("?");
		}

		return con;
	}

	@Override
	public List<Employee> dataRead() {
		connectionToDatabase();

		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;

		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM Musteri");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// System.out.println(resultSet.getInt(1) + " "+ resultSet.getInt(2) + " " +
				// resultSet.getString(3) + " "+ resultSet.getString(4) );

				employee = new Employee(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						resultSet.getString(4));

				employees.add(employee);
			}

		} catch (Exception e) {
			System.out.println("HATA: " + e);
		}

		for (int i = 0; i < employees.size(); i++) {
			Object obj = employees.get(i).getEmployeeiId() + " " + employees.get(i).getEmployeeNo() + " "
					+ employees.get(i).getEmployeeName() + " " + employees.get(i).getEmployeeSurname();

			System.out.println(obj);
		}

		return employees;
	}

	@Override
	public Employee dataRead(int employeeId) {
		// TODO Auto-generated method stub

		connectionToDatabase();

		Employee employee = null;

		try {

			String sorgu = "SELECT * FROM Musteri WHERE musteriId=?";
			PreparedStatement preparedStatement = con.prepareStatement(sorgu);

			preparedStatement.setInt(1, employeeId); // 1 -> bir tane soru iþareti var demektir yani bu birinci
														// parametredir ve degeri employeeiId dir.

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				employee = new Employee(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						resultSet.getString(4));

			}

		} catch (Exception e) {
			System.out.println("HATA: " + e);
		}

		System.out.println(employee);
		return employee;
	}

	@Override
	public boolean dataAdd(Employee employee) {
		// TODO Auto-generated method stub

		connectionToDatabase();
		boolean postState = false;
		String result = "";

		try {
			String query = "INSERT INTO Musteri (musteriNo, musteriAdi, musteriSoyadi) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, employee.getEmployeeNo());
			preparedStatement.setString(2, employee.getEmployeeName());
			preparedStatement.setString(3, employee.getEmployeeSurname());

			postState = preparedStatement.execute();

			if (postState == false)
				result = "ADD SUCCESSFUL";
			else
				result = "ADD UNSUCCESSFUL";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e);
		}
		System.out.println(result);

		return postState;
	}

	@Override
	public boolean dataEdit(Employee employee, int employeeId)  {
		// TODO Auto-generated method stub
		connectionToDatabase();
		boolean editState=false;
		String infoResult="";
		try {
			
			String query="UPDATE Musteri"
					+ " SET musteriNo = ?, "
					+ " musteriAdi = ?, "
					+ " musteriSoyadi = ? "
					+ " WHERE musteriId = ?";
			
			PreparedStatement  preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, employee.getEmployeeNo());
			preparedStatement.setString(2, employee.getEmployeeName());
			preparedStatement.setString(3, employee.getEmployeeSurname());
			preparedStatement.setInt(4,employeeId);
			int queryResult = preparedStatement.executeUpdate();
			
			if (queryResult==1) {
				infoResult="EDÝt SUCCESSFUL";
				editState=true;
				}else {
				infoResult="EDÝT UNSUCCESS";
				editState=false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR: "+e);
			
		}
		System.out.println(infoResult);
		return editState;
	}

	@Override
	public boolean dataDelete(int employeeId) {
		// TODO Auto-generated method stub

		connectionToDatabase();
		boolean deleteState = false;
		String result = "";

		try {

			String query = "DELETE FROM musteri WHERE musteriId=?";

			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, employeeId);

			deleteState = preparedStatement.execute();

			if (deleteState == false)
				result = "DELETE SUCCESSFUL";
			else
				result = "DELETE UNSUCCESSFUL";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e);
		}
		System.out.println(result);

		return deleteState;
	}

	/*public static void main(String[] args) {
		EmployeeDAOImpl nesne = new EmployeeDAOImpl();
		Employee employee = new Employee();
		nesne.connectionToDatabase();

		nesne.dataRead();
		nesne.dataRead(3);

		employee.setEmployeeNo(456);
		employee.setEmployeeName("java");
		employee.setEmployeeSurname("RESTful");

		nesne.dataAdd(employee);

		nesne.dataDelete(2);
		nesne.dataEdit(nesne.dataRead(1), 4);
	    employee.setEmployeeNo(78);
		employee.setEmployeeName("AYŞENUR");
		employee.setEmployeeSurname("GÖKDEMİR");
		nesne.dataEdit(employee, 1);
		nesne.dataRead();
	

	}
	*/
	
}


