package com.Commerce.controller;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Commerce.bean.ProductBean;
import com.Commerce.doas.ProductDao;
import java.io.OutputStream;


/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public String getPathImg(String pathImg){
    	String replaceString=pathImg.replace('\\','/');
		 String split[]  = replaceString.split("/");
		 String s = "img/";
		 String ss=split[split.length-1];
		 s = s.concat(ss);
		 return s;
	}
    final static String IMAGE_RESOURCE_PATH = "/WebContent/imgs";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		ProductBean product=new ProductBean();
		ProductDao productDao=new ProductDao();
		
		String nameProduct=request.getParameter("productName");
		float price=Float.parseFloat(request.getParameter("price"));
		int quant=Integer.parseInt(request.getParameter("quantity"));
		String img=request.getParameter("image");
		
		int width = 963;    //width of the image
		int height = 640;   //height of the image
		BufferedImage image = null;
		File f = null;
		
		 //read image
		try{
			
		      f = new File(img); //image file path
		      image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		      image = ImageIO.read(f);
		      System.out.println("Reading complete.");
		    }catch(IOException e){
		      System.out.println("Error: "+e);
		    }
		 //write image
	    String name=nameProduct+".jpg";
		File directory=null;
	    try{
	    	//String filePath = getServletContext().getInitParameter("file-upload"); 
		   
	    	//File fi = new File(filePath+nameProduct);
	    	
	    	final  String IMAGE_RESOURCE_PATH = "/WebContent/imgs";
	    	String directoryPath = 
	    	        getServletContext().getRealPath(IMAGE_RESOURCE_PATH + "/" + name);
	    	
	    	 directory = new File(directoryPath);
	    	System.out.println(directory.mkdirs());

	      ImageIO.write(image, "jpg",directory );
	      System.out.println("Writing complete.");
	    }catch(IOException e){
	      System.out.println("Error: "+e);
	    }
		
		
		
		String inStock=request.getParameter("stock");
		String descrption=request.getParameter("productDesc");
		int cateID=Integer.parseInt(request.getParameter("categId"));
		
		product.setProductName(nameProduct);
		product.setPrice(price);
		product.setQuantity(quant);
		product.setImgPath(directory.toString());
		product.setInStock(inStock);
		product.setDescription(descrption);
		product.setCategoryId(cateID);
		
		
		int status=productDao.addProduct(product);
		if(status>0){
			out.print("<p>Product added successfully!</p>");
		}
	  else{  
		  
         out.println("Sorry! unable to add Category");  
          
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
