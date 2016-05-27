
package com.amazonaws.queue.doc._2012_11_05;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QueueUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "queueUrl"
})
@XmlRootElement(name = "CreateQueueResult")
public class CreateQueueResult {

    @XmlElement(name = "QueueUrl", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String queueUrl;

    /**
     * Obt�m o valor da propriedade queueUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueueUrl() {
        return queueUrl;
    }

    /**
     * Define o valor da propriedade queueUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueueUrl(String value) {
        this.queueUrl = value;
    }

}
