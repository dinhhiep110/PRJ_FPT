/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import controller.login.BaseRequiredAuthController;
import dal.CertificateDBContext;
import dal.DepartmentDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Certificate;
import model.Department;
import model.Student;
import model.StudentCertificate;

/**
 *
 * @author Duy Hiep
 */
public class InsertController extends BaseRequiredAuthController {

     @Override
    protected void proccessGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDBContext db = new DepartmentDBContext();
        ArrayList<Department> depts = db.getDepartments();
        request.setAttribute("depts", depts);
        CertificateDBContext cdb = new CertificateDBContext();
        ArrayList<Certificate> certificate = cdb.getCertificate();
        request.setAttribute("certs", certificate);
        request.getRequestDispatcher("../view/insert.jsp").forward(request, response);
    }

    @Override
    protected void proccessPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        Student student = new Student();
        student.setName(request.getParameter("name"));
        student.setGender(request.getParameter("gender").equals("male"));
        student.setDob(Date.valueOf(request.getParameter("dob")));
        Department d = new Department();
        d.setDid(Integer.parseInt(request.getParameter("did")));
        student.setDepartment(d);
        String cid[] = request.getParameterValues("cid");
        if (cid != null) {
            for (String c : cid) {
                StudentCertificate sc = new StudentCertificate();
                sc.setStudent(student);
                Certificate cert = new Certificate();
                cert.setCid(Integer.parseInt(c));
                sc.setCertificate(cert);
                student.getCerts().add(sc);                     
            }
        }
        
        StudentDBContext db = new StudentDBContext();
        db.insert(student);
        response.sendRedirect("list");
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
