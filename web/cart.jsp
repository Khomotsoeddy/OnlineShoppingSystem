<%-- 
    Document   : cart
    Created on : 09 Apr 2022, 02:20:08
    Author     : Asus
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="za.ac.tut.businness.ProductsProcessoor"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="za.ac.tut.model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    DecimalFormat df = new DecimalFormat("#.##");
    request.setAttribute("df", df);
    //String emailAddress = (String) request.getSession().getAttribute("emailAddress");
    //if (emailAddress != null) {
      //  request.setAttribute("emailAddress", emailAddress);
    //}
    
    ArrayList<Cart> cart_List = (ArrayList<Cart>) session.getAttribute("Cart-List");
    double totalPrice =0;
    int totalQuantity = 0;
    ProductsProcessoor pp = new ProductsProcessoor();
        List<Cart> cartProduct= null;
    if (cart_List != null) {
        cartProduct = pp.getCartProducts(cart_List);
        totalQuantity = pp.getTotalQuantity(cart_List);
        totalPrice = pp.getTotalPrice(cart_List);
        request.setAttribute("cart_List", cart_List);
        request.setAttribute("totalPrice", totalPrice);
    }
    
%>
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
                    if (cart_List != null) {
                        for (Cart c : cartProduct) {
                %>


                <tr>
                    <td>
                        <div class="cart_info">
                            <img src="./product_images/<%=c.getImage()%>"/>
                            <div>
                                <p><%=c.getName()%></p>
                                <small>R<%=c.getPrice()%></small><br>
                                <a href="#">Remove</a>
                            </div>
                        </div>
                    </td>
                    <td>
                        <select>
                            <option>Select Size</option>
                            <option>Small</option>
                            <option>Medium</option>
                            <option>Large</option>
                        </select>
                    </td>
                    <td>
                        <form action="" method="post" class="form-inline">
                            <input type="hidden"  name="id" value="<%=c.getProductId()%>" class="form-input">
                            <div class="form-group d-flex justify-content-between">
                                <a class="btn btn-sm btn-decre" href="QuantityEncrDecrServlet.do?action=dec&id=<%=c.getProductId()%>">
                                    <i class="fas fa-minus-square"></i>
                                </a>
                                <input type="text" name="quantity" value="<%=c.getQuantity()%>" readonly>

                                <a class="btn btn-sm btn-incre" href="QuantityEncrDecrServlet.do?action=inc&id=<%=c.getProductId()%>" >
                                    <i class="fas fa-plus-square"></i>
                                </a>
                            </div>
                        </form>
                    </td>
                    <td><%=df.format(c.getPrice() * c.getQuantity())%></td>
                </tr>

                <%
                        }
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
                        <td>
                            <%=totalQuantity%>
                        </td>
                        <td>
                            <!--------{ (totalPrice>0)?totalPrice:0.0 }--------->
                            <%=totalPrice%>
                        </td>
                    </tr>
                </table>

            </div>
            <a class="butn" href="#">CheckOut &#8594;</a>
        </div>
        <%@include file="include/footer.jsp"%>
    </body>
</html>
