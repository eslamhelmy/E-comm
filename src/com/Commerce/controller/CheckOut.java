package com.Commerce.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.OrderBean;
import com.Commerce.bean.ProductBean;
import com.Commerce.bean.UserBean;
import com.Commerce.doas.OrderDao;
import com.Commerce.doas.ProductDao;
import com.Commerce.doas.ShoppingCartDao;
import com.Commerce.doas.UserDao;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
		ProductDao productdao=new ProductDao();
		
		 ArrayList <ProductBean> listProduct=productdao.getProductList(); //all product
		 
		UserBean userData =(UserBean) request.getSession(false).getAttribute("userData");
		
		double credit=userData.getCreditNumber(); //current user credit 
		
		int id=userData.getId(); // user id
		double newCredit=0;
		System.out.println(credit);
		
		 OrderDao orderdao=new OrderDao();
		 ArrayList <OrderBean> listOrder=orderdao.getOrder();  // user order
		 double total=0;
		 int updateProductQuantity=0;
		 
		 for(int i=0;i<listOrder.size();i++){
			
			 
			 total+=(listOrder.get(i).getQuntity())*(listOrder.get(i).getPrice()); //total 
			 
			/* for(int j=0;j<listProduct.size();j++){
				 if(listProduct.get(j).getProductId()==listOrder.get(i).getProductId()){
					 updateProductQuantity=listProduct.get(j).getQuantity()-listOrder.get(i).getQuntity(); // update quantity 
					 productdao.UpdateProductQuantity(listProduct.get(j).getProductId(), updateProductQuantity);
					 
				 }
				 
			 }*/
			
		 }
		 
		 int deletecart=0;
		 int deleteorder=0;
		 PrintWriter out=response.getWriter();
		 //to update credit user
		 System.out.println(total);
		 if(credit>total){
			 //To update Product Quantity
			 for(int i=0;i<listOrder.size();i++){
				 
				 for(int j=0;j<listProduct.size();j++){
					 
					 if(listProduct.get(j).getProductId()==listOrder.get(i).getProductId()){
						 
						 if(listOrder.get(i).getQuntity()>listProduct.get(j).getQuantity() ){
							 out.print("<h1>Sorry this Quantity Not availabe !</h1>");
							 System.out.println("Nottttttt");
							 return;
						 }
						
						 else{
							 updateProductQuantity=listProduct.get(j).getQuantity()-listOrder.get(i).getQuntity(); // update quantity 
							 productdao.UpdateProductQuantity(listProduct.get(j).getProductId(), updateProductQuantity);
						 }
						 
						 
						 
					 }
					 
				 }
				
			 }
			 // update User Credit 
		newCredit=credit-total;
		UserDao userdao= new UserDao();
		userdao.UpdateCredit(id, newCredit);
		System.out.println(newCredit);
		// delete cart and order
		 deletecart = ShoppingCartDao.delete(id);
		 deleteorder = OrderDao.delete(id);
		
		 }
		//////////////////////////////
		 else{
		 			out.print("<h1>Sorry Your order greater than Your Credit!</h1>");
		 }
		
		if(deleteorder>0){
		
			request.getRequestDispatcher("AfterCheckOut.jsp").forward(request, response);
		}
		else{
			response.getWriter().print("<br>Error to Check Out !");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
