package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.ModelMessage;
import com.model.ModelUser;

public class MessageDao 
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
	    
	 public boolean addMessage(ModelMessage mms) {
	        Connection con = null;
	        PreparedStatement ps = null;
	        boolean isSuccess = false;

	        try {
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/message_system", "root", "");
	            ps = con.prepareStatement("INSERT INTO messages (uid, from, to, msg) VALUES (?, ?, ?, ?)");
	            ps.setInt(1, mms.getUid());
	            ps.setString(2, mms.getFrom());
	            ps.setString(3, mms.getTo());
	            ps.setString(4, mms.getMsg());

	            int rowsAffected = ps.executeUpdate();
	            isSuccess = (rowsAffected > 0);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (ps != null) ps.close();
	                if (con != null) con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return isSuccess;
	    }
}
