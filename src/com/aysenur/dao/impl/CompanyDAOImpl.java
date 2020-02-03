package com.aysenur.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aysenur.dao.IBaseDao;
import com.aysenur.model.Company;


public class CompanyDAOImpl implements IBaseDao<Company> {
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
	public List<Company> dataRead() {
		connectionToDatabase();

		List<Company> companys = new ArrayList<Company>();
		Company company = null;

		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM vale_firmalari");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// System.out.println(resultSet.getInt(1) + " "+ resultSet.getInt(2) + " " +
				// resultSet.getString(3) + " "+ resultSet.getString(4) );

				company = new Company(resultSet.getInt(1), resultSet.getString(2),
						  resultSet.getString(3), resultSet.getString(4),resultSet.getString(5));

				companys.add(company);
			}

		} catch (Exception e) {
			System.out.println("HATA: " + e);
		}
		  
		  for (int i = 0; i < companys.size(); i++) { Object obj =
		  companys.get(i).getCompanyId() + " " + companys.get(i).getCompanyName() + " " +
		  companys.get(i).getCompanyService() + " " +
		  companys.get(i).getCompanyDistance()+" "+companys.get(i).getCompanyServiceTime();
		  
		  System.out.println(obj); }
		  
		  return companys; }

	@Override 
	public Company dataRead(int firmaId) {
		  connectionToDatabase();
		  
		  Company company = null;
		  
		  try {
		  
		  String sorgu = "SELECT * FROM vale_firmalari WHERE firmaId=?";
		  PreparedStatement preparedStatement = con.prepareStatement(sorgu);
		  
		  preparedStatement.setInt(1, firmaId); // 1 -> bir tane soru iþareti vardemektir yani bu birinci // parametredir ve degeri employeeiId dir.
		  
		  ResultSet resultSet = preparedStatement.executeQuery();
		  
		  while (resultSet.next()) {
		  
		  company = new Company(resultSet.getInt(1), resultSet.getString(2),
		  resultSet.getString(3), resultSet.getString(4),resultSet.getString(5));
		  
		  }
		  
		  } catch (Exception e) { System.out.println("HATA: " + e); }
		  
		  System.out.println(company); return company; }

	@Override
	public boolean dataAdd(Company employe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dataEdit(Company company, int companyId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dataDelete(int employeeId) {
		// TODO Auto-generated method stub
		return false;
	}
	public static void main(String[] args) {
		CompanyDAOImpl nesne = new CompanyDAOImpl();
		
		nesne.dataRead();

		

	}
}