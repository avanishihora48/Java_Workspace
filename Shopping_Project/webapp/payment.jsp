<%@page import="com.dao.Dao"%>
<%@page import="com.model.CartModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var xhttp=new XMLHttpRequest();
	var RazorpayOrderId;
	function CreateOrderID()
	{
		alert("1");
		xhttp.open("GET","http://localhost:8080/PaymentInteEx/OrderCreation",false);
		alert("2");
		xhttp.send();
		RazorpayOrderId=xhttp.responseText;
		OpenCheckOut();
	}
</script>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script type="text/javascript">
	function OpenCheckOut()
	{
		alert("3");
		var options={
				"key":"rzp_test_7PX7ejznhsbYwJ",
				"amount":"100",
				"currency":"INR",
				"name":"Tops",
				"description":"Test",
				"order_id":RazorpayOrderId,
				"callback_url":"http://localhost:8080/StripeDemo/OrderCreation",
				"prefill":{
					"name":"Avani",
					"email":"avanishihora50@gmail.com",
					"contact":"6354935874"
				},
				"notes":{
					"address":"Rajkot"
				},
				"theme":{
					"color":"#3399cc"
				}
				
				
		};
		var rzp1=new Razorpay(options);
		rzp1.on('payment.failed',function (response){
			alert(response.error.code);
	        alert(response.error.description);
	        alert(response.error.source);
	        alert(response.error.step);
	        alert(response.error.reason);
	        alert(response.error.metadata.order_id);
	        alert(response.error.metadata.payment_id);
		});
		rzp1.open();
	    e.preventDefault();
	}
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
	<%
		if(session.getAttribute("project")!=null)
		{
			String id = request.getParameter("id");
			int id2 = Integer.parseInt(id);
			CartModel m = Dao.getproductcartwise(id2);
			
			
			
	%>
		
			<br>
			<br>
			<center>
			<h2><%=m.getP_name() %></h2>
			<h3><%=m.getP_price() %></h3>
			<h3><%=m.getP_des() %></h3>
			<img src="data:image/jpeg;base64,<%=m.getP_image()%>" width="350px" height="300px" />
	
	
	<form action="PaymentSave" method="post" enctype="multipart/form-data" class="requires-validation" novalidate>


							
                            
                             <div class="col-md-12">
                               <input class="form-control" type="hidden" name="id" placeholder="Product Name" value="<%=m.getId() %>" required>
                            </div>
                            
                            <div class="col-md-12">
                               <input class="form-control" type="hidden" name="p_name" placeholder="Product Name" value="<%=m.getP_name() %>" required>
                            </div>
                            
                            <div class="col-md-12">
                               <input class="form-control" type="hidden" name="p_price" placeholder="Product Price" value="<%=m.getP_price() %>" required>
                            </div>
                            
                            <div class="col-md-12">
                               <input class="form-control" type="hidden" name="p_des" placeholder="Product Description" value="<%=m.getP_des()%>" readonly="readonly">
                            </div>
                            
                        
                            
                             <div class="col-md-12">
                               <input class="form-control" type="hidden" name="email" placeholder="Product Price" value="<%=session.getAttribute("email") %>" required>
                            </div>
                            
                            
                            <br>
                            <div class="col-md-12">
                            	<input type="hidden" name="p_image" value="data:image/jpeg;base64,<%=m.getP_image() %>" /> 
                             </div>
                             
                             
                               
                  			<br>
                  			
                  			<div class="col-md-12">
                            	<input type="hidden" name="email" value="<%=session.getAttribute("email") %>" /> 
                             </div>
                  

                            <div class="form-button mt-3">
                                <button id="submit" type="submit" onclick="CreateOrderID()" class="btn btn-primary">Payment</button>
                            </div>
                        </form>
	
	<% 		
		}
		else
		{

	%>
			<br>
			<center>
					
					<b><p style="color:red;font-family: sans-serif; font-size: 25px;">Please Login First!!</p></b>
				</center>

				<br>
				<br>
			<%@ include file="signin.jsp"%>

		<% 
		}
		%>

<jsp:include page="footer.jsp"/>
</body>
</html>