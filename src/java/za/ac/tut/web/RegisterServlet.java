/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.businness.CustomerNumberProcessor;
import za.ac.tut.model.Customer;
//import za.ac.tut.model.Customer;

/**
 *
 * @author Asus
 */
public class RegisterServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String fname = request.getParameter("firstName");
        String lname = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("emailAddress");
        String street = request.getParameter("streetName");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip_code = request.getParameter("zipCode");
        String password = request.getParameter("password");
        String role = "CUSTOMER";
        CustomerNumberProcessor cnp = new CustomerNumberProcessor();
        String customer_id = cnp.generateCustomerNumber();
        
        
        Customer customer = new Customer(customer_id,fname,lname,phoneNumber,email,street,city,state,zip_code,password,role);
    }

}
