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
<%categoryBean category=(categoryBean)request.getAttribute("category"); %>

<form action="SaveCategory">
<table>
<tr>
<th>Name</th>
<td><input type="text" name="name" value=<%=category.getCategoryName() %>>
</td>
</tr>
<tr>
<th>Description</th>
<td><input type="text" name="desc" value=<%=category.getCategoryDescription() %>>
</td>
</tr>

<tr>
<td></td>
<td>
<input type="hidden" name="id" value=<%=category.getCategoryId() %>>
<input type="submit" value="save" >
</td>
</tr>


</table>




</form>
</body>
</html>