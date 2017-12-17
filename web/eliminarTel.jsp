<%-- 
    Document   : eliminarTel
    Created on : Oct 18, 2009, 12:11:52 PM
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

            statement.execute("delete from Contacto where Nombre ='"+ev+"' And Usuario='"+session.getAttribute("usuario")+"';");

            out.println(" <center>Se ha eliminado correctamente el contacto "+ev+".....!");
            statement.close();
            conn.close();

        }catch(Exception e){
        out.println("<center>Error al eliminar!!!");
        out.println("delete from Contacto where Nombre ='"+ev+"' And Usuario='"+session.getAttribute("usuario")+"';");
        }
            %>
