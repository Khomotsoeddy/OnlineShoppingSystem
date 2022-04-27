<%-- 
    Document   : all_ready_exit
    Created on : 09 Apr 2022, 12:11:18
    Author     : Asus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="za.ac.tut.model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="include/header.jsp"%>
    </head>
    <body style="background: radial-gradient(#fff,#ffd6d6)">
        <%
            ArrayList<Cart> cart_List = (ArrayList<Cart>) session.getAttribute("Cart-List");
            if (cart_List != null) {
                request.setAttribute("cart_List", cart_List);
            }
        %>
        <%@include file="include/navbar.jsp"%>
        <h5>Item already exit in cart page. Click <a href="cart.jsp">here to go</a> to cart page</h5>
        
        <%@include file="include/footer.jsp"%>
        <%@include file="include/footer1.jsp"%>
    </body>
</html>
