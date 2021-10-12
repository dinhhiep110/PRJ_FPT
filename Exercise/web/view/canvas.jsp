<%-- 
    Document   : canvas
    Created on : Sep 13, 2021, 3:40:28 PM
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
        <%ArrayList<Rectangle> rects = (ArrayList<Rectangle>) request.getAttribute("list"); %>
    </head>
    <body>
        <canvas id="myCanvas" width="500" height="500" style="border:1px solid #d3d3d3;"></canvas>
        <script>
        var c = document.getElementById("myCanvas");
        var ctx = c.getContext("2d");
         
            ctx.beginPath();
            <% for (Rectangle r : rects) { %>
            ctx.rect(<%=r.getX()%>, <%=r.getY() %>, <%=r.getWidth()%>, <%=r.getHeight()%>);
            <% } %>
            ctx.stroke();
         
        </script>
    </body>
</html>
