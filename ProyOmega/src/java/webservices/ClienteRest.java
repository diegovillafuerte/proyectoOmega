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
import javax.ws.rs.core.MediaType;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Service;
import java.io.StringReader;

/**
 * REST Web Service
 *
 * @author diego
 */
@Path("rest")
public class ClienteRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClienteRest
     */
    public ClienteRest() {
    }

    /**
     * Retrieves representation of an instance of webservices.ClienteRest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        //TODO return proper representation object
        if(valida("miguelon","miguelon"))
            return "Verdadero";
        return "Falso";
    }

    /**
     * PUT method for updating or creating an instance of ClienteRest
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }

    private static boolean valida(java.lang.String curr1, java.lang.String curr2) {
        webservices.SoapWS_Service service = new webservices.SoapWS_Service();
        webservices.SoapWS port = service.getSoapWSPort();
        return port.valida(curr1, curr2);
    }
    
    
    
}
