<%-- 
    Document   : modificar
    Created on : Oct 13, 2009, 6:39:49 PM
    Author     : wiichooo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.sql.*" %>
<%
String login = "root";
String password = "fernando";
String url = "jdbc:mysql://localhost:3306/Practica3";
Connection conn = null;
Statement statement = null;
ResultSet rs = null;
%>
<%
        String ev = request.getParameter("event");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, login, password);
            statement = conn.createStatement();

           rs = statement.executeQuery("select Nombre,Hora,Descripcion,Prioridad from Evento where Nombre ='"+ev+"' And Usuario='"+session.getAttribute("usuario")+"';");

           rs.next();
           out.print("<table align=\"center\" >");
           out.print("<tr>"); out.print("<td>");
           out.print("<BR>Ingrese el Nombre del Evento");
           out.print("</td>"); out.print("<td>");
           out.print("<BR><input align=\"left\" type=\"text\" name=\"nombre\" id=\"nombre\" value =\""+rs.getString("Nombre")+"\" />");
           out.print("</td>");  out.print("</tr>");

           out.print("<tr>"); out.print("<td>");
           out.print("<BR>Ingrese la Hora del Evento");
           out.print("</td>"); out.print("<td>");
           out.print("<BR><input type=\"text\" name=\"hora\" id=\"hora\" value =\""+rs.getString("Hora")+"\" />");
           out.print("</td>");  out.print("</tr>");

           out.print("<tr>"); out.print("<td>");
           out.print("<BR>Ingrese una Breve Descripcion");
           out.print("</td>"); out.print("<td>");
           out.print("<BR><textarea name=\"desc\" id=\"desc\"rows=\"3\">"+rs.getString("Descripcion")+"</textarea>");
           out.print("</td>");  out.print("</tr>");

           out.print("<tr>"); out.print("<td>");
           out.print("<BR>Ingrese la Prioridad" );
           out.print("</td>"); out.print("<td>");
           out.print("<BR><input type=\"text\" name=\"prio\" id=\"prio\" value =\""+rs.getString("Prioridad")+"\" />");
           out.print("</td>");  out.print("</tr>");

           out.print("<tr>"); out.print("<td>");
           //out.println("<BR><BR><h3 title=\"" +rs.getString("Nombre")+"\" onclick=\"clickmod(this)\"> Modificar </h3>"+"<br>");
           out.print("</td>"); out.print("<td>");
           //out.println("<BR><BR><h3 title=\"" +rs.getString("Nombre")+"\" onclick=\"clickeli(this)\"> Aceptar </h3>"+"<br>");
           out.print("<BR><BR><input type=\"submit\" name=\"Aceptar\" value=\"Aceptar\" />"+"<BR><BR>");
           out.print("</td>");  out.print("</tr>");
           out.print("</table>");

            statement.close();
           // rs.close();
            conn.close();
           
            %>
