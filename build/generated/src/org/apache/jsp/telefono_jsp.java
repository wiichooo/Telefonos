package org.apache.jsp;

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
      out.write("\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\">\n");
      out.write("//RELOJ ANALOGICO\n");
      out.write("//\tBasado en un script original de Brian Gosselin\n");
      out.write("//\thttp://scriptasylum.com/index.html\n");
      out.write("//\tTraducido, comentado y adaptado por Iván Nieto\n");
      out.write("//\n");
      out.write("//Este script y otros muchos pueden\n");
      out.write("//descarse on-line de forma gratuita\n");
      out.write("//en El Código: www.elcodigo.com\n");
      out.write("\n");
      out.write("//deteccion de capacidades del navegador\n");
      out.write("var navok\n");
      out.write("if ( document.getElementById || document.all )\n");
      out.write("\tnavok = true\n");
      out.write("else\n");
      out.write("\tnavok = false\n");
      out.write("\n");
      out.write("//fecha y hora actuales\n");
      out.write("var ahora = new Date()\n");
      out.write("\n");
      out.write("//coordenadas posicion numeros en la circulo del Inicializa\n");
      out.write("var circulo_x = new Array()\n");
      out.write("var circulo_y = new Array()\n");
      out.write("circulo_x[7] = [80, 94, 100, 94, 77, 53, 28, 11,  5, 11, 28, 53]\n");
      out.write("circulo_y[7] = [ 8, 26,  50, 74, 91, 97, 91, 74, 50, 26,  8,  2]\n");
      out.write("\n");
      out.write("//elementos graficos del Inicializa\n");
      out.write("var horas = new Array()\n");
      out.write("var minutos = new Array()\n");
      out.write("var segundos = new Array()\n");
      out.write("var numeros = new Array()\n");
      out.write("\n");
      out.write("\n");
      out.write("function pinta_reloj() {\n");
      out.write("\n");
      out.write("\t//dibuja circulo del Inicializa\n");
      out.write("\tvar txt\n");
      out.write("        txt = '<div id=\"exterior\" style=\"position:relative; width:117px; height:117px; visibility:visible\">'\n");
      out.write("\n");
      out.write("\tfor(i=1;i<=7;i++)\t//minutero\n");
      out.write("\t\ttxt += '<div id=\"min'+i+'\" style=\"position:absolute; top:-100px; left:-100px; width:6px; height:6px; background-color:black; font-size:6px;\"></div>'\n");
      out.write("\n");
      out.write("\tfor(i=1;i<=5;i++)\t//horas\n");
      out.write("\t\ttxt += '<div id=\"hrs'+i+'\" style=\"position:absolute; top:-100px; left:-100px; width:6px; height:6px; background-color:black; font-size:6px;\"></div>'\n");
      out.write("\n");
      out.write("\tfor(i=1;i<=7;i++)\t//segundero\n");
      out.write("\t\ttxt += '<div id=\"sec'+i+'\" style=\"position:absolute; top:-100px; left:-100px; width:4px; height:4px; background-color:white; font-size:6px;\"></div>'\n");
      out.write("\n");
      out.write("\tfor(i=1;i<=12;i++)\t//digitos\n");
      out.write("\t\ttxt += '<div id=\"h'+i+'\" style=\"position:absolute; top:-100px; left:0px; width:10px; height:10px; font-size:10pt; font-family: Arial;\">'+i+'</div>'\n");
      out.write("\n");
      out.write("\ttxt += '</div>'\n");
      out.write("\n");
      out.write("\tdocument.write(txt)\n");
      out.write("//\tmueve_capa( exterior, 100, 200);\n");
      out.write("}\n");
      out.write("\n");
      out.write("//movimiento agujas\n");
      out.write("function avanza_reloj() {\n");
      out.write("\tahora = new Date()\n");
      out.write("\tahora.hrs = ahora.getHours()\n");
      out.write("\tahora.min = ahora.getMinutes()\n");
      out.write("\tahora.sec = ahora.getSeconds()\n");
      out.write("\n");
      out.write("\tahora.hrs = ( ahora.hrs >= 12 ) ? ahora.hrs - 12 : ahora.hrs\n");
      out.write("\n");
      out.write("\tahora.hrs = Math.floor( ( ahora.hrs * 5 ) + ( ahora.min/12 ) )\n");
      out.write("\n");
      out.write("\tfor(n=0;n<horas.length;n++)\n");
      out.write("\t\tmueve_capa(horas[n], circulo_x[n][ahora.hrs], circulo_y[n][ahora.hrs])\n");
      out.write("\tfor(n=0;n<minutos.length;n++)\n");
      out.write("\t\tmueve_capa(minutos[n], circulo_x[n][ahora.min], circulo_y[n][ahora.min])\n");
      out.write("\tfor(n=0;n<segundos.length;n++)\n");
      out.write("\t\tmueve_capa(segundos[n], circulo_x[n][ahora.sec], circulo_y[n][ahora.sec])\n");
      out.write("}\n");
      out.write("\n");
      out.write("function mueve_capa(id,x,y){\n");
      out.write("\tid.style.left = x + 'px'\n");
      out.write("\tid.style.top = y + 'px'\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("function obtiene_capa(idstr) {\n");
      out.write("\tif (document.getElementById)\n");
      out.write("\t\treturn document.getElementById(idstr)\n");
      out.write("\telse if (document.all)\n");
      out.write("\t\treturn document.all[idstr]\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("function Inicializa() {\n");
      out.write("\n");
      out.write("\tif ( !navok )\n");
      out.write("\t\treturn\n");
      out.write("\n");
      out.write("\t//array de objetos aguja horas\n");
      out.write("\tfor( i=1; i<=5; i++)\n");
      out.write("\t\thoras[i-1] = obtiene_capa('hrs'+i)\n");
      out.write("  \t//array objetos minutero\n");
      out.write("  \tfor( i=1; i<=7; i++)\n");
      out.write("  \t\tminutos[i-1] = obtiene_capa('min'+i)\n");
      out.write("\t//array objetos segundero\n");
      out.write("\tfor( i=1; i<=7; i++)\n");
      out.write("\t\tsegundos[i-1] = obtiene_capa('sec'+i)\n");
      out.write("\t//array objetos numeros circulo\n");
      out.write("\tfor( i=1; i<=12; i++)\n");
      out.write("\t\tnumeros[i] = obtiene_capa('h'+i)\n");
      out.write("\n");
      out.write("\t//inicializa posicion numeros circulo\n");
      out.write("\tfor( n=1; n<=12; n++)\n");
      out.write("  \t\tmueve_capa(numeros[n], circulo_x[7][n-1], circulo_y[7][n-1])\n");
      out.write("\n");
      out.write("\tvar centro = [0]\n");
      out.write("  \tvar radio = 6\n");
      out.write("  \tvar resultado = new Array()\n");
      out.write("  \tfor( i=1; i<=60; i++) {\n");
      out.write("  \t\tcentro[i] = centro[i-1] + ((Math.PI*2)/60)\n");
      out.write("  \t\tcentro[i-1] += Math.PI/180\n");
      out.write("  \t}\n");
      out.write("\n");
      out.write("\tfor( num=0; num<=6; num++) {\n");
      out.write("\t\tcirculo_x[num] = new Array()\n");
      out.write("\t\tcirculo_y[num] = new Array()\n");
      out.write("  \t\tfor( i=1; i<=60; i++) {\n");
      out.write("  \t\t\tresultado = ((i-15)<0)? 60 + i - 15 : i - 15\n");
      out.write("  \t\t\tcirculo_x[num][i] = Math.floor((num*radio*Math.cos(centro[resultado]))+56)\n");
      out.write("  \t\t\tcirculo_y[num][i] = Math.floor((num*radio*Math.sin(centro[resultado]))+55)\n");
      out.write("  \t\t}\n");
      out.write("\t\tcirculo_x[num][0]=circulo_x[num][60]\n");
      out.write("\t\tcirculo_y[num][0]=circulo_y[num][60]\n");
      out.write("  \t}\n");
      out.write("\n");
      out.write("\tvar IdIntervalo = setInterval(\"avanza_reloj()\", 100)\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("window.onload = Inicializa\n");
      out.write("\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
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
      out.write("                <li>\n");
      out.write("                        <center><TABLE  BACKGROUND=\"images/reloj.png \"  width=\\\"215\\\" height=\\\"231\\\" >\n");
      out.write("\t\t\t <TR>\n");
      out.write("\t\t\t <TD><center><script type=\"text/javascript\"> pinta_reloj() </script> </TD>\n");
      out.write("\t\t\t </TR>\n");
      out.write("\t\t\t </TABLE>\n");
      out.write("                </li>\n");
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
