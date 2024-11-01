import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/send")
public class postData extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException 
    {
        String u = req.getParameter("username");
        String p = req.getParameter("pass");
  
        String u1 = "tops";
        String p1 = "1234";
   
        if (u1.equals(u) && p1.equals(p)) 
        {
            resp.sendRedirect("Success.html");
        } 
        else 
        {
            resp.sendRedirect("Error.html");
        }
    }
}
