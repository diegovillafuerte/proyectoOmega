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
    <body onload="callRESTfulWebService1(
'GET','http://localhost:8080/OmegaElbueno/webresources/nombretablas','')">
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
           HttpSession mySession = request.getSession();
           String user = mySession.getAttribute("username").toString();
           out.println("<input hidden='true' id='usuario' value='"+user+"'>");
           
           
           

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

                if (target == 'http://localhost:8080/OmegaElbueno/webresources/login') {
                    if (ajaxRequest.readyState==4 && (ajaxRequest.status==200 || ajaxRequest.status==204)){
                        var resp = ajaxRequest.responseText;
                        //alert(resp);
                        if(resp == "True") {
                            location.href = "ProfileServlet?usuario="+document.getElementById("usuario").value;
                        } else {
                            alert("Usuario y/o contraseña incorrectos");
                        }
                    }
                } else if(true){
                    if (ajaxRequest.readyState==4 && (ajaxRequest.status==200 || ajaxRequest.status==204)){
                        var resp = ajaxRequest.responseText;
                        //alert(resp);
                        if(ajaxRequest.responseText == "True") {
                            location.href = "ProfileServlet?usuario="+document.getElementById("usuario").value;
                        } else {
                            alert("Ese usuario ya existe");
                        }
                    }
                } else {
                    
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
        
        
        
        function callRESTfulWebService1(method, target, msg) {
            var ajaxRequest;
            if (window.XMLHttpRequest){
                ajaxRequest=new XMLHttpRequest(); // IE7+, Firefox, Chrome, Opera, Safari
            } else {
                ajaxRequest=new ActiveXObject("Microsoft.XMLHTTP"); // IE6, IE5
            }
                ajaxRequest.onreadystatechange = function(){

                if (ajaxRequest.readyState==4 && (ajaxRequest.status==200 || ajaxRequest.status==204)){
                        var resp = ajaxRequest.responseText;
                        
                        var elxml = StringToXML(resp);
                        
                        alert(elxml).getElementsByTagName("nombreTabla")[0].childNodes[0].nodeValue);
                        //alert(resp);
                        
                    }
            }
            
            var aux = target + "?nombre="+document.getElementById("usuario").value;
            
            //alert(aux);
            ajaxRequest.open(method, aux, true /*async*/);
            ajaxRequest.setRequestHeader("Content-Type", "text/html");
            ajaxRequest.send(msg);
        } 
        
        function StringToXML(oString) {
        //code for IE
        if (window.ActiveXObject) { 
        var oXML = new ActiveXObject("Microsoft.XMLDOM"); oXML.loadXML(oString);
        return oXML;
        }
        // code for Chrome, Safari, Firefox, Opera, etc. 
        else {
        return (new DOMParser()).parseFromString(oString, "text/xml");
        }
       }
        
        document.getElementById("ct").onclick = function () {
            location.href = "nuevatabla.jsp";
        };
        
        document.getElementById("cs").onclick = function () {
            location.href = "index.jsp";
        };
        
    </script>
</html>
