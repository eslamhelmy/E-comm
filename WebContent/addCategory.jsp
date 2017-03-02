<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Add Category</title>

<style type="text/css">
    <%@include file="css/styleLogin.css" %>
</style>
</head>
<body>
    <center>
	<h2>Add Category</h2>
	</center>
	<center>
<form class="formLogin" action="addCategoryServlet" >

  <div class="container">
    <label><b>  Name </b></label>
    <input type="text" placeholder="Enter Name Category" name="categName" required>

    <label><b> Description</b></label>
    <input type="text" placeholder="Enter category Description" name="categDesc" required>
        
    <button type="submit">Insert </button>
    
  </div>
</form>
</center>
</body>
</html>