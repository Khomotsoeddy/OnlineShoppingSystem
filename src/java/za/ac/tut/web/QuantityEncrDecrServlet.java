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
import javax.servlet.http.HttpSession;
import za.ac.tut.model.Cart;

/**
 *
 * @author Asus
 */
public class QuantityEncrDecrServlet extends HttpServlet {
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));
        
        ArrayList<Cart> cart_List = (ArrayList<Cart>) session.getAttribute("Cart-List");
        
        if(action!=null && id>0){
            if(action.equals("inc")){
                for(Cart c : cart_List){
                    if(c.getProductId() == id){
                        int quantity = c.getQuantity();
                        quantity++;
                        c.setQuantity(quantity);
                        response.sendRedirect("LoadCartServlet.do");
                    }
                }
            }
            if(action.equals("dec")){
                for(Cart c : cart_List){
                    if(c.getProductId() == id && c.getQuantity() >1){
                        int quantity = c.getQuantity();
                        quantity--;
                        c.setQuantity(quantity);
                        response.sendRedirect("LoadCartServlet.do");
                        break;
                    }
                }
            }
        }else{
            response.sendRedirect("cart.jsp");
        }
    }
}
