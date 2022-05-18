<%-- 
    Document   : login
    Created on : 09 Apr 2022, 02:20:41
    Author     : Asus
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="za.ac.tut.model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="include/header.jsp"%>
        <title>Login Page | Power Gym</title>
    </head>
    <body style="background: radial-gradient(#fff,#ffd6d6)">
        <%
            ArrayList<Cart> cart_List = (ArrayList<Cart>) session.getAttribute("Cart-List");
            if (cart_List != null) {
                request.setAttribute("cart_List", cart_List);
            }
            String message = (String) session.getAttribute("message");
        %>
        <%@include file="include/navbar.jsp"%>
        <div class="account_page">
            <div class="container_">
                <div class="row_">
                    <div class="col_2">
                        <img src="./product_images/display_icon.png" width="100%"/>
                    </div>
                    <div class="col_2">
                        <div class="form_container">
                            <div class="form_btn">
                                <span onclick="login()">Register</span>
                                <span onclick="register()">Login</span>
                                <hr id="form_indicator">
                            </div>
                            <form action="LoginServlet.do" method="post" id="login_form" class="form_container">
                                <input type="email" placeholder="Email Address" name="emailAddress"/>
                                <input type="password" placeholder="Password" name="password"/>
                                <%                                    
                                    if (message == null) {
                                        
                                    } else {
                                %>
                                        <p style="color: red">
                                            Password or Email is incorrect
                                        </p>
                                <%
                                    }
                                %>
                                <input type="submit" value="Login" class="butn"/>
                                <a href="">Forget Password</a>
                            </form>
                            <form action="RegistrationServlet.do" method="post" id="registration_form" class="form_container">
                                <input type="text" placeholder="Firstname" name="firstName"/>
                                <input type="text" placeholder="Lastname" name="lastName"/>
                                <input type="number" placeholder="Phone number" name="phoneNumber"/>
                                <input type="email" placeholder="Email Address" name="emailAddress"/>
                                <input type="text" placeholder="Street name" name="streetName"/>
                                <input type="text" placeholder="City" name="city"/>
                                <input type="text" placeholder="State" name="state"/>
                                <input type="text" placeholder="Zip Code" name="zipCode"/>
                                <input type="password" placeholder="Password" name="password"/>
                                <input type="submit" value="Register" class="butn"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-----------js for footer-------------------->
        <%@include file="include/footer.jsp"%>
        <%@include file="include/footer1.jsp"%>
        <!-----------js for change form-------------->
        <script>
            var loginForm = document.getElementById("login_form");
            var registrationForm = document.getElementById("registration_form");
            var formIndicator = document.getElementById("form_indicator");

            function register() {
                loginForm.style.transform = "translateX(0px)";
                registrationForm.style.transform = "translateX(0px)";
                formIndicator.style.transform = "translateX(100px)";
            }
            function login() {
                loginForm.style.transform = "translateX(300px)";
                registrationForm.style.transform = "translateX(300px)";
                formIndicator.style.transform = "translateX(0px)";
            }
        </script>
    </body>
</html>
