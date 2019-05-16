/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

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
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.TEXT_HTML)
    public Boolean getHtml(@QueryParam("esquema")String esquema,@QueryParam("nombre")String nombre,@QueryParam("idusuario")int idusuario) {
        try {
            return creaTabla(esquema, nombre, idusuario);
        } catch (ParseException_Exception ex) {
            Logger.getLogger(NuevaTablaResource.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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

    private static Boolean creaTabla(java.lang.String esquemaTabla, java.lang.String nombreTabla, int idusuario) throws ParseException_Exception {
        referencias.SoapWS_Service service = new referencias.SoapWS_Service();
        referencias.SoapWS port = service.getSoapWSPort();
        return port.creaTabla(esquemaTabla, nombreTabla, idusuario);
    }
    
    
    
}
