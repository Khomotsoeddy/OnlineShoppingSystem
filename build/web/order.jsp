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
    <body>
        <%
            ArrayList<Cart> cart_List = (ArrayList<Cart>) session.getAttribute("Cart-List");
            if (cart_List != null) {
                request.setAttribute("cart_List", cart_List);
            }
        %>
        <%@include file="include/navbar.jsp"%>
        <%@include file="include/footer.jsp"%>
    </body>
</html>
