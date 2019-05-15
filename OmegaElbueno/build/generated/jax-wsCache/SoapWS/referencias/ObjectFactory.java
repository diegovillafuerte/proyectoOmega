
package referencias;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the referencias package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ClassNotFoundException_QNAME = new QName("http://webservices/", "ClassNotFoundException");
    private final static QName _AltaUsuario_QNAME = new QName("http://webservices/", "altaUsuario");
    private final static QName _AltaUsuarioResponse_QNAME = new QName("http://webservices/", "altaUsuarioResponse");
    private final static QName _Hello_QNAME = new QName("http://webservices/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://webservices/", "helloResponse");
    private final static QName _SignIn_QNAME = new QName("http://webservices/", "signIn");
    private final static QName _SignInResponse_QNAME = new QName("http://webservices/", "signInResponse");
    private final static QName _Valida_QNAME = new QName("http://webservices/", "valida");
    private final static QName _ValidaResponse_QNAME = new QName("http://webservices/", "validaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: referencias
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClassNotFoundException }
     * 
     */
    public ClassNotFoundException createClassNotFoundException() {
        return new ClassNotFoundException();
    }

    /**
     * Create an instance of {@link AltaUsuario }
     * 
     */
    public AltaUsuario createAltaUsuario() {
        return new AltaUsuario();
    }

    /**
     * Create an instance of {@link AltaUsuarioResponse }
     * 
     */
    public AltaUsuarioResponse createAltaUsuarioResponse() {
        return new AltaUsuarioResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link SignIn }
     * 
     */
    public SignIn createSignIn() {
        return new SignIn();
    }

    /**
     * Create an instance of {@link SignInResponse }
     * 
     */
    public SignInResponse createSignInResponse() {
        return new SignInResponse();
    }

    /**
     * Create an instance of {@link Valida }
     * 
     */
    public Valida createValida() {
        return new Valida();
    }

    /**
     * Create an instance of {@link ValidaResponse }
     * 
     */
    public ValidaResponse createValidaResponse() {
        return new ValidaResponse();
    }

    /**
     * Create an instance of {@link Throwable }
     * 
     */
    public Throwable createThrowable() {
        return new Throwable();
    }

    /**
     * Create an instance of {@link StackTraceElement }
     * 
     */
    public StackTraceElement createStackTraceElement() {
        return new StackTraceElement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "ClassNotFoundException")
    public JAXBElement<ClassNotFoundException> createClassNotFoundException(ClassNotFoundException value) {
        return new JAXBElement<ClassNotFoundException>(_ClassNotFoundException_QNAME, ClassNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "altaUsuario")
    public JAXBElement<AltaUsuario> createAltaUsuario(AltaUsuario value) {
        return new JAXBElement<AltaUsuario>(_AltaUsuario_QNAME, AltaUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "altaUsuarioResponse")
    public JAXBElement<AltaUsuarioResponse> createAltaUsuarioResponse(AltaUsuarioResponse value) {
        return new JAXBElement<AltaUsuarioResponse>(_AltaUsuarioResponse_QNAME, AltaUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "signIn")
    public JAXBElement<SignIn> createSignIn(SignIn value) {
        return new JAXBElement<SignIn>(_SignIn_QNAME, SignIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignInResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "signInResponse")
    public JAXBElement<SignInResponse> createSignInResponse(SignInResponse value) {
        return new JAXBElement<SignInResponse>(_SignInResponse_QNAME, SignInResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Valida }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "valida")
    public JAXBElement<Valida> createValida(Valida value) {
        return new JAXBElement<Valida>(_Valida_QNAME, Valida.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "validaResponse")
    public JAXBElement<ValidaResponse> createValidaResponse(ValidaResponse value) {
        return new JAXBElement<ValidaResponse>(_ValidaResponse_QNAME, ValidaResponse.class, null, value);
    }

}
