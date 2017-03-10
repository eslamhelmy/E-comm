<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*"%>
<%@page import="com.Commerce.bean.ProductBean"%>
<%@page import="com.Commerce.doas.ProductDao"%>
<html>
<head>
<title>Electronic Store a Ecommerce User Header</title>

</head> 
<body>
		
<%
ProductDao productdao=new ProductDao();

 List <ProductBean> list=productdao.getProductList();
 
 
 request.setAttribute("products",list);
%>
							
					<c:forEach items="${products}" var="current">
						<div class="col-md-4 agileinfo_new_products_grid agileinfo_new_products_grid_mobiles">
							<div class="agile_ecommerce_tab_left mobiles_grid">
								<div class="simpleCart_shelfItem">
								<img width="255px" height="340px" src="<c:out value="${current.imgPath}" />"></img>
									
								</div>
								<h5><a><c:out value="${current.productName}" /></a></h5> 
								<div class="simpleCart_shelfItem">
									<p><i class="item_price">$<c:out value="${current.price}" /></i></p>
									<form action="AddToShoppingCart">
										<input type="hidden" name="idProduct" value="${current.productId}" />  
										<button type="submit" class="w3ls-cart">Add to cart</button>
									</form>
								</div> 
								
							</div>
						</div>
					 </c:forEach>
					 
					 	
					
						


</body>
</html>