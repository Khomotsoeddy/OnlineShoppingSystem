<%-- 
    Document   : order_tracking
    Created on : 22 Apr 2022, 22:34:43
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="include/header.jsp"%>
    <title>Track Order Page</title>
</head>
<body style="background: radial-gradient(#fff,#ffd6d6)">
    <%@include file="include/navbar.jsp"%>

    <div class="order_container">
        <div class="details">
            <div class="order">
                <h1>Order number <span>123342</span></h1>
            </div>
            <div class="date">
                <p>Expected date: 12/14/2022</p>
                <p>USP 1424256542</p>
            </div>
        </div>
    </div>
    <div class="track">

        <div class="order_progress">
            <ul>
                <%
                    if(1==1){
                %>
                <li>
                    <img src="./product_images/processing.png"/>

                    <p>Order <br> Processing</p>
                    <i class="fa fa-check"></i>
                </li>
                <li>
                    <img src="./product_images/package.jpg"/>
                    <p>Order <br> Packaging</p>
                    <i>...</i>
                </li>
                <li>
                    <img src="./product_images/shipping.png" width="50"/>
                    <p>Order <br> Shipping</p>
                    <i>...</i>
                </li>
                <li>
                    <img src="./product_images/home_icon.png"/>
                    <p>Order <br> Arrived</p>

                    <i>...</i>
                </li>
                <%
                    }
                    if(1==4){
                %>
                <li>
                    <img src="./product_images/processing.png"/>

                    <p>Order <br> Processing</p>
                    <i class="fa fa-check"></i>
                </li>
                <li>
                    <img src="./product_images/package.jpg"/>
                    <p>Order <br> Packaging</p>
                    <i class="fa fa-check"></i>
                </li>
                <li>
                    <img src="./product_images/shipping.png" width="50"/>
                    <p>Order <br> Shipping</p>
                    <i>...</i>
                </li>
                <li>
                    <img src="./product_images/home_icon.png"/>
                    <p>Order <br> Arrived</p>

                    <i>...</i>
                </li>
                <%
                    }
                    if(1==3){
                %>
                <li>
                    <img src="./product_images/processing.png"/>

                    <p>Order <br> Processing</p>
                    <i class="fa fa-check"></i>
                </li>
                <li>
                    <img src="./product_images/package.jpg"/>
                    <p>Order <br> Packaging</p>
                    <i class="fa fa-check"></i>
                </li>
                <li>
                    <img src="./product_images/shipping.png" width="50"/>
                    <p>Order <br> Shipping</p>
                    <i class="fa fa-check"></i>
                </li>
                <li>
                    <img src="./product_images/home_icon.png"/>
                    <p>Order <br> Arrived</p>

                    <i>...</i>
                </li>
                <%
                    }
                %>
                
                <%
                    if(1==2){
                %>
                <li>
                    <img src="./product_images/processing.png"/>

                    <p>Order <br> Processing</p>
                    <i class="fa fa-check"></i>
                </li>
                <li>
                    <img src="./product_images/package.jpg"/>
                    <p>Order <br> Packaging</p>
                    <i class="fa fa-check"></i>
                </li>
                <li>
                    <img src="./product_images/shipping.png" width="50"/>
                    <p>Order <br> Shipping</p>
                    <i class="fa fa-check"></i>
                </li>
                <li>
                    <img src="./product_images/home_icon.png"/>
                    <p>Order <br> Arrived</p>

                    <i class="fa fa-check"></i>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>

    <%@include file="include/footer.jsp"%>
    <%@include file="include/footer1.jsp"%>
</body>
</html>
