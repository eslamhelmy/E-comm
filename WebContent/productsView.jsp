<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="com.Commerce.bean.ProductBean"%>
<%@page import="com.Commerce.doas.ProductDao"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Product View</title>
</head>
<body>
<h1>All Product</h1>

<%
ProductDao productdao=new ProductDao();

 ArrayList <ProductBean> list=productdao.getProductList();
 
 
 request.setAttribute("products",list);
%>


<table border="5">
	<tr>
		<td>Name</td>
		<td>price</td>
		<td>Image</td>
		<td>Description</td>
		<td>Action</td>
	</tr>


<c:forEach items="${products}" var="current">
        <tr>
          <td><c:out value="${current.productName}" /></td>
          <td><c:out value="${current.price}" /></td>
          <td><img width="100" height="100" src="<c:out value="${current.imgPath}" />"></img></td>
          <td><c:out value="${current.description}" /></td>
          <td>
        	  <form action="AddToShoppingCart">
    		  <input type="hidden" name="idProduct" value="${current.productId}" />
   		 	  <input type="submit" name="details" value="Add to cart" />
			  </form>
         </td>
        </tr>
 </c:forEach>

</table>



</body>
</html>