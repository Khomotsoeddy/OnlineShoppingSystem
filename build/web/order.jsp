<%-- 
    Document   : order
    Created on : 09 Apr 2022, 02:20:19
    Author     : Asus
--%>

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

        <div class="order_container">
            <table>
                <tr>
                    <th>Order Number</th>
                    <th>Products</th>
                    <th>Address</th>
                    <th>Total Price</th>
                    <th></th>
                </tr>
                <tr>
                    <td>2345</td>
                <td>
                    <%                       
                         for (int i = 0; i < 5; i++) {
                    %>
                    ertjhbd<br>
                    <%
                        }
                    %>
                </td>

                <td>123 street</td>
                <td>R564</td>
                <td><a class="butn" href="order_tracking.jsp">TRACK &#8594;</a></td>
                </tr>

            </table>

        </div>


        <%@include file="include/footer.jsp"%>
        <%@include file="include/footer1.jsp"%>
    </body>
</html>
