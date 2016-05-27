
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
 *         &lt;element ref="{http://sns.amazonaws.com/doc/2010-03-31/}ListSubscriptionsByTopicResult"/>
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
    "listSubscriptionsByTopicResult",
    "responseMetadata"
})
@XmlRootElement(name = "ListSubscriptionsByTopicResponse")
public class ListSubscriptionsByTopicResponse {

    @XmlElement(name = "ListSubscriptionsByTopicResult", required = true)
    protected ListSubscriptionsByTopicResult listSubscriptionsByTopicResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    /**
     * Obtém o valor da propriedade listSubscriptionsByTopicResult.
     * 
     * @return
     *     possible object is
     *     {@link ListSubscriptionsByTopicResult }
     *     
     */
    public ListSubscriptionsByTopicResult getListSubscriptionsByTopicResult() {
        return listSubscriptionsByTopicResult;
    }

    /**
     * Define o valor da propriedade listSubscriptionsByTopicResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ListSubscriptionsByTopicResult }
     *     
     */
    public void setListSubscriptionsByTopicResult(ListSubscriptionsByTopicResult value) {
        this.listSubscriptionsByTopicResult = value;
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
