/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author jarandaba
 */
@Path("nombretablas")
public class NombretablasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of NombretablasResource
     */
    public NombretablasResource() {
    }

    /**
     * Retrieves representation of an instance of webservices.NombretablasResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getText( @QueryParam("nombre")String nombre) {
        //TODO return proper representation object
        return obtenTablasDeUsuario(nombre);
    }

    /**
     * PUT method for updating or creating an instance of NombretablasResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }

    private static String obtenTablasDeUsuario(java.lang.String nombre) {
        referencias.SoapWS_Service service = new referencias.SoapWS_Service();
        referencias.SoapWS port = service.getSoapWSPort();
        return port.obtenTablasDeUsuario(nombre);
    }
    
}
