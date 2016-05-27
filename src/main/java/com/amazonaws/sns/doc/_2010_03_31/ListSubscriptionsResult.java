
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
 *         &lt;element name="Subscriptions" type="{http://sns.amazonaws.com/doc/2010-03-31/}SubscriptionsList" minOccurs="0"/>
 *         &lt;element name="NextToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "subscriptions",
    "nextToken"
})
@XmlRootElement(name = "ListSubscriptionsResult")
public class ListSubscriptionsResult {

    @XmlElement(name = "Subscriptions")
    protected SubscriptionsList subscriptions;
    @XmlElement(name = "NextToken")
    protected String nextToken;

    /**
     * Obtém o valor da propriedade subscriptions.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionsList }
     *     
     */
    public SubscriptionsList getSubscriptions() {
        return subscriptions;
    }

    /**
     * Define o valor da propriedade subscriptions.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionsList }
     *     
     */
    public void setSubscriptions(SubscriptionsList value) {
        this.subscriptions = value;
    }

    /**
     * Obtém o valor da propriedade nextToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextToken() {
        return nextToken;
    }

    /**
     * Define o valor da propriedade nextToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextToken(String value) {
        this.nextToken = value;
    }

}
