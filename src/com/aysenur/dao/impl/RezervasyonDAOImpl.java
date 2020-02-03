package com.aysenur.dao.impl;
import com.aysenur.model.Rezervasyon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import com.aysenur.dao.IBaseDao;
public class RezervasyonDAOImpl implements IBaseDao<Rezervasyon>  {
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
	public List<Rezervasyon> dataRead() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rezervasyon dataRead(int rezId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean dataAdd(Rezervasyon rez) {
		connectionToDatabase(); boolean postState = false; String result = "";
		  
		  try { String query =
		  "INSERT INTO rez_registers (state,ekstraHizmet) VALUES (?, ?)";
		  PreparedStatement preparedStatement = con.prepareStatement(query);
		  preparedStatement.setString(1, rez.getState());
		  preparedStatement.setString(2, rez.getEkstservice());
		  
		  
		  
		  postState = preparedStatement.execute();
		  
		  if (postState == false) result = "ADD SUCCESSFUL"; else result =
		  "ADD UNSUCCESSFUL"; } catch (Exception e) { // TODO: handle exception
		  System.out.println("Error: " + e); } System.out.println(result);
		  
		  return postState;
		  
	}

	@Override
	public boolean dataEdit(Rezervasyon rez, int rezId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dataDelete(int rezId) {
		// TODO Auto-generated method stub
		return false;
	}

}
