import java.io.IOException;

import dao.Dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Model;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet
{
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   {
	     int id = Integer.parseInt(req.getParameter("id"));
	        String fname = req.getParameter("fname");
	        String lname = req.getParameter("lname");
	        String email = req.getParameter("email");
	        String mobile = req.getParameter("mobile");
	        String gender = req.getParameter("gender");
	        String pass = req.getParameter("pass");

	        Model m = new Model();
	        m.setId(id);
	        m.setFname(fname);
	        m.setLname(lname);
	        m.setEmail(email);
	        m.setMobile(mobile);
	        m.setGender(gender);
	        m.setPass(pass);

	        Dao.updatedata(m); 

	        resp.sendRedirect("show.jsp");
  }
}
