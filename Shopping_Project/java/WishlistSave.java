import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Base64;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/WishlistSave")
@MultipartConfig(maxFileSize=16177216)
public class WishlistSave extends HttpServlet 
{
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	 {
		 HttpSession ss = req.getSession(false);
			
			if(ss != null)
			{
			
			String usl = "jdbc:mysql://localhost:3306/shopping_project";
			String user = "root";
			String pass = "";
		
			String id3 = req.getParameter("id");
			int id4 = Integer.parseInt(id3);
			String name = req.getParameter("p_name");
			String price = req.getParameter("p_price");
			String description = req.getParameter("p_des");
			String image = req.getParameter("p_image");
			String email = req.getParameter("email");
			
				String base64ImageData = image.split(",")[1];
			 byte[] imageData = Base64.getDecoder().decode(base64ImageData);
			 InputStream io = new ByteArrayInputStream(imageData);
		
			int r = 0;
			Connection con = null;
		
			
				try {
					
				Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(usl, user, pass);
					
					PreparedStatement ps = con.prepareStatement("insert into wishlist(p_name,p_price,p_image,p_des,email) values(?,?,?,?,?)");
	
					
					ps.setString(1, name);
					ps.setString(2, price);				
					ps.setBlob(3, io);
					ps.setString(4,description);
					ps.setString(5,email);
					//ps.setInt(6,id4);
					
					r = ps.executeUpdate();
				
					if(r>0)
					{
						System.out.println("done");
						resp.sendRedirect("wishlist.jsp");
					}
					else				{
					System.out.println("error");
					}
					
					
				
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			}
			
			
			
			
		}
	}
