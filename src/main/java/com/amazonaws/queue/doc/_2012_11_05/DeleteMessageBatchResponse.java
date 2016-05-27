
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
 *         &lt;element ref="{http://queue.amazonaws.com/doc/2012-11-05/}DeleteMessageBatchResult"/>
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
    "deleteMessageBatchResult",
    "responseMetadata"
})
@XmlRootElement(name = "DeleteMessageBatchResponse")
public class DeleteMessageBatchResponse {

    @XmlElement(name = "DeleteMessageBatchResult", required = true)
    protected DeleteMessageBatchResult deleteMessageBatchResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    /**
     * Obtém o valor da propriedade deleteMessageBatchResult.
     * 
     * @return
     *     possible object is
     *     {@link DeleteMessageBatchResult }
     *     
     */
    public DeleteMessageBatchResult getDeleteMessageBatchResult() {
        return deleteMessageBatchResult;
    }

    /**
     * Define o valor da propriedade deleteMessageBatchResult.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteMessageBatchResult }
     *     
     */
    public void setDeleteMessageBatchResult(DeleteMessageBatchResult value) {
        this.deleteMessageBatchResult = value;
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
