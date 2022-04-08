<%-- 
    Document   : products
    Created on : 08 Apr 2022, 19:07:11
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Power Gym | Products</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    </head>
    <body>
        <%
            String pictureName;
            String productName;
            Double price;
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
        
        <!------------All products--------->
        
        <div class="small_container">
            <div class="row row_2">
                <h2 class="products">All Products</h2>
                <select>
                    <option>Sort By Default</option>
                    <option>Sort By Price</option>
                    <option>Sort By Brand</option>
                </select>
            </div>

            <div class="row">
                <%
                    for(int i=0;i<10;i++){
                %>
                <div class="col_4">
                    <a href="./product-details.html"><img src="pictures/IMG_20181024_080006.jpg"/></a>
                    <a href="./product-details.html"><h4>Hello lloo</h4></a>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-half-o"></i>
                        <i class="fa fa-star-o"></i>
                    </div>                        
                    <p>R150.00</p>
                </div>
                <%
                    }
                %>
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
