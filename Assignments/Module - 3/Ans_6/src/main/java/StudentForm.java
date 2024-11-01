import java.io.IOException;
import java.io.PrintWriter;

import dao.Dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Model;

@WebServlet("/StudentForm")
public class StudentForm extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String pass = req.getParameter("pass");
        
        Model m = new Model();
        m.setFname(fname);
        m.setLname(lname);
        m.setEmail(email);
        m.setEmail(email);
        m.setMobile(mobile);
        m.setPass(pass);
        
        int status = Dao.insertdata(m);
        
        if(status > 0)
        {
        	resp.sendRedirect("Login.jsp");
        }
        else
        {
        	out.print("Error");
        }
	} 
}
