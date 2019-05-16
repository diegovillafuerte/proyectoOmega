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
        <input type="submit" id="vt" value="Ver tabla" />
        <input type="submit" id="mt" value="Modificar tabla" />
        <input type="submit" id="bt" value="Borrar tabla" />
        <input type="submit" id="ct" value="Crear tabla" />
    </body>
    <script type="text/javascript">
        document.getElementById("mt").onclick = function () {
            location.href = "modificatabla.jsp";
        };
        
        document.getElementById("ct").onclick = function () {
            location.href = "nuevatabla.jsp";
        };
    </script>
</html>
