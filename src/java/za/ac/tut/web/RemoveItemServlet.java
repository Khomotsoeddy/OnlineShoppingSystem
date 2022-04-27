/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.Cart;
import za.ac.tut.model.Store;

/**
 *
 * @author Asus
 */
public class RemoveItemServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productId = request.getParameter("id");
    
        if(productId != null){
            ArrayList<Store> cartList = (ArrayList<Store>) request.getSession().getAttribute("cart-products");
            if(cartList != null){
                for(Store c:cartList){
                    if(c.getProductId() == Integer.parseInt(productId)){
                        cartList.remove(cartList.indexOf(c));
                        break;
                    }
                }  
                response.sendRedirect("cart.jsp");
            }
        }else{
            response.sendRedirect("cart.jsp");
        }
    }
}
