<%-- 
    Document   : campos
    Created on : Oct 12, 2009, 11:47:08 AM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
        String ev = request.getParameter("event");

           // out.print("<BR>DIA: "+"<input align=\"left\" type=\"text\" name=\"ldia\" id=\"tdia\" />"+"<BR>");
           // out.print("<BR>MES"+"<input align=\"left\" type=\"text\" name=\"lmes\" id=\"tmex\" />"+"<BR>");
           // out.print("<BR>Año"+"<input align=\"left\" type=\"text\" name=\"lyear\" id=\"tyear\" />"+"<BR>");

           out.print("<table>");
           out.print("<tr>"); out.print("<td>");
           out.print("<BR>Ingrese el Nombre del Evento");
           out.print("</td>"); out.print("<td>");
           out.print("<BR><input align=\"left\" type=\"text\" name=\"nombre\" id=\"nombre\" />");
           out.print("</td>");  out.print("</tr>");

           out.print("<tr>"); out.print("<td>");
           out.print("<BR>Ingrese la Hora del Evento");
           out.print("</td>"); out.print("<td>");
           out.print("<BR><input type=\"text\" name=\"hora\" id=\"hora\" />");
           out.print("</td>");  out.print("</tr>");
           
           out.print("<tr>"); out.print("<td>");
           out.print("<BR>Ingrese una Breve Descripcion");
           out.print("</td>"); out.print("<td>");
           out.print("<BR><textarea name=\"desc\" id=\"desc\"rows=\"3\"></textarea>");
           out.print("</td>");  out.print("</tr>");

           out.print("<tr>"); out.print("<td>");
           out.print("<BR>Ingrese la Prioridad" );
           out.print("</td>"); out.print("<td>");
           out.print("<BR><input type=\"text\" name=\"prio\" id=\"prio\" />");
           out.print("</td>");  out.print("</tr>");

           out.print("<tr>"); out.print("<td>"); 
           out.print("</td>"); out.print("<td>");
           out.print("<BR><BR><input type=\"submit\" name=\"Ingresar\" value=\"Ingresar\" />"+"<BR><BR>");
           //out.println("<BR><BR><h4 \" onclick=\"clickact(this)\">Insertar</h4>"+"<BR><BR>");
           out.print("</td>");  out.print("</tr>");
           out.print("</table>");
        %>