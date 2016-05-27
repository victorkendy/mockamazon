
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
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MessageBody" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DelaySeconds" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element ref="{http://queue.amazonaws.com/doc/2012-11-05/}MessageAttribute" maxOccurs="unbounded" minOccurs="0"/>
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
    "id",
    "messageBody",
    "delaySeconds",
    "messageAttribute"
})
@XmlRootElement(name = "SendMessageBatchRequestEntry")
public class SendMessageBatchRequestEntry {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "MessageBody", required = true)
    protected String messageBody;
    @XmlElement(name = "DelaySeconds")
    protected BigInteger delaySeconds;
    @XmlElement(name = "MessageAttribute")
    protected List<MessageAttribute> messageAttribute;

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade messageBody.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageBody() {
        return messageBody;
    }

    /**
     * Define o valor da propriedade messageBody.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageBody(String value) {
        this.messageBody = value;
    }

    /**
     * Obtém o valor da propriedade delaySeconds.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDelaySeconds() {
        return delaySeconds;
    }

    /**
     * Define o valor da propriedade delaySeconds.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDelaySeconds(BigInteger value) {
        this.delaySeconds = value;
    }

    /**
     * Gets the value of the messageAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessageAttribute }
     * 
     * 
     */
    public List<MessageAttribute> getMessageAttribute() {
        if (messageAttribute == null) {
            messageAttribute = new ArrayList<MessageAttribute>();
        }
        return this.messageAttribute;
    }

}
