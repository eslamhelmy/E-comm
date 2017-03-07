<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ page import="com.Commerce.bean.*" %>
    <%@page import="java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Search page</title>
</head>
<body>



<% 
@SuppressWarnings("unchecked")
ArrayList<ProductBean> product=(ArrayList<ProductBean>)request.getAttribute("searchRes");

%>



<table border="5">
	<tr>
		<td>Name</td>
		<td>price</td>
		<td>Image</td>
		<td>Description</td>
		<td>Action</td>
	</tr>
<%
for(ProductBean products:product){
%>
<tr>
<td><%= products.getProductName()%></td>
<td><%= products.getPrice()%></td>
<td><img width="100" height="100" src="<c:out value="<%= products.getImgPath()%>"/>"></img></td>
<td><%= products.getDescription()%></td>
<td>
        	  <form action="AddToShoppingCart">
    		  <input type="hidden" name="idProduct" value="<%= products.getProductId()%>" />
   		 	  <input type="submit" name="details" value="Add to cart" />
			  </form>
         </td>
</tr>


<%} %>

</table>

<br><br>
  <form action="ShoppingCart.jsp">
   		 	  <input type="submit" name="details" value="Go to your Shopping Cart" />
  </form>




</body>
</html>