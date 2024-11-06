<%@ page import="java.sql.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Messages</title>
</head>
<body>
    <h2>Your Messages</h2>
    <%
        String email = (String) session.getAttribute("email");
        if (email == null) 
        {
            response.sendRedirect("login.jsp");  
        }
        else 
        {
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "")) 
            {
                
                String sql = "SELECT * FROM messages WHERE recipient_email = ? ORDER BY timestamp DESC";
                try (PreparedStatement ps = con.prepareStatement(sql)) 
                {
                    ps.setString(1, email);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) 
                    {
                        String senderEmail = rs.getString("sender_email");
                        String messageText = rs.getString("message_content");
                        Timestamp timestamp = rs.getTimestamp("timestamp");
                        int messageId = rs.getInt("id");

                        out.println("<div>");
                        out.println("<p><strong>From: </strong>" + senderEmail + "</p>");
                        out.println("<p><strong>Message: </strong>" + messageText + "</p>");
                        out.println("<p><strong>Time: </strong>" + timestamp + "</p>");
                        out.println("<p><a href='replyMessage.jsp?messageId=" + messageId + "'>Reply</a></p>");
                        out.println("</div><hr>");
                    }
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    %>
</body>
</html>
