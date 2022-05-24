/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.AdminsFacadeLocal;
import za.ac.tut.business.CustomerFacadeLocal;
import za.ac.tut.entity.Admins;
import za.ac.tut.entity.Customer;

/**
 *
 * @author Asus
 */
public class LoginServlet extends HttpServlet {

    @EJB
    private AdminsFacadeLocal adminsFacade;

    @EJB
    private CustomerFacadeLocal customerFacade;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        String emailAddress = request.getParameter("emailAddress");
        String password = request.getParameter("password");
        String message = "oops";
        List<Customer> customers = customerFacade.getCustomers();
        List<Admins> admins = adminsFacade.getAdmins();
        
        for(Customer s:customers){
            if(s.getEmail().equals(emailAddress) && s.getPassword().equals(password) && s.getRole().equals("CUSTOMER")){
                session.setAttribute("emailAddress",s.getEmail());
                session.setAttribute("password",s.getPassword());
                session.setAttribute("role",s.getRole());
                message = "";
                RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
                disp.forward(request, response);
            }
        }
        for(Admins a:admins){
            if(a.getEmailAddress().equals(emailAddress) && a.getPassword().equals(password) && a.getRole().equals("ADMIN")){
                session.setAttribute("emailAddress",a.getEmailAddress());
                session.setAttribute("employeeId",a.getEmployeeId());
                session.setAttribute("name",a.getName());
                session.setAttribute("surname",a.getSurname());
                session.setAttribute("role",a.getRole());
                message = "";
                RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
                disp.forward(request, response);
            }
        }
        
        if(message.equals("oops")){
            session.setAttribute("message",message);
            response.sendRedirect("login.jsp");
        }
    }
}
