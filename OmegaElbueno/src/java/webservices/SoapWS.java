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
    @WebMethod(operationName = "signIn")
    public Boolean signIn(@WebParam(name = "base") String base, @WebParam(name = "usuario") String usuario, @WebParam(name = "password") String password) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/root","root","root");
            Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT MAX(ID) AS RES FROM USUARIOS");
            int id=Integer.parseInt(rs.getString("RES"));
            System.out.println(id);
            id++;
            rs = query.executeQuery("INSERT INTO USUARIOS (NOMBRE,BASE, PASSWORD,ID) VALUES ('"+usuario+"','"+base+"','"+password+"',"+id+")");
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
    
    
}
