/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.businness.CartSBLocal;
import za.ac.tut.businness.ProductFacadeLocal;
import za.ac.tut.entity.Product;
import za.ac.tut.model.Cart;
import za.ac.tut.model.Store;

/**
 *
 * @author Asus
 */
public class LoadCartServlet extends HttpServlet {

    @EJB
    private ProductFacadeLocal productFacade;

    @EJB
    private CartSBLocal cartSB;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session =  request.getSession();
        
        ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("Cart-List");
        
        
        if(cartList != null){
        ArrayList <Store> products = new ArrayList<>();
        
        List<Cart> cart_List = cartSB.getCartProducts(cartList);
        
        
        
        //String List = "";
        for(Cart c:cart_List){
            Product product = productFacade.findProduct(c.getProductId());
            
            Store store = new Store();
            
            store.setCategory(product.getCategory());
            store.setImage(product.getImage());
            store.setName(product.getName());
            store.setPrice(product.getPrice());
            store.setProductId(product.getProductId());
            store.setQuantity(c.getQuantity());
            
            products.add(store);
        }
        
        double totalPrice = cartSB.getTotalPrice(products);
        
        int totalQuantity = cartSB.getTotalQuantity(products);
        
        //System.out.println(totalQuantity);
        System.out.println(products);
        session.setAttribute("cart-products", products);
        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("totalQuantity", totalQuantity);
        session.setAttribute("cart_List", cart_List);
        RequestDispatcher disp = request.getRequestDispatcher("cart.jsp");
        disp.forward(request, response);
        }
        RequestDispatcher disp = request.getRequestDispatcher("cart.jsp");
        disp.forward(request, response);
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

}
