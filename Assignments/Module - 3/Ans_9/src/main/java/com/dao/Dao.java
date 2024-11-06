package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.model.Model;

public class Dao 
{
	public static Connection getconnect()
    {
    	Connection con = null;
    	
    	try 
    	{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","");
		} 
    	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
    	
    }
	
	public static int signupdata(Model m)
	{
		int status = 0;
		
		Connection con = Dao.getconnect();
		
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("insert into details(name,email,mobile,password) values (?,?,?,?)");
			ps.setString(1, m.getName());
			ps.setString(2, m.getEmail());
			ps.setString(3, m.getMobile());
			ps.setString(4, m.getPassword());
			
			status = ps.executeUpdate();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
    
	 public static Model logindata(Model m) {
	        Connection con = Dao.getconnect();
	        Model m2 = null;
	        PreparedStatement ps = null;
	        ResultSet set = null;

	        try {
	            ps = con.prepareStatement("SELECT * FROM details WHERE email = ? AND password = ?");
	            ps.setString(1, m.getEmail());
	            ps.setString(2, m.getPassword());

	            set = ps.executeQuery();

	            if (set.next()) {
	                int id = set.getInt(1);
	                String name = set.getString(2);
	                String email = set.getString(3); 
	                String mobile = set.getString(4);
	                String password = set.getString(5);

	                m2 = new Model();
	                m2.setId(id);
	                m2.setName(name);
	                m2.setEmail(email);
	                m2.setMobile(mobile);
	                m2.setPassword(password);
	            }
	        } catch (SQLException e) {
	            System.err.println("Error during login.");
	            e.printStackTrace();
	        
	        }

	        return m2;
	    }
    
	 public static boolean checkEmailExists(String email) {
	        boolean exists = false;
	        Connection con = Dao.getconnect();
	        
	        try {
	            PreparedStatement ps = con.prepareStatement("select * from details where email=?");
	            ps.setString(1, email);
	            
	            ResultSet set = ps.executeQuery();
	            exists = set.next(); 
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        
	        return exists;
	    }

	public static boolean updateProfile(Model user) 
	{
		Connection con = Dao.getconnect();
	    PreparedStatement ps = null;
	    boolean isUpdated = false;
	    
	    try 
	    {
	        ps = con.prepareStatement("UPDATE details SET name = ?, email = ?, mobile = ? WHERE id = ?");
	        ps.setString(1, user.getName());
	        ps.setString(2, user.getEmail());
	        ps.setString(3, user.getMobile());
	        ps.setInt(4, user.getId());
	        
	        int rowsUpdated = ps.executeUpdate();
	        if (rowsUpdated > 0) 
	        {
	            isUpdated = true; 
	        }
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    }
		return isUpdated; 
	    
	}

}
