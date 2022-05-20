<%-- 
    Document   : upload-products
    Created on : 19 Apr 2022, 01:20:58
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="include/header.jsp"%>
        <title>Upload Products</title>
    </head>
    <body style="background: radial-gradient(#fff,#ffd6d6)">
        <%@include file="include/navbar.jsp"%>

        <div class="prod">
            <div class="uploading">
                <div class="detail">
                    <p>Upload new product</p>
                </div>
            </div>
            <div class="upload_container">
                <form action="UploadImageServlet.do" method="POST" enctype="multipart/form-data">

                    <input type="text" name="productName" placeholder="Name of product"/><br>
                    <input type="text" name="productId" placeholder="Product ID"/><br>
                    <input type="text" name="productCategory" placeholder="Product Category"/><br>
                    <input type="number" name="productPrice" placeholder="Product price"/><br>
                    <input type="file" name="file" placeholder="Browse To Your Product"><br><br>
                    <input type="submit" value="UPLOAD" class="butn"><br>
                </form>
            </div>
        </div>

        <%@include file="include/footer.jsp"%>
        <%@include file="include/footer1.jsp"%>
    </body>
</html>
