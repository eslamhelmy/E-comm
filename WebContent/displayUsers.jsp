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
<%@ page import="com.Commerce.bean.*" %>
<%@ page import="java.util.List" %>
<jsp:include page="headerAdmin.jsp"></jsp:include>
<%
List<UserBean> users=UserDao.getAllUsers();
%>
<table cellspacing="5" border="1">
<tr>
<td>ID</td>
<td>Name</td>
<td>Email</td>
<td>Password</td>
<td>Credit Card</td>
<td>Job</td>
<td>Date of Birth</td>
<td>To Delete</td>
</tr>

<% 
for(UserBean us:users){
%>
<tr>
<td><%=us.getId() %></td>
<td><%=us.getFullName() %></td>
<td><%=us.getEmail() %></td>
<td><%=us.getPassword() %></td>
<td><%=us.getCreditNumber() %></td>
<td><%=us.getJob() %></td>
<td><%=us.getDateOfBirth() %></td>
<td><form action="DeleteUser">
<input type="hidden" name="id" value=<%=us.getId() %>>
<input type="submit" value="Delete"></form>
</tr>	
<%
}
%>
</table>
</body>
</html>