/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import dal.DepartmentDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Department;
import model.Student;

/**
 *
 * @author Duy Hiep
 */
public class SearchController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_id = request.getParameter("id");
        String raw_name = request.getParameter("name");
        String raw_gender = request.getParameter("gender");
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        String raw_did = request.getParameter("did");
        
        if(raw_id == null || raw_id.length() == 0){
            raw_id = "-1";
        }
        if(raw_did == null || raw_did.length() == 0){
            raw_did = "-1";
        }
        if(raw_gender ==null || raw_gender.length() ==0){
            raw_gender = "all";
        }
        int id = Integer.parseInt(raw_id);
        int did = Integer.parseInt(raw_did);
        String name = (raw_name == null || raw_name.length() == 0) ? null : raw_name;
        Boolean gender = (raw_gender.equals("all")) ? null : raw_gender.equals("male");
        Date from = (raw_from == null || raw_from.length() == 0) ? null : Date.valueOf(raw_from);
        Date to = (raw_to == null || raw_to.length() == 0) ? null : Date.valueOf(raw_to);
        
        DepartmentDBContext dbc =  new DepartmentDBContext();
        StudentDBContext sdbc = new StudentDBContext();
        ArrayList<Student> searchStudent = sdbc.search(id, name, gender, from, to, did);
        ArrayList<Department> departments = dbc.getDepartments();
        request.setAttribute("depts", departments);
        request.setAttribute("searchStudent", searchStudent);
        request.getRequestDispatcher("../view/search.jsp").forward(request, response);
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
