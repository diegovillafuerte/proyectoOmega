<%-- 
    Document   : modificatabla
    Created on : 13/05/2019, 04:11:33 PM
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
        <<form action="action">
        <div>
            <div>><p>Campo: </p><input type="text" name="campo1" value="" /><p>Tipo: </p><select name="">
                    <option>varchar</option>
                    <option>integer</option>
                    <option>double</option>
                    <option>boolean</option>
                    <option>time</option>
                    <option>date</option>
                    <option>char</option>
                </select></div>
        </div>
        <input type="submit" value="Agregar campo" />
        <input type="submit" value="Quitar campo" />
        </form>
    </body>
</html>