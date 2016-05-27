
package com.amazonaws.queue.doc._2012_11_05;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element name="MaxNumberOfMessages" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="VisibilityTimeout" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="WaitTimeSeconds" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="AttributeName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MessageAttributeName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Unused" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "maxNumberOfMessages",
    "visibilityTimeout",
    "waitTimeSeconds",
    "attributeName",
    "messageAttributeName",
    "unused"
})
@XmlRootElement(name = "ReceiveMessage")
public class ReceiveMessage {

    @XmlElement(name = "MaxNumberOfMessages")
    protected BigInteger maxNumberOfMessages;
    @XmlElement(name = "VisibilityTimeout")
    protected BigInteger visibilityTimeout;
    @XmlElement(name = "WaitTimeSeconds")
    protected BigInteger waitTimeSeconds;
    @XmlElement(name = "AttributeName")
    protected List<String> attributeName;
    @XmlElement(name = "MessageAttributeName")
    protected List<String> messageAttributeName;
    @XmlElement(name = "Unused")
    protected String unused;

    /**
     * Obtém o valor da propriedade maxNumberOfMessages.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxNumberOfMessages() {
        return maxNumberOfMessages;
    }

    /**
     * Define o valor da propriedade maxNumberOfMessages.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxNumberOfMessages(BigInteger value) {
        this.maxNumberOfMessages = value;
    }

    /**
     * Obtém o valor da propriedade visibilityTimeout.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVisibilityTimeout() {
        return visibilityTimeout;
    }

    /**
     * Define o valor da propriedade visibilityTimeout.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVisibilityTimeout(BigInteger value) {
        this.visibilityTimeout = value;
    }

    /**
     * Obtém o valor da propriedade waitTimeSeconds.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWaitTimeSeconds() {
        return waitTimeSeconds;
    }

    /**
     * Define o valor da propriedade waitTimeSeconds.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWaitTimeSeconds(BigInteger value) {
        this.waitTimeSeconds = value;
    }

    /**
     * Gets the value of the attributeName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributeName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAttributeName() {
        if (attributeName == null) {
            attributeName = new ArrayList<String>();
        }
        return this.attributeName;
    }

    /**
     * Gets the value of the messageAttributeName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageAttributeName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageAttributeName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMessageAttributeName() {
        if (messageAttributeName == null) {
            messageAttributeName = new ArrayList<String>();
        }
        return this.messageAttributeName;
    }

    /**
     * Obtém o valor da propriedade unused.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnused() {
        return unused;
    }

    /**
     * Define o valor da propriedade unused.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnused(String value) {
        this.unused = value;
    }

}
