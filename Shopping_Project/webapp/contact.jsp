<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webwing</title>
</head>

	<body>
	
		<jsp:include page="header.jsp"/>
		
			    <div id="contact" class="contact ">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <div class="titlepage">
                     <h2><strong class="yellow">Contact us</strong><br>Request a call back</h2>
                  </div>
               </div>
            </div>
            <div class="row">
               <div class="col-md-8 offset-md-2">
                  <form id="post_form" class="contact_form" action="contactinsert.jsp" method="post">
                     <div class="row">
                     	
                     	 <input type="hidden" name="access_key" value="e504b919-a5f1-4376-8c5e-37d805fe3431">
                     
                        <div class="col-md-12 ">
                           <input class="contact_control" placeholder=" Name" type="type" name="name" value="<%=session.getAttribute("name")%>"> 
                        </div>
                        <div class="col-md-12">
                           <input class="contact_control" placeholder="Email" type="type" name="email" value="<%=session.getAttribute("email")%>" readonly="readonly"> 
                        </div>
                        <div class="col-md-12">
                           <input class="contact_control" placeholder="Phone Number " type="type" name="mobile" value="<%=session.getAttribute("phone")%>">                          
                        </div>
                        <div class="col-md-12">
                           <input type="text" class="textarea" placeholder="Message" name="query"/>
                        </div>
                        <div class="col-md-12">
                           <button class="send_btn">Send</button>
                        </div>
                  </form>
                  </div>
               </div>
            </div>
         </div>
      </div>
		
		<jsp:include page="footer.jsp"/>
 
   </body>
</html>