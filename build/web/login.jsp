<%-- 
    Document   : login
    Created on : Oct 14, 2009, 9:11:53 PM
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
        String us = request.getParameter("u");
        String pas = request.getParameter("p");

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, login, password);
            statement = conn.createStatement();

if(!us.contains("'") && !pas.contains("'") && !us.contains("=") && !pas.contains("=") && !us.contains("-") && !pas.contains("-") && !us.contains("+") && !pas.contains("+")){
            rs = statement.executeQuery("select Nombre from Usuario where Nombre ='"+us+"' And Password='"+pas+"';");
            //out.println("select Nombre from Usuario where Nombre ='"+us+"' And Password='"+pas+"';");
            try{

            rs.next();
            if(rs.getString("Nombre").toString().equals("")){
            out.println("Usuario o Password Incorrecto...........");
            response.sendRedirect("index.jsp?err=Usuario o Password Incorrecto");
            }else{
            out.println("Usuario y Password Correcto...........");
            response.sendRedirect("home.jsp?us="+rs.getString("Nombre").toString());
            }
            }catch(Exception e){
            out.println("Usuario o Password Incorrecto...........");
            response.sendRedirect("index.jsp?err=Usuario o Password Incorrecto");
            }
 }else{
 response.sendRedirect("index.jsp?err=Caracter Invalido!!");
 }
            statement.close();
            //rs.close();
            conn.close();
            //out.print("</form>");

        %>