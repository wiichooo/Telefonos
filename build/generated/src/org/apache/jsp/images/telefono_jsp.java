package org.apache.jsp.images;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class telefono_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    public boolean isDate(int m, int d, int y) // This method is used to check for a VALID date
    {
        m -= 1;
        Calendar c = Calendar.getInstance();
        c.setLenient(false);

        try
        {
                c.set(y,m,d);
                Date dt = c.getTime();
        }
          catch (IllegalArgumentException e)
        {
                return false;

        }
                return true;
    }


   public String getDateName (int monthNumber) // This method is used to quickly return the proper name of a month
   {
                String strReturn = "";
                switch (monthNumber)
                {
                    case 0:
                            strReturn = "Enero";
                            break;
                    case 1:
                            strReturn = "Febrero";
                            break;
                    case 2:
                            strReturn = "Marzo";
                            break;
                    case 3:
                            strReturn = "Abril";
                            break;
                    case 4:
                            strReturn = "Mayo";
                            break;
                    case 5:
                            strReturn = "Junio";
                            break;
                    case 6:
                            strReturn = "Julio";
                            break;
                    case 7:
                            strReturn = "Agosto";
                            break;
                    case 8:
                            strReturn = "Septiembre";
                            break;
                    case 9:
                            strReturn = "Octubre";
                            break;
                    case 10:
                            strReturn = "Noviembre";
                            break;
                    case 11:
                            strReturn = "Diciembre";
                            break;
        }
        return strReturn;
    }

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

// Global Vars
            int action = 0;  // incoming request for moving calendar up(1) down(0) for month
            int currYear = 0; // if it is not retrieved from incoming URL (month=) then it is set to current year
            int currMonth = 0; // same as year
            String boxSize = "50";  // how big to make the box for the calendar

//build 2 calendars

            Calendar c = Calendar.getInstance();
            Calendar cal = Calendar.getInstance();

            if (request.getParameter("action") == null) // Check to see if we should set the year and month to the current
            {
                currMonth = c.get(c.MONTH);

                currYear = c.get(c.YEAR);
                cal.set(currYear, currMonth, 1);

            } else {
                if (!(request.getParameter("action") == null)) // Hove the calendar up or down in this if block
                {
                    currMonth = Integer.parseInt(request.getParameter("month"));
                    currYear = Integer.parseInt(request.getParameter("year"));

                    if (Integer.parseInt(request.getParameter("action")) == 1) {
                        cal.set(currYear, currMonth, 1);
                        cal.add(cal.MONTH, 1);
                        currMonth = cal.get(cal.MONTH);
                        currYear = cal.get(cal.YEAR);
                    } else {
                        cal.set(currYear, currMonth, 1);
                        cal.add(cal.MONTH, -1);
                        currMonth = cal.get(cal.MONTH);
                        currYear = cal.get(cal.YEAR);
                    }
                }
            }

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<title>MiniAgendaPersonal</title>\n");
      out.write("<meta name=\"keywords\" content=\"\" />\n");
      out.write("<meta name=\"description\" content=\"\" />\n");
      out.write("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n");
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
      out.write("                    function clicked(par){\n");
      out.write("                        if(xmlHttp.readyState ==4 ||xmlHttp.readyState==0){\n");
      out.write("                           xmlHttp.open(\"GET\",\"fecha.jsp?diaev=\"+par.title+\"&month=");
      out.print(currMonth);
      out.write("&year=");
      out.print(currYear);
      out.write("\",true);\n");
      out.write("                           xmlHttp.onreadystatechange = ActualizarInsertar;\n");
      out.write("                          //alert(par.title);\n");
      out.write("                          xmlHttp.send(null);\n");
      out.write("                        }\n");
      out.write("                     }\n");
      out.write("\n");
      out.write("\n");
      out.write("                    function ActualizarInsertar(){\n");
      out.write("                        if(xmlHttp.readyState==4){\n");
      out.write("                           if(xmlHttp.status ==200){\n");
      out.write("                             Response = xmlHttp.responseText;\n");
      out.write("                              //alert(Response);\n");
      out.write("                                 document.getElementById(\"insertar\").innerHTML=Response;\n");
      out.write("                            }\n");
      out.write("                         }\n");
      out.write("                    }\n");
      out.write("                    function click(par){\n");
      out.write("                        if(xmlHttp.readyState ==4 ||xmlHttp.readyState==0){\n");
      out.write("                            xmlHttp.open(\"GET\",\"campos.jsp?event=\"+par.title,true);\n");
      out.write("                           xmlHttp.onreadystatechange = ActualizarCampos;\n");
      out.write("                          //alert(par.title);\n");
      out.write("                          xmlHttp.send(null);\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                     }\n");
      out.write("\n");
      out.write("                     function ActualizarCampos(){\n");
      out.write("                         if(xmlHttp.readyState==4){\n");
      out.write("                           if(xmlHttp.status ==200){\n");
      out.write("                              Response = xmlHttp.responseText;\n");
      out.write("                              //alert(Response);\n");
      out.write("                                 document.getElementById(\"campos\").innerHTML=Response;\n");
      out.write("                            }\n");
      out.write("                         }\n");
      out.write("                     }\n");
      out.write("                     function clickm(par){\n");
      out.write("                        if(xmlHttp.readyState ==4 ||xmlHttp.readyState==0){\n");
      out.write("                            xmlHttp.open(\"GET\",\"mostrar.jsp?event=\"+par.title,true);\n");
      out.write("                           xmlHttp.onreadystatechange = MostrarCampos;\n");
      out.write("                          //alert(par.title);\n");
      out.write("                          xmlHttp.send(null);\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                     }\n");
      out.write("\n");
      out.write("                     function MostrarCampos(){\n");
      out.write("                         if(xmlHttp.readyState==4){\n");
      out.write("                           if(xmlHttp.status ==200){\n");
      out.write("                              Response = xmlHttp.responseText;\n");
      out.write("                              //alert(Response);\n");
      out.write("                                 document.getElementById(\"campos\").innerHTML=Response;\n");
      out.write("                            }\n");
      out.write("                         }\n");
      out.write("                     }\n");
      out.write("                     function clickeli(par){\n");
      out.write("                        //alert(par.title);\n");
      out.write("                        if(xmlHttp.readyState ==4 ||xmlHttp.readyState==0){\n");
      out.write("                            xmlHttp.open(\"GET\",\"eliminar.jsp?event=\"+par.title,true);\n");
      out.write("                           xmlHttp.onreadystatechange = Eliminar;\n");
      out.write("                          //alert(par.title);\n");
      out.write("                          xmlHttp.send(null);\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                     }\n");
      out.write("\n");
      out.write("                     function Eliminar(){\n");
      out.write("                         //alert(\"eliminar\");\n");
      out.write("                         if(xmlHttp.readyState==4){\n");
      out.write("                           if(xmlHttp.status ==200){\n");
      out.write("                              Response = xmlHttp.responseText;\n");
      out.write("                              //alert(Response);\n");
      out.write("                                 document.getElementById(\"campos\").innerHTML=Response;\n");
      out.write("                            }\n");
      out.write("                         }\n");
      out.write("                     }\n");
      out.write("                     function clickmod(par){\n");
      out.write("                        //alert(par.title);\n");
      out.write("                        if(xmlHttp.readyState ==4 ||xmlHttp.readyState==0){\n");
      out.write("                            xmlHttp.open(\"GET\",\"modificar.jsp?event=\"+par.title,true);\n");
      out.write("                           xmlHttp.onreadystatechange = Modificar;\n");
      out.write("                          //alert(par.title);\n");
      out.write("                          xmlHttp.send(null);\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                     }\n");
      out.write("\n");
      out.write("                     function Modificar(){\n");
      out.write("                         //alert(\"eliminar\");\n");
      out.write("                         if(xmlHttp.readyState==4){\n");
      out.write("                           if(xmlHttp.status ==200){\n");
      out.write("                              Response = xmlHttp.responseText;\n");
      out.write("                              //alert(Response);\n");
      out.write("                                 document.getElementById(\"campos\").innerHTML=Response;\n");
      out.write("                            }\n");
      out.write("                         }\n");
      out.write("                     }\n");
      out.write("                     function clickact(par){\n");
      out.write("                       //alert(document.getElementById(\"s\").value);\n");
      out.write("                        if(xmlHttp.readyState ==4 ||xmlHttp.readyState==0){\n");
      out.write("                            xmlHttp.open(\"GET\",\"buscar.jsp?event=\"+document.getElementById(\"s\").value,true);\n");
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
      out.write("                                 document.getElementById(\"insertar\").innerHTML=Response;\n");
      out.write("                            }\n");
      out.write("                         }\n");
      out.write("                     }\n");
      out.write("                </script>\n");
session.setAttribute("usuario", request.getParameter("us"));
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write(" <div id=\"banner\"><center><img src=\"images/logo2.png\" /></div>\n");
      out.write("\n");
      out.write("<div id=\"menu\">\n");
      out.write("\t<ul>\n");
      out.write("\t\t<li class=\"first\"><a href=\"home.jsp?us=");
out.print(session.getAttribute("usuario"));
      out.write("\" accesskey=\"1\" title=\"\">Home</a></li>\n");
      out.write("\t\t<li><a href=\"index.jsp\" accesskey=\"2\" title=\"\">Logout</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\t<div id=\"search\">\n");
      out.write("\n");
      out.write("\t\t\t<fieldset>\n");
      out.write("                            <input id=\"s\"   type=\"text\" name=\"s\" />\n");
      out.write("\t\t\t<input id=\"x\" type=\"image\" onclick=\"clickact(this)\" name=\"imageField\" src=\"images/img10.jpg\" />\n");
      out.write("\t\t\t</fieldset>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("<hr />\n");
      out.write("\n");
      out.write("<!-- start page -->\n");
      out.write("<div id=\"page\">\n");
      out.write("\t<!-- start content -->\n");
      out.write("\t<div id=\"content\">\n");
      out.write("\t\t<div class=\"post\">\n");
      out.write("                    <h2 class=\"title\"><a>Bienvenid@  ");


                                  out.println(session.getAttribute("usuario"));
      out.write(" ......</a></h2>\n");
      out.write("\t\t\t<div class=\"entry\">\n");
      out.write("\t\t\t\t<h3>A su mini agenda personal...</h3>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"post\">\n");
      out.write("\t\t\t<div class=\"entry\">\n");
      out.write("                             <form action=\"ingreso.jsp\">\n");
      out.write("                        <div id=\"insertar\"></div>\n");
      out.write("                </form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- end content -->\n");
      out.write("\t<!-- start sidebar -->\n");
      out.write("\t<div id=\"sidebar\">\n");
      out.write("\t\t<ul>\n");
      out.write("\t\t\t<li id=\"calendar\">\n");
      out.write("\t\t\t\t<table summary=\"Calendar\">\n");
      out.write("\t\t\t\t\t<caption>\n");
      out.write("\t\t\t\t\t<center><b>");
      out.print(getDateName(cal.get(cal.MONTH)) + " " + cal.get(cal.YEAR));
      out.write("</b></center>\n");
      out.write("\t\t\t\t\t</caption>\n");
      out.write("\t\t\t\t\t<thead>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<th abbr=\"Monday\" scope=\"col\" title=\"Monday\">D</th>\n");
      out.write("\t\t\t\t\t\t\t<th abbr=\"Tuesday\" scope=\"col\" title=\"Tuesday\">L</th>\n");
      out.write("\t\t\t\t\t\t\t<th abbr=\"Wednesday\" scope=\"col\" title=\"Wednesday\">M</th>\n");
      out.write("\t\t\t\t\t\t\t<th abbr=\"Thursday\" scope=\"col\" title=\"Thursday\">M</th>\n");
      out.write("\t\t\t\t\t\t\t<th abbr=\"Friday\" scope=\"col\" title=\"Friday\">J</th>\n");
      out.write("\t\t\t\t\t\t\t<th abbr=\"Saturday\" scope=\"col\" title=\"Saturday\">V</th>\n");
      out.write("\t\t\t\t\t\t\t<th abbr=\"Sunday\" scope=\"col\" title=\"Sunday\">S</th>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</thead>\n");
      out.write("\t\t\t\t\t<tfoot>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("                                                    <td abbr=\"October\" colspan=\"3\" id=\"prev\"><a href=\"home.jsp?month=");
      out.print(currMonth);
      out.write("&year=");
      out.print(currYear);
      out.write("&action=0&us=");
out.print(session.getAttribute("usuario"));
      out.write("\"><font size=\"1\">Previous</font></a></td>\n");
      out.write("\t\t\t\t\t\t\t<td class=\"pad\">&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t\t<td abbr=\"December\" colspan=\"3\" id=\"next\"><a href=\"home.jsp?month=");
      out.print(currMonth);
      out.write("&year=");
      out.print(currYear);
      out.write("&action=1&us=");
out.print(session.getAttribute("usuario"));
      out.write("\"><font size=\"1\">Next</font></a></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</tfoot>\n");
      out.write("\t\t\t\t\t<tbody>\n");
      out.write("\n");
      out.write("                    ");

                        //'Calendar loop
                        int currDay;
                        String todayColor;
                        int count = 1;
                        int dispDay = 1;

                        for (int w = 1; w < 7; w++) {
                    
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                    ");

                                for (int d = 1; d < 8; d++) {
                                    if (!(count >= cal.get(c.DAY_OF_WEEK))) {

                    
      out.write("\n");
      out.write("                                        <td width=\"");
      out.print(boxSize);
      out.write("\" height=\"");
      out.print(boxSize);
      out.write("\" valign=\"top\" align=\"left\">&nbsp;</td>\n");
      out.write("                    ");

                                                    count += 1;
                                    } else {
                                        if (isDate(currMonth + 1, dispDay, currYear)) // use the isDate method
                                        {
                                            if (dispDay == c.get(c.DAY_OF_MONTH) && c.get(c.MONTH) == cal.get(cal.MONTH) && c.get(c.YEAR) == cal.get(cal.YEAR)) // Here we check to see if the current day is today
                                            {
                                                todayColor = "#6C7EAA";
                                            } else {
                                                todayColor = "#ffffff";
                                            }
                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            <td bgcolor =\"");
      out.print(todayColor);
      out.write("\" width=\"");
      out.print(boxSize);
      out.write("\" align=\"left\" height=\"");
      out.print(boxSize);
      out.write("\" valign=\"top\" name=\"botdia\" title=\"");
      out.print(dispDay);
      out.write("\"  ondblclick=\"clicked(this)\">");
      out.print(dispDay);
      out.write("</a><br>\n");
      out.write("                                            </td>\n");
      out.write("\n");
      out.write("                    ");

                                           count += 1;
                                           dispDay += 1;
                                       } else {
                    
      out.write("\n");
      out.write("                                            <td width=\"");
      out.print(boxSize);
      out.write("\" align=\"left\" height=\"");
      out.print(boxSize);
      out.write("\" valign=\"top\">&nbsp;</td>\n");
      out.write("                    ");

                                         }
                                       }
                                    }
                    
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                                }
                    
      out.write("\n");
      out.write("                </table> </li>\n");
      out.write("                <li> </li>\n");
      out.write("\t\t<li> </li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- end sidebar -->\n");
      out.write("</div>\n");
      out.write("<!-- end page -->\n");
      out.write("<div id=\"footer\">\n");
      out.write("\t<p class=\"legal\">Copyright (c) 2007 Website Name. All rights reserved.</p>\n");
      out.write("\t<p class=\"credit\">Designed by <a href=\"http://www.nodethirtythree.com/\">NodeThirtyThree</a> + <a href=\"http://www.freecsstemplates.org/\">Free CSS Templates</a></p>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
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
