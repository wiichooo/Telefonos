<%-- 
    Document   : eliminar
    Created on : Oct 13, 2009, 5:40:07 PM
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
%>
<%
        String ev = request.getParameter("event");
            
           try{
           
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, login, password);
            statement = conn.createStatement();

            statement.execute("delete from Evento where Nombre ='"+ev+"' And Usuario='"+session.getAttribute("usuario")+"';");
            
            out.println(" Se ha eliminado correctamente el evento "+ev+".....!");
            statement.close();
            conn.close();

        }catch(Exception e){
        out.println("Error al eliminar!!!");
        out.println("delete from Evento where Nombre ='"+ev+"' And Usuario='"+session.getAttribute("usuario")+"';");
        }
            %>
