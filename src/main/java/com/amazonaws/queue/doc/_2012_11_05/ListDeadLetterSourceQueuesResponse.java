
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
 *         &lt;element ref="{http://queue.amazonaws.com/doc/2012-11-05/}ListDeadLetterSourceQueuesResult"/>
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
    "listDeadLetterSourceQueuesResult",
    "responseMetadata"
})
@XmlRootElement(name = "ListDeadLetterSourceQueuesResponse")
public class ListDeadLetterSourceQueuesResponse {

    @XmlElement(name = "ListDeadLetterSourceQueuesResult", required = true)
    protected ListDeadLetterSourceQueuesResult listDeadLetterSourceQueuesResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    /**
     * Obtém o valor da propriedade listDeadLetterSourceQueuesResult.
     * 
     * @return
     *     possible object is
     *     {@link ListDeadLetterSourceQueuesResult }
     *     
     */
    public ListDeadLetterSourceQueuesResult getListDeadLetterSourceQueuesResult() {
        return listDeadLetterSourceQueuesResult;
    }

    /**
     * Define o valor da propriedade listDeadLetterSourceQueuesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ListDeadLetterSourceQueuesResult }
     *     
     */
    public void setListDeadLetterSourceQueuesResult(ListDeadLetterSourceQueuesResult value) {
        this.listDeadLetterSourceQueuesResult = value;
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
