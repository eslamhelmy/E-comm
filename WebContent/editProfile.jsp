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
UserBean us=(UserBean)request.getSession(false).getAttribute("userData");
if(us!=null){
	
%>
<form action="EditProfile" method="post">
<table width="100%" height="100%" cellpadding="5" cellspacing="5" border="1">
<tr>
<th align="center">Name</th>
<td><input type="text" name="fullName" value=<%=us.getFullName() %>></td>
</tr>
<tr>
<th align="center">Email</th>
<td><input type="text" name="email" value=<%=us.getEmail() %>></td>
</tr>
<tr>
<th align="center">Password</th>
<td><input type="text" name="password" value=<%=us.getPassword() %>></td>
</tr>
<tr>
<th align="center">Credit Card</th>
<td><input type="text" name="creditcard" value=<%=us.getCreditNumber() %>></td>
</tr>
<tr>
<th align="center">Date of Birth</th>
<td><input type="text" name="dateofbirth" value=<%=us.getDateOfBirth() %>></td>
</tr>

<tr>
<th align="center">Job</th>
<td><input type="text" name="job" value=<%=us.getJob() %>></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="save">

</tr>
</table>	
</form>	
<%
}
%>

</body>
</html>