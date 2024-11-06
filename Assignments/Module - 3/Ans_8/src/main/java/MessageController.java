import java.io.IOException;
import com.dao.UserDao;
import com.dao.MessageDao;  
import com.model.ModelMessage;
import com.model.ModelUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MessageController")
public class MessageController extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addUser".equals(action)) {
            ModelUser mu = new ModelUser();
            mu.setFname(request.getParameter("fname"));
            mu.setLname(request.getParameter("lname"));
            mu.setEmail(request.getParameter("email"));
            mu.setMobile(request.getParameter("mobile"));

            UserDao ud = new UserDao();
            boolean isUserAdded = ud.addUser(mu); 

            if (isUserAdded) {
                response.sendRedirect("success.jsp"); 
            } else {
                request.setAttribute("errorMessage", "Failed to add user. Please try again."); 
                request.getRequestDispatcher("error.jsp").forward(request, response); 
            }
        } 
        else if ("sendMessage".equals(action)) {
            ModelMessage mms = new ModelMessage();
            mms.setUid(Integer.parseInt(request.getParameter("uid")));
            mms.setFrom(request.getParameter("from"));
            mms.setTo(request.getParameter("to"));
            mms.setMsg(request.getParameter("msg"));

            MessageDao messageDAO = new MessageDao(); 
            boolean isMessageSent = messageDAO.addMessage(mms); 

            if (isMessageSent) {
                response.sendRedirect("success.jsp"); 
            } else {
                request.setAttribute("errorMessage", "Failed to send message. Please try again."); 
                request.getRequestDispatcher("error.jsp").forward(request, response); 
            }
        }
    }
}
