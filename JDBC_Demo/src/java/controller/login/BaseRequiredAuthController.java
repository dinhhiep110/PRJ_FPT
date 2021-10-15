/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Feature;

/**
 *
 * @author Duy Hiep
 */
public abstract class BaseRequiredAuthController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private boolean isAuthenticated(HttpServletRequest request){
        Account account = (Account) request.getSession().getAttribute("account");
        if(account == null){
            return false;
        }
        String url = request.getServletPath();
        for (Feature feature : account.getFeature()) {
            if (feature.getUrl().equals(url)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (isAuthenticated(request)) {
            proccessGet(request, response);
        } else {
            response.sendRedirect("../login");
            
        }
    }
    
    protected abstract void proccessGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    
    protected abstract void proccessPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

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
        if (isAuthenticated(request)) {
            proccessPost(request, response);
        } else {
            response.getWriter().println("Access Denied");
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
