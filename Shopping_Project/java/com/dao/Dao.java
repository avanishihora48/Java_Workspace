
package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.model.AdminModel;
import com.model.CartModel;
import com.model.ContactModel;
import com.model.PaymentModel;
import com.model.ProductModel;
import com.model.Model;
import com.model.WishlistModel;

public class Dao 
{
	public static Connection getconnect()
	{
		Connection con = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_project","root","");

		} 
		catch (Exception e) 
		{
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
			PreparedStatement ps = con.prepareStatement("insert into myshopp(name,email,phone,password) values (?,?,?,?)");
			ps.setString(1,m.getName());
			ps.setString(2,m.getEmail());
			ps.setString(3,m.getPhone());
			ps.setString(4,m.getPassword());
			
			status = ps.executeUpdate();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static Model signindata(Model m)
	{
		
		
		Connection con = Dao.getconnect();
		
		Model m2=null;
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from myshopp where email=? and password=?");
			ps.setString(1,m.getEmail());
			ps.setString(2,m.getPassword());
			
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				int id = set.getInt(1);
				String name= set.getString(2);
				String email= set.getString(3);
				String phone= set.getString(4);
				String password= set.getString(5);
			
				m2 = new Model();
				m2.setId(id);
				m2.setName(name);
				m2.setEmail(email);
				m2.setPhone(phone);
				m2.setPassword(password);
			}
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m2;
	}
	
	public static List<ProductModel>viewproducts()
	{
		List<ProductModel>list = new ArrayList<>();
		Connection con = Dao.getconnect();
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from products");
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				
				int id = set.getInt(1);
				String pname = set.getString(2);
				String pprice = set.getString(3);
				String pdes = set.getString(4);
				//String pimage = set.getString(5);
				byte[] imgData = set.getBytes("p_image");
				
				ProductModel pm = new ProductModel();
				pm.setId(id);
				pm.setP_name(pname);
				pm.setP_price(pprice);
				pm.setP_des(pdes);
				//pm.setP_image(pimage);

				 // blob field 
		         String encode = Base64.getEncoder().encodeToString(imgData);
		         pm.setP_image(encode);
				
				
				list.add(pm);
			}
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static ProductModel getproductindexwise(int id)
	{
		ProductModel pm = null;
		Connection con = Dao.getconnect();
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from products where id=?");
			ps.setInt(1, id);
			
			ResultSet set = ps.executeQuery();
			
			if(set.next())
			{
				int id1 = set.getInt(1);
				String pname = set.getString(2);
				String pprice = set.getString(3);
				String pdes = set.getString(4);
				byte[] imgData = set.getBytes("p_image");
				
				pm = new ProductModel();
				pm.setId(id1);
				pm.setP_name(pname);
				pm.setP_price(pprice);
				pm.setP_des(pdes);
				String encode = Base64.getEncoder().encodeToString(imgData);
		        pm.setP_image(encode);
			}
			
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pm;
	}
	
	public static List<WishlistModel>wishlistbyemail(String email)
	{
		List<WishlistModel>list = new ArrayList<>();
		Connection con = Dao.getconnect();
		WishlistModel wm = null;
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from wishlist where email=?");
			ps.setString(1, email);
			
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				int id1 = set.getInt(1);
				String pname = set.getString(2);
				String pprice = set.getString(3);
				String pdes = set.getString(4);
				byte[] imgData = set.getBytes("p_image");
				String email1 = set.getString(6);
				
				wm = new WishlistModel();
				wm.setId(id1);
				wm.setP_name(pname);
				wm.setP_price(pprice);
				wm.setP_des(pdes);
				
				String encode = Base64.getEncoder().encodeToString(imgData);
				wm.setP_image(encode);
				wm.setEmail(email1);
				
				list.add(wm);
			}
			
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public static List<CartModel>cartbyemail(String email)
	{
		List<CartModel>list = new ArrayList<>();
		Connection con = Dao.getconnect();
		CartModel wm = null;
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from cart where email=?");
			ps.setString(1, email);
			
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				int id1 = set.getInt(1);
				String pname = set.getString(2);
				String pprice = set.getString(3);
				String pdes = set.getString(4);
				byte[] imgData = set.getBytes("p_image");
				String qua = set.getString(6);
				String fp = set.getString(7);
				String email1 = set.getString(8);
				
				int fp2 = Integer.parseInt(fp);
				
				wm = new CartModel();
				wm.setId(id1);
				wm.setP_name(pname);
				wm.setP_price(pprice);
				wm.setP_des(pdes);
				wm.setP_qua(qua);
				wm.setFp(fp2);
				//wm.setEmail(email);
				
				String encode = Base64.getEncoder().encodeToString(imgData);
				wm.setP_image(encode);
				wm.setEmail(email1);
				
				list.add(wm);
			}
			
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static WishlistModel getitemindexwise(int id)
	{
		WishlistModel pm = null;
		Connection con = Dao.getconnect();
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from wishlist where id=?");
			ps.setInt(1, id);
			
			ResultSet set = ps.executeQuery();
			
			if(set.next())
			{
				int id1 = set.getInt(1);
				String pname = set.getString(2);
				String pprice = set.getString(3);
				String pdes = set.getString(4);
				byte[] imgData = set.getBytes("p_image");
				
				pm = new WishlistModel();
				pm.setId(id1);
				pm.setP_name(pname);
				pm.setP_price(pprice);
				pm.setP_des(pdes);
				String encode = Base64.getEncoder().encodeToString(imgData);
		        pm.setP_image(encode);
			}
			
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pm;
	}
	 public static AdminModel adminlogin(AdminModel m) 
	 { 
		 AdminModel m2=null;
	  
		 Connection con = Dao.getconnect(); 
		 try 
		 {
			 PreparedStatement ps = con.prepareStatement("select * from adminlogin where username=? and password=?");
			 ps.setString(1,m.getUsername()); 
			 ps.setString(2,m.getPassword());
	  
			 ResultSet set = ps.executeQuery();
	  
			 while(set.next()) 
			 {
				 int id = set.getInt(1); 
				 String username =set.getString(2); 
				 String password = set.getString(3);
	  
				 m2 = new AdminModel();
	  
				 m2.setId(id);
				 m2.setUsername(username); 
				 m2.setPassword(password);
	  
			 }
			 }
		 catch (Exception e)
		 { // TODO Auto-generated catch block
			 	e.printStackTrace(); 
		}
	  
	  return m2;
	  
	  }
	 
	 public static int contactinsertdata(ContactModel cm)
		{
			int status = 0;
			
			Connection con = Dao.getconnect();
			
			
			try 
			{
				PreparedStatement ps = con.prepareStatement("insert into contact(name,email,mobile,query) values (?,?,?,?)");
				ps.setString(1,cm.getName());
				ps.setString(2,cm.getEmail());
				ps.setString(3,cm.getMobile());
				ps.setString(4,cm.getQuery());
				
				status = ps.executeUpdate();
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return status;
		}
	 
	 public static List<ContactModel>viewquery()
		{
			List<ContactModel>list = new ArrayList<>();
			Connection con = Dao.getconnect();
			
			try 
			{
				PreparedStatement ps = con.prepareStatement("select * from contact");
				ResultSet set = ps.executeQuery();
				
				while(set.next())
				{
					
					int id = set.getInt(1);
					String name = set.getString(2);
					String email = set.getString(3);
					String mobile = set.getString(4);
					String query = set.getString(5);
					String status = set.getString(6);
					
					ContactModel cm = new ContactModel();
					cm.setId(id);
					cm.setName(name);
					cm.setEmail(email);
					cm.setMobile(mobile);
					cm.setQuery(query);
					cm.setStatus(status);
					
					list.add(cm);
				}
			}
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
		
	 	public static int changestatus(ContactModel m)
	 	{
	 		int status = 0;
			
			Connection con = Dao.getconnect();
			
			
			try 
			{
				PreparedStatement ps = con.prepareStatement("update contact set status=? where id=?");
				ps.setString(1,m.getStatus());
				ps.setInt(2,m.getId());
				
				status = ps.executeUpdate();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return status;
			
	 	}
	 
	 	public static CartModel getproductcartwise(int id)
		{
			CartModel cm = null;
			Connection con = Dao.getconnect();
			
			try 
			{
				PreparedStatement ps = con.prepareStatement("select * from cart where id=?");
				ps.setInt(1, id);
				
				ResultSet set = ps.executeQuery();
				
				if(set.next())
				{
					int id1 = set.getInt(1);
					String pname = set.getString(2);
					String pprice = set.getString(3);
					String pdes = set.getString(4);
					byte[] imgData = set.getBytes("p_image");
					
					cm = new CartModel();
					cm.setId(id1);
					cm.setP_name(pname);
					cm.setP_price(pprice);
					cm.setP_des(pdes);
					String encode = Base64.getEncoder().encodeToString(imgData);
			        cm.setP_image(encode);
				}
				
			}
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return cm;
		}
	 	
	 	public static List<PaymentModel>viewplacedorder()
		{
			List<PaymentModel>list = new ArrayList<>();
			Connection con = Dao.getconnect();
			
			try 
			{
				PreparedStatement ps = con.prepareStatement("select * from placedorder");
				ResultSet set = ps.executeQuery();
				
				while(set.next())
				{
					
					int id = set.getInt(1);
					int pid = set.getInt(2);
					String pname = set.getString(3);
					String pprice = set.getString(4);
					String pdes = set.getString(5);
					//String pimage = set.getString(5);
					byte[] imgData = set.getBytes("p_image");
					
					PaymentModel pm = new PaymentModel();
					pm.setId(id);
					pm.setP_id(pid);
					pm.setP_name(pname);
					pm.setP_price(pprice);
					pm.setP_des(pdes);
					//pm.setP_image(pimage);

					 // blob field 
			         String encode = Base64.getEncoder().encodeToString(imgData);
			         pm.setP_image(encode);
					
					
					list.add(pm);
				}
			}
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
	
}
