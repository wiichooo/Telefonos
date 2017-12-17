package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class in_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("                   var xmlHttp = createXmlHttpRequestObject();\n");
      out.write("            function createXmlHttpRequestObject(){\n");
      out.write("                var xmlHttp;\n");
      out.write("                if(window.ActiveXObject){\n");
      out.write("                    try{\n");
      out.write("                        xmlHttp=new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                    }\n");
      out.write("                    catch(e){\n");
      out.write("                        xmlHttp=false;\n");
      out.write("                    }\n");
      out.write("                }else{\n");
      out.write("                   try{\n");
      out.write("                        xmlHttp = new XMLHttpRequest();\n");
      out.write("                    }catch (e){\n");
      out.write("                        xmlHttp = false;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            if(!xmlHttp)\n");
      out.write("                alert(\"Error al crear el objeto XMLHttpRequest\");\n");
      out.write("            else\n");
      out.write("                 return xmlHttp;\n");
      out.write("             }\n");
      out.write("\n");
      out.write("                   function login(par){\n");
      out.write("                       //alert(document.getElementById(\"u\").value);\n");
      out.write("                       //alert(document.getElementById(\"p\").value);\n");
      out.write("                        if(xmlHttp.readyState ==4 ||xmlHttp.readyState==0){\n");
      out.write("                            xmlHttp.open(\"GET\",\"login.jsp?usuario=\"+document.getElementById(\"u\").value+\"&pass=\"+document.getElementById(\"p\").value,true);\n");
      out.write("                           xmlHttp.onreadystatechange = Act;\n");
      out.write("                          //alert(par.title);\n");
      out.write("                          xmlHttp.send(null);\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                     }\n");
      out.write("                     function Act(){\n");
      out.write("                         //alert(\"eliminar\");\n");
      out.write("                         if(xmlHttp.readyState==4){\n");
      out.write("                           if(xmlHttp.status ==200){\n");
      out.write("                              Response = xmlHttp.responseText;\n");
      out.write("                              //alert(Response);\n");
      out.write("                              \n");
      out.write("                                 document.getElementById(\"insertar\").innerHTML=Response;\n");
      out.write("                              \n");
      out.write("                            }\n");
      out.write("                         }\n");
      out.write("                     }\n");
      out.write("                </script>\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<title>MiniAgendaPersonal</title>\n");
      out.write("<meta name=\"keywords\" content=\"\" />\n");
      out.write("<meta name=\"description\" content=\"\" />\n");
      out.write("<link href=\"style2.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write(" <div id=\"banner\"><img src=\"images/img04.jpg\" alt=\"\" width=\"960\" height=\"147\" /></div>\n");
      out.write("\n");
      out.write("<div id=\"menu\">\n");
      out.write("\t<ul>\n");
      out.write("\n");
      out.write("\t</ul>\n");
      out.write("\t\n");
      out.write("</div>\n");
      out.write("<hr />\n");
      out.write("\n");
      out.write("<!-- start page -->\n");
      out.write("<div id=\"page\">\n");
      out.write("\t<!-- start content -->\n");
      out.write("\t<div id=\"content\">\n");
      out.write("\t\t<div>\n");
      out.write("\t\t\t<h2 class=\"title\"><a>Bienvenido.</a></h2>\n");
      out.write("\t\t\t<div class=\"entry\">\n");
      out.write("\t\t\t\t<h3>A su mini agenda personal...</h3>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"post\">\n");
      out.write("\t\t\t<div class=\"entry\">\n");
      out.write("                             \n");
      out.write("                        <div id=\"login\">\n");
      out.write("                            <form action=\"login.jsp\">\n");
      out.write("                            <br><br><br><br>\n");
      out.write("                            Usuario:<input id=\"u\"   type=\"text\" name=\"u\" /><br><br>\n");
      out.write("                            Password:<input id=\"p\"   type=\"password\" name=\"p\" /><br><br>\n");
      out.write("\n");
      out.write("                               <ul>\n");
      out.write("                <li>\n");
      out.write("\n");
      out.write("                              <input id=\"x\" type=\"submit\" name=\"imageField\" value=\"Ingresar!\"/> </li>\n");
      out.write("                              </ul>\n");
      out.write("\n");
      out.write("                              <br><br><br><br><br><br>\n");
      out.write("                        </form>\n");
      out.write("                           </div>\n");
      out.write("            \n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div> \n");
      out.write("\t</div>\n");
      out.write("         \n");
      out.write("\t<!-- end content -->\n");
      out.write("\t<!-- start sidebar -->\n");
      out.write("\t<div id=\"sidebar\">\n");
      out.write("\t\t<ul>\n");
      out.write("                <li> </li>\n");
      out.write("\t\t<li> </li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- end sidebar -->\n");
      out.write("</div>\n");
      out.write("<!-- end page -->\n");
      out.write("<div id=\"footer\">\n");
      out.write("\t<p class=\"legal\">Copyright (c) 2009 Website Name. All rights reserved.</p>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
