<%-- 
    Document   : cart
    Created on : 09 Apr 2022, 02:20:08
    Author     : Asus
--%>

<%@page import="za.ac.tut.model.Store"%>
<%@page import="za.ac.tut.entity.Product"%>
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
    ArrayList<Store> products = (ArrayList<Store>) session.getAttribute("cart-products");
    ArrayList<Cart> cart_List = (ArrayList<Cart>) session.getAttribute("Cart-List");
    Double totalPrice =0.0;
    Integer totalQuantity =0;
    ProductsProcessoor pp = new ProductsProcessoor();
    if (products != null) {
        //cartProduct = (List<Cart>)session.getAttribute(cart_List);
        totalQuantity = pp.getTotalQuantity(products);
        totalPrice = pp.getTotalPrice(products);
        request.setAttribute("cart_List", cart_List);
        //request.setAttribute("totalPrice", totalPrice);
    }

%>
<html>
    <head>
        <%@include file="include/header.jsp"%>
        <title>Cart Page</title>
    </head>
    <body style="background: radial-gradient(#fff,#ffd6d6)">
        <%@include file="include/navbar.jsp"%>
        <div class="small_container cart_page">
            <table>
                <tr>
                    <th>Product</th>
                    <th>Size</th>
                    <th>Quantity</th>
                    <th>Subtotal</th>

                </tr>
                <%                    if (cart_List != null) {
                        for (Store p : products) {
                %>


                <tr>
                    <td>
                        <div class="cart_info">
                            <img src="./product_images/<%=p.getImage()%>"/>
                            <div>
                                <p><%=p.getName()%></p>
                                <small>R<%=p.getPrice()%></small><br>
                                <a href="RemoveItemServlet.do?id=<%=p.getProductId()%>">Remove</a>
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
                            <input type="hidden"  name="id" value="<%=p.getProductId()%>" class="form-input">
                            <div class="form-group d-flex justify-content-between">
                                <a class="btn btn-sm btn-decre" href="QuantityEncrDecrServlet.do?action=dec&id=<%=p.getProductId()%>">
                                    <i class="fas fa-minus-square"></i>
                                </a>
                                <input type="text" name="quantity" value="<%=p.getQuantity()%>" readonly>

                                <a class="btn btn-sm btn-incre" href="QuantityEncrDecrServlet.do?action=inc&id=<%=p.getProductId()%>" >
                                    <i class="fas fa-plus-square"></i>
                                </a>
                            </div>
                        </form>
                    </td>
                    <td><%=df.format(p.getPrice() * p.getQuantity())%></td>
                </tr>

                <%
                            //totalQuantity =+ p.getQuantity();  //}
                            //totalPrice =+ p.getPrice() * p.getQuantity();
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
                            <%=totalPrice%>
                        </td>
                    </tr>
                </table>

            </div>
            <a class="butn" href="CheckoutServlet.do">CheckOut &#8594;</a>
        </div>
        <%@include file="include/footer.jsp"%>
        <%@include file="include/footer1.jsp"%>
    </body>
</html>
