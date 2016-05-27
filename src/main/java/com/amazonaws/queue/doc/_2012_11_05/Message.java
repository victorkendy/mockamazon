
package com.amazonaws.queue.doc._2012_11_05;

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
 *         &lt;element name="MessageId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReceiptHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MD5OfBody" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MD5OfMessageAttributes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Body" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://queue.amazonaws.com/doc/2012-11-05/}Attribute" maxOccurs="unbounded" minOccurs="0"/>
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
    "messageId",
    "receiptHandle",
    "md5OfBody",
    "md5OfMessageAttributes",
    "body",
    "attribute",
    "messageAttribute"
})
@XmlRootElement(name = "Message")
public class Message {

    @XmlElement(name = "MessageId", required = true)
    protected String messageId;
    @XmlElement(name = "ReceiptHandle", required = true)
    protected String receiptHandle;
    @XmlElement(name = "MD5OfBody", required = true)
    protected String md5OfBody;
    @XmlElement(name = "MD5OfMessageAttributes", required = true)
    protected String md5OfMessageAttributes;
    @XmlElement(name = "Body", required = true)
    protected String body;
    @XmlElement(name = "Attribute")
    protected List<Attribute> attribute;
    @XmlElement(name = "MessageAttribute")
    protected List<MessageAttribute> messageAttribute;

    /**
     * Obtém o valor da propriedade messageId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Define o valor da propriedade messageId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageId(String value) {
        this.messageId = value;
    }

    /**
     * Obtém o valor da propriedade receiptHandle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptHandle() {
        return receiptHandle;
    }

    /**
     * Define o valor da propriedade receiptHandle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptHandle(String value) {
        this.receiptHandle = value;
    }

    /**
     * Obtém o valor da propriedade md5OfBody.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMD5OfBody() {
        return md5OfBody;
    }

    /**
     * Define o valor da propriedade md5OfBody.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMD5OfBody(String value) {
        this.md5OfBody = value;
    }

    /**
     * Obtém o valor da propriedade md5OfMessageAttributes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMD5OfMessageAttributes() {
        return md5OfMessageAttributes;
    }

    /**
     * Define o valor da propriedade md5OfMessageAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMD5OfMessageAttributes(String value) {
        this.md5OfMessageAttributes = value;
    }

    /**
     * Obtém o valor da propriedade body.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBody() {
        return body;
    }

    /**
     * Define o valor da propriedade body.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBody(String value) {
        this.body = value;
    }

    /**
     * Gets the value of the attribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attribute }
     * 
     * 
     */
    public List<Attribute> getAttribute() {
        if (attribute == null) {
            attribute = new ArrayList<Attribute>();
        }
        return this.attribute;
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
