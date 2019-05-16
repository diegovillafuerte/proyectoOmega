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
 * @author mreyesba
 */
@Path("altas")
public class AltasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AltasResource
     */
    public AltasResource() {
    }

    /**
     * Retrieves representation of an instance of webservices.AltasResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml(@QueryParam("name")String name, @QueryParam("password")String password, @QueryParam("base")String base) {
        //TODO return proper representation object
        if(altaUsuario(name, password, base)) return "True";
        else return "False";
    }

    /**
     * PUT method for updating or creating an instance of AltasResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }

    private static Boolean altaUsuario(java.lang.String name, java.lang.String password, java.lang.String base) {
        referencias.SoapWS_Service service = new referencias.SoapWS_Service();
        referencias.SoapWS port = service.getSoapWSPort();
        return port.altaUsuario(name, password, base);
    }
}
