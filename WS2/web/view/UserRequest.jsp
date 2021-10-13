<%-- 
    Document   : UserRequest
    Created on : Oct 13, 2021, 9:49:09 AM
    Author     : Duy Hiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Request Page</title>
    </head>
    <body>
        <c:forEach items="${requestScope.userRequest}" var="ur">
            ${ur.id}
            ${ur.reason}
            ${ur.requestDate}
            ${ur.account.username}
        </c:forEach>
    </body>
</html>
