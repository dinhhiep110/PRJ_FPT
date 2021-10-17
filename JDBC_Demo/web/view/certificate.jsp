<%-- 
    Document   : certificate
    Created on : Oct 17, 2021, 9:19:14 AM
    Author     : Duy Hiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Certificate Page</title>
    </head>
    <body>
        <form action="certificate" method="Post">
            <label>
                Certificate:<br> 
                <c:forEach items="${requestScope.certificate}" var="c">
                    <input type="checkbox" name="certid" value="${c.cid}">${c.name}
                </c:forEach>
                    <br>
            </label>
            <input type="submit" value="Search">   
        </form>
        
        <table border="1px" style="width: 70%">
            <tr>
                <th>Student</th>
                <th>Certificates</th>
                 
            </tr>
            <c:forEach items="${requestScope.searchCertificate}" var="s">
                <tr>
                    <td>${s.name}</td>
                    <td>
                    <c:forEach items="${s.certs}" var="sc">
                        +${sc.certificate.name}<br>
                    </c:forEach>
                    </td>
                </tr>    
            </c:forEach>
           
        </table>
        
    </body>
</html>
