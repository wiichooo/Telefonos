<%-- 
    Document   : ingreso
    Created on : Oct 12, 2009, 9:30:04 PM
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
            String dia = session.getAttribute("dia").toString();
            String mes = session.getAttribute("mes").toString();
            String anio = session.getAttribute("anio").toString();
            String hora=request.getParameter("hora");
            String nombre=request.getParameter("nombre");
            String descripcion=request.getParameter("desc");
            String prioridad=request.getParameter("prio");
            int diai = Integer.parseInt(dia);
            int mesi = Integer.parseInt(mes);
            int anioi = Integer.parseInt(anio);

            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, login, password);
            statement = conn.createStatement();

            try{
            statement.execute("insert into Evento values ('"+nombre+"','"+hora+"','"+descripcion+"','"+prioridad+"',"+diai+","+mesi+","+anioi+",'"+session.getAttribute("usuario")+"');");
            R="Se realizo la insercion correctamente....";
            }catch(Exception e){
            statement.execute("update Evento set Hora = '"+hora+"', Descripcion ='"+descripcion+"', Prioridad ='"+prioridad+"' where Nombre ='"+nombre+"' And Usuario='"+session.getAttribute("usuario")+"';");
            R="Se realizo la actualizacion correctamente....";
            }
            statement.close();
            //rs.close();
            conn.close();       
            }catch(Exception e){out.println("no");}
    response.sendRedirect("home.jsp?us="+session.getAttribute("usuario")+"&ret="+R);
%>
    </body>
</html>
