
package com.amazonaws.sns.doc._2010_03_31;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>A wrapper type for the topic's Amazon Resource Name (ARN). To retrieve a topic's attributes, use GetTopicAttributes.</p>
 * 
 * <p>Classe Java de Topic complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Topic">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TopicArn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Topic", propOrder = {
    "topicArn"
})
public class Topic {

    @XmlElement(name = "TopicArn")
    protected String topicArn;

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

}
