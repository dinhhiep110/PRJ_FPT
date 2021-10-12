<%-- 
    Document   : searchByDepts
    Created on : Oct 9, 2021, 2:39:40 PM
    Author     : Duy Hiep
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
                    <option value="0">all</option>
                    <c:forEach items="${requestScope.departments}" var="d">
                    <option value="${d.did}">${d.dname}</option>
                    </c:forEach>
                </select> </label> 
            <input type="submit" value="search">
        </form>
        
    </body>
    
    
     
        
        
        
         
</html>
