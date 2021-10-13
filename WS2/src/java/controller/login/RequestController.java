/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import dal.UserRequestDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserRequest;

/**
 *
 * @author Duy Hiep
 */
public class RequestController extends BaseRequiredAuthController {
    //chua in ra duoc ra cac request
    @Override
    protected void proccessGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserRequestDBContext urdb = new UserRequestDBContext();
        ArrayList<UserRequest> userRequest = urdb.getUserRequest();
        request.setAttribute("userRequest", userRequest);
        request.getRequestDispatcher("/view/UserRequest.jsp").forward(request, response);
    }

    @Override
    protected void proccessPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
