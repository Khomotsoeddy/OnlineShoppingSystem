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
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.CustomerFacadeLocal;
import za.ac.tut.entity.Customer;
import za.ac.tut.model.Cart;
import za.ac.tut.model.Store;

/**
 *
 * @author Asus
 */
public class CheckoutServlet extends HttpServlet {

    @EJB
    private CustomerFacadeLocal customerFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        ArrayList<Store> cartList = (ArrayList<Store>) session.getAttribute("cart-products");
        ArrayList<Cart> cart_List = (ArrayList<Cart>) session.getAttribute("Cart-List");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dateFormat.format(date);
        List<Customer> customers = customerFacade.getCustomers();
        String emailAddress = (String) session.getAttribute("emailAddress");
        String password = (String) session.getAttribute("password");
        
        for (Customer s : customers) {
            if (s.getEmail().equals(emailAddress) && s.getPassword().equals(password)) {
                
                String streetName = s.getStreet();
                String town = s.getCity();
                String state = s.getState();
                String zipCode = s.getZip_code();
        
                session.setAttribute("town", town);
                session.setAttribute("streetName", streetName);
                session.setAttribute("state", state);
                session.setAttribute("zipCode", zipCode);
            }
        }
        if(cartList != null){
            for(Store c:cartList){
                
            }
            cart_List.clear();
            response.sendRedirect("shipping_address.jsp");
        }else
            response.sendRedirect("nothingincart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
