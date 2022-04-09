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
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="include/navbar.jsp"%>
        <%
            ProductsProcessoor pp = new  ProductsProcessoor();
            List<Products> listOfProducts = pp.getAllProducts();
            Products p = new Products();
        %>
        <div class="container">
            <div class="cart-header my-3">
                All Products
            </div>
            <div class="row">
                <%
                    for(int i=0;i<listOfProducts.size();i++){
                %>
                <div class="col-md-3 my-3">
                    <div class="card w-100" style="width: 18rem;">
                        <img class="card-img-top" src="./product_images/<%=p.getImage()%>" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title"><%=p.getName()%></h5>
                            <h6 class="price">Price R<%=p.getPrice()%></h6>
                            <h6 class="category">Category: <%=p.getCategory()%></h6>
                            <div class="mt-3 d-flex justify-content-between">
                                <a href="#" class="btn btn-primary">Add To Cart</a>
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
        <!-----------js for footer-------------------->
        <%@include file="include/footer.jsp"%>
    </body>
</html>
