
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
 *         &lt;element name="TopicArn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Token" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AuthenticateOnUnsubscribe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "topicArn",
    "token",
    "authenticateOnUnsubscribe"
})
@XmlRootElement(name = "ConfirmSubscription")
public class ConfirmSubscription {

    @XmlElement(name = "TopicArn", required = true)
    protected String topicArn;
    @XmlElement(name = "Token", required = true)
    protected String token;
    @XmlElement(name = "AuthenticateOnUnsubscribe")
    protected String authenticateOnUnsubscribe;

    /**
     * Obtém o valor da propriedade topicArn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTopicArn() {
        return topicArn;
    }

    /**
     * Define o valor da propriedade topicArn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTopicArn(String value) {
        this.topicArn = value;
    }

    /**
     * Obtém o valor da propriedade token.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Define o valor da propriedade token.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Obtém o valor da propriedade authenticateOnUnsubscribe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthenticateOnUnsubscribe() {
        return authenticateOnUnsubscribe;
    }

    /**
     * Define o valor da propriedade authenticateOnUnsubscribe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthenticateOnUnsubscribe(String value) {
        this.authenticateOnUnsubscribe = value;
    }

}
