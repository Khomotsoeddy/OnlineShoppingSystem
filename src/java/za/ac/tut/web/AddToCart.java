/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
public class AddToCart extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String productName = request.getParameter("productName");
        String productLocation = request.getParameter("MG_20181024_080036.jpg");
        String size = request.getParameter("size");
        String price = (request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        
        System.out.println(productName);
        
        request.setAttribute("productName", productName);
        request.setAttribute("productLocation", productLocation);
        request.setAttribute("size", size);
        request.setAttribute("price", price);
        request.setAttribute("quantity", quantity);
        
        RequestDispatcher disp = request.getRequestDispatcher("cart.jsp");
        disp.forward(request, response);
    }


}
