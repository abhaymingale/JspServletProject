package com.nanowebhub.dao;

import java.sql.*;

import com.nanowebhub.utils.connection;
import com.nanowebub.beans.RegistrationBeans;

public class RegistrationDao {
	
	public String RegisterUser(RegistrationBeans registration)
	{
		String name = registration.getName();
		String email = registration.getEmail();
		String password = registration.getPassword();
		
		Connection conn =null;
		PreparedStatement preparedStatement =null;
		
		try {
			 conn = connection.getCon();
			
			String query ="insert into REGISTRATION (ID,NAME,EMAIL,PASSWORD) values (null,?,?,?)";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			
			int i = preparedStatement.executeUpdate();
			if(i!=0)
		    return "Success";		
			
			
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "Oop Something Wrong";
		
	}
	

}
