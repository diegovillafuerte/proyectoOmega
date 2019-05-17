/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

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
 * @author hca
 */
@Path("obtenerTabla")
public class ObtenerTablaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ObtenerTablaResource
     */
    public ObtenerTablaResource() {
    }

    /**
     * Retrieves representation of an instance of webservices.ObtenerTablaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml(@QueryParam("nombre")String nombre, @QueryParam("idusuario")String idusuario) {
        return obtenerTabla(nombre, idusuario);
    }

    /**
     * PUT method for updating or creating an instance of ObtenerTablaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }

    

    private static String obtenerTabla(java.lang.String base, java.lang.String idusuario) {
        referencias.SoapWS_Service service = new referencias.SoapWS_Service();
        referencias.SoapWS port = service.getSoapWSPort();
        return port.obtenerTabla(base, idusuario);
    }
    
    
}
