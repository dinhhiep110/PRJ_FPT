/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.eventslistener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author Duy Hiep
 */
public class CountUserListener implements HttpSessionListener {
    ServletContext ctx=null;  
    static int total = 0, current = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        total++;
        current++;
        ctx = se.getSession().getServletContext();  
        ctx.setAttribute("totalusers", total);  
        ctx.setAttribute("currentusers", current);  
         
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        current--;  
        ctx.setAttribute("currentusers",current);  
    }
}
