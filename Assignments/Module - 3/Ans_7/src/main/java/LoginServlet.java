import java.io.IOException;
import java.io.PrintWriter;

import dao.Dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Model;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   {
	   resp.setContentType("text/html");
	   PrintWriter out = resp.getWriter();
	   
	   String email = req.getParameter("email");
	   String pass = req.getParameter("pass");
	   
	   Model m = new Model();
	   m.setEmail(email);
	   m.setPass(pass);
	   
	   Model m2 = Dao.logindata(m);
	   
	   if(m2 != null)
	   {
		   resp.sendRedirect("show.jsp");
	   }
	   else
	   {
		   out.print("Login Fail");
		   
	   }
	    
   }
}
