
package com.amazonaws.sns.doc._2010_03_31;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
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
@XmlType(name = "", propOrder = {
    "topicArn"
})
@XmlRootElement(name = "CreateTopicResult")
public class CreateTopicResult {

    @XmlElement(name = "TopicArn")
    protected String topicArn;

    /**
     * Obt�m o valor da propriedade topicArn.
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
