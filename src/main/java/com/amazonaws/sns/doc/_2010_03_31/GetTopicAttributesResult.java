
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
 *         &lt;element name="Attributes" type="{http://sns.amazonaws.com/doc/2010-03-31/}TopicAttributesMap" minOccurs="0"/>
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
    "attributes"
})
@XmlRootElement(name = "GetTopicAttributesResult")
public class GetTopicAttributesResult {

    @XmlElement(name = "Attributes")
    protected TopicAttributesMap attributes;

    /**
     * Obtém o valor da propriedade attributes.
     * 
     * @return
     *     possible object is
     *     {@link TopicAttributesMap }
     *     
     */
    public TopicAttributesMap getAttributes() {
        return attributes;
    }

    /**
     * Define o valor da propriedade attributes.
     * 
     * @param value
     *     allowed object is
     *     {@link TopicAttributesMap }
     *     
     */
    public void setAttributes(TopicAttributesMap value) {
        this.attributes = value;
    }

}
