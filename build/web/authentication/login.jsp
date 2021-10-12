<%-- 
    Document   : login
    Created on : Sep 29, 2021, 9:58:17 AM
    Author     : Duy Hiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="login" method="Post">
            <label>UserName: <input type="text" name="user" > </label> <br>
            <label>PassWord: <input type="text" name="pass" > </label> <br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
