package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class telefonos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script>\n");
      out.write("//Script original de KarlanKas para Forosdelweb.com\n");
      out.write("\n");
      out.write("\n");
      out.write("var codigo=\"\";\n");
      out.write("var incremento=-1\n");
      out.write("var radio=110\n");
      out.write("var radio2=100\n");
      out.write("radianes=(2*3.141592/360)\n");
      out.write("\n");
      out.write("function crear(nombr,radi,hor,destin){\n");
      out.write("this.nombre=nombr;\n");
      out.write("this.radio=radi;\n");
      out.write("this.hora=hor;\n");
      out.write("this.destino=destin;\n");
      out.write("}\n");
      out.write("\n");
      out.write("manecillas=new Array();\n");
      out.write("manecillas[0]=new crear(\"segundero\",1,\"segundo\",\"http://www.forosdelweb.com/images/smilies/dedosabajo.gif\");\n");
      out.write("manecillas[1]=new crear(\"minutero\",0.8,\"minuto\",\"http://www.forosdelweb.com/images/smilies/dedosarriba.gif\");\n");
      out.write("manecillas[2]=new crear(\"horero\",0.5,\"hora\",\"http://www.forosdelweb.com/images/smilies/wink.gif\");\n");
      out.write("\n");
      out.write("// -------------- DIBUJAR MANECILLAS ---------------------------\n");
      out.write("for(numeroIconos=0;numeroIconos<5;numeroIconos++){\n");
      out.write("for(cadaManecilla=0;cadaManecilla<3;cadaManecilla++){\n");
      out.write("codigo+='<img id=\"'+manecillas[cadaManecilla].nombre+numeroIconos+'\" style=\"z-index:2;position:absolute;top:-300px;\" src=\"'+manecillas[cadaManecilla].destino+'\">\\n'}\n");
      out.write("}\n");
      out.write("//----------- PONER EL CENTRO DE LA ESFERA---------------------------------\n");
      out.write("\n");
      out.write("codigo+='<img style=\"z-index:4;position:absolute;top:110px;left:110px;\" src=\"http://www.forosdelweb.com/images/smilies/smile.gif\">'\n");
      out.write("\n");
      out.write("//------------- DIBUJAR ESFERA --------------------------\n");
      out.write("for(numero=0;numero<=359;numero+=30){\n");
      out.write("x=Math.floor((radio2)*Math.cos(radianes*numero));\n");
      out.write("y=Math.floor((radio2)*Math.sin(radianes*numero));\n");
      out.write("document.write('<img src=\"http://www.forosdelweb.com/images/smilies/risa.gif\" style=\"position:absolute;left:'+(radio+x)+'px;top:'+(radio+y)\n");
      out.write("+'px\">');\n");
      out.write("}\n");
      out.write("\n");
      out.write("//------------------ MAQUINARIA DEL RELOJ --------------\n");
      out.write("\n");
      out.write("function reloj(){\n");
      out.write("\n");
      out.write("//-------------SABER LA HORA----------------\n");
      out.write("ahora=new Date();\n");
      out.write("\n");
      out.write("document.title=ahora.toLocaleString()\n");
      out.write("\n");
      out.write("segundo=ahora.getSeconds()*6\n");
      out.write("minuto=ahora.getMinutes()*6\n");
      out.write("hora=(ahora.getHours()*30)\n");
      out.write("\n");
      out.write("hora+=(minuto/12)\n");
      out.write("\n");
      out.write("//---------PONER 0 GRAD0S EN 90 GRADOS---------------\n");
      out.write("hora-=90;\n");
      out.write("minuto-=90;\n");
      out.write("segundo-=90\n");
      out.write("\n");
      out.write("//-------MOVER LAS MANECILLAS---------------\n");
      out.write("\n");
      out.write("for (a=0;a<99;a=a+20){\n");
      out.write("incremento++\n");
      out.write("for (m=0;m<3;m++){\n");
      out.write("manecilla=document.getElementById(manecillas[m].nombre+incremento);\n");
      out.write("eval(\"cosa=\"+manecillas[m].hora);\n");
      out.write("x=a*manecillas[m].radio*Math.cos(radianes*cosa);\n");
      out.write("y=a*manecillas[m].radio*Math.sin(radianes*cosa);\n");
      out.write("manecilla.style.left=x+radio+'px';\n");
      out.write("manecilla.style.top=y+radio+'px';\n");
      out.write("\n");
      out.write("}\n");
      out.write("}\n");
      out.write("incremento=-1;\n");
      out.write("}\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("<body onload='reloj();window.setInterval(\"reloj()\",50)'>\n");
      out.write("\n");
      out.write("<script>document.write(codigo)</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("    </body>\n");
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
