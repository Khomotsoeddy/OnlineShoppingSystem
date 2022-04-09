<%-- 
    Document   : cart
    Created on : 09 Apr 2022, 02:20:08
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="include/header.jsp"%>
        <title>Cart Page</title>
    </head>
    <body>
        <%@include file="include/navbar.jsp"%>
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
                            <img src="./product_images/buy-1.jpg"/>
                            <div>
                                <p>red t_shirt</p>
                                <small>R456</small><br>
                                <a href="#">Remove</a>
                            </div>
                        </div>
                    </td>
                    <td>small</td>
                    <td>
                       <form action="" methot="post" class="form-inline">
                            <input type="hidden"  name="id" value="1" class="form-input">
                            <div class="form-group d-flex justify-content-between">
                                <a class="btn btn-sm btn-decre" href="">
                                    <i class="fas fa-minus-square"></i>
                                </a>
                                <input type="text" name="quantity" class="form-control" value="1" readonly>
                                <a class="btn btn-sm btn-incre" href="" >
                                    <i class="fas fa-plus-square"></i>
                                </a>
                            </div>
                        </form>
                      </td>
                    <td>456</td>
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
                        <td>17</td>
                        <td>1333</td>
                    </tr>
                </table>
                
            </div>
            <a class="mx-3 btn-primary" href="#">CheckOut</a>
        </div>
        <%@include file="include/footer.jsp"%>
    </body>
</html>
