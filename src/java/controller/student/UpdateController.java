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
public class UpdateController extends BaseRequiredAuthController {

 
    @Override
    protected void proccessGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        int id = Integer.parseInt(request.getParameter("id"));
        StudentDBContext db = new StudentDBContext();
        CertificateDBContext cdb = new CertificateDBContext();         
        Student detailStudent = db.getDetailAboutStudent(id);
        request.setAttribute("detailStudent", detailStudent);
        DepartmentDBContext ddbc = new DepartmentDBContext();
        ArrayList<Department> depts = ddbc.getDepartments();
        ArrayList<Certificate> certificate = cdb.getCertificate();
        request.setAttribute("certificate", certificate);
        request.setAttribute("depts", depts);
        request.getRequestDispatcher("../view/update.jsp").forward(request, response);
    }
    @Override
    protected void proccessPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student s = new Student();
        Department d = new Department();
        s.setId(Integer.parseInt(request.getParameter("id")));
        s.setName(request.getParameter("name"));
        s.setGender(request.getParameter("gender").equals("male"));
        s.setDob(Date.valueOf(request.getParameter("dob")));
        d.setDid(Integer.parseInt(request.getParameter("did")));
        s.setDepartment(d);
        String cids[] =  request.getParameterValues("cid");
        if (cids != null) {
            for (String c : cids) {
                StudentCertificate sc = new StudentCertificate();
                sc.setStudent(s);
                Certificate cert = new Certificate();
                cert.setCid(Integer.parseInt(c));
                sc.setCertificate(cert);
                s.getCerts().add(sc);                     
            }
        }
        StudentDBContext db = new StudentDBContext();
        db.update(s);
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
