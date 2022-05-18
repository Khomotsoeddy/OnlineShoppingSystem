<%@page import="za.ac.tut.entity.Admins"%>
<%@page import="za.ac.tut.entity.Customer"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">POWER</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
<%
    String emailAddress = (String) session.getAttribute("emailAddress");
    String role = (String) session.getAttribute("role");
%>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ProductServlet.do">Products</a>
                </li>
                <%
                    if (emailAddress == null) {
                %>
                <li class="nav-item">
                    <a class="nav-link active" href="login.jsp">Login</a>
                </li>


                <%
                    }
                    if (emailAddress != null && role.equals("CUSTOMER")) {
                %>

                <li class="nav-item active">
                    <a class="nav-link" href="LoadCartServlet.do">Cart<span class="badge badge-danger px-1">${cart_List.size()}</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="LoadOrdersServlet.do">Orders</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="LogoutServlet.do">Logout</a>
                </li>
                <%
                    }else if(emailAddress != null && role.equals("ADMIN")){
                %>
                <li class="nav-item">
                    <a class="nav-link active" href="upload_product.jsp">Add Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="AminOrderServlet.do">Orders</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="LogoutServlet.do">Logout</a>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>
