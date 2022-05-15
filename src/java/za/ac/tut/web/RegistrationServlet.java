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
import za.ac.tut.business.CustomerFacadeLocal;
import za.ac.tut.entity.Customer;

/**
 *
 * @author Asus
 */
public class RegistrationServlet extends HttpServlet {

    @EJB
    private CustomerFacadeLocal customerFacade;
    
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
        //customerFacade.generateCustomerId();
        Long customer_id = Long.parseLong(""+customerFacade.generateCustomerId());
        
        Customer customer = createCustomer(customer_id,fname,lname,phoneNumber,email,street,city,state,zip_code,password,role);
        System.out.println(customer);
        
        customerFacade.addCustomer(customer);
        
        response.sendRedirect("login.jsp");
    }

    private Customer createCustomer(Long customer_id, String fname, String lname, String phoneNumber, String email, String street, String city, String state, String zip_code, String password, String role) {
        Customer customer = new Customer();
        
        customer.setId(customer_id);
        customer.setFname(fname);
        customer.setLname(lname);
        customer.setPhoneNumber(phoneNumber);
        
        customer.setEmail(email);
        customer.setStreet(street);
        customer.setCity(city);
        
        customer.setState(state);
        customer.setPassword(password);
        customer.setZip_code(zip_code);
        
        
        
        customer.setRole(role);
        
        return customer;
    }


}
