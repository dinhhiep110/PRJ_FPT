<%-- 
    Document   : enroll
    Created on : Sep 24, 2021, 10:25:59 AM
    Author     : Duy Hiep
--%>

<%@page import="model.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Employee"%>
<%@page import="model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% ArrayList<Employee> employees =(ArrayList<Employee>) request.getAttribute("employees"); %>
        <% ArrayList<Course> courses =(ArrayList<Course>) request.getAttribute("courses"); %>
    </head>
    <body>
        <form action="enroll" method="Post">
            <label>Employee:
                <select name="eid">
                    <% for (Employee e : employees) { %>
                    <option value="<%=e.getId()%>"><%=e.getName()%></option>
                    <% } %>
                </select> </label> <br>
                
            <label>Course: 
                <select name="cid">
                    <% for (Course c : courses) { %>
                    <option value="<%=c.getId()%>"><%=c.getName()%></option>
                    <% } %>
                </select> </label> <br>
            
            <label>From: <input type="date" name="from"></label> <br>
            <label>To: <input type="date" name="to"></label> <br>
            <label>Active: <input type="radio" name="active" checked="checked" value="Yes">Yes</label>
                            
                            <input type="radio" name="active" value="No">No</label> 
                            
                             <br>
            <label>Note: <input type="text" name="note"></label> <br>
            <input type="submit" value="Save" >
        </form>
        
    </body>
</html>
