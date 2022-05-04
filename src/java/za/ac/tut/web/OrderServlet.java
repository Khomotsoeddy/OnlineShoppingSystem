/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.OrderFacadeLocal;
import za.ac.tut.entity.Address;
import za.ac.tut.entity.Customer;
import za.ac.tut.entity.Order;
import za.ac.tut.model.Store;

/**
 *
 * @author Asus
 */
public class OrderServlet extends HttpServlet {

    @EJB
    private OrderFacadeLocal orderFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String orderedDate = df.format(date).toString();
        //System.out.println(df.format(date));
        Calendar c = Calendar.getInstance();
        
        try {
            c.setTime(df.parse(orderedDate));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
            c.add(DATE, 7);
        
        String expectedDate = df.format(c.getTime());
        
        //System.out.println(date2);
        
        
        HttpSession session = request.getSession();
        Customer cos = null;
        
        ArrayList<Store> products = (ArrayList<Store>) session.getAttribute("cart-products");
        Address address = null;
        int orderNo = orderFacade.generateOrderNo();
        
        Order order = createNewOrder(orderNo,products,address,cos,expectedDate,orderedDate);
        
        System.out.println(order);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private Order createNewOrder(int orderNo, ArrayList<Store> products, Address address, Customer cos, String expectedDate, String orderedDate) {
        Order order = new Order();
        
        order.setOrderNo(orderNo);
        order.setCustomerNo(cos);
        order.setAddress(address);
        order.setExpectedDate(expectedDate);
        order.setOrderedDate(orderedDate);
        order.setStore(products);
        
        return order;
    }

}
