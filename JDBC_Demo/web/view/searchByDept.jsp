<%-- 
    Document   : searchByDept
    Created on : Oct 12, 2021, 7:29:19 PM
    Author     : Duy Hiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="searchByDept" method="Post">
            <label>Department: 
                <select name="did">
                    <option value ="0">all</option>
                    <c:forEach items="${requestScope.departments}" var="d">
                    <option value="${d.did}">${d.dname}</option>
                    </c:forEach>
                </select> </label> 
                <input type="submit" value="Search" >
        </form>
        
        <table border="1px" style="width: 70%">
            <tr>
                 <th>Name</th>
                <th>Certificate</th>
                <th>Department</th>
            </tr>
            <c:forEach items="${requestScope.listStudent}" var="s">
                <tr>
                    <td>${s.name}</td>
                    <td>
                    <c:forEach items="${s.certs}" var="sc">
                        + ${sc.certificate.name} <br>
                    </c:forEach>
                    </td>
                    <td>
                        ${s.department.dname}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
