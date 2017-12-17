<%-- 
    Document   : in.jsp
    Created on : Oct 13, 2009, 10:43:22 PM
    Author     : wiichooo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page session="true" import="java.util.*" %>
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

                   function login(par){
                       //alert(document.getElementById("u").value);
                       //alert(document.getElementById("p").value);
                        if(xmlHttp.readyState ==4 ||xmlHttp.readyState==0){
                            xmlHttp.open("GET","login.jsp?usuario="+document.getElementById("u").value+"&pass="+document.getElementById("p").value,true);
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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>MiniAgendaPersonal</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="style2.css" rel="stylesheet" type="text/css" media="screen" />

</head>
<body>
 <div id="banner"><center><img src="images/logo2.png" /></div>

<div id="menu"></div>
<hr />

<!-- start page -->
<div id="page"> 
            <div> 
                <center><div ><h3 style="color:red"><%
                if(request.getParameter("err") != null)
                out.println(request.getParameter("err"));

                %></h3></div>
            </div>

                             
	<!-- start content -->
	<div id="content">

                <div><h2 class="title">Bienvenido.</h2> </div>

                

		<div class="post">
			<div class="entry">
                             
                        <div id="login">
                            <form action="login.jsp">
                            <br><br><br><br> 
                            Usuario:<input id="u"   type="text" name="u" /><br><br>
                            Password:<input id="p"   type="password" name="p" /><br><br>
                            <ul> <li> <input id="x" type="submit" name="imageField" value="Ingresar!"/> </li> </ul>

                              <br><br><br><br> 
                            </form>
                        </div>
                            
			</div>
		</div> 
	</div>
         
</div>
<!-- end page -->
<div id="footer">
	<p class="legal">Copyright (c) 2007 Website Name. All rights reserved.</p>
	<p class="credit">Designed by <a href="http://www.nodethirtythree.com/">NodeThirtyThree</a> + <a href="http://www.freecsstemplates.org/">Free CSS Templates</a></p>

</div>
</body>
</html>
