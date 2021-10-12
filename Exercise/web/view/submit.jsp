<%-- 
    Document   : submit
    Created on : Sep 15, 2021, 9:48:50 AM
    Author     : Duy Hiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="../add" method="Post">
             <fieldset>
                <label>X</label>
                <input type="text" name="x"><br>
                <label>Y</label>
                <input type="text" name="y"><br> 
                <label>W</label>
                <input type="text" name="w"><br>
                <label>H</label>
                <input type="text" name="h"><br>
                <br>
                <input type="submit" value="Save">
             </fieldset>
        </form>
    </body>
</html>
