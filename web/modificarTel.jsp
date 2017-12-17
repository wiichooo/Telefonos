<%-- 
    Document   : modificarTel
    Created on : Oct 18, 2009, 12:00:57 PM
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

           rs = statement.executeQuery("select Nombre,Telefono,Celular,Email from Contacto where Nombre ='"+ev+"' And Usuario='"+session.getAttribute("usuario")+"';");

           rs.next();
           out.print("<center><table align=\"center\" >");
           out.print("<tr>"); out.print("<td>");
           out.print("<BR>Ingrese el Nombre ");
           out.print("</td>"); out.print("<td>");
           out.print("<BR><input align=\"left\" type=\"text\" name=\"TELn\" id=\"TELn\" value =\""+rs.getString("Nombre")+"\" />");
           out.print("</td>");  out.print("</tr>");

           out.print("<tr>"); out.print("<td>");
           out.print("<BR>Ingrese Telefono ");
           out.print("</td>"); out.print("<td>");
           out.print("<BR><input type=\"text\" name=\"TELt\" id=\"TELt\" value =\""+rs.getString("Telefono")+"\" />");
           out.print("</td>");  out.print("</tr>");

           out.print("<tr>"); out.print("<td>");
           out.print("<BR>Ingrese Celular");
           out.print("</td>"); out.print("<td>");
           out.print("<BR><input type=\"text\" name=\"TELc\" id=\"TELc\" value =\""+rs.getString("Celular")+"\" />");
           out.print("</td>");  out.print("</tr>");

           out.print("<tr>"); out.print("<td>");
           out.print("<BR>Email " );
           out.print("</td>"); out.print("<td>");
           out.print("<BR><input type=\"text\" name=\"TELe\" id=\"TELe\" value =\""+rs.getString("Email")+"\" />");
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
