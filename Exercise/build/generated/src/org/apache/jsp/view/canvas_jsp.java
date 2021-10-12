package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import module.Rectangle;

public final class canvas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Rectangle Page</title>\n");
      out.write("        ");
ArrayList<Rectangle> rects = (ArrayList<Rectangle>) request.getAttribute("list"); 
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <canvas id=\"myCanvas\" width=\"500\" height=\"500\" style=\"border:1px solid #d3d3d3;\"></canvas>\n");
      out.write("        <script>\n");
      out.write("        var c = document.getElementById(\"myCanvas\");\n");
      out.write("        var ctx = c.getContext(\"2d\");\n");
      out.write("        ctx.beginPath();\n");
      out.write("        ");
 for (Rectangle rect : rects) {
      out.write("\n");
      out.write("            ctx.rect(");
 rect.getTop(); 
      out.write(',');
      out.write(' ');
 rect.getLeft(); 
      out.write(',');
      out.write(' ');
 rect.getBottom(); 
      out.write(',');
      out.write(' ');
 rect.getRight(); 
      out.write(");\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        ctx.stroke();\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
