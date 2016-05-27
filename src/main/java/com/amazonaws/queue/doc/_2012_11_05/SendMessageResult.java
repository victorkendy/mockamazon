
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
 *         &lt;element name="MessageId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MD5OfMessageBody" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MD5OfMessageAttributes" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "md5OfMessageBody",
    "md5OfMessageAttributes"
})
@XmlRootElement(name = "SendMessageResult")
public class SendMessageResult {

    @XmlElement(name = "MessageId", required = true)
    protected String messageId;
    @XmlElement(name = "MD5OfMessageBody", required = true)
    protected String md5OfMessageBody;
    @XmlElement(name = "MD5OfMessageAttributes", required = true)
    protected String md5OfMessageAttributes;

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
     * Obtém o valor da propriedade md5OfMessageBody.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMD5OfMessageBody() {
        return md5OfMessageBody;
    }

    /**
     * Define o valor da propriedade md5OfMessageBody.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMD5OfMessageBody(String value) {
        this.md5OfMessageBody = value;
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

}
