<%-- 
    Document   : fecha
    Created on : Oct 12, 2009, 11:47:08 AM
--%>
 
 <%@page import="java.util.List"%>
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
        String ev = request.getParameter("diaev");
        String mes = request.getParameter("month");
        String year = request.getParameter("year"); 

        out.print("<table width=400>");

        out.print("<tr>"); out.print("<td>");
           out.print("<BR><center>"+"Dia: "+"<label id=\"dialabel\" name=\"ldia\" >"+ev+"</label>");
           out.print("</td>"); out.print("<td>");
           out.print("<BR><center>"+"MES: "+"<label id=\"meslabel\" name=\"lmex\" >"+(Integer.parseInt(mes)+1)+"</label>");
           out.print("</td>");out.print("<td>");
           out.print("<BR><center>"+"Año: "+"<label id=\"yearlabel\" name=\"lyear\" >"+year+"</label>");
           out.print("</td>");  out.print("</tr>");
           session.setAttribute("dia", ev);
           session.setAttribute("mes", Integer.parseInt(mes)+1);
           session.setAttribute("anio", year);

           out.print("<tr>"); out.print("<td>");
           out.print("</td>"); out.print("<td>");
           out.print("<center><h3 title=\"title\" onclick=\"click(this)\">Nuevo Evento</h3>");
           out.print("</td>");out.print("<td>");
           out.print("</td>");  out.print("</tr>");
           out.print("<table>");

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, login, password);
            statement = conn.createStatement();

            rs = statement.executeQuery("select Nombre from Evento where Dia="+ev+" And Mes="+(Integer.parseInt(mes)+1)+" And Anio="+year+" And Usuario='"+session.getAttribute("usuario")+"';");
            //insert into Evento values ('Primero','09:00','rrrrrrr','wwww',13,10,2009);
            try{
            out.println("Eventos Programados Para Esta Fecha...........<br>");
            while (rs.next()) {
            out.println("<h4 title=\"" +rs.getString("Nombre")+"\" onclick=\"clickm(this)\">" +rs.getString("Nombre")+"</h4>"+"<br>");
            }
            }catch(Exception e){
            out.println("No Tiene Eventos Programados Para Esta Fecha...........<br>");
            }
            statement.close();
            //rs.close();
            conn.close();


            out.print("<div id=\"campos\"></div>");
            //out.print("</form>");

        %>