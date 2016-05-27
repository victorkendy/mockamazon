
package com.amazonaws.sns.doc._2010_03_31;

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
 *         &lt;element ref="{http://sns.amazonaws.com/doc/2010-03-31/}GetTopicAttributesResult"/>
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
    "getTopicAttributesResult",
    "responseMetadata"
})
@XmlRootElement(name = "GetTopicAttributesResponse")
public class GetTopicAttributesResponse {

    @XmlElement(name = "GetTopicAttributesResult", required = true)
    protected GetTopicAttributesResult getTopicAttributesResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    /**
     * Obtém o valor da propriedade getTopicAttributesResult.
     * 
     * @return
     *     possible object is
     *     {@link GetTopicAttributesResult }
     *     
     */
    public GetTopicAttributesResult getGetTopicAttributesResult() {
        return getTopicAttributesResult;
    }

    /**
     * Define o valor da propriedade getTopicAttributesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link GetTopicAttributesResult }
     *     
     */
    public void setGetTopicAttributesResult(GetTopicAttributesResult value) {
        this.getTopicAttributesResult = value;
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
