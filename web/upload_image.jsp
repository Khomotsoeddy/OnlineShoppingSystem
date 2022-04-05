<%-- 
    Document   : hello
    Created on : 02 Apr 2022, 22:36:23
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="upload_img">
            <form action="UploadImage" method="POST" enctype="multipart/form-data">
                <input type="file" name="file">
                <input type="submit" value="UPLOOAD">
            </form>
        </div>
    </body>
</html>
