package com.Commerce.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.Part;
/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       

	  
	   public void doPost(HttpServletRequest request,    HttpServletResponse response)   throws ServletException, java.io.IOException {
		   
		   String strpath=request.getParameter("Image");
			String filepath=strpath.substring(strpath.lastIndexOf("\\")+1);
			File imgfile = new File(strpath);
			System.out.println(filepath);
			FileInputStream fin = new FileInputStream(imgfile);
			
		   
		 
	   }

	   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { doPost(request, response); }
	   	    
	


}