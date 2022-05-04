<%-- 
    Document   : all_ready_exit
    Created on : 09 Apr 2022, 12:11:18
    Author     : Asus
--%>

<%@page import="za.ac.tut.model.Store"%>
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
            ArrayList<Store> cart_List = (ArrayList<Store>) session.getAttribute("cart-products");
            if (cart_List != null) {
                request.setAttribute("cart-products", cart_List);
            }
        %>
        
        <h5>Item already exit in cart page. Click <a href="LoadCartServlet.do">here to go</a> to cart page</h5>
        
    </body>
</html>
