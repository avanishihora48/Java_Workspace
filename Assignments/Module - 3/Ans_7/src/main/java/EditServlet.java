import java.io.IOException;
import java.io.PrintWriter;

import dao.Dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Model;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet
{
   @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   {
	   int id = Integer.parseInt(req.getParameter("id"));
       Model student = Dao.editdata(id); 
       req.setAttribute("student", student);
       req.getRequestDispatcher("editstudent.jsp").forward(req, resp);
  }
}
