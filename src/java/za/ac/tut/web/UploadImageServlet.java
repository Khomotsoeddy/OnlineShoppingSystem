/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import za.ac.tut.business.ProductFacadeLocal;
import za.ac.tut.entity.Product;

/**
 *
 * @author Asus
 */
@MultipartConfig
public class UploadImageServlet extends HttpServlet {

    @EJB
    private ProductFacadeLocal productFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Part file = request.getPart("file");
        
        String fileName = file.getSubmittedFileName();
        String productCategory = request.getParameter("productCategory");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        
        
        String uploadPath = "C:/Users/Asus/Desktop/INT316D/project/OnlineShopping/web/product_images/"+fileName;
        
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
        Product product = createProduct(fileName,productCategory,productPrice,productName,productId);
        productFacade.addProduct(product);
//        System.out.println("Added");
//        
//        request.setAttribute("fileName", fileName);
//        RequestDispatcher disp = request.getRequestDispatcher("display.jsp");
//        disp.forward(request, response);
    }

    private Product createProduct(String fileName, String productCategory, double productPrice, String productName, int productId) {
        Product product = new Product();
        
        product.setCategory(productCategory);
        product.setImage(fileName);
        product.setName(productName);
        product.setPrice(productPrice);
        product.setProductId(productId);
        
        return product;
    }
}
