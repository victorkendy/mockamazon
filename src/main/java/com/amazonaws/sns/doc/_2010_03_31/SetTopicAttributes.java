
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
 *         &lt;element name="AttributeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AttributeValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "attributeName",
    "attributeValue"
})
@XmlRootElement(name = "SetTopicAttributes")
public class SetTopicAttributes {

    @XmlElement(name = "TopicArn", required = true)
    protected String topicArn;
    @XmlElement(name = "AttributeName", required = true)
    protected String attributeName;
    @XmlElement(name = "AttributeValue", required = true)
    protected String attributeValue;

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
     * Obtém o valor da propriedade attributeName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * Define o valor da propriedade attributeName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeName(String value) {
        this.attributeName = value;
    }

    /**
     * Obtém o valor da propriedade attributeValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeValue() {
        return attributeValue;
    }

    /**
     * Define o valor da propriedade attributeValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeValue(String value) {
        this.attributeValue = value;
    }

}
