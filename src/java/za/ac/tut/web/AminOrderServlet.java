/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.OrderFacadeLocal;
import za.ac.tut.business.ProductFacadeLocal;
import za.ac.tut.entity.Order;
import za.ac.tut.entity.Product;

/**
 *
 * @author Asus
 */
public class AminOrderServlet extends HttpServlet {
    
    @EJB
    private ProductFacadeLocal productFacade;

    @EJB
    private OrderFacadeLocal orderFacade;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Order> orders = orderFacade.getOrders();
        //Order order =(Order) session.getAttribute("order");
        //System.out.println("adress" + order.getAddress()+"\n customer number "+order.getCustomerNo()+"\n "+order.getStore().get(0).getName()+"\nPrice "+order.getTotalPrice());
        if(!orders.isEmpty()){
            List<Product> products = new ArrayList<>();
            
            for(int i = 0;i<orders.size();i++){
                Product product = productFacade.findProduct(orders.get(i).getStore().get(i));
                products.add(product);
            }
            session.setAttribute("orders", orders);
            session.setAttribute("products", products);
            response.sendRedirect("admin_order.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
