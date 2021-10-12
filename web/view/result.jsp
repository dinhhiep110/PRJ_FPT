<%-- 
    Document   : search
    Created on : Oct 9, 2021, 2:55:04 PM
    Author     : Duy Hiep
--%>

<%@page import="model.StudentCertificate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <% ArrayList<Student> listStudent  = (ArrayList<Student>)request.getAttribute("listStudent"); %>
    </head>
    <body>
        <table border="1px" style="width: 70%">
            <tr>
                <th>Student Name</th>
                <th>Certificate</th>
                <th>Department</th>
            </tr>
            <% for(Student s : listStudent) { %>
            <tr>
                <td><%=s.getName() %></td>
             
                <td>
                    <% for(StudentCertificate  sc : s.getCerts()) { %>
                    +<%=sc.getCertificate().getName() %><br>
                    <% } %>
                </td>

                <td><%=s.getDepartment().getDname() %></td>  
            </tr>
            <% } %>
        </table>
        
    </body>
</html>
