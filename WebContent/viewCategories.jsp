<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.Commerce.doas.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Commerce.bean.*" %>
<%categoryDao cd=new categoryDao();
ArrayList<categoryBean> list=cd.getCategoryList();
%>
<table>
<tr>
<th>Name</th>
<th>Description</th>
<th>Delete</th>
<th>Edit</th>
</tr>
<%
for(categoryBean cb:list){

%>
<tr>
<td><%=cb.getCategoryName() %></td>
<td><%=cb.getCategoryDescription() %></td>
<td>
<form action="DeleteCategory">
<input type="hidden" name="id" value=<%=cb.getCategoryId() %>>
<input type="submit" value="delete">
</form>
</td>
<td>
<form action="EditCategory">
<input type="hidden" name="id" value=<%=cb.getCategoryId() %>>
<input type="submit" value="edit">
</form>
</td>
</tr>


<%
}
%>


</table>
</body>
</html>