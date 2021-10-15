<%-- 
    Document   : signUp
    Created on : Oct 14, 2021, 12:16:59 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRATION</title>
    </head>
    <body>
        <h1>REGISTRATION FORM</h1>
        <form action="signUp" method="POST"> 
            Username: <input type="text" name="user"/> <br/>
            Password:<input type="password" name ="pass" /> <br/>
            Re-input pass word: <input type="password" name ="pass1" /> <br/>
            Display name: <input type="text" name="displayName"/> <br/>
            Gender:<input name="gender" type="radio" value="male" checked="checked">Male
            <input name="gender" type="radio" value="female" >Female <br>
            Date of Birth: <input name="dob" type="date"><br>
            Address: <input type="text" name="address"/> <br/>
            <input type="submit" value="Sign Up" />
        </form>
    </body>
</html>
