/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.simple.parser.ParseException;
import referencias.ParseException_Exception;
/**
 * REST Web Service
 *
 * @author hca
 */
@Path("nuevaTabla")
public class NuevaTablaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of NuevaTablaResource
     */
    public NuevaTablaResource() {
    }

    /**
     * Retrieves representation of an instance of webservices.NuevaTablaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.TEXT_HTML)
    public String getHtml(@QueryParam("esquema")String esquema,@QueryParam("nombre")String nombre,@QueryParam("nombreUsuario")String nombreUsuario) {
            
        //System.out.println(esquema);
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/root","root","root");
       
            Statement query5 = con.createStatement();
            ResultSet rs5 = query5.executeQuery("SELECT ID AS RES2 FROM USUARIOS WHERE NOMBRE='"+nombreUsuario+"'");
            rs5.next();
            int idusuario=rs5.getInt("RES2");
            
             con.commit();
            con.close();
            
            
            
            if (creaTabla(esquema, nombre, idusuario)) {
                return "True";
            } else {
                return "False";
            }
        } catch (Exception ex) {
            Logger.getLogger(NuevaTablaResource.class.getName()).log(Level.SEVERE, null, ex);
            return "False";
        }
    }

    /**
     * PUT method for updating or creating an instance of NuevaTablaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }

    

    private static Boolean creaTabla(java.lang.String esquemaTabla, java.lang.String nombreTabla, int idusuario) throws ParseException_Exception, ParseException {
        referencias.SoapWS_Service service = new referencias.SoapWS_Service();
        referencias.SoapWS port = service.getSoapWSPort();
        return port.creaTabla(esquemaTabla, nombreTabla, idusuario);
    }
    
    
    
    
}
