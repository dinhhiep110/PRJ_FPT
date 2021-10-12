<%-- 
    Document   : studentcertificate
    Created on : Oct 6, 2021, 9:27:38 AM
    Author     : Duy Hiep
--%>

<%@page import="model.Certificate"%>
<%@page import="model.Student"%>
<%@page import="model.StudentCertificate"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Certificate Page</title>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    </head>
    <body>
        <form action="certificate" method="Post">
            <table border="1px" style="width: 70%">
                <tr>
                    <td></td>
                    <c:forEach items="${requestScope.certificate}" var="c">
                        <c:set var="temp" value=""/>
                        <th>${c.name}</th>

                    </c:forEach>
                 </tr>
                 <c:forEach items="${requestScope.studentCertificate}" var="s">
                <tr>
                    <td>${s.name}</td>
                    <c:forEach items="${requestScope.certificate}" var="c">
                        <td style="text-align: center">
                            <input type="checkbox" 
                                <c:forEach items="${s.certs}" var="sc">
                                    <c:if test="${c.cid == sc.certificate.cid}">
                                    checked="checked"
                                    </c:if>
                                </c:forEach> name="certid" value="${s.id}_${c.cid}">
                        </td>
                    </c:forEach>
                </tr>
                </c:forEach>  
            </table>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
