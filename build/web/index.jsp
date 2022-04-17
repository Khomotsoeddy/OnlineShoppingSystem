<%-- 
    Document   : index
    Created on : 09 Apr 2022, 14:50:31
    Author     : Asus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="za.ac.tut.model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="include/header.jsp"%>
        <title>Welcome To Our Online Shop</title>
    </head>
    <body>
        <%
            ArrayList<Cart> cart_List = (ArrayList<Cart>) session.getAttribute("Cart-List");
            if (cart_List != null) {
                request.setAttribute("cart_List", cart_List);
            }
        %>
        <%@include file="include/navbar.jsp"%>
        
        <!-----------js for footer-------------------->
        <%@include file="include/footer.jsp"%>
        <%@include file="include/footer1.jsp"%>
    </body>
</html>
