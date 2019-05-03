/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.json.Json;
import org.json.simple.JSONObject;

/**
 *
 * @author dvillafus
 */
@WebService(serviceName = "SoapWS")
@Stateless()
public class SoapWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "valida")
    public Boolean valida(@WebParam(name = "nombre") String nombre, @WebParam(name = "password") String password) {
 try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/root","root","root");
            Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT * FROM USUARIOS WHERE NOMBRE = '"+nombre+"' AND PASSWORD = '"+password+"'");
            if(rs.next()){
                con.commit();
                con.close();
                return true;
            }
            con.commit();
            con.close();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "signUp")
    public Boolean signUp(@WebParam(name = "base") String base, @WebParam(name = "usuario") String usuario, @WebParam(name = "password") String password) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/root","root","root");
            Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT MAX(ID) AS RES FROM USUARIOS");
            rs.next();
            int id=rs.getInt("RES");
            System.out.println(id);
            id++;
            query.execute("INSERT INTO USUARIOS (NOMBRE,BASE, PASSWORD,ID) VALUES ('"+usuario+"','"+base+"','"+password+"',"+id+")");
            System.out.println(rs.toString());
            con.commit();
            con.close();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
      
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearTabla")
    public Boolean crearTabla(@WebParam(name = "esquema") String esquema, @WebParam(name = "nombreTabla") String nombreTabla, @WebParam(name = "iDUsuario") int iDUsuario) {
            try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/root","root","root");
            Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT MAX(IDTABLA) AS RES FROM TABLAS");
            rs.next();
            int iDTabla=rs.getInt("RES");
            iDTabla++;
            String s="INSERT INTO ROOT.TABLAS (NOMBRE,IDTABLA,IDUSUARIO) VALUES ('"+nombreTabla+"',"+iDTabla+","+iDUsuario+")";
            query.execute(s);
            
            //Aquí hay que desempaquetar el JSON y generar el query SQL que hará la nueva tabla.
//          String parametros="";
//          esquema.
//            
//          query.executeQuery("CREATE TABLE "+iDTabla+"( )");
            con.commit();
            con.close();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }
    
    
}
