<%@ page import="java.sql.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reply to Message</title>
</head>
<body>
    <h2>Reply to Message</h2>
    
    <%
        String email = (String) session.getAttribute("email");
        String messageId = request.getParameter("messageId");

        if (email == null)
        {
            response.sendRedirect("login.jsp");
        } 
        else 
        {
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "")) {
                String sql = "SELECT * FROM messages WHERE id = ?";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, messageId);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        String senderEmail = rs.getString("sender_email");
                        String messageText = rs.getString("message_content");
                        Timestamp timestamp = rs.getTimestamp("timestamp");

                        out.println("<div>");
                        out.println("<p><strong>From: </strong>" + senderEmail + "</p>");
                        out.println("<p><strong>Message: </strong>" + messageText + "</p>");
                        out.println("<p><strong>Time: </strong>" + timestamp + "</p>");
                        out.println("</div><hr>");
                       
                        out.println("<form action='sendReply.jsp' method='post'>");
                        out.println("<input type='hidden' name='originalMessageId' value='" + messageId + "' />");
                        out.println("<textarea name='replyContent' rows='5' cols='40' placeholder='Write your reply here'></textarea><br><br>");
                        out.println("<button type='submit'>Send Reply</button>");
                        out.println("</form>");
                    } else {
                        out.println("<p>Message not found!</p>");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    %>
</body>
</html>
