<%@page import="com.dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cm" class="com.model.ContactModel"/>
<jsp:setProperty property="*" name="cm"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Form Submission</title>
</head>
<body>
    <%
        int status = Dao.contactinsertdata(cm);

        if (status > 0) {
    %>
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <form id="post_form" class="contact_form" action="https://api.web3forms.com/submit" method="post">
                    <div class="row">
                        <input type="hidden" name="access_key" value="e504b919-a5f1-4376-8c5e-37d805fe3431">

            

                        <input class="contact_control" type="hidden" name="email" 
                               value="<%= session.getAttribute("email") != null ? session.getAttribute("email") : "" %>"> 

                        <input class="contact_control" type="hidden" name="subject" 
                               value="<%= cm.getSubject() %>"> 

                        <input type="hidden" class="textarea" name="message" 
                               value="<%= cm.getMessage() %>">

                        <button type="submit" class="send_btn">Send Email</button>
                    </div>
                </form>
            </div>
        </div>
    <%
        } else {
            out.print("Failed to insert data into the database.");
        }
    %>
</body>
</html>
