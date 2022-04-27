<%-- 
    Document   : products
    Created on : 09 Apr 2022, 03:43:48
    Author     : Asus
--%>

<%@page import="za.ac.tut.entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="za.ac.tut.model.Cart"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.businness.ProductsProcessoor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <%@include file="include/header.jsp"%>
        <title>All Product Page</title>
    </head>
    <body style="background: radial-gradient(#fff,#ffd6d6)">
        <%
            List<Product> products = (List<Product>)session.getAttribute("products");
        %>
        <%@include file="include/navbar.jsp"%>

        <div class="container">
            <div class="cart-header my-3">
                All Products
            </div>
            <div class="row">
                <%
                    for (Product p : products) {
                %>
                <div class="col-md-3 my-3">
                    <div class="card w-100" style="width: 18rem;">
                        <img class="card-img-top" src="./product_images/<%=p.getImage()%>" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title"><%=p.getName()%></h5>
                            <h6 class="price">Price R<%=p.getPrice()%></h6>
                            <h6 class="category">Category: <%=p.getCategory()%></h6>
                            <div class="mt-3 d-flex justify-content-between">
                                <a href="AddToCartServlet.do?id=<%=p.getProductId()%>" class="btn btn-dark">Add To Cart</a>
                                <a href="BuyNowServlet.do?id=<%=p.getProductId()%>" class="btn btn-primary">Buy Now</a>
                            </div>

                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
        </div>
        <!-----------js for footer-----?id=//product.getProductId()%>"--------------->
        <%@include file="include/footer.jsp"%>
        <%@include file="include/footer1.jsp"%>
    </body>
</html>
