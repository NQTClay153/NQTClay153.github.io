<%-- 
    Document   : listBlog
    Created on : Oct 14, 2021, 3:24:11 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BLOG</title>
    </head>
    <body>
        <table border="1px">
            <tr>
                <th>Title</th>
                <th>Created From</th>
            </tr>
            <c:forEach items="${requestScope.blogs}" var="b">
                <tr>
                    <td>${b.title}</td>
                    <td>${b.from}</td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
