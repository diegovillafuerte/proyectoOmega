<%-- 
    Document   : nuevatabla
    Created on : 13/05/2019, 04:10:47 PM
    Author     : sdist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .nav li {
                display: inline-block;
            }
       </style>
    </head>
    <body>
        <form>
        <input type="text" name="nombre" value="" id="nombreb"/>
        <div id="principal">
            <ul class="nav" id="1">
                <li><p>Campo: </p></li>
                <li><input type="text" name="campo1" value="" id="campo1"/></li>
                <li><p>Tipo: </p></li>
                <li><select name="tipo" id="tipo1">
                    <option>varchar%28100%29</option>
                    <option>integer</option>
                    <option>double</option>
                    <option>boolean</option>
                    <option>char</option>
                </select></li>
            </ul>
        </div>
        <input type="button" id="nc" value="Agregar campo" />
        <input type="button" id="qc" value="Quitar campo" />
        <input type="button" value="Crear tabla" onclick="callRESTfulWebService(
'GET','http://localhost:8080/OmegaElbueno/webresources/nuevaTabla','')"/>
        </form>
        <%
           HttpSession mySession = request.getSession();
           String user = mySession.getAttribute("username").toString();
           out.println("<input hidden='true' id='usuario' value='"+user+"'>");
        %>
        <script type="text/javascript">
            var rows = ["1"];
            var currow = 1;
            
            document.getElementById("nc").onclick = function () {
                addRow();
            };
            document.getElementById("qc").onclick = function () {
               removeRow();
            };
            
            function addRow() {
                var div = document.createElement('ul');
                
                currow = currow + 1;
                div.id = ""+currow;
                
               
                
                div.className = 'nav';
                div.innerHTML =
                    '<li><p>Campo: </p></li>'+
                '<li><input type="text" name="campo1" value="" id="campo'+currow+'"/></li>'+
                '<li><p>Tipo: </p></li>'+
                '<li><select name="tipo" id="tipo'+currow+'">'+
                    '<option>varchar%28100%29</option>'+
                    '<option>integer</option>'+
                    '<option>double</option>'+
                    '<option>boolean</option>'+
                    '<option>char</option>'+
                '</select></li>';
                document.getElementById('principal').appendChild(div);
            }
            function removeRow() {
                if (currow > 1) {
                    var ids = "" + currow;
                    var element = document.getElementById(ids);
                    element.parentNode.removeChild(element);
                    currow = currow - 1;
                }
            }
            
            function callRESTfulWebService(method, target, msg) {
                var ajaxRequest;
                if (window.XMLHttpRequest){
                    ajaxRequest=new XMLHttpRequest(); // IE7+, Firefox, Chrome, Opera, Safari
                } else {
                    ajaxRequest=new ActiveXObject("Microsoft.XMLHTTP"); // IE6, IE5
                }
                    ajaxRequest.onreadystatechange = function(){
                    
                    if (ajaxRequest.readyState==4 && (ajaxRequest.status==200 || ajaxRequest.status==204)){
                        
                        var resp = ajaxRequest.responseText;
                        
                            if(resp == "True") {
                                location.href = "ProfileServlet";
                            } else {
                                alert("algo paso incorrecto");
                            }
                    }
                }
                var aux = "";
                var idc = "";
                var idt = "";

                for (var i = 1; i <= currow; i++) {
                    idc = "campo" + i;
                    idt = "tipo" + i;
                    aux = aux + "%7B%22nombre%22%3A%22"+document.getElementById(idc).value+"%22%2C%22tipo%22%3A%22"+document.getElementById(idt).value+"%22%7D";
                    if (i < currow) {
                        aux = aux + "%2C";
                    }
                }           
                aux = "%5B" + aux + "%5D";
                //alert(aux);
                
                var aux2 = "";
                
                aux2 = target + "?esquema="+aux+"&nombre="+document.getElementById("nombreb").value+"&nombreUsuario="+document.getElementById("usuario").value;
                ajaxRequest.open(method, aux2, true /*async*/);
                ajaxRequest.setRequestHeader("Content-Type", "text/html");
                ajaxRequest.send(msg);
            }
        </script>
    </body>
</html>