<%-- 
    Document   : list
    Created on : Sep 21, 2021, 8:25:32 PM
    Author     : Duy Hiep
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP First Test</title>
    </head>
    <body>
        <table border="1px">
            <tr style="background-color: gray" >
                <td>Name</td>
                <td>Id</td>
                <td>Gender</td>
                <td>DOB</td>
                <td>Department</td>
                <td>Detail about Student</td>
                <td>Update Information</td>
                <td>Delete</td>
            </tr>
            <c:forEach items="${requestScope.list}" var="student">
             <tr>
                 <td>${student.id}</td>
                <td>${student.name}</td>
                <td><c:if test="${student.gender}">
                        <img src="../img/male-icon.png" alt=""/>
                    </c:if>
                    <c:if test="${!student.gender}">
                        <img src="../img/female-icon.png" alt=""/>
                    </c:if>
                </td>
                <td>${student.dob}</td>
                <td>${student.department.dname}</td>
                <td><a href="detail?id=${student.id}" >Detail</a></td>
                <td><input type="button" onclick="doUpdate(${student.id});" value="Update" ></td>
                <td><input type="button" onclick="doDelete(${student.id});" value="Delete" ></td>
            </tr>
            </c:forEach>
        </table>
        <a href="insert">Insert</a><br>
        <a href="../logout">Log out</a>
    </body>
    
    <script>
        function doUpdate(id) {
            window.location.href = "update?id=" + id;
        }
        
        function doDelete(id) {
            var c = confirm("Are you sure");
            if(c){
                window.location.href = "delete?id=" + id;
            }
        }
    </script>
</html>

