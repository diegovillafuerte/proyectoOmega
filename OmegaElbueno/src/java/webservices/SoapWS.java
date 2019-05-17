/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.io.File;
import java.io.StringWriter;
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
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "creaTabla")
    public Boolean creaTabla(@WebParam(name = "esquemaTabla") String esquemaTabla, @WebParam(name = "nombreTabla") String nombreTabla, @WebParam(name = "idusuario") int idusuario) throws ParseException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/root","root","root");
            Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT MAX(IDTABLA) AS RES FROM TABLAS");
            rs.next();
            int iDTabla=rs.getInt("RES");
            iDTabla++;
            /*
            String usuario = "";
            Statement query5 = con.createStatement();
            ResultSet rs5 = query5.executeQuery("SELECT ID AS RES2 FROM USUARIOS WHERE NOMBRE='"+usuario+"'");
            rs5.next();
            idusuario=rs5.getInt("RES2");*/
            
            
            String s="INSERT INTO ROOT.TABLAS (NOMBRE,IDTABLA,IDUSUARIO) VALUES ('"+nombreTabla+"',"+iDTabla+","+idusuario+")";
            query.execute(s);
            
            Statement query2 = con.createStatement();
            String campos = "(";
            JSONParser parser = new JSONParser();
            JSONArray columnas = (JSONArray) parser.parse(esquemaTabla);
            
            for(Object obje:columnas){
                JSONObject col = (JSONObject) obje;
                campos = campos + col.get("nombre") + " " + col.get("tipo") + ",";
            }
            campos = campos.substring(0,campos.length()-1) + ")";
            String qry="CREATE TABLE TABLA"+iDTabla+" "+campos;
            System.out.println(qry);
            query2.execute(qry);
            con.commit();
            con.close();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        }
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenTablasDeUsuario")
    public String obtenTablasDeUsuario(@WebParam(name = "nombre") String nombre) {
        System.out.println(nombre);
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/root","root","root");
            Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT ID FROM USUARIOS WHERE NOMBRE = '"+nombre+"'");
            rs.next();
            int idusuario = rs.getInt("ID");
            Statement query2 = con.createStatement();
            ResultSet rs2 = query2.executeQuery("SELECT NOMBRE FROM TABLAS WHERE IDUSUARIO = "+idusuario);
            //rs2.next();
            DocumentBuilderFactory dbFactory =
                DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                org.w3c.dom.Document doc = dBuilder.newDocument();
                //rs2.next();
                Element rootElement = doc.createElement("tablas");
                doc.appendChild(rootElement);
                Attr attr = doc.createAttribute("usuario");
                attr.setValue(nombre);
                rootElement.setAttributeNode(attr);
                
            while(rs2.next()){
                Element nombreTabla = doc.createElement("nombreTabla");
                String nomTabla = rs2.getString("NOMBRE");
                nombreTabla.appendChild(doc.createTextNode(nomTabla));
                rootElement.appendChild(nombreTabla);
            }
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(new DOMSource(doc), new StreamResult(sw));
             con.commit();
            con.close();
            return sw.toString();
            
            
            //return rootElement.toString();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
            return "falle";
        } catch (SQLException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
            return "falle";
    }   catch (ParserConfigurationException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
            return "falle";
    }   catch (TransformerConfigurationException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(SoapWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return "falle";
    }
    
}
