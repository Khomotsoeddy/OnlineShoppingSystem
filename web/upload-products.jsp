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
    <body>
        <!--------------upload a picture---------------->
        <div class="upload_img">
            <form action="UploadImageServlet.do" method="POST" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td>Name of product</td>
                        <td><input type="text" name="productName"/></td>
                    </tr>
                    <tr>
                        <td>Product Category</td>
                        <td><input type="text" name="productCategory"/></td>
                    </tr>
                    <tr>
                        <td>Product price</td>
                        <td><input type="number" name="productPrice"/></td>
                    </tr>
                    <tr>
                        <td>Product ID</td>
                        <td><input type="text" name="productId"/></td>
                    </tr>
                    <tr>
                        <td>Browse To Your Product</td>
                        <td><input type="file" name="file"></td>
                    </tr>
                    <tr>
                        <td>Click Button To Upload</td><br>
                        <td><input type="submit" value="UPLOOAD" class="btn"></td>
                    </tr>
                </table>
                
                
            </form>
        </div>
        <%@include file="include/footer.jsp"%>
        <%@include file="include/footer1.jsp"%>
    </body>
</html>
