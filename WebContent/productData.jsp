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
<%
ProductBean product=(ProductBean) request.getAttribute("productData");
%>
<table>
<tr>
<td><%=product.getProductId()%><br>	
<%=product.getProductName()%><br>
<%=product.getPrice() %><br>
<%=product.getQuantity() %><br>
<%=product.getInStock() %><br>
<%=product.getCategoryId() %><br>
<%=product.getDescription() %><br>

<img width="100" height="100" src="<%=product.getImgPath() %>"></img>
</td>
</tr>

</table>
</body>
</html>