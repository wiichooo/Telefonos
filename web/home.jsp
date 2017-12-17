<%-- 
    Document   : index
    Created on : Oct 12, 2009, 11:47:08 AM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page session="true" import="java.util.*" %>
<%
// Global Vars
            int action = 0;  // incoming request for moving calendar up(1) down(0) for month
            int currYear = 0; // if it is not retrieved from incoming URL (month=) then it is set to current year
            int currMonth = 0; // same as year
            String boxSize = "50";  // how big to make the box for the calendar

//build 2 calendars

            Calendar c = Calendar.getInstance();
            Calendar cal = Calendar.getInstance();

            if (request.getParameter("action") == null) // Check to see if we should set the year and month to the current
            {
                currMonth = c.get(c.MONTH);

                currYear = c.get(c.YEAR);
                cal.set(currYear, currMonth, 1);

            } else {
                if (!(request.getParameter("action") == null)) // Hove the calendar up or down in this if block
                {
                    currMonth = Integer.parseInt(request.getParameter("month"));
                    currYear = Integer.parseInt(request.getParameter("year"));

                    if (Integer.parseInt(request.getParameter("action")) == 1) {
                        cal.set(currYear, currMonth, 1);
                        cal.add(cal.MONTH, 1);
                        currMonth = cal.get(cal.MONTH);
                        currYear = cal.get(cal.YEAR);
                    } else {
                        cal.set(currYear, currMonth, 1);
                        cal.add(cal.MONTH, -1);
                        currMonth = cal.get(cal.MONTH);
                        currYear = cal.get(cal.YEAR);
                    }
                }
            }
%>

<%!
    public boolean isDate(int m, int d, int y) // This method is used to check for a VALID date
    {
        m -= 1;
        Calendar c = Calendar.getInstance();
        c.setLenient(false);

        try
        {
                c.set(y,m,d);
                Date dt = c.getTime();
        }
          catch (IllegalArgumentException e)
        {
                return false;

        }
                return true;
    }
%>
<%!
   public String getDateName (int monthNumber) // This method is used to quickly return the proper name of a month
   {
                String strReturn = "";
                switch (monthNumber)
                {
                    case 0:
                            strReturn = "Enero";
                            break;
                    case 1:
                            strReturn = "Febrero";
                            break;
                    case 2:
                            strReturn = "Marzo";
                            break;
                    case 3:
                            strReturn = "Abril";
                            break;
                    case 4:
                            strReturn = "Mayo";
                            break;
                    case 5:
                            strReturn = "Junio";
                            break;
                    case 6:
                            strReturn = "Julio";
                            break;
                    case 7:
                            strReturn = "Agosto";
                            break;
                    case 8:
                            strReturn = "Septiembre";
                            break;
                    case 9:
                            strReturn = "Octubre";
                            break;
                    case 10:
                            strReturn = "Noviembre";
                            break;
                    case 11:
                            strReturn = "Diciembre";
                            break;
        }
        return strReturn;
    }
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>MiniAgendaPersonal</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />

<script>
                   var xmlHttp = createXmlHttpRequestObject();
            function createXmlHttpRequestObject(){
                var xmlHttp;
                if(window.ActiveXObject){
                    try{
                        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    catch(e){
                        xmlHttp=false;
                    }
                }else{
                   try{
                        xmlHttp = new XMLHttpRequest();
                    }catch (e){
                        xmlHttp = false;
                    }
                }

            if(!xmlHttp)
                alert("Error al crear el objeto XMLHttpRequest");
            else
                 return xmlHttp;
             } 

                    function clicked(par){
                        if(xmlHttp.readyState ==4 ||xmlHttp.readyState==0){
                           xmlHttp.open("GET","fecha.jsp?diaev="+par.title+"&month=<%=currMonth%>&year=<%=currYear%>",true);
                           xmlHttp.onreadystatechange = ActualizarInsertar;
                          //alert(par.title);
                          xmlHttp.send(null);
                        }
                     }


                    function ActualizarInsertar(){
                        if(xmlHttp.readyState==4){
                           if(xmlHttp.status ==200){
                             Response = xmlHttp.responseText;
                              //alert(Response);
                                 document.getElementById("insertar").innerHTML=Response;
                            }
                         }
                    }
                    function click(par){
                        if(xmlHttp.readyState ==4 ||xmlHttp.readyState==0){
                            xmlHttp.open("GET","campos.jsp?event="+par.title,true);
                           xmlHttp.onreadystatechange = ActualizarCampos;
                          //alert(par.title);
                          xmlHttp.send(null);
                        }

                     }

                     function ActualizarCampos(){
                         if(xmlHttp.readyState==4){
                           if(xmlHttp.status ==200){
                              Response = xmlHttp.responseText;
                              //alert(Response);
                                 document.getElementById("campos").innerHTML=Response;
                            }
                         }
                     }
                     function clickm(par){
                        if(xmlHttp.readyState ==4 ||xmlHttp.readyState==0){
                            xmlHttp.open("GET","mostrar.jsp?event="+par.title,true);
                           xmlHttp.onreadystatechange = MostrarCampos;
                          //alert(par.title);
                          xmlHttp.send(null);
                        }

                     }

                     function MostrarCampos(){
                         if(xmlHttp.readyState==4){
                           if(xmlHttp.status ==200){
                              Response = xmlHttp.responseText;
                              //alert(Response);
                                 document.getElementById("campos").innerHTML=Response;
                            }
                         }
                     }
                     function clickeli(par){
                        //alert(par.title);
                        if(xmlHttp.readyState ==4 ||xmlHttp.readyState==0){
                            xmlHttp.open("GET","eliminar.jsp?event="+par.title,true);
                           xmlHttp.onreadystatechange = Eliminar;
                          //alert(par.title);
                          xmlHttp.send(null);
                        }

                     }

                     function Eliminar(){
                         //alert("eliminar");
                         if(xmlHttp.readyState==4){
                           if(xmlHttp.status ==200){
                              Response = xmlHttp.responseText;
                              //alert(Response);
                                 document.getElementById("campos").innerHTML=Response;
                            }
                         }
                     }
                     function clickmod(par){
                        //alert(par.title);
                        if(xmlHttp.readyState ==4 ||xmlHttp.readyState==0){
                            xmlHttp.open("GET","modificar.jsp?event="+par.title,true);
                           xmlHttp.onreadystatechange = Modificar;
                          //alert(par.title);
                          xmlHttp.send(null);
                        }

                     }

                     function Modificar(){
                         //alert("eliminar");
                         if(xmlHttp.readyState==4){
                           if(xmlHttp.status ==200){
                              Response = xmlHttp.responseText;
                              //alert(Response);
                                 document.getElementById("campos").innerHTML=Response;
                            }
                         }
                     }
                     function clickact(par){
                       //alert(document.getElementById("s").value);
                        if(xmlHttp.readyState ==4 ||xmlHttp.readyState==0){
                            xmlHttp.open("GET","buscar.jsp?event="+document.getElementById("s").value,true);
                           xmlHttp.onreadystatechange = Act;
                          //alert(par.title);
                          xmlHttp.send(null);
                        }

                     }
                     function Act(){
                         //alert("eliminar");
                         if(xmlHttp.readyState==4){
                           if(xmlHttp.status ==200){
                              Response = xmlHttp.responseText;
                              //alert(Response);
                                 document.getElementById("insertar").innerHTML=Response;
                            }
                         }
                     }
                </script>
<%session.setAttribute("usuario", request.getParameter("us"));%>
</head>
<body>
 <div id="banner"><center><img src="images/logo2.png" /></div>
 
<div id="menu">
	<ul>
		<li class="first"><a href="home.jsp?us=<%out.print(session.getAttribute("usuario"));%>" accesskey="1" title="">Agenda</a></li>
                <li><a href="telefono.jsp?us=<%out.print(session.getAttribute("usuario"));%>" accesskey="1" title="">Telefonos</a></li>
		<li><a href="index.jsp" accesskey="2" title="">Logout</a></li>
	</ul>
	<div id="search">
		
			<fieldset>
                            <input id="s"   type="text" name="s" />
			<input id="x" type="image" onclick="clickact(this)" name="imageField" src="images/img10.jpg" />
			</fieldset>
		
	</div>
</div>
<hr />

<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">
                    <h2 class="title"><a>Bienvenid@  <%
                            
                                  out.println(session.getAttribute("usuario"));%> ......</a></h2>
			<div class="entry">
				<h3>A su mini agenda personal...</h3>
			</div>

		</div>
		<div class="post">
			<div class="entry">
                             <form action="ingreso.jsp">
                        <div id="insertar"><center><div ><h3 style="color:blue"><%
                if(request.getParameter("ret") != null)
                out.println(request.getParameter("ret"));

                %></h3></div></div>
                </form>
			</div>
                        
		</div>
	</div>
	<!-- end content -->
	<!-- start sidebar -->
	<div id="sidebar">
		<ul>
			<li id="calendar">
				<table summary="Calendar">
					<caption>
					<center><b><%=getDateName(cal.get(cal.MONTH)) + " " + cal.get(cal.YEAR)%></b></center>
					</caption>
					<thead>
						<tr>
							<th abbr="Monday" scope="col" title="Monday">D</th>
							<th abbr="Tuesday" scope="col" title="Tuesday">L</th>
							<th abbr="Wednesday" scope="col" title="Wednesday">M</th>
							<th abbr="Thursday" scope="col" title="Thursday">M</th>
							<th abbr="Friday" scope="col" title="Friday">J</th>
							<th abbr="Saturday" scope="col" title="Saturday">V</th>
							<th abbr="Sunday" scope="col" title="Sunday">S</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
                                                    <td abbr="October" colspan="3" id="prev"><a href="home.jsp?month=<%=currMonth%>&year=<%=currYear%>&action=0&us=<%out.print(session.getAttribute("usuario"));%>"><font size="1">Previous</font></a></td>
							<td class="pad">&nbsp;</td>
							<td abbr="December" colspan="3" id="next"><a href="home.jsp?month=<%=currMonth%>&year=<%=currYear%>&action=1&us=<%out.print(session.getAttribute("usuario"));%>"><font size="1">Next</font></a></td>
						</tr>
					</tfoot>
					<tbody>

                    <%
                        //'Calendar loop
                        int currDay;
                        String todayColor;
                        int count = 1;
                        int dispDay = 1;

                        for (int w = 1; w < 7; w++) {
                    %>
                            <tr>
                    <%
                                for (int d = 1; d < 8; d++) {
                                    if (!(count >= cal.get(c.DAY_OF_WEEK))) {

                    %>
                                        <td width="<%=boxSize%>" height="<%=boxSize%>" valign="top" align="left">&nbsp;</td>
                    <%
                                                    count += 1;
                                    } else {
                                        if (isDate(currMonth + 1, dispDay, currYear)) // use the isDate method
                                        {
                                            if (dispDay == c.get(c.DAY_OF_MONTH) && c.get(c.MONTH) == cal.get(cal.MONTH) && c.get(c.YEAR) == cal.get(cal.YEAR)) // Here we check to see if the current day is today
                                            {
                                                todayColor = "#6C7EAA";
                                            } else {
                                                todayColor = "#ffffff";
                                            }
                    %>


                                            <td bgcolor ="<%=todayColor%>" width="<%=boxSize%>" align="left" height="<%=boxSize%>" valign="top" name="botdia" title="<%=dispDay%>"  ondblclick="clicked(this)"><%=dispDay%></a><br>
                                            </td>

                    <%
                                           count += 1;
                                           dispDay += 1;
                                       } else {
                    %>
                                            <td width="<%=boxSize%>" align="left" height="<%=boxSize%>" valign="top">&nbsp;</td>
                    <%
                                         }
                                       }
                                    }
                    %>
                    </tr>
                    <%
                                }
                    %>
                </table> </li>
                <li> </li>
		<li> </li>
		</ul>
	</div>
	<!-- end sidebar -->
</div>
<!-- end page -->
<div id="footer">
	<p class="legal">Copyright (c) 2007 Website Name. All rights reserved.</p>
	<p class="credit">Designed by <a href="http://www.nodethirtythree.com/">NodeThirtyThree</a> + <a href="http://www.freecsstemplates.org/">Free CSS Templates</a></p>
	
</div>
</body>
</html>