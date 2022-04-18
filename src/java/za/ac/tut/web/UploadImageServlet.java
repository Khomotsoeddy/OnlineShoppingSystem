/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.io.PrintWriter;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Asus
 */
public class UploadImageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Part file = request.getPart("file");
        
        String fileName = file.getSubmittedFileName();
        String productCategory = request.getParameter("productCategory");
        String productPrice = request.getParameter("productPrice");
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        
        
        String uploadPath = "./product_images/"+fileName;
        
        System.out.println(fileName);
        try{
            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is= file.getInputStream();

            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
//        System.out.println("Added");
//        
//        request.setAttribute("fileName", fileName);
//        RequestDispatcher disp = request.getRequestDispatcher("display.jsp");
//        disp.forward(request, response);
    }
}
