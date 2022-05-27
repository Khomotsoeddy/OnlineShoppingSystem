/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.CardFacadeLocal;
import za.ac.tut.entity.Card;

/**
 *
 * @author Asus
 */
public class PurchasingServlet extends HttpServlet {

    @EJB
    private CardFacadeLocal cardFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cardHolder = request.getParameter("cardHolder");
        String cardNumber = (request.getParameter("cardNumber"));
        String expireDate = request.getParameter("expireDate");
        String CVV = request.getParameter("CVV");

        String amount = "notEnough", errorCard = "errorCard";

        Card card = cardFacade.find(cardNumber);
        if (card != null) {
            if (cardHolder.equals(card.getCardHolder()) && expireDate.equals(card.getExpireDate()) && CVV.equals(card.getCVV())) {
                double totalPrice = (Double) session.getAttribute("totalPrice");
                if (totalPrice <= card.getAmount()) {
                    double availableBalance = card.getAmount() - totalPrice;
                    card.setAmount(availableBalance);
                    cardFacade.edit(card);
                    amount = "";
                    errorCard = "";
                    response.sendRedirect("OrderServlet.do");
                } else {
                    if (amount.equals("notEnough")) {
                        session.setAttribute("amount", amount);
                        //response.sendRedirect("card_detail");
                        RequestDispatcher disp = request.getRequestDispatcher("card_detail.jsp");
                disp.forward(request, response);
                    }
                }
            } else {
                if (errorCard.equals("errorCard")) {
                    session.setAttribute("errorCard", errorCard);
                    response.sendRedirect("card_detail");
                    RequestDispatcher disp = request.getRequestDispatcher("card_detail.jsp");
                disp.forward(request, response);
                }
            }
        } else {
            if (errorCard.equals("errorCard")) {
                session.setAttribute("errorCard", errorCard);
                //response.sendRedirect("card_detail");
                RequestDispatcher disp = request.getRequestDispatcher("card_detail.jsp");
                disp.forward(request, response);
            }
        }
    }

}
