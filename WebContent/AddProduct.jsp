<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Commerce.bean.categoryBean"%>
<%@page import="com.Commerce.doas.categoryDao"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Add Product</title>
<style type="text/css">
    <%@include file="css/styleLogin.css" %>
</style>
</head>
<body>
    	
  <%
    	categoryBean category=new categoryBean();
    	categoryDao categDao=new categoryDao();

		 ArrayList <categoryBean> list=categDao.getCategoryList();
 		request.setAttribute("category",list);
 %>

   <center>
	<h2>Add product</h2>
	</center>
	<center>
<form class="formLogin" action="AddProductServlet" >

  <div class="container">
    
    <label><b>  Name </b></label>
    <input type="text" placeholder="Enter Name product" name="productName" required/>
    
    <label><b>  Price </b></label>
    <input type="text" placeholder="Enter Price 00.000" name="price" required/>
    
	<label><b>  Quantity </b></label>
	<input type="number" name="quantity" min="1" max="500"/>
	
	<label><b>  Choose Image </b></label>
	<input type='file' name="image"  required/>
	
	<label><b>  In Stock</b></label>
	<select name="stock">
  <option value="available">Available</option>
  <option value="ReadySoon">Ready Soon</option>
	</select>
	
    <label><b> Description</b></label>
    <input type="text" placeholder="Enter Product Description" name="productDesc" required/>
     <label><b> Category</b></label>  
      
     <select name="categId">
     	<c:forEach items="${category}" var="current">
    		<option value="${current.categoryId}" >${current.categoryName}</option>
    	</c:forEach>
	</select>
	
     
    <button type="submit">Insert  Product</button>
    
    
    
    
    
    
    
    
  </div>
</form>
</center>

</body>
</html>