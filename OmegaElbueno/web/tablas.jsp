<%-- 
    Document   : tablas
    Created on : 13/05/2019, 04:10:30 PM
    Author     : sdist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <select name="ProfileServlet">
        <select name="tablas">
            <option></option>
        </select>
        <br>
        <input type="submit" id="vt" value="Ver tabla" onclick="callRESTfulWebService(
'GET','http://localhost:8080/OmegaElbueno/webresources/','')"/>
        <input type="submit" id="mt" value="Modificar tabla" onclick="callRESTfulWebService(
'GET','http://localhost:8080/OmegaElbueno/webresources/','')"/>
        <input type="submit" id="bt" value="Borrar tabla" onclick="callRESTfulWebService(
'GET','http://localhost:8080/OmegaElbueno/webresources/','')"/>
        <input type="submit" id="ct" value="Crear tabla"/>
        <input type="submit" id="cs" value="Cerrar sesion"/>
        <%
           
        
        %>
    </body>
    <script type="text/javascript">
        function callRESTfulWebService(method, target, msg) {
                var ajaxRequest;
                if (window.XMLHttpRequest){
                    ajaxRequest=new XMLHttpRequest(); // IE7+, Firefox, Chrome, Opera, Safari
                } else {
                    ajaxRequest=new ActiveXObject("Microsoft.XMLHTTP"); // IE6, IE5
                }
                    ajaxRequest.onreadystatechange = function(){
                    switch (target) {
                        case 'http://localhost:8080/OmegaElbueno/webresources/login':
                            if (ajaxRequest.readyState==4 && (ajaxRequest.status==200 || ajaxRequest.status==204)){
                                var resp = ajaxRequest.responseText;
                                //alert(resp);
                                if(ajaxRequest.responseText == "True") {
                                    location.href = "";
                                } else {
                                    alert("No se pudo acceder a la tabla");
                                }
                            }
                          //Sentencias ejecutadas cuando el resultado de expresion coincide con valor1
                          [break;]
                        case 'http://localhost:8080/OmegaElbueno/webresources/login':
                            if (ajaxRequest.readyState==4 && (ajaxRequest.status==200 || ajaxRequest.status==204)){
                                var resp = ajaxRequest.responseText;
                                //alert(resp);
                                if(ajaxRequest.responseText == "True") {
                                    location.href = "";
                                } else {
                                    alert("No se pudo acceder a la tabla");
                                }
                            }
                          //Sentencias ejecutadas cuando el resultado de expresion coincide con valor2
                          [break;]
                        default:
                            if (ajaxRequest.readyState==4 && (ajaxRequest.status==200 || ajaxRequest.status==204)){
                                var resp = ajaxRequest.responseText;
                                //alert(resp);
                                if(ajaxRequest.responseText == "True") {
                                    location.href = "ProfileServlet";
                                } else {
                                    alert("Ese usuario ya existe");
                                }
                            }
                          //Sentencias_def ejecutadas cuando no ocurre una coincidencia con los anteriores casos
                          [break;]
                      }
                                      }
                var aux;
                
                if (target == 'http://localhost:8080/OmegaElbueno/webresources/login') {
                    //alert(document.getElementById("usuario").value);
                    aux = target +"?name="+document.getElementById("usuario").value+"&password="+document.getElementById("contra").value;
                    //ajaxRequest.open(method, target +"?name="+document.getElementById("usuario").value+"&password="+document.getElementById("contra").value, true /*async*/);
                } else {
                    aux =  target +"?name="+document.getElementById("usuario").value+"&password="+document.getElementById("contra").value+"&base="+document.getElementById("basedd").value;
                    //ajaxRequest.open(method, target +"?name="+document.getElementById("usuario").value+"&password="+document.getElementById("contra").value"&base="+document.getElementById("basedd").value+"", true /*async*/);
                }
                //alert(aux);
                ajaxRequest.open(method, aux, true /*async*/);
                ajaxRequest.setRequestHeader("Content-Type", "text/html");
                ajaxRequest.send(msg);
        } 
        
        document.getElementById("ct").onclick = function () {
            location.href = "nuevatabla.jsp";
        };
        
        document.getElementById("cs").onclick = function () {
            location.href = "index.jsp";
        };
        
    </script>
</html>
