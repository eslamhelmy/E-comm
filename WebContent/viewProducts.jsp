<%@page import="com.Commerce.doas.ProductDao"%>
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
<%@ page import="java.util.List" %>
<%
ProductDao productDao=new ProductDao();
List<ProductBean> products=productDao.getProductList();
%>
<table cellspacing="5" cellpadding="5" border="1">
<tr>
<!-- <th>ID</th> -->
<th>Name</th>
<th>Price</th>
<th>Quantity</th>
<!-- <th>Stock</th> -->
<th>Category</th>
<!--  <th>Description</th>-->
<th>View Product</th>
<th>Delete Product</th>
<th>Edit Product</th>

</tr>
<% 
for(ProductBean product:products){
%>
<tr>	
<!-- <td><%=product.getProductId()%></td> -->	
<td><%=product.getProductName()%></td>
<td><%=product.getPrice() %></td>
<td><%=product.getQuantity() %></td>
<!-- <td><%=product.getInStock() %></td> -->
<td><%=product.getCategoryId() %></td>
<!-- <td><%=product.getDescription() %></td> -->
<td><form action="ViewProduct"><input type="hidden" name="id" value=<%=product.getProductId() %>>
	<input type="submit" value="view"></form></td>
<td><form action="DeleteProduct">
<input type="hidden" name="id" value=<%=product.getProductId() %>>
	<input type="submit" value="Delete"></form></td>
<td><form action="EditProduct"><input type="hidden" name="id" value=<%=product.getProductId() %>>
	<input type="submit" value="Edit"></form></td>
	
</tr>	
<%	
}
%>
</table>
</body>
</html>