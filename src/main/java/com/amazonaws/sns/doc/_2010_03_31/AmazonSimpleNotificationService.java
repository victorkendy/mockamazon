
package com.amazonaws.sns.doc._2010_03_31;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * 
 *     <fullname>Amazon Simple Notification Service</fullname>
 *   
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AmazonSimpleNotificationService", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", wsdlLocation = "file:/C:/Users/victor/workspace/mockamazon/amazon_sns.wsdl")
public class AmazonSimpleNotificationService
    extends Service
{

    private final static URL AMAZONSIMPLENOTIFICATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException AMAZONSIMPLENOTIFICATIONSERVICE_EXCEPTION;
    private final static QName AMAZONSIMPLENOTIFICATIONSERVICE_QNAME = new QName("http://sns.amazonaws.com/doc/2010-03-31/", "AmazonSimpleNotificationService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/victor/workspace/mockamazon/amazon_sns.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        AMAZONSIMPLENOTIFICATIONSERVICE_WSDL_LOCATION = url;
        AMAZONSIMPLENOTIFICATIONSERVICE_EXCEPTION = e;
    }

    public AmazonSimpleNotificationService() {
        super(__getWsdlLocation(), AMAZONSIMPLENOTIFICATIONSERVICE_QNAME);
    }

    public AmazonSimpleNotificationService(WebServiceFeature... features) {
        super(__getWsdlLocation(), AMAZONSIMPLENOTIFICATIONSERVICE_QNAME, features);
    }

    public AmazonSimpleNotificationService(URL wsdlLocation) {
        super(wsdlLocation, AMAZONSIMPLENOTIFICATIONSERVICE_QNAME);
    }

    public AmazonSimpleNotificationService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, AMAZONSIMPLENOTIFICATIONSERVICE_QNAME, features);
    }

    public AmazonSimpleNotificationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AmazonSimpleNotificationService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AmazonSimpleNotificationServicePortType
     */
    @WebEndpoint(name = "AmazonSimpleNotificationServicePort")
    public AmazonSimpleNotificationServicePortType getAmazonSimpleNotificationServicePort() {
        return super.getPort(new QName("http://sns.amazonaws.com/doc/2010-03-31/", "AmazonSimpleNotificationServicePort"), AmazonSimpleNotificationServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AmazonSimpleNotificationServicePortType
     */
    @WebEndpoint(name = "AmazonSimpleNotificationServicePort")
    public AmazonSimpleNotificationServicePortType getAmazonSimpleNotificationServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://sns.amazonaws.com/doc/2010-03-31/", "AmazonSimpleNotificationServicePort"), AmazonSimpleNotificationServicePortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (AMAZONSIMPLENOTIFICATIONSERVICE_EXCEPTION!= null) {
            throw AMAZONSIMPLENOTIFICATIONSERVICE_EXCEPTION;
        }
        return AMAZONSIMPLENOTIFICATIONSERVICE_WSDL_LOCATION;
    }

}
