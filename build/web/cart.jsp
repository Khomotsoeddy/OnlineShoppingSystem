<%-- 
    Document   : cart
    Created on : 02 Apr 2022, 22:02:16
    Author     : Asus
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Power Gym | Cart Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    </head>
    <body>
        <%
            String productName =(String) request.getAttribute("productName");
            String productLocation = (String) request.getAttribute("productLocation");
            Integer quantity = (Integer) request.getAttribute("quantity");
            String size = (String) request.getAttribute("size");
            Double price = (Double) request.getAttribute("price");
            Double subtotal = quantity * price;
            DecimalFormat df = new DecimalFormat("#,##");
        %>
<div class="header">

            <div class="container">

                <div class="navbar">

                    <div class="logo">
                        <a href="index.html"><img src="./pictures/logo_icon.jpeg" width="160" height="80"/></a>
                    </div>
                    <nav>
                        <ul id="menuItems">
                            <li><a href="index.html">HOME</a></li>
                            <li><a href="products.jsp">PRODUCT</a></li>
                            <li><a href="#">ABOUT</a></li>
                            <li><a href="#">CONTACT</a></li>
                            <li><a href="account.html">ACCOUNT</a></li>
                        </ul>
                        <a href="cart.html"><img src="./pictures/cart.png" width="15px"/></a>
                        <img src="./pictures/menu.png" width="15px" class="menu-icon" onclick="menutoggle()"/>
                    </nav>
                </div>
                <div class="row">
                    <div class="col_2">
                        <h1>Have your style this summer</h1>

                        <p>We give you best look this summer</p>
                        <a href="products.jsp" class="btn">Explore more &#8594;</a>
                    </div>
                    <div class="col_2">
                        <img src="./pictures/display_icon.png"/>
                    </div>
                </div>
            </div>
        </div>
        <!------------Cart item details------------->
        <div class="small_container cart_page">
            <table>
                <tr>
                    <th>Product</th>
                    <th>Size</th>
                    <th>Quantity</th>
                    <th>Subtotal</th>

                </tr>
                <%
                    for(int i=0;i<2;i++){
                %>
                <tr>
                    <td>
                        <div class="cart_info">
                            <img src="./web/pictures/"<%=productLocation%>/>
                            <div>
                                <p><%=productName%></p>
                                <small>R<%=price%></small><br>
                                <a href="#">Remove</a>
                            </div>
                        </div>
                    </td>
                    <td><%=size%></td>
                    <td><%=quantity%></td>
                    <td><%=df.format(subtotal)%></td>
                </tr>
                <%
                    }
                %>
            </table>
           <!---------------Total price table---------------->
            <div class="total_price">
                <table>
                    <tr>
                        <th>
                            Total Quantity
                        </th>
                        <th>
                            Total Price
                        </th>
                    </tr>
                    <tr>
                        <td><%=quantity++%></td>
                        <td><%=df.format(subtotal++)%></td>
                    </tr>
                </table>
            </div>
        </div>

        <!---------footer---------->
        <div class="footer">
            <div class="container">
                <div class="row">
                    <div class="footer_col_1">
                        <h3>Download Our App</h3>
                        <p>
                            Download our app for Android and IOS mobile phone.
                        </p>
                        <div class="app_logo">
                            <img src="./pictures/play-store.png" width="200" height="100"/>
                            <img src="./pictures/app-store.png" width="200" height="100"/>
                        </div>
                    </div>
                    <div class="footer_col_2">
                        <img src="./pictures/logo_icon.jpeg" width="150" height="100"/>
                        <p>
                            Our Purpose Is To Sustainably Make The Pleasure And Benefits Of Sports Accessible To Many.
                        </p>
                    </div>
                    <div class="footer_col_3">
                        <h3>Useful Links</h3>
                        <ul>
                            <li>Coupons</li>
                            <li>Blog Post</li>
                            <li>Return Policy</li>
                            <li>Join Affiliate</li>
                        </ul>
                    </div>
                    <div class="footer_col_4">
                        <h3>Follow Us</h3>
                        <ul>
                            <li>Facebook</li>
                            <li>Twitter</li>
                            <li>Instagram</li>
                            <li>WhatsApp</li>
                        </ul>
                    </div>
                </div>
                <hr>
                <p class="copyright">Copyright 2022</p>
            </div>
        </div>

        <!-------js for toggle menu--------->
        
        <script>
            var menuItems = document.getElementById("menuItems");
            menuItems.style.maxHeight = "0px";

            function menutoggle() {
                if (menuItems.style.maxHeight === "0px") {
                    menuItems.style.maxHeight = "200px";
                } else {
                    menuItems.style.maxHeight = "0px";
                }
            }
        </script>
    </body>
</html>
