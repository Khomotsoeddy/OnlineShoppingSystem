/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.OrderFacadeLocal;
import za.ac.tut.entity.Order;

/**
 *
 * @author Asus
 */
public class UpdateOrderStatusServlet extends HttpServlet {

    @EJB
    private OrderFacadeLocal orderFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String updates = request.getParameter("updates");
        Order order = (Order) session.getAttribute("order");
        
        order.setStatus(updates);
        
        orderFacade.updateOrder(order);
        
        response.sendRedirect("AminOrderServlet.do");
    }
}
