<%-- 
    Document   : listuser
    Created on : Oct 13, 2021, 3:49:23 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
    </head>
    <body>
        <table border="1px">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Date of Birth</th>
                <th>Address</th>
                <th>Position</th>
            </tr>

            <c:forEach items="${requestScope.users}" var="u">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.displayName}</td>
                    <td>${u.gender}</td>
                    <td>${u.dob}</td>
                    <td>${u.address}</td>
                    <c:if test="${u.isAdmin}">
                        <td>Admin</td>
                    </c:if>
                    <c:if test="${!u.isAdmin}">
                        <td>Member</td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
