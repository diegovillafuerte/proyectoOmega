/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

/**
 *
 * @author dvillafus
 */
public class pruebaWS {


    
    public static void main(String[] args) {
        System.out.println(valida("miguelon", "miguelon"));
    }

    private static Boolean valida(java.lang.String nombre, java.lang.String password) {
        referencias.SoapWS_Service service = new referencias.SoapWS_Service();
        referencias.SoapWS port = service.getSoapWSPort();
        return port.valida(nombre, password);
    }
}
