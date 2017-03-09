<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Electronic Store a Ecommerce User Header</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Electronic Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	SmartPhone Compatible web template, free web designs for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
	function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<!-- Custom Theme files -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" /> 
<link href="css/fasthover.css" rel="stylesheet" type="text/css" media="all" />
<!-- //Custom Theme files -->
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<!-- js -->
<script src="js/jquery.min.js"></script> 
<!-- //js -->  
<!-- web fonts --> 
<link href='//fonts.googleapis.com/css?family=Glegoo:400,700' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- //web fonts --> 
<!-- for bootstrap working -->
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- //for bootstrap working -->
<!-- start-smooth-scrolling -->
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- //end-smooth-scrolling --> 
</head> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import="java.util.ArrayList"%>
 <%@page import="com.Commerce.bean.OrderBean"%>
<%@page import="com.Commerce.doas.OrderDao"%>
<body>

<%
OrderDao orderdao=new OrderDao();

 ArrayList <OrderBean> list=orderdao.getOrder();
 
 request.setAttribute("order",list);
 
 
%>
	
 			<center><div class="simpleCart_shelfItem">
 	 			 <form action="CheckOut">  
   		 	  		 <button  type="submit" class="w3ls-cart" >Check Out</button>
   		 	  		 
			     </form>
			     <br>
			     <form action="HomeServlet">  
   		 	  		 <button  type="submit" class="w3ls-cart" >Back to shop </button>
			     </form>
			       </div>
			</center> 
				
			
			
			<hr/><hr/>
	
				<c:forEach items="${order}" var="current">

						<div class="col-md-4 agileinfo_new_products_grid agileinfo_new_products_grid_mobiles">
							<div class="agile_ecommerce_tab_left mobiles_grid">
								<div class="simpleCart_shelfItem">
								<img width="255px" height="340px" src="<c:out value="${current.imgPath}" />"></img>
									
								</div>
								<h5><a><c:out value="${current.productName}" /></a></h5> 
								
								<div class="simpleCart_shelfItem">
									<p><i class="item_price">$<c:out value="${current.price}" /></i></p>
									<form action="EditQuntityServlet">
    								  <input type="number" name="quntity" min="1" max="500" style="background:#f5f5f5; border:1px solid #DFDFDF" value="${current.quntity}" />
    								  <input type="hidden" name="idProduct" value="${current.productId}" />	
   		 							  <button type="submit" class="w3ls-cart">Edit Quantity</button>
		 							</form>
								</div> 
								
								<div class="simpleCart_shelfItem">
								<form action="DeleteOrderServlet">
    		 						 <input type="hidden" name="idProduct" value="${current.productId}" />
   		 	 						 <button type="submit" class="w3ls-cart">Delete</button>
			 						 </form>
								</div> 
							</div>
						</div>


 			</c:forEach>
 			
 <br>
	<jsp:include page="footer.jsp" />	


</body>
</html>