
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitStudent")
public class submitStudent extends HttpServlet
{
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   {
	   String fname = req.getParameter("fname");
       String lname = req.getParameter("lname");
       String email = req.getParameter("email");
       String mobile = req.getParameter("mobile");
       String gender = req.getParameter("gender");
       String password = req.getParameter("password");

       System.out.println("First Name: " + fname);
       System.out.println("Last Name: " + lname);
       System.out.println("Email: " + email);
       System.out.println("Mobile: " + mobile);
       System.out.println("Gender: " + gender);
       System.out.println("Password: " + password); 

    
       resp.getWriter().println("Student information submitted successfully!");
   }
   
}
