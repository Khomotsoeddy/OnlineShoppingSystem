/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.CustomerFacadeLocal;
import za.ac.tut.business.OrderConfirmationLocal;
import za.ac.tut.business.OrderFacadeLocal;
import za.ac.tut.entity.Customer;
import za.ac.tut.entity.Order;
import za.ac.tut.model.Store;

/**
 *
 * @author Asus
 */
public class OrderServlet extends HttpServlet {

    @EJB
    private OrderConfirmationLocal orderConfirmation;

    @EJB
    private CustomerFacadeLocal customerFacade;

    @EJB
    private OrderFacadeLocal orderFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = null;
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String orderedDate = df.format(date).toString();
        
        Calendar c = Calendar.getInstance();

        try {
            c.setTime(df.parse(orderedDate));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        c.add(DATE, 7);

        String expectedDate = df.format(c.getTime());
        Long costomerNo = null;

        List<Customer> customers = customerFacade.getCustomers();
        HttpSession session = request.getSession();
        String emailAddress = (String) session.getAttribute("emailAddress");
        String password = (String) session.getAttribute("password");
        for (Customer s : customers) {
            if (s.getEmail().equals(emailAddress) && s.getPassword().equals(password)) {
                costomerNo = s.getId();
            }
        }

        List<Store> store = (List<Store>) session.getAttribute("cart-products");
        List<Integer> products = new ArrayList<>();

        for (Store s : store) {

            products.add(s.getProductId());
        }
        int orderNo = orderFacade.generateOrderNo();
        double totalPrice = (Double) session.getAttribute("totalPrice");
        int totalQuantity = (int) session.getAttribute("totalQuantity");
        String status = "processing";
        String town = (String) session.getAttribute("town");
        String streetName = (String) session.getAttribute("streetName");
        //String suburb = (String) session.getAttribute("suburb");
        String province = (String) session.getAttribute("province");
        String zipCode = (String) session.getAttribute("zipCode");

        Order order = createNewOrder(orderNo, products, costomerNo, expectedDate, orderedDate, totalPrice, totalQuantity, streetName, town, province, zipCode, status);
        orderFacade.createOrder(order);
        orderConfirmation.orderConfirm(emailAddress, order);

        RequestDispatcher disp = request.getRequestDispatcher("orderconfirm.html");
        disp.forward(request, response); 
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private Order createNewOrder(int orderNo, List<Integer> products, Long cos, String expectedDate, String orderedDate, double totalPrice, int totalQuantity, String streetName, String town, String province, String zipCode, String status) {
        Order order = new Order();

        order.setProvince(province);
        order.setStreetName(streetName);
        //order.setSuburb(suburb);
        order.setTown(town);
        order.setZipCode(zipCode);
        order.setOrderNo(orderNo);
        order.setCustomerNo(cos);
        order.setExpectedDate(expectedDate);
        order.setOrderedDate(orderedDate);
        order.setStore(products);
        order.setTotalPrice(totalPrice);
        order.setQuantity(totalQuantity);
        order.setStatus(status);

        return order;
    }

}
