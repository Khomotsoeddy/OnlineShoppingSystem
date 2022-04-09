/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.Cart;

/**
 *
 * @author Asus
 */
public class AddToCartServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Cart> cartList = new ArrayList<>();

        Integer id = Integer.parseInt(request.getParameter("id"));
        Cart ct = new Cart();
        ct.setProductId(id);
        ct.setQuantity(1);

        HttpSession session = request.getSession();
        ArrayList<Cart> cart_List = (ArrayList) session.getAttribute("Cart-List");

        if (cart_List == null) {
            cartList.add(ct);
            session.setAttribute("Cart-List", cartList);
            response.sendRedirect("products.jsp");
        } else {
            boolean exit = false;
            cartList = cart_List;
            for (Cart c : cart_List) {
                if (c.getProductId() == id) {
                    exit = true;
                    response.sendRedirect("all_ready_exit.jsp");
                }
            }
            if (!exit) {
                cartList.add(ct);
                response.sendRedirect("products.jsp");
            }
            for (Cart d : cart_List) {
                System.out.println(d.getProductId());
            }
        }
    }
}
