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
        
        <%
            String town = (String)session.getAttribute("town");
            String streetName = (String)session.getAttribute("streetName");
            String state = (String)session.getAttribute("state");
            String zipCode = (String)session.getAttribute("zipCode");
        %>
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
                    <form action="AddressServlet.do" method="post">
                        <input type="text" name="streetName" placeholder="street name" value="<%=streetName%>"/>
                        <input type="text" name="town" placeholder="town" value="<%=town%>"/>
                        <input type="text" name="province" placeholder="province" value="<%=state%>"/>
                        <input type="text" name="zipCode" placeholder="ZIP code" value="<%=zipCode%>"/>
                        <input type="submit" value="NEXT" class="butn"/>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="include/footer.jsp"%>
        <%@include file="include/footer1.jsp"%>
    </body>
</html>
