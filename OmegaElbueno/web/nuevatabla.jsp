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
        <form action="ProfileServlet">
        <div id="principal">
            <ul class="nav" id="1">
                <li><p>Campo: </p></li>
                <li><input type="text" name="campo1" value="" /></li>
                <li><p>Tipo: </p></li>
                <li><select name="">
                    <option>varchar</option>
                    <option>integer</option>
                    <option>double</option>
                    <option>boolean</option>
                    <option>time</option>
                    <option>date</option>
                    <option>char</option>
                </select></li>
            </ul>
        </div>
        <input type="button" id="nc" value="Agregar campo" />
        <input type="button" id="qc" value="Quitar campo" />
        <input type="submit" value="Crear tabla" />
        </form>
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

                div.id = ""+currow;
                
                currow = currow + 1;
                
                div.className = 'nav';

                div.innerHTML =
                    '<li><p>Campo: </p></li>'+
                '<li><input type="text" name="campo1" value="" /></li>'+
                '<li><p>Tipo: </p></li>'+
                '<li><select name="">'+
                    '<option>varchar</option>'+
                    '<option>integer</option>'+
                    '<option>double</option>'+
                    '<option>boolean</option>'+
                    '<option>time</option>'+
                    '<option>date</option>'+
                    '<option>char</option>'+
                '</select></li>';

                document.getElementById('principal').appendChild(div);
            }

            function removeRow() {
                if (currow > 1) {
                    var element = document.getElementById(currow + "");
                    element.parentNode.removeChild(element);
                    currow = currow - 1;
                }
        }
        </script>
    </body>
</html>