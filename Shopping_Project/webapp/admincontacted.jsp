<%@page import="com.dao.Dao"%>
<%@page import="com.model.ContactModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Panel</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <!-- Custom CSS -->
 
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <!-- Custom CSS -->
  <style>
    /* Add custom styles here */
    body {
      background-color: #f4f4f4;
    }
    .sidebar {
      background-color: #343a40;
      color: white;
      height: 100vh;
    }
    .content {
      padding: 20px;
    }
  </style>

  
</head>
<body>

	<%
    
	    response.setHeader("cache-control", "no-cache");
	    response.setHeader("cache-control", "no-store");
	    response.setHeader("pragma", "no-cache");
	    response.setDateHeader("Expires", 0);
    
    %>

<%
	if(session.getAttribute("webwingadmin")!=null)
	{
		
	}
	else
	{
		response.sendRedirect("adminlogin.jsp");
	}

%>

  
    <div class="row">
      <!-- Sidebar -->
      <div class="col-md-3 col-lg-2 sidebar">
        <div class="pt-3">
          <h2>Admin Panel</h2>
          
          
          
          <ul class="nav flex-column mt-3">
            <li class="nav-item">
              <a class="nav-link" href="adminaddproducts.jsp" style="color: white;">Add Products</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="adminviewproducts.jsp" style="color: white;">View All Products</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="adminplacedorder.jsp" style="color: white;">Placed Order</a>
            </li>
             <li class="nav-item">
              <a class="nav-link" href="admincontacted.jsp" style="color: white;">Queries</a>
            </li>
             <li class="nav-item">
              <a class="nav-link" href="adminlogout.jsp" style="color: red;">Logout</a>
            </li>
            
          </ul>
        </div>
      </div>

      <!-- Main Content -->
      <div class="col-md-9 col-lg-10 content">
       
        <h2>Welcome to the Admin Panel</h2>
       	  <table class="scroll table table-bordered  ">
         <thead>
            <th>Name</th>
			<th>Email</th>
			<th>Subject</th>
			<th>Message</th>
			<th>Status</th>
			
         </thead>
         <tbody>
           <%
			List<ContactModel> list = Dao.viewquery();
			for(ContactModel m : list)
			{
			%>
			<tr>
				<td><%=m.getName() %></td><td><%=m.getEmail() %></td><td><%=m.getMobile() %></td><td><%=m.getQuery() %></td>
				<td>
					
					<%=m.getStatus() %>
				<form action="contactstatus.jsp">
					<select name="status">
						<option>Pending</option>
						<option>Resolved</option>
					</select>
					<input type="hidden" name="id" value="<%=m.getId()%>">
					<input type="submit" value="update">
				
				</form>
				
				</td>
			
				
			<%-- 	
				<form action="contactstatus.jsp">
				
					<td>
					
						
						<%
							String status=m.getStatus().toString();
							if(status=="" && status.isEmpty())
							{
						%>		
							 <select name="status">
								<option>Pending</option>
								<option>Resolved</option>
							</select>	 
						
						<% 		
							}
							else
							{
						%>
						
							<select>
								<option><%=m.getStatus() %></option>
								
								<%
									if(m.getStatus()=="Pending")
									{
								%>
								
								<option>Resolved</option>		
								<% 	
									}
									else if(m.getStatus()=="Resolved")
									{
								%>
								
								<option>Pending</option>			
								<% 	
									}
								%>
								
								
							</select>
							
						
						
						
						<% 		
							}
						%>
						
						
						
				
					<input type="hidden" name="id" value="<%=m.getId()%>">
					<input type="submit" value="update">
					</td>
					
				</form> --%>
				
				
				
				
				<!-- <td><a href="queryedit.jsp">Edit</a></td> -->
			</tr>	
			
			<%
				}
			
			%>
			
         </tbody>
      </table>
       	 
        <!-- Add your content here -->
      </div>
    </div>
  </div>
 <div class="container ">
     
   </div>

  <%-- <div class="container-fluid">
    <div class="row">
      <!-- Sidebar -->
      <div class="col-md-3 col-lg-2 sidebar">
        <div class="pt-3">
          <h2>Admin Panel</h2>
          
          
          
          <ul class="nav flex-column mt-3">
            <li class="nav-item">
              <a class="nav-link" href="adminaddproducts.jsp" style="color: white;">Add Products</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="adminviewproducts.jsp" style="color: white;">View All Products</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#" style="color: white;">Placed Order</a>
            </li>
             <li class="nav-item">
              <a class="nav-link" href="admincontacted.jsp" style="color: white;">Queries</a>
            </li>
             <li class="nav-item">
              <a class="nav-link" href="adminlogout.jsp" style="color: red;">Logout</a>
            </li>
            
          </ul>
        </div>
      </div>
 <div class="scroll">
<table align="center" border="1"  style="background-color: aqua;height: 100%;width: 100%;">
	
	<tbody>
		<tr>
			
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Description</th>
			<th>Product Image</th>
		</tr>		
  
<%
	List<ImageModel> list = ImageDao.getAll();
	
	
	for(ImageModel m : list)
	{
		
	
	
%>
		<tr>
			</td><td><%=m.getP_name() %></td><td><%=m.getP_price() %></td><td><%=m.getP_des() %></td><td><img src="data:image/jpeg;base64,<%=m.getP_image()%>" width="150px" height="200px" /></td>
		</tr>
		
<%
	}
%>
		</tbody>	
	</table>
	</div>


    </div>
  </div>

  <!-- Bootstrap JS and dependencies -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> --%>
</body>
</html>
    