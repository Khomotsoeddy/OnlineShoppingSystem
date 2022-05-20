/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class BuyNowServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Store> store = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dateFormat.format(date);
        HttpSession session = request.getSession();
        String emailAddress = (String) request.getSession().getAttribute("emailAddress");
        ArrayList<Cart> cartList = new ArrayList<>();
        if(emailAddress != null){
            int productId = Integer.parseInt(request.getParameter("id"));
            Integer quantity = 0;//Integer.parseInt(request.getParameter("quantity"));
            
            //ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("Cart-List");
            if(quantity <= 0){
                quantity=1;
                Cart ct  = new Cart();
                
                ct.setProductId(productId);
                ct.setQuantity(quantity);
                cartList.add(ct);
                session.setAttribute("Cart-List",cartList);
            }
            response.sendRedirect("LoadCartServlet.do");
        }else{
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
