<%-- 
    Document   : index
    Created on : 13/05/2019, 04:06:01 PM
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
        <form>
            <p>Usuario: </p><input type="text" id="usuario" value="" />
            <p>Contraseña: </p><input type="password" id="contra" value="" />
            <p>Nombre de la base de datos: </p><input type="text" id="basedd" value="" /><br>
            <input type="button" id="signup" value="Registrar" onclick="callRESTfulWebService(
'GET','http://localhost:8080/OmegaElbueno/webresources/altas','')"/>
            <input type="button" id="login" value="Ingresar" onclick="callRESTfulWebService(
'GET','http://localhost:8080/OmegaElbueno/webresources/login','')"/>
        </form>
        <script type="text/javascript" language="javascript">
            
            function callRESTfulWebService(method, target, msg) {
                var ajaxRequest;
                if (window.XMLHttpRequest){
                    ajaxRequest=new XMLHttpRequest(); // IE7+, Firefox, Chrome, Opera, Safari
                } else {
                    ajaxRequest=new ActiveXObject("Microsoft.XMLHTTP"); // IE6, IE5
                }
                    ajaxRequest.onreadystatechange = function(){
                    
                    if (target == 'http://localhost:8080/OmegaElbueno/webresources/login') {
                        if (ajaxRequest.readyState==4 && (ajaxRequest.status==200 || ajaxRequest.status==204)){
                            var resp = ajaxRequest.responseText;
                            //alert(resp);
                            if(resp == "True") {
                                location.href = "ProfileServlet";
                            } else {
                                alert("Usuario y/o contraseña incorrectos");
                            }
                        }
                    } else {
                        if (ajaxRequest.readyState==4 && (ajaxRequest.status==200 || ajaxRequest.status==204)){
                            var resp = ajaxRequest.responseText;
                            //alert(resp);
                            if(ajaxRequest.responseText == "True") {
                                location.href = "ProfileServlet";
                            } else {
                                alert("Ese usuario ya existe");
                            }
                        }
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
        </script>
    </body>
</html>