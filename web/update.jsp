<%-- 
    Document   : update
    Created on : May 18, 2022, 9:31:43 PM
    Author     : Asus
--%>

<%@page import="za.ac.tut.entity.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Order Page</title>
    </head>
    <%
        Order order = (Order) session.getAttribute("order");
    %>
    <body>
        <div class="update">
            <div class="details">
                <div class="order">
                    <h1>Order number : <span><%=order.getOrderNo()%></span></h1>
                </div>
                <div class="date">
                    <p>Expected date : <%=order.getExpectedDate()%></p>
                </div>
            </div>
        </div>
        <div class="update_container">
            <form action="UpdateOrderStatusServlet.do" method="post">
                <select name="updates">
                    <option>Update order</option>
                    <option>processing</option>
                    <option>packaging</option>
                    <option>shipping</option>
                    <option>arrived</option>
                </select><br>
                <input type="submit" value="UPDATE" class="butn"><br>
            </form>

        </div>
    </body>
</html>
