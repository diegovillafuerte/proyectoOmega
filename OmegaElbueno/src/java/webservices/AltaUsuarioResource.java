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
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author mreyesba
 */
@Path("alta")
public class AltaUsuarioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AltaUsuarioResource
     */
    public AltaUsuarioResource() {
    }

    /**
     * Retrieves representation of an instance of webservices.AltaUsuarioResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Boolean getHtml(@QueryParam("name")String name, @QueryParam("password")String password, @QueryParam("base")String base) {
        return altaUsuario(name, password, base);
    }

    /**
     * PUT method for updating or creating an instance of AltaUsuarioResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
    
    private static Boolean altaUsuario(java.lang.String name, java.lang.String password, java.lang.String base) {
        try {
            referencias.SoapWS_Service service = new referencias.SoapWS_Service();
            referencias.SoapWS port = service.getSoapWSPort();
            return port.altaUsuario(name, password, base);
        } catch (Exception ex) {
            Logger.getLogger(AltaUsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
}
