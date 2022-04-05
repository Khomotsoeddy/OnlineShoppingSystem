<%-- 
    Document   : cart
    Created on : 02 Apr 2022, 22:02:16
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JuniorStore | Product details</title>
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
        %>
       <div class="container">

            <div class="navbar">

                <div class="logo">
                    <a href="index.html"><img src=$[]"C:/Users/Asus/Documents/NetBeansProjects/OnlineShoppingFinal/web/pictures/IMG_20181024_080006.jpg" width="50px"/></a>                </div>
                <nav>
                    <ul id="menuItems">
                        <li><a href="index.html">HOME</a></li>
                        <li><a href="products.html">PRODUCT</a></li>
                        <li><a href="#">ABOUT</a></li>
                        <li><a href="#">CONTACT</a></li>
                        <li><a href="account.html">ACCOUNT</a></li>
                    </ul>
                    <a href="cart.html"><img src="C:/Users/Asus/Documents/NetBeansProjects/OnlineShoppingFinal/web/pictures/IMG_20181024_080017.jpg" width="15px"/></a>
                    <img src="C:/Users/Asus/Documents/NetBeansProjects/OnlineShoppingFinal/web/pictures/IMG_20181024_080006.jpg" width="15px" class="menu-icon" onclick="menutoggle()"/>
                </nav>
            </div>
        </div>
        <!------------Cart item details------------->
        <div class="small_container cart_page">
            <table>
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Subtotal</th>

                </tr>
                <tr>
                    <td>
                        <div class="cart_info">
                            <img src="C:/Users/Asus/Documents/NetBeansProjects/OnlineShoppingFinal/web/pictures/"<%=productLocation%>/>
                            <div>
                                <p><%=productName%></p>
                                <small><%=price%></small><br>
                                <a href="#">Remove</a>
                            </div>
                        </div>
                    </td>
                    <td><input type="number" value="1"/></td>
                    <td><%=price%></td>
                </tr>
                <!---
                <tr>
                    <td>
                        <div class="cart_info">
                            <img src="C:/Users/Asus/Documents/NetBeansProjects/OnlineShoppingFinal/web/pictures/IMG_20181024_080017.jpg"/>
                            <div>
                                <p>Product Name</p>
                                <small>R105.00</small><br>
                                <a href="#">Remove</a>
                            </div>
                        </div>
                    </td>
                    <td><input type="number" value="1"/></td>
                    <td>105.00</td>
                </tr>
                <tr>
                    <td>
                        <div class="cart_info">
                            <img src="C:/Users/Asus/Documents/NetBeansProjects/OnlineShoppingFinal/web/pictures/IMG_20181024_080017.jpg"/>
                            <div>
                                <p>Product Name</p>
                                <small>R105.00</small><br>
                                <a href="#">Remove</a>
                            </div>
                        </div>
                    </td>
                    <td><input type="number" value="1"/></td>
                    <td>105.00</td>
                </tr>
                <tr>
                    <td>
                        <div class="cart_info">
                            <img src="C:/Users/Asus/Documents/NetBeansProjects/OnlineShoppingFinal/web/pictures/IMG_20181024_080017.jpg"/>
                            <div>
                                <p>Product Name</p>
                                <small>R105.00</small><br>
                                <a href="#">Remove</a>
                            </div>
                        </div>
                    </td>
                    <td><input type="number" value="1"/></td>
                    <td>105.00</td>
                </tr>
                -->
            </table>
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
                        <td><%=quantity%></td>
                        <td><%=price%></td>
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
                            <img src="pictures/IMG_20181024_080036.jpg" width="200" height="100"/>
                            <img src="pictures/IMG_20181024_080036.jpg" width="200" height="100"/>
                        </div>
                    </div>
                    <div class="footer_col_2">
                        <img src="C:/Users/Asus/Documents/NetBeansProjects/OnlineShoppingFinal/web/pictures/IMG_20181024_080036.jpg" width="150" height="100"/>
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
