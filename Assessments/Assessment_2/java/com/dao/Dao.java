package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Model;

public class Dao 
{
	public static Connection getconnect()
    {
    	Connection con = null;
    	
    	try 
    	{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_reg","root","");
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
			PreparedStatement ps = con.prepareStatement("insert into user(fname,lname,email,mobile,address,gender,password) values (?,?,?,?,?,?,?)");
			ps.setString(1,m.getFname());
			ps.setString(2,m.getLname());
			ps.setString(3,m.getEmail());
			ps.setString(4,m.getMobile());
			ps.setString(5, m.getAddress());
			ps.setString(6, m.getGender());
			ps.setString(7, m.getPassword());
			
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
	            ps = con.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
	            ps.setString(1, m.getEmail());
	            ps.setString(2, m.getPassword());

	            set = ps.executeQuery();

	            if (set.next()) {
	                int id = set.getInt(1);
	                String fname = set.getString(2);
	                String lname = set.getString(3);
	                String email = set.getString(4); 
	                String mobile = set.getString(5);
	                String address = set.getString(6);
	                String gender = set.getString(7);
	                String password = set.getString(8);

	                m2 = new Model();
	                m2.setId(id);
	                m2.setFname(fname);
	                m2.setLname(lname);
	                m2.setEmail(email);
	                m2.setMobile(mobile);
	                m2.setAddress(address);
	                m2.setGender(gender);
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
	            PreparedStatement ps = con.prepareStatement("select * from user where email=?");
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
}
