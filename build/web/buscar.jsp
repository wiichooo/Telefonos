<%-- 
    Document   : buscar
    Created on : Oct 13, 2009, 9:26:37 PM
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

            if(ev.equalsIgnoreCase("todos")){
            out.println("Todos los Eventos Programados.........<br>");
            rs = statement.executeQuery("select Nombre from Evento Where Usuario='"+session.getAttribute("usuario")+"';");
                }else{
            out.println("Eventos Programados Con Ese Nombre..........<br>");
            rs = statement.executeQuery("select Nombre from Evento where Nombre like '%"+ev+"%' And Usuario='"+session.getAttribute("usuario")+"';");
            //insert into Evento values ('Primero','09:00','rrrrrrr','wwww',13,10,2009);
            }
            try{
            
            while (rs.next()) {
            out.println("<h4 title=\"" +rs.getString("Nombre")+"\" onclick=\"clickm(this)\">" +rs.getString("Nombre")+"</h4>"+"<br>");
            }
            }catch(Exception e){
            out.println("No Tiene Eventos Programados Con Ese Nombre...........<br>");
            }
            statement.close();
            //rs.close();
            conn.close();


            out.print("<div id=\"campos\"></div>");
            //out.print("</form>");

        %>
