
package com.amazonaws.queue.doc._2012_11_05;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://queue.amazonaws.com/doc/2012-11-05/}GetQueueAttributesResult"/>
 *         &lt;element ref="{http://queue.amazonaws.com/doc/2012-11-05/}ResponseMetadata"/>
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
    "getQueueAttributesResult",
    "responseMetadata"
})
@XmlRootElement(name = "GetQueueAttributesResponse")
public class GetQueueAttributesResponse {

    @XmlElement(name = "GetQueueAttributesResult", required = true)
    protected GetQueueAttributesResult getQueueAttributesResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    /**
     * Obtém o valor da propriedade getQueueAttributesResult.
     * 
     * @return
     *     possible object is
     *     {@link GetQueueAttributesResult }
     *     
     */
    public GetQueueAttributesResult getGetQueueAttributesResult() {
        return getQueueAttributesResult;
    }

    /**
     * Define o valor da propriedade getQueueAttributesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link GetQueueAttributesResult }
     *     
     */
    public void setGetQueueAttributesResult(GetQueueAttributesResult value) {
        this.getQueueAttributesResult = value;
    }

    /**
     * Obtém o valor da propriedade responseMetadata.
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
