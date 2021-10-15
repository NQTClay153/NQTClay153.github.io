<%-- 
    Document   : login
    Created on : Oct 13, 2021, 3:34:44 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="login" method="POST"> 
            Username: <input type="text" name="user"/> <br/>
            Password:<input type="password" name ="pass" /> <br/>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
