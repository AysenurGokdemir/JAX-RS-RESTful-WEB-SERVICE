package com.aysenur.dao;

import java.sql.Connection;
import java.util.List;


public interface IBaseDao<T> {
	
	public Connection connectionToDatabase(); 
	public List<T> dataRead();
	public T dataRead(int t);
	public boolean dataAdd(T t);
	public boolean dataEdit(T t, int a);
	public boolean dataDelete(int t);
}
	
	
	