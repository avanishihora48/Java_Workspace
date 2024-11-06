package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Model;

public class Dao 
{
    public static Connection getconnect()
    {
    	Connection con = null;
    	
    	try 
    	{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
		} 
    	catch (Exception e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
    	
    }
    
    public static int insertdata(Model m)
    {
    	int status = 0;
    	
    	Connection con = Dao.getconnect();
    	
    	try 
    	{
			PreparedStatement ps = con.prepareStatement("insert into stud_info (fname,lname,email,mobile,gender,pass)values(?,?,?,?,?,?)");
			ps.setString(1, m.getFname());
			ps.setString(2, m.getLname());
			ps.setString(3, m.getEmail());
			ps.setString(4, m.getMobile());
			ps.setString(5, m.getGender());
			ps.setString(6, m.getPass());
			
			status = ps.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
    	
    }

	public static Model logindata(Model m) 
	{
		Model m2 = null;
		
		Connection con = Dao.getconnect();
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from stud_info where email = ? and pass = ?");
			ps.setString(1, m.getEmail());
			ps.setString(2, m.getPass());
			
			ResultSet set = ps.executeQuery();
			
			if(set.next())
			{
				int id = set.getInt(1);
				String fname = set.getString(2);
				String lname = set.getString(3);
				String email = set.getString(4);
				String mobile = set.getString(5);
				String gender = set.getString(6);
				String pass = set.getString(7);
				
				m2 = new Model();
				m2.setId(id);
				m2.setFname(fname);
				m2.setLname(lname);
				m2.setEmail(email);
				m2.setMobile(mobile);
				m2.setGender(gender);
				m2.setPass(pass);
			}
			else
			{
				System.out.println("fail");
			}
		
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m2;
	}
	
	public static List<Model> viewdata()
	{
		 List<Model> list = new ArrayList<>();
	        Connection con = Dao.getconnect();
	        
	        try 
	        {
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM stud_info");
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()) 
	            {
	                Model student = new Model();
	                student.setId(rs.getInt(1)); 
	                student.setFname(rs.getString(2));
	                student.setLname(rs.getString(3));
	                student.setEmail(rs.getString(4));
	                student.setMobile(rs.getString(5));
	                student.setGender(rs.getString(6));
	                student.setPass(rs.getString(7));
	                
	                list.add(student);
	            }
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        return list;
	    }

	public static Model editdata(int id) {
		Model m = null;
	    Connection con = Dao.getconnect();
	    
	    try 
	    {
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM stud_info WHERE id = ?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) 
	        {
	            m = new Model();
	            m.setId(rs.getInt(1)); 
	            m.setFname(rs.getString(2));
	            m.setLname(rs.getString(3));
	            m.setEmail(rs.getString(4));
	            m.setMobile(rs.getString(5));
	            m.setGender(rs.getString(6));
	            m.setPass(rs.getString(7));
	        }
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    }
	    return m;
	}

	public static void updatedata(Model m) 
	{
		Connection con = Dao.getconnect();
	    try 
	    {
	    	PreparedStatement ps = con.prepareStatement("UPDATE stud_info SET fname = ?, lname = ?, email = ?, mobile = ?, gender = ?, pass = ? WHERE id = ?");

	        ps.setString(1, m.getFname());
	        ps.setString(2, m.getLname());
	        ps.setString(3, m.getEmail());
	        ps.setString(4, m.getMobile());
	        ps.setString(5, m.getGender());
	        ps.setString(6, m.getPass());
	        ps.setInt(7, m.getId());
	        ps.executeUpdate();
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    }
		
	}
	
	public static int deletedata(int id)
	{
		int status = 0;
		
		Connection con = Dao.getconnect();
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("delete from stud_info where id=?");
			ps.setInt(1,id);
		
		
			status = ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}
}
	

