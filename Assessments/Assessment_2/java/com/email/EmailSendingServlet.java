
package com.email;
import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet
{
	String resultMessage = "";
	private String host;
	private String port;
	private String user;
	private String pass;

	
	@Override
	public void init() throws ServletException
	{
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
	
		HttpSession sess = req.getSession();
		
		String recipient = sess.getAttribute("email").toString();
		String subject = "Welcome to Shopping Project";
		String content = "Your OTP is "+sess.getAttribute("n1")+sess.getAttribute("n2")+sess.getAttribute("n3")+sess.getAttribute("n4");
		
		
		try 
		{
			EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("otpsend.jsp");
		}
		catch (AddressException e)
		{
			e.printStackTrace();
		} 
		catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
