<%--
    Document   : index
    Created on : Oct 12, 2009, 11:47:08 AM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page session="true" import="java.util.*" %>

<script language="javascript" type="text/javascript">
var navok
if ( document.getElementById || document.all )
	navok = true
else
	navok = false

//fecha y hora actuales
var ahora = new Date()

//coordenadas posicion numeros en la circulo del Inicializa
var circulo_x = new Array()
var circulo_y = new Array()
circulo_x[7] = [80, 94, 100, 94, 77, 53, 28, 11,  5, 11, 28, 53]
circulo_y[7] = [ 8, 26,  50, 74, 91, 97, 91, 74, 50, 26,  8,  2]

//elementos graficos del Inicializa
var horas = new Array()
var minutos = new Array()
var segundos = new Array()
var numeros = new Array()


function pinta_reloj() {

	//dibuja circulo del Inicializa
	var txt
        txt = '<div id="exterior" style="position:relative; width:117px; height:117px; visibility:visible">'

	for(i=1;i<=7;i++)	//minutero
		txt += '<div id="min'+i+'" style="position:absolute; top:-100px; left:-100px; width:6px; height:6px; background-color:black; font-size:6px;"></div>'

	for(i=1;i<=5;i++)	//horas
		txt += '<div id="hrs'+i+'" style="position:absolute; top:-100px; left:-100px; width:6px; height:6px; background-color:black; font-size:6px;"></div>'

	for(i=1;i<=7;i++)	//segundero
		txt += '<div id="sec'+i+'" style="position:absolute; top:-100px; left:-100px; width:4px; height:4px; background-color:white; font-size:6px;"></div>'

	for(i=1;i<=12;i++)	//digitos
		txt += '<div id="h'+i+'" style="position:absolute; top:-100px; left:0px; width:10px; height:10px; font-size:10pt; font-family: Arial;">'+i+'</div>'

	txt += '</div>'

	document.write(txt)
//	mueve_capa( exterior, 100, 200);
}

//movimiento agujas
function avanza_reloj() {
	ahora = new Date()
	ahora.hrs = ahora.getHours()
	ahora.min = ahora.getMinutes()
	ahora.sec = ahora.getSeconds()

	ahora.hrs = ( ahora.hrs >= 12 ) ? ahora.hrs - 12 : ahora.hrs

	ahora.hrs = Math.floor( ( ahora.hrs * 5 ) + ( ahora.min/12 ) )

	for(n=0;n<horas.length;n++)
		mueve_capa(horas[n], circulo_x[n][ahora.hrs], circulo_y[n][ahora.hrs])
	for(n=0;n<minutos.length;n++)
		mueve_capa(minutos[n], circulo_x[n][ahora.min], circulo_y[n][ahora.min])
	for(n=0;n<segundos.length;n++)
		mueve_capa(segundos[n], circulo_x[n][ahora.sec], circulo_y[n][ahora.sec])
}

function mueve_capa(id,x,y){
	id.style.left = x + 'px'
	id.style.top = y + 'px'
}


function obtiene_capa(idstr) {
	if (document.getElementById)
		return document.getElementById(idstr)
	else if (document.all)
		return document.all[idstr]
}


function Inicializa() {

	if ( !navok )
		return

	//array de objetos aguja horas
	for( i=1; i<=5; i++)
		horas[i-1] = obtiene_capa('hrs'+i)
  	//array objetos minutero
  	for( i=1; i<=7; i++)
  		minutos[i-1] = obtiene_capa('min'+i)
	//array objetos segundero
	for( i=1; i<=7; i++)
		segundos[i-1] = obtiene_capa('sec'+i)
	//array objetos numeros circulo
	for( i=1; i<=12; i++)
		numeros[i] = obtiene_capa('h'+i)

	//inicializa posicion numeros circulo
	for( n=1; n<=12; n++)
  		mueve_capa(numeros[n], circulo_x[7][n-1], circulo_y[7][n-1])

	var centro = [0]
  	var radio = 6
  	var resultado = new Array()
  	for( i=1; i<=60; i++) {
  		centro[i] = centro[i-1] + ((Math.PI*2)/60)
  		centro[i-1] += Math.PI/180
  	}

	for( num=0; num<=6; num++) {
		circulo_x[num] = new Array()
		circulo_y[num] = new Array()
  		for( i=1; i<=60; i++) {
  			resultado = ((i-15)<0)? 60 + i - 15 : i - 15
  			circulo_x[num][i] = Math.floor((num*radio*Math.cos(centro[resultado]))+56)
  			circulo_y[num][i] = Math.floor((num*radio*Math.sin(centro[resultado]))+55)
  		}
		circulo_x[num][0]=circulo_x[num][60]
		circulo_y[num][0]=circulo_y[num][60]
  	}

	var IdIntervalo = setInterval("avanza_reloj()", 100)
}


window.onload = Inicializa


</script>



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

                    
                    function click(par){
                        if(xmlHttp.readyState ==4 ||xmlHttp.readyState==0){
                            xmlHttp.open("GET","mostrarTel.jsp?letras="+par.id,true);
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
                            xmlHttp.open("GET","mostrarreg.jsp?event="+par.title,true);
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
                            xmlHttp.open("GET","eliminarTel.jsp?event="+par.title,true);
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
                            xmlHttp.open("GET","modificarTel.jsp?event="+par.title,true);
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
                            xmlHttp.open("GET","buscarTel.jsp?event="+document.getElementById("s").value,true);
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
                                 document.getElementById("campos").innerHTML=Response;
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
                    <h2 class="title"><a>Bienvenid@  <% out.println(session.getAttribute("usuario"));%> ......</a></h2>


			<div class="entry">
				<h3>A su mini agenda personal...</h3>
			</div>
                        <div id="telefono">
                        <ul>
                            <li class="first"><a id="A-D" onclick="click(this)" >A-D</a></li>
                            <li><a id="E-H" onclick="click(this)" >E-H</a></li>
                            <li><a id="I-L" onclick="click(this)" >I-L</a></li>
                            <li><a id="M-O" onclick="click(this)" >M-O</a></li>
                            <li><a id="P-T" onclick="click(this)" >P-T</a></li>
                            <li><a id="U-Z" onclick="click(this)" >U-Z</a></li> 
                        </ul></div> 
                        <br><br><form action="ingresoTel.jsp">
                        <div id="campos"><center><div ><h3 style="color:blue"><%
                if(request.getParameter("ret") != null)
                out.println(request.getParameter("ret"));

                %></h3></div></div>
                </form><br><br>
                        <div id="telefonox">  </div> 
		</div>

		<div class="post">
			<div class="entry">
                           
			</div>
		</div>
	</div>
	<!-- end content -->
	<!-- start sidebar -->
	<div id="sidebar">
		<ul>
                <li>
                        <center><TABLE  BACKGROUND="images/reloj.png "  width=\"215\" height=\"231\" >
			 <TR>
			 <TD><center><script type="text/javascript"> pinta_reloj() </script> </TD>
			 </TR>
			 </TABLE>
                </li>
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