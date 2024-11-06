import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.mail.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SendMessageServlet")
public class SendMessageServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	HttpSession session = request.getSession();
       
        String senderEmail = (String) session.getAttribute("email");
       
        String receiverEmail = request.getParameter("receiverEmail");
        String messageText = request.getParameter("messageText");

        if (senderEmail == null || receiverEmail == null || messageText == null || messageText.trim().isEmpty()) {
            response.sendRedirect("error.jsp");
            return;
        }

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "")) {
            String sql = "INSERT INTO messages (sender_email, recipient_email, message_content) VALUES (?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, senderEmail);
                ps.setString(2, receiverEmail);
                ps.setString(3, messageText);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("messageSent.jsp");
    }
}
