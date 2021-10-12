/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CourseDBContext;
import dal.EmployeeDBContext;
import dal.EnrollDBContext;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.Employee;
import model.Enrollment;

/**
 *
 * @author Duy Hiep
 */
public class AccessEnroll extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmployeeDBContext ed = new EmployeeDBContext();
        CourseDBContext cd = new CourseDBContext();
        ArrayList<Employee> employees = ed.getEmployee();
        ArrayList<Course> courses = cd.getCourse();
        request.setAttribute("employees", employees);
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("/view/enroll.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Enrollment enroll = new Enrollment();
        Employee e = new Employee();
        Course c = new Course();
        enroll.setFrom(Date.valueOf(request.getParameter("from")));
        enroll.setTo(Date.valueOf(request.getParameter("to")));
        c.setId(Integer.parseInt(request.getParameter("cid")));
        enroll.setCid(c);
        e.setId(Integer.parseInt(request.getParameter("eid")));
        enroll.setEid(e);
        enroll.setActive(request.getParameter("active").equals("Yes"));
        enroll.setNote(request.getParameter("note"));
        EnrollDBContext enrollDBContext = new EnrollDBContext();
        int row = enrollDBContext.insert(enroll);
        if(row > 0){
            response.getWriter().println("Insert row " +row + " successfull");
        }
        else{
            response.getWriter().println("Insert row " +row + " unsuccessfull");
        }
        
                
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
