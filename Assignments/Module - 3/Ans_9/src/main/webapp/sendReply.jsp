<%@ page import="java.sql.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reply Sent</title>
</head>
<body>
    <h2>Reply Sent Successfully</h2>
    
    <%
        String email = (String) session.getAttribute("email");
        String replyContent = request.getParameter("replyContent");
        String originalMessageId = request.getParameter("originalMessageId");

        if (email == null) 
        {
            response.sendRedirect("login.jsp");
        } 
        else 
        {
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "")) 
            {
                
                String originalMessageQuery = "SELECT sender_email, recipient_email FROM messages WHERE id = ?";
                try (PreparedStatement ps = con.prepareStatement(originalMessageQuery)) 
                {
                    ps.setString(1, originalMessageId);
                    ResultSet rs = ps.executeQuery();
                    
                    if (rs.next()) 
                    {
                        String senderEmail = rs.getString("sender_email");
                        String receiverEmail = rs.getString("recipient_email");

                        String replyQuery = "INSERT INTO messages (sender_email, recipient_email, message_content, timestamp) VALUES (?, ?, ?, NOW())";
                        try (PreparedStatement replyPs = con.prepareStatement(replyQuery)) 
                        {
                            replyPs.setString(1, email);  
                            replyPs.setString(2, senderEmail);  
                            replyPs.setString(3, replyContent);
                            replyPs.executeUpdate();
                          
                            out.println("<p>Your reply has been sent to " + senderEmail + ".</p>");
                        }
                    } 
                    else 
                    {
                        out.println("<p>Original message not found.</p>");
                    }
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
                out.println("<p>Error occurred while sending the reply. Please try again later.</p>");
            }
        }
    %>

    <p><a href="yourMessages.jsp">Go back to your messages</a></p>
</body>
</html>
