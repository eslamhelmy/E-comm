
    <jsp:include page="headerAdmin.jsp"></jsp:include>	

    <center>
	<h2>Add Category</h2>
	</center>
	<center>
<form class="formLogin" action="addCategoryServlet" >

  <div class="container-fluid">
       <label><b>  Name </b></label>
    <input type="text" placeholder="Enter Name Category" name="categName" required>

    <label><b> Description</b></label>
    <input type="text" placeholder="Enter category Description" name="categDesc" required>
        
    <button class="btn btn-lg" type="submit">Insert </button>    
  </div>
</form>
</center>
<jsp:include page="footer.jsp"></jsp:include>
