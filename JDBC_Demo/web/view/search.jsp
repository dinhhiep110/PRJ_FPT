<%-- 
    Document   : search
    Created on : Oct 11, 2021, 10:41:31 AM
    Author     : dell
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
        <form action="search">
            Id: <input type="text" value="${param.id}" name="id"/> <br/>
            Name: <input type="text" name="name" value="${param.name}"/> <br/>
            Gender: 
            <input type="radio"
                   ${param.gender!=null && param.gender eq "male"?"checked=\"checked\"":""}
                   name="gender" value="male"/> Male
            <input type="radio"
                   ${param.gender!=null && param.gender eq "female"?"checked=\"checked\"":""}
                   name="gender" value="female"/> Female
            <input type="radio"
                   ${param.gender==null || param.gender eq "" || param.gender eq "all"?"checked=\"checked\"":""}
                   name="gender" value="all"/> All
            <br/>
            From: <input type="date" value="${param.from}" name="from"/> <br/>
            To: <input type="date" value="${param.to}" name="to"/> <br/>
            Department: <select name="did">
                <option 
                        value="-1">
                       all
                    </option>
                <c:forEach items="${requestScope.depts}" var="d">
                    <option 
                        <c:if test="${d.did eq param.did}">
                            selected="selected"
                        </c:if>
                        value="${d.did}">
                        ${d.dname}
                    </option>
                </c:forEach>
            </select>
            <br/>
            <input type="submit" value="Search"/>
        </form>
        <table border="1px" style="width: 70%">
            <tr> 
                <td>Id</td>
                <td>Name</td>
                <td>Gender</td>
                <td>Dob</td>
                <td>Department</td>
            </tr>
            <c:forEach items="${requestScope.searchStudent}" var="s">
            <tr> 
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td><c:if test="${s.gender}">
                    <img src="../img/male-icon.png" alt=""/>
                    </c:if>
                    <c:if test="${!s.gender}">
                    <img src="../img/female-icon.png" alt=""/>
                    </c:if>
                </td>
                <td>${s.dob}</td>
                <td>${s.department.dname}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
