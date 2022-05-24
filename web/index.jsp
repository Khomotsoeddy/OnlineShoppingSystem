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
    <body style="background: radial-gradient(#fff,#ffd6d6)">
        <%
            ArrayList<Cart> cart_List = (ArrayList<Cart>) session.getAttribute("Cart-List");
            if (cart_List != null) {
                request.setAttribute("cart_List", cart_List);
            }
        %>
        <%@include file="include/navbar.jsp"%>

        <div class="container_" style="margin: 30px" >

            <div class="row_" style="justify-content: space-between">
                <div class="col_2" style="margin-right: 0px">
                    <h1>ONLINE SHOPPING SYSTEM</h1>
                    <p style="font-style: italic">This is an online platform that cater for both Clients and Store Owners by providing this user friendly Online Shop-web.
                        You can browse through our web to check the products we are selling <br>
                        and you can create an account with us when you want to make orders.
                        <br><br>
                        You can learn more about US by clicking on the button below</p>
                    <a href="about.html"><input type="button" value="About US" class="butn"/></a>
                </div>
                <div class="col_2" >
                    <div class="row" style="justify-content: space-between;padding-left: 20px">
                        <div class="col_3">
                            <img src="./product_images/Elliptical.jpeg" width="400px"/>
                        </div>
                        <div class="col_3">
                            <img src="./product_images/protein-1.jpg" width="400px"/>
                        </div>
                        <div class="col_3">
                            <img src="./product_images/top.jpg" width="400px"/>
                            <a href="ProductServlet.do" class="butn">Explore More</a>
                        </div>
                        
                    </div>
                    
                </div>
            </div>

            <div class="categories">
                <div class="small_container" style="background: linear-gradient(11deg, #ff3a3a -15.11%, #ae249a 51.46%, #081ea9 113.9%);">
                    <center>
                        <h1>CATEGORIES</h1>
                    </center>
                    <div class="row" style="justify-content: space-between">
                        <div class="col_3">
                            <img src="./product_images/protein_logo.jpg" width="400px"/>
                        </div>
                        <div class="col_3">
                            <img src="./product_images/lifting_logo.png" width="400px"/>
                        </div>
                        <div class="col_3">
                            <img src="./product_images/clothing_logo.jpg" width="400px"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-home2">
                <div class="row">
                    <div class="col_4">
                        <h1>PURPOSE</h1>
                        <p>We want to make life easy for people when it comes to buying stuff that needs delivery.
                            By using this app, you will be able to make orders and get your
                            <br>orders dilivered to a spacific address that you provide us with.</p>
                    </div>

                    <div class="col_4">
                        <h1>TARGET</h1>
                        <p>This application is user friendly, It is for anyone who is interested in
                            <br> improving thier lives by using gym products.<br>
                            In other words, we are bringing GYM to your home</p>

                    </div>

                    <div class="col_4">
                        <h1>STORE</h1>
                        <p>The store has 3 categories of products so far, make sure
                            <br> you add the products to your cart.<br>
                            you will get a full summary of your orders after paying and then you
                            <br>will be able to track the progress of your order</p>

                    </div>

                    <div class="col_4">
                        <h1>SUMMARY</h1>
                        <p>Make sure you create an account with us so that you can be able to place
                            <br> your orders any time and get to view your orders in detail.</p>

                    </div>

                </div>
            </div>
        </div>
        <!-----------js for footer-------------------->
        <%@include file="include/footer.jsp"%>
        <%@include file="include/footer1.jsp"%>
    </body>
</html>
