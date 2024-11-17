import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/newPassword")
public class NewPassword extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

		HttpSession session = request.getSession();
		String newPassword = request.getParameter("password");
		String confPassword = request.getParameter("confPassword");
		RequestDispatcher dispatcher = null;
		
		 	
		if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) 
		{
			String email = (String) session.getAttribute("email");

			if (email == null) {
				request.setAttribute("status", "sessionExpired");
				dispatcher = request.getRequestDispatcher("login.jsp");
			} 
			else 
			{
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_reg", "root", "");

					PreparedStatement pst = con.prepareStatement("update user set password = ? where email = ? ");
					pst.setString(1, confPassword);  
					pst.setString(2, email);  

					int rowCount = pst.executeUpdate();
					if (rowCount > 0) 
					{
						request.setAttribute("status", "resetSuccess");
						response.sendRedirect("login.jsp");
					} 
					else 
					{
						request.setAttribute("status", "resetFailed");
						System.out.println("fail");
					}
					dispatcher.forward(request, response);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		} 
		else {
			request.setAttribute("status", "passwordMismatch");
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
