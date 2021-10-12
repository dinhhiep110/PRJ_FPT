<%-- 
    Document   : draw
    Created on : Sep 15, 2021, 10:00:18 AM
    Author     : Duy Hiep
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Rectangle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rectangle Page</title>
        <%Rectangle rec = (Rectangle) request.getAttribute("rects"); %>
    </head>
    <body>
        <canvas id="myCanvas" width="500" height="500" style="border:1px solid #d3d3d3;"></canvas>
        <script>
        var c = document.getElementById("myCanvas");
        var ctx = c.getContext("2d");
         
            ctx.beginPath();
            ctx.rect(<%=rec.getX()%>,<%=rec.getY()%>,<%=rec.getWidth()%>,<%=rec.getHeight()%>)
            ctx.stroke();
         
        </script>
    </body>
</html>
