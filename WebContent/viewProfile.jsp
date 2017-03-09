<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>View Profile </title>
</head>
<body bgcolor="powderblue">
<%@ page import="com.Commerce.bean.*" %>
<jsp:include page="headerAdmin.jsp" />
<%
UserBean us=(UserBean)request.getSession(false).getAttribute("userData");
if(us!=null){
%>	

<h1>Mr <%=us.getFullName() %> Profile</h1>
<form action="editProfile.jsp" >
<table width="100%" height="100%" cellpadding="5" cellspacing="5" border="1">
<tr>
<th align="center">Name</th>
<td><%=us.getFullName() %></td>

</tr>
<tr>
<th align="center">Email</th>
<td><%=us.getEmail() %></td>

</tr>
<tr>
<th align="center">Password</th>
<td><%=us.getPassword() %></td>

</tr>
<tr>
<th align="center">Credit Card</th>
<td><%=us.getCreditNumber() %></td>
</tr>
<tr>
<th align="center">Date of Birth</th>
<td><%=us.getDateOfBirth() %></td>
</tr>

<tr>
<th align="center">Job</th>
<td><%=us.getJob() %></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="edit">
</tr>
</table>	
</form>
<% 	
	
}
%>
</body>
</html>