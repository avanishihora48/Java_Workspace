<%@page import="com.dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="cm" class="com.model.ContactModel"/>    
<jsp:setProperty property="*" name="cm"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
   int status = Dao.contactinsertdata(cm);
	
		if(status>0)
		{
%>

            <div class="row">
               <div class="col-md-8 offset-md-2">
                  <form id="post_form" class="contact_form" action="https://api.web3forms.com/submit" method="post">
                     <div class="row">
                     	
                     	 <input type="hidden" name="access_key" value="e504b919-a5f1-4376-8c5e-37d805fe3431">
                     
                        <div class="col-md-12 ">
                           <input class="contact_control" placeholder=" Name" type="hidden" name="name" value="<%=session.getAttribute("name")%>"> 
                        </div>
                        <div class="col-md-12">
                           <input class="contact_control" placeholder="Email" type="hidden" name="email" value="<%=session.getAttribute("email")%>" readonly="readonly"> 
                        </div>
                        <div class="col-md-12">
                           <input class="contact_control" placeholder="Phone Number " type="hidden" name="mobile" value="<%=session.getAttribute("phone")%>">                          
                        </div>
                        <div class="col-md-12">
                           <input type="hidden" class="textarea" placeholder="Message" name="query"/>
                        </div>
                        <div class="col-md-12">
                           <button class="send_btn">Send Email</button>
                        </div>
                  </form>
                  </div>
               </div>
            </div>
         </div>
      </div>




	<% 
		}
		else
		{
			out.print("fail");
		}
	%>


</body>
</html>