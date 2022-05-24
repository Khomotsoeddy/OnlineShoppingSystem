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
import za.ac.tut.business.OrderFacadeLocal;
import za.ac.tut.business.ProductFacadeLocal;
import za.ac.tut.entity.Customer;
import za.ac.tut.entity.Order;
import za.ac.tut.entity.Product;
import za.ac.tut.business.CustomerFacadeLocal;


/**
 *
 * @author Asus
 */
public class LoadOrdersServlet extends HttpServlet {

    @EJB
    private ProductFacadeLocal productFacade;

    @EJB
    private OrderFacadeLocal orderFacade;

    @EJB
    private CustomerFacadeLocal customerFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Order> orders = orderFacade.getOrders();
        List<Product> products = productFacade.listAllProduct();
        List<Customer> customers = customerFacade.getCustomers();
        String emailAddress = (String) session.getAttribute("emailAddress");
        String password = (String) session.getAttribute("password");
        Long costomerNo = null;
        for (Customer s : customers) {
            if (s.getEmail().equals(emailAddress) && s.getPassword().equals(password)) {
                costomerNo = s.getId();
            }
        }
        if (!orders.isEmpty()) {
            
            session.setAttribute("orders", orders);
            session.setAttribute("products", products);
            session.setAttribute("costomerNo", costomerNo);
            response.sendRedirect("order.jsp");
        } else {
            response.sendRedirect("cart.jsp");
        }

    }
}
