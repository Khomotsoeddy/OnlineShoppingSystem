<%-- 
    Document   : products
    Created on : 09 Apr 2022, 03:43:48
    Author     : Asus
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.Products"%>
<%@page import="za.ac.tut.businness.ProductsProcessoor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="include/header.jsp"%>
        <title>All Product Page</title>
    </head>
    <body>
        <%@include file="include/navbar.jsp"%>
        <%
            ProductsProcessoor pp = new  ProductsProcessoor();
            List<Products> listOfProducts = pp.getAllProducts();
        %>
        <div class="container">
            <div class="cart-header my-3">
                All Products
            </div>
            <div class="row">
                <%
                    for(Products product : listOfProducts){
                %>
                <div class="col-md-3 my-3">
                    <div class="card w-100" style="width: 18rem;">
                        <img class="card-img-top" src="./product_images/<%=product.getImage()%>" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title"><%=product.getName()%></h5>
                            <h6 class="price">Price R<%=product.getPrice()%></h6>
                            <h6 class="category">Category: <%=product.getCategory()%></h6>
                            <div class="mt-3 d-flex justify-content-between">
                                <a href="AddToCartServlet.do?id=<%=product.getProductId()%>" class="btn btn-dark">Add To Cart</a>
                                <a href="#" class="btn btn-primary">Buy Now</a>
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
    </body>
</html>
