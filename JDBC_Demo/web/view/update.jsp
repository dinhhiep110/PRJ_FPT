<%-- 
    Document   : update
    Created on : Sep 27, 2021, 3:13:07 PM
    Author     : Duy Hiep
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Certificate"%>
<%@page import="model.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <form action="update" method="Post">
            ID: ${requestScope.detailStudent.id} <input type="hidden" name="id" value="${requestScope.detailStudent.id}" /> <br/>
            <label>Name: <input type="text" name="name" value="${requestScope.detailStudent.name}"></label> <br>
            <label>Gender: <input type="radio" name="gender" 
                            ${requestScope.detailStudent.gender?"checked=\"checked\"": ""}         
                            value="male">Male
                            <img src="../img/male-icon.png" alt=""/>
                            <input type="radio" name="gender" 
                            ${!requestScope.detailStudent.gender?"checked=\"checked\"": ""}         
                            value="female">Female
                            <img src="../img/female-icon.png" alt=""/>
                             <br>
                             </label> 
            <label>DOB: <input type="date" name="dob" value="${requestScope.detailStudent.dob}"></label> <br>
            Department: 
                <select name="did">
                    <c:forEach items="${requestScope.depts}" var="d">
                        <option 
                            <c:if test="${d.did == requestScope.detailStudent.department.did}" >
                                selected="selected"
                            </c:if> 
                            value="${d.did}" >
                            ${d.dname}
                        </option>
                    </c:forEach>
                </select> <br>    
                    Certificate:<br>
                    <c:forEach items="${requestScope.certificate}" var="c">
                        <input name="cid" type="checkbox" 
                               <c:forEach items="${requestScope.detailStudent.certs}" var="sc">
                                   <c:if test="${c.cid == sc.certificate.cid}">
                                       checked="checked"
                                   </c:if>       
                               </c:forEach>
                           value="${c.cid}">${c.name} <br>
                         
                    </c:forEach>
                  
                <input type="submit" value="Save" >
        </form>
    </body>
</html>
