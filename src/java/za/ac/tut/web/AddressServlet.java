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
import za.ac.tut.entity.Address;
import za.ac.tut.business.AddressFacadeLocal;

/**
 *
 * @author Asus
 */
public class AddressServlet extends HttpServlet {

    @EJB
    private AddressFacadeLocal addressFacade;

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String streetName = request.getParameter("streetName");
        String suburb = request.getParameter("suburb");
        String town = request.getParameter("town");
        String province = request.getParameter("province");
        String zipCode = request.getParameter("zipCode");
        
        session.setAttribute("town", town);
        session.setAttribute("streetName", streetName);
        session.setAttribute("suburb", suburb);
        session.setAttribute("province", province);
        session.setAttribute("zipCode", zipCode);
        
        //Address address = createNewAddress(streetName,suburb,town,province,zipCode);
        
        response.sendRedirect("card_detail.jsp");
    }

    private Address createNewAddress(String streetName, String suburb, String town, String province, String zipCode) {
        Address address = new Address();
        
        address.setProvince(province);
        address.setStreetName(streetName);
        address.setSuburb(suburb);
        address.setTown(town);
        address.setZipCode(zipCode);
        
        return address;
    }

}
