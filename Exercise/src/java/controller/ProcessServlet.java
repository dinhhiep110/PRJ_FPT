/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Rectangle;

/**
 *
 * @author Duy Hiep
 */
public class ProcessServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.sendRedirect("view/submit.jsp");
          request.getRequestDispatcher("view/submit.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int x = Integer.parseInt(request.getParameter("x"));
        int y = Integer.parseInt(request.getParameter("y"));
        int w = Integer.parseInt(request.getParameter("w"));
        int h = Integer.parseInt(request.getParameter("h"));
        Rectangle rec = new Rectangle(x, y, h, h);
//        ArrayList<Rectangle> list = new ArrayList<>();
        if( x < 0 || y < 0 || x + w > 500 || h + y > 500){
            response.getWriter().println("Invalidated Rectangular");
        }
        else{
            request.setAttribute("rects", rec);
            request.getRequestDispatcher("/view/draw.jsp").forward(request, response);
        }
    }

    
    

}
