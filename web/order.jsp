<%-- 
    Document   : order
    Created on : 09 Apr 2022, 02:20:19
    Author     : Asus
--%>

<%@page import="za.ac.tut.model.Store"%>
<%@page import="za.ac.tut.entity.Product"%>
<%@page import="za.ac.tut.entity.Order"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="za.ac.tut.model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="include/header.jsp"%>
        <title>Order Page</title>
    </head>
    <body style="background: radial-gradient(#fff,#ffd6d6)">
        <%@include file="include/navbar.jsp"%>
        <%            List<Order> orders = (List<Order>) session.getAttribute("orders");
            List<Product> products = (List<Product>) session.getAttribute("products");
        %>
        <div class="order_container">
            <table>
                <tr>
                    <th>Order Number</th>
                    <th>Products</th>
                    <th>Address</th>
                    <th>Total Price</th>
                    <th></th>
                </tr>
                <%
                    if (!orders.isEmpty()) {
                        for (Order order : orders) {
                %>
                <tr>
                    <td><%=order.getOrderNo()%></td>
                    <td>
                        <%
                            List<Integer> oppss = order.getStore();
                            for (Integer op : oppss) {
                                for (Product p : products) {
                                    if (op == p.getProductId()) {
                        %>
                        <%=p.getName()%><br>
                        <%
                                    }
                                }
                            }
                        %>
                    </td>

                    <td><%=order.getAddress().getStreetName()%></td>
                    <td><%=order.getTotalPrice()%></td>

                    <td><a class="butn" href="OrderTrackingServlet.do?id=<%=order.getOrderNo()%>">TRACK &#8594;</a></td>
                </tr>
                <%
                        }
                    }
                %>

            </table>

        </div>


        <%@include file="include/footer.jsp"%>
        <%@include file="include/footer1.jsp"%>
    </body>
</html>
