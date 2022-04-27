<%-- 
    Document   : checkout
    Created on : 24 Apr 2022, 17:04:38
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="include/header.jsp"%>
        <title>Checkout Page</title>
    </head>
    <body style="background: radial-gradient(#fff,#ffd6d6)">
        <%@include file="include/navbar.jsp"%>
        <div class="track">
            <div class="checkout_progress">
                <ul>
                    <li>
                        <p>Shipping Address</p>
                        <i class="fa fa-check"></i>
                    </li>
                    <li>
                        <p>Payment Processing</p>
                        <i>.</i>
                    </li>
                </ul>
                <div class="address_container">
                    <h1>Address Detail</h1>
                    <form action="ShippingAddressServlet.do" method="post">
                        <input type="text" name="streetName" placeholder="street name"/>
                        <input type="text" name="suburb" placeholder="suburb"/>
                        <input type="text" name="town" placeholder="town"/>
                        <input type="text" name="province" placeholder="province"/>
                        <input type="number" name="zipCode" placeholder="ZIP code" accept="number"/>
                        <input type="submit" value="NEXT" class="butn"/>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="include/footer.jsp"%>
        <%@include file="include/footer1.jsp"%>
    </body>
</html>
