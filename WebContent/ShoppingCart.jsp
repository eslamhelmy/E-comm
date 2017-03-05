<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import="java.util.ArrayList"%>
 <%@page import="com.Commerce.bean.OrderBean"%>
<%@page import="com.Commerce.doas.OrderDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Your Shopping Cart</title>
</head>
<body>

<h1>Your Shopping Cart</h1>

<%
OrderDao orderdao=new OrderDao();

 ArrayList <OrderBean> list=orderdao.getOrder();
 
 request.setAttribute("order",list);
 
 
%>


<table border="5">
	<tr>
		<td>Product Name</td>
		<td>Product Image</td>
		<td>Price </td>
		<td>Quantity</td>
		
	</tr>


<c:forEach items="${order}" var="current">
        <tr>
          <td><c:out value="${current.productName}" /></td>
          <td><img width="100" height="100" src="<c:out value="${current.imgPath}" />"></img></td>
          <td><c:out value="${current.price}" /></td>
          <td><c:out value="${current.quntity}" /></td>
       
        </tr>
 </c:forEach>

</table>

 
        	  <form action="">
    		  
   		 	  <input type="submit" name="details" value="Check Out" />

			  </form>
        

</body>
</html>