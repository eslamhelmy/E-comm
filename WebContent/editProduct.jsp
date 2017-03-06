<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.Commerce.bean.*" %>
<%ProductBean product=(ProductBean)request.getAttribute("sendproduct"); %>
<%=product.getProductName() %>
<form action="EditChangesProduct">
<table>
<tr>
<th>Name</th>
<td><input type="text" name="name" value=<%=product.getProductName() %>></td>
</tr>
<tr>
<th>Category</th>
<td><input type="text" name="category" value=<%=product.getCategoryId() %>></td>
</tr>
<tr>
<th>Quantity</th>
<td><input type="text" name="quantity" value=<%=product.getQuantity() %>></td>
</tr>
<tr>
<th>Price</th>
<td><input type="text" name="price" value=<%=product.getPrice() %>></td>
</tr>
<tr>
<td></td>
<td><input type="hidden" name="idproduct" value=<%=product.getProductId() %>>
<input type="submit" value="save">
</table>


</form>
</body>
</html>