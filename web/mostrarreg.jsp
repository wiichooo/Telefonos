<%-- 
    Document   : mostrarreg
    Created on : Oct 17, 2009, 9:54:31 PM
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
           out.print("<tr>");
           out.print("<td width=\"250\" >");out.print("<BR>Nombre del Contacto");out.print("</td>");
           out.print("<td>");out.print("<BR>"+"  "+rs.getString("Nombre"));out.print("</td>");
           out.print("</tr>");

           out.print("<tr>");
           out.print("<td>");out.print("<BR>Telefono");out.print("</td>");
           out.print("<td>");out.print("<BR>"+"  "+rs.getString("Telefono"));out.print("</td>");
           out.print("</tr>");

           out.print("<tr>");
           out.print("<td>");out.print("<BR>Celular");out.print("</td>");
           out.print("<td>");out.print("<BR>"+"  "+rs.getString("Celular"));out.print("</td>");
           out.print("</tr>");

           out.print("<tr>"); out.print("<td>"); out.print("<BR>Email" ); out.print("</td>");
           out.print("<td>"); out.print("<BR>"+"  "+rs.getString("Email")); out.print("</td>");
           out.print("</tr>");

           out.print("<tr>");

           out.print("<td> <center>");
           out.println("<BR><BR><h3 title=\"" +rs.getString("Nombre")+"\" onclick=\"clickmod(this)\"> Modificar </h3>"+"<br>");
           out.print("</td>");
           out.print("<td> <center>");
           out.println("<BR><BR><h3 title=\"" +rs.getString("Nombre")+"\" onclick=\"clickeli(this)\"> Eliminar </h3>"+"<br>");
           out.print("</td>");

           out.print("</tr>"); out.print("</table>");

            statement.close();
           // rs.close();
            conn.close();

            //out.print("<div id=\"salida\"></div>");
        %>

