
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
 *         &lt;element name="QueueName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="QueueOwnerAWSAccountId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "queueName",
    "queueOwnerAWSAccountId"
})
@XmlRootElement(name = "GetQueueUrl")
public class GetQueueUrl {

    @XmlElement(name = "QueueName", required = true)
    protected String queueName;
    @XmlElement(name = "QueueOwnerAWSAccountId")
    protected String queueOwnerAWSAccountId;

    /**
     * Obtém o valor da propriedade queueName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueueName() {
        return queueName;
    }

    /**
     * Define o valor da propriedade queueName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueueName(String value) {
        this.queueName = value;
    }

    /**
     * Obtém o valor da propriedade queueOwnerAWSAccountId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueueOwnerAWSAccountId() {
        return queueOwnerAWSAccountId;
    }

    /**
     * Define o valor da propriedade queueOwnerAWSAccountId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueueOwnerAWSAccountId(String value) {
        this.queueOwnerAWSAccountId = value;
    }

}
