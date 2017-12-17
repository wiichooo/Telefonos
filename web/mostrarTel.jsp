<%-- 
    Document   : mostrarTel
    Created on : Oct 16, 2009, 12:13:06 PM
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
ResultSet rs2 = null;
%>
        <%

           out.print("<center><table width=480 >");

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, login, password);
            statement = conn.createStatement();


            String parametro = request.getParameter("letras");
            //out.println(parametro);
            rs = statement.executeQuery("select Nombre from Contacto where Nombre Between '"+parametro.charAt(0) +"%' AND '"+parametro.charAt(2) +"%' And Usuario='"+session.getAttribute("usuario")+"';");

            try{
            out.println("Telefonos en seccion "+parametro+"...........<br>");
            while (rs.next()) {
            out.println("<h4 title=\"" +rs.getString("Nombre")+"\" onclick=\"clickm(this)\">" +rs.getString("Nombre")+"</h4>"+"<br>");
            }
            }catch(Exception e){
            out.println("No Tiene Ingresos con este parametro...........<br>");
            }
            rs2 = statement.executeQuery("select Nombre from Contacto where Nombre Like '"+parametro.charAt(2) +"%' And Usuario='"+session.getAttribute("usuario")+"';");

            try{
            //out.println("Telefonos en seccion "+parametro+"...........<br>");
            while (rs2.next()) {
            out.println("<h4 title=\"" +rs2.getString("Nombre")+"\" onclick=\"clickm(this)\">" +rs2.getString("Nombre")+"</h4>"+"<br>");
            }
            }catch(Exception e){
            //out.println("No Tiene Ingresos con este parametro...........<br>");
            }
            statement.close();
            //rs.close();o
            conn.close();
            //out.print("<div id=\"campos\"></div>");


            

            out.print("<TR>");
            out.print("<TD width=\"50\"> </TD>");
            out.print("<TD width=\"105\">Nombre:</TD>");
            out.print("<TD width=\"105\"><input align=\"left\" type=\"text\" name=\"TELn\" id=\"TELn\" /></TD>");
            out.print("</TR> ");
            out.print("<TR>");
            out.print("<TD width=\"50\"> </TD>");
            out.print("<TD width=\"105\">Telefono:</TD>");
            out.print("<TD width=\"105\"><input align=\"left\" type=\"text\" name=\"TELt\" id=\"TELt\" /></TD>");
            out.print("</TR> ");
            out.print("<TR>");
            out.print("<TD width=\"50\"> </TD>");
            out.print("<TD width=\"105\">Celular:</TD>");
            out.print("<TD width=\"105\"><input align=\"left\" type=\"text\" name=\"TELc\" id=\"TELc\" /></TD>");
            out.print("</TR> ");
            out.print("<TR>");
            out.print("<TD width=\"50\"> </TD>");
            out.print("<TD width=\"105\">Email:</TD>");
            out.print("<TD width=\"105\"><input align=\"left\" type=\"text\" name=\"TELe\" id=\"TELe\" /></TD>");
            out.print("</TR>");
            out.print("<br><TR>");
            out.print("<TD width=\"50\"> </TD>");
            out.print("<TD width=\"105\"></TD>");
            out.print("<BR><BR><input type=\"submit\" name=\"Aceptar\" value=\"Ingresar\" />"+"<BR><BR>");
            out.print("</TR>");
            out.print("</TABLE>");
        %>