<%-- 
    Document   : blogDetail
    Created on : Oct 14, 2021, 8:23:53 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${requestScope.blogDetail.blog.title}</title>
    </head>
    <body>
        <table border="1px">
            <tr>
                <h1>${requestScope.blogDetail.blog.title}</h1>
            </tr>
            <tr>
                <p>${requestScope.blogDetail.user.displayName}</p>
                <p>${requestScope.blogDetail.blog.from}</p>
                <br>
            </tr>
            <tr>
                <p>${requestScope.blogDetail.description}</p>
            </tr>
<!--            <tr></tr>
            <tr>
            <h3>Comment</h3>
            </tr>
            <tr>
                ${requestScope.blogDetail.description}
            </tr>-->
    </table>
</body>
</html>
