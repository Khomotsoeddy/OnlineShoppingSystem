<%-- 
    Document   : admin_order
    Created on : May 18, 2022, 4:18:51 PM
    Author     : Asus
--%>

<%@page import="za.ac.tut.entity.Product"%>
<%@page import="za.ac.tut.entity.Order"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="include/header.jsp"%>
        <title>Orders Page</title>
    </head>
    <body style="background: radial-gradient(#fff,#ffd6d6)">
        <%@include file="include/navbar.jsp"%>
        <%
            List<Order> orders = (List<Order>) session.getAttribute("orders");
            List<Product> products = (List<Product>)  session.getAttribute("products");
        %>
        <div class="order_container">
            <table>
                <tr>
                    <th>Order Number</th>
                    <th>Products</th>
                    <th>Status</th>
                    <th>Total Price</th>
                    <th></th>
                </tr>
                <%
                    if (!orders.isEmpty()) {
                        for (Order o : orders) {
                %>
                <tr>
                    <td><%=o.getOrderNo()%></td>
                    <td>
                        <%
                            List<Integer> oppss = o.getStore();
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

                    <td><%=o.getStatus()%></td>
                    <td><%=o.getTotalPrice()%></td>

                    <td><a class="butn" href="StatusServlet.do?id=<%=o.getOrderNo()%>">UPDATE &#8594;</a></td>
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
