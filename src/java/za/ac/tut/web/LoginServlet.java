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
import za.ac.tut.business.CustomerFacadeLocal;
import za.ac.tut.entity.Customer;

/**
 *
 * @author Asus
 */
public class LoginServlet extends HttpServlet {

    @EJB
    private CustomerFacadeLocal customerFacade;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        String emailAddress = request.getParameter("emailAddress");
        String password = request.getParameter("password");
        //String password = request.getParameter("password");
        List<Customer> customers = customerFacade.getCustomers();
        
        for(Customer s:customers){
            if(s.getEmail().equals(emailAddress) && s.getPassword().equals(password)){
                session.setAttribute("emailAddress",s.getEmail());
                session.setAttribute("password",s.getPassword());
                RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
                disp.forward(request, response);
            }else{
//                RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
//                disp.forward(request, response);
                response.sendRedirect("login.jsp");
            }
        }
    }
}
