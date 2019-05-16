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
import org.json.simple.JSONArray;
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
            return true;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
      
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "altaUsuario")
    public Boolean altaUsuario(@WebParam(name = "name") String name, @WebParam(name = "password") String password, @WebParam(name = "base") String base){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/root","root","root");
            Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT MAX(ID) AS RES FROM USUARIOS");
            rs.next();
            int id=rs.getInt("RES");
            System.out.println(id);
            id++;
            query.execute("INSERT INTO USUARIOS (NOMBRE,BASE, PASSWORD,ID) VALUES ('"+name+"','"+base+"','"+password+"',"+id+")");
            System.out.println(rs.toString());
            con.commit();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerTabla")
    public String obtenerTabla(@WebParam(name = "base") String base, @WebParam(name = "idusuario") String idusuario) {
        JSONObject jo = new JSONObject();
        JSONArray jarr = new JSONArray();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/root","root","root");
            Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT IDTABLA FROM TABLAS WHERE NOMBRE = '"+base+"' AND IDUSUARIO = "+idusuario);
            rs.next();
            int tabla = rs.getInt("IDTABLA");
            String nomTabla = "TABLA"+tabla;
            Statement quer = con.createStatement();
            ResultSet rst = quer.executeQuery("SELECT * FROM "+nomTabla);
            int columnas = rst.getMetaData().getColumnCount();
            String nombres[] = new String[columnas];
            for(int i = 0;i<columnas;i++){
                nombres[i] = rst.getMetaData().getColumnName(i+1);
                    
                }
            while(rst.next()){
                for(String nom: nombres){
                    jo.put(nom , rst.getString(nom));
                }
                jarr.add(jo);
            }
            con.commit();
            con.close();  
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
            jo.put("Error", "Error");
        } catch (SQLException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
            jo.put("Error", "Error");
        }
        String res = jarr.toString();
        return res;
    }
    
    
    
    
}
