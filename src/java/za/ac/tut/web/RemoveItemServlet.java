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
        HttpSession session = request.getSession();
        String productId = request.getParameter("id");
    
        if(productId != null){
            ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("Cart-List");
            if(cartList != null){
                for(Cart c:cartList){
                    if(c.getProductId() == Integer.parseInt(productId)){
                        cartList.remove(c);
                        break;
                    }
                }  
                session.setAttribute("Cart-List", cartList);
                response.sendRedirect("LoadCartServlet.do");
            }
        }else{
            response.sendRedirect("LoadCartServlet.do");
        }
    }
}
