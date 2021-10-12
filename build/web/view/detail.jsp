<%-- 
    Document   : detail
    Created on : Sep 27, 2021, 10:34:13 AM
    Author     : Duy Hiep
--%>

<%@page import="model.Certificate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.StudentCertificate"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Page</title>     
    </head>
    <body>
        ID: ${requestScope.detailStudent.id} <br/>
        Name: ${requestScope.detailStudent.name} <br/>
        Dob: <fmt:formatDate type = "date" 
         value = "${requestScope.detailStudent.dob}" /><br/>
        Gender: ${requestScope.detailStudent.gender?"Male":"Female"}<br/>
        Department:${requestScope.detailStudent.department.dname}<br/>
        Certificate:<br>
        <c:if test="${requestScope.detailStudent.certs == null}">
            <c:out value="No certificate"></c:out>
        </c:if>
        <c:forEach items="${requestScope.detailStudent.certs}" var="sc">
            ${sc.certificate.name}<br>
        </c:forEach>
    </body>
</html>
