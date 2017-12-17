<%-- 
    Document   : IngresoTel
    Created on : Oct 18, 2009, 12:13:56 PM
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
         String R ="";
try {

            String nombre=request.getParameter("TELn");
            String tel=request.getParameter("TELt");
            String cel=request.getParameter("TELc");
            String email=request.getParameter("TELe");


            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, login, password);
            statement = conn.createStatement();

            try{
            statement.execute("insert into Contacto values ('"+nombre+"','"+tel+"','"+cel+"','"+email+"','"+session.getAttribute("usuario")+"');");
            R = "Se realizo la insercion del Contacto correctamente....";
            }catch(Exception e){
            statement.execute("update Contacto set Telefono = '"+tel+"', Celular ='"+cel+"', Email ='"+email+"' where Nombre ='"+nombre+"' And Usuario='"+session.getAttribute("usuario")+"';");
            R = "Se realizo la actualizacion del Contacto correctamente....";
            }
            statement.close();
            //rs.close();
            conn.close();
            }catch(Exception e){out.println("no");}
    response.sendRedirect("telefono.jsp?us="+session.getAttribute("usuario")+"&ret="+R);
%>
    </body>
</html>