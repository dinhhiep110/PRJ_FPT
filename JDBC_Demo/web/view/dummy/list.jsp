<%-- 
    Document   : list
    Created on : Oct 22, 2021, 10:31:46 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="../js/pagger.js" type="text/javascript"></script>
        <link href="../css/pagger.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <div id="paggertop" class="pagger"></div>
        <table> 
            <tr>
                <td>ID</td>
                <td>Name</td>
            </tr>
            <c:forEach items="${requestScope.dummies}" var="d">
                <tr>
                    <td>${d.id}</td>
                    <td>${d.name}</td>
                </tr>    
            </c:forEach>
        </table>
         <div id="paggerbottom" class="pagger"></div>
         <script>
             generatePagger('paggerbottom',${requestScope.pageindex},${requestScope.totalPage},2);
         </script>
             
        
    </body>
</html>
