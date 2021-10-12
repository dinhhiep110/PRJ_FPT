/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import dal.CertificateDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Certificate;
import model.Student;

/**
 *
 * @author Duy Hiep
 */
public class StudentCertificateController extends HttpServlet {

    

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
        StudentDBContext sdb = new StudentDBContext();
        ArrayList<Integer> idStudent = sdb.getIDStudent();
        ArrayList<Student> studentCertificate = new ArrayList<>();
        for (Integer id : idStudent) {
            studentCertificate.add(sdb.getDetailAboutStudent(id));
        }
        CertificateDBContext cdb = new CertificateDBContext();
        ArrayList<Certificate> certificate = cdb.getCertificate();
        request.setAttribute("studentCertificate", studentCertificate);
        request.setAttribute("certificate", certificate);
        request.getRequestDispatcher("../view/studentcertificate.jsp").forward(request, response);
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
        String certs [] = request.getParameterValues("certid");
        StudentDBContext sdb = new StudentDBContext();
        ArrayList<Integer> idStudentCertificate = new ArrayList<>();
        int temp = -1;
        ArrayList<Integer> idStudent = sdb.getIDStudent();
        for (String cert : certs) {
            String[] arr = cert.split("_");
            if(temp != Integer.parseInt(arr[0])){
                sdb.deleteStudentCertificate(Integer.parseInt(arr[0]));
            }
            sdb.updateStudentCertificate(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
            temp = Integer.parseInt(arr[0]);
            idStudentCertificate.add(Integer.parseInt(arr[0]));
        }
        
       
        for (Integer id : idStudent) {
            if(!idStudentCertificate.contains(id)){
                sdb.deleteStudentCertificate(id);
            }
        }
        response.sendRedirect("certificate");
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
