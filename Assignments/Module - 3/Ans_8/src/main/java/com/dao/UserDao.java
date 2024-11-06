package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.ModelMessage;
import com.model.ModelUser;

public class UserDao 
{
    public static Connection getconnect()
    {
    	Connection con = null;
    	
    	try 
    	{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/message_system","root","");
		} 
    	catch (Exception e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
    	
    }
    
    public boolean addUser(ModelUser mu) {
        Connection con = UserDao.getconnect();
        PreparedStatement ps = null;
        boolean isSuccess = false;

        try 
        {
  
            ps = con.prepareStatement("INSERT INTO user (fname, lname, email, mobile) VALUES (?, ?, ?, ?)");
            ps.setString(1, mu.getFname()); 
            ps.setString(2, mu.getLname());
            ps.setString(3, mu.getEmail());
            ps.setString(4, mu.getMobile());

            int rowsAffected = ps.executeUpdate();
            isSuccess = (rowsAffected > 0); 
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccess; 
    }

}
