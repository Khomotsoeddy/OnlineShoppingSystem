/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.businness.ProductFacadeLocal;
import za.ac.tut.entity.Product;
import za.ac.tut.model.Cart;

/**
 *
 * @author Asus
 */
public class ProductServlet extends HttpServlet {

    @EJB
    private ProductFacadeLocal productFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> products = productFacade.listAllProduct();
        
        List<Cart> cart = (List<Cart>) request.getAttribute("Cart-List");
        if(cart != null){
            session.setAttribute("Cart-List", cart);
        }
        
        session.setAttribute("products", products);
        
        response.sendRedirect("products.jsp");
    }


}
