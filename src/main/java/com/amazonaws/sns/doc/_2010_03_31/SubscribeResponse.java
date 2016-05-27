
package com.amazonaws.sns.doc._2010_03_31;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element ref="{http://sns.amazonaws.com/doc/2010-03-31/}SubscribeResult"/>
 *         &lt;element ref="{http://sns.amazonaws.com/doc/2010-03-31/}ResponseMetadata"/>
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
    "subscribeResult",
    "responseMetadata"
})
@XmlRootElement(name = "SubscribeResponse")
public class SubscribeResponse {

    @XmlElement(name = "SubscribeResult", required = true)
    protected SubscribeResult subscribeResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    /**
     * Obt�m o valor da propriedade subscribeResult.
     * 
     * @return
     *     possible object is
     *     {@link SubscribeResult }
     *     
     */
    public SubscribeResult getSubscribeResult() {
        return subscribeResult;
    }

    /**
     * Define o valor da propriedade subscribeResult.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscribeResult }
     *     
     */
    public void setSubscribeResult(SubscribeResult value) {
        this.subscribeResult = value;
    }

    /**
     * Obt�m o valor da propriedade responseMetadata.
     * 
     * @return
     *     possible object is
     *     {@link ResponseMetadata }
     *     
     */
    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

    /**
     * Define o valor da propriedade responseMetadata.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseMetadata }
     *     
     */
    public void setResponseMetadata(ResponseMetadata value) {
        this.responseMetadata = value;
    }

}