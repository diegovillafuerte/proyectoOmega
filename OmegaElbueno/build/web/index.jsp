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
        <form action="ProfileServlet">
            <p>Usuario: </p><input type="text" name="usuario" value="" />
            <p>Contraseña: </p><input type="password" name="contra" value="" />
            <p>Nombre de la base de datos: </p><input type="text" name="basedd" value="" /><br>
            <input type="submit" id="signup" value="Registrar" />
            <input type="submit" id="login" value="Ingresar" />
        </form>
    </body>
</html>