import java.io.IOException;

import com.dao.Dao;
import com.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();

	    Integer userId = (Integer) session.getAttribute("userId");
	    if (userId == null) 
	    {
	        response.getWriter().println("Error: User is not logged in.");
	        return;
	    }

	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String mobile = request.getParameter("mobile");

	    Model user = new Model();
	    user.setId(userId);  
	    user.setName(name);
	    user.setEmail(email);
	    user.setMobile(mobile);

	    boolean updateSuccess = Dao.updateProfile(user);

	    if (updateSuccess) {
	      
	        session.setAttribute("name", name);
	        session.setAttribute("email", email);
	        session.setAttribute("mobile", mobile);

	        response.sendRedirect("dashboard.jsp");
	    } else {
	        response.getWriter().println("Error updating profile. Please try again.");
	    }
	}

}
