<%-- 
    Document   : insert
    Created on : Sep 22, 2021, 9:59:32 AM
    Author     : Duy Hiep
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Certificate"%>
<%@page import="model.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>   
    </head>
    <body>
        <form action="insert" method="Post">
            <label>Name: <input type="text" name="name"></label> <br>
            <label>Gender: <input type="radio" name="gender" checked="checked" value="male">Male</label>
                            <img src="../img/male-icon.png" alt=""/>
                            <input type="radio" name="gender" value="female">Female</label> 
                            <img src="../img/female-icon.png" alt=""/>
                             <br>
            <label>DOB: <input type="date" name="dob"></label> <br>
            <label>Department: 
                <select name="did">
                    <c:forEach items="${requestScope.depts}" var="d">
                    <option value="${d.did}">${d.dname}</option>
                    </c:forEach>
                </select> </label> <br>
                
                <c:forEach items="${requestScope.certs}" var="c">
                <input name="cid" type="checkbox" value="${c.cid}">${c.name} <br>
                    </c:forEach>
                <input type="submit" value="Save" >
        </form>
        
    </body>
</html>
