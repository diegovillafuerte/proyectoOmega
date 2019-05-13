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
        <form action="action">
        <div id="principal">
            <ul class="nav">
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
        <input type="submit" value="Agregar campo" />
        <input type="submit" value="Quitar campo" />
        </form>
    </body>
</html>