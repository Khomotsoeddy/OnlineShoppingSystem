<%-- 
    Document   : card_detail
    Created on : 24 Apr 2022, 17:27:02
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
            String amount = (String)session.getAttribute("amount");
            String errorCard = (String)session.getAttribute("errorCard");
        %>
        <%@include file="include/navbar.jsp"%>
        <div class="track">
            <div class="order_progress">
                <ul>
                    <li>
                        <p>Shipping Address</p>
                        <i class="fa fa-check"></i>
                    </li>
                    <li>
                        <p>Payment Processing</p>
                        <i class="fa fa-check"></i>
                    </li>
                </ul>
                <div class="card_container">
                    <h1>Card Detail</h1>
                    <form action="PurchasingServlet.do" method="post">
                        <input type="text" name="cardHolder" placeholder="card holder"/>
                        <input type="text" name="cardNumber" placeholder="xxxx-xxxx-xxxx-xxxx"/>
                        <input type="text" name="expireDate" placeholder="MM/YY"/>
                        <input type="text" name="CVV" placeholder="000"/>
                        <%
                            if(amount == null ){
                            
                            }else{
                        %>
                        <p style="color: red">You don't have enough amount</p>
                        <%        
                            }if( errorCard == null){
                                
                            }else {
                        %>
                            <p style="color: red">Wrong card details</p>
                        <%
                            }
                        %>
                        <input type="submit" value="NEXT" class="butn"/>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="include/footer.jsp"%>
        <%@include file="include/footer1.jsp"%>
    </body>
</html>
