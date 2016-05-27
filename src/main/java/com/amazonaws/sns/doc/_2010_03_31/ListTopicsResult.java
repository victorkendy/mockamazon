
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
 *         &lt;element name="Topics" type="{http://sns.amazonaws.com/doc/2010-03-31/}TopicsList" minOccurs="0"/>
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
    "topics",
    "nextToken"
})
@XmlRootElement(name = "ListTopicsResult")
public class ListTopicsResult {

    @XmlElement(name = "Topics")
    protected TopicsList topics;
    @XmlElement(name = "NextToken")
    protected String nextToken;

    /**
     * Obtém o valor da propriedade topics.
     * 
     * @return
     *     possible object is
     *     {@link TopicsList }
     *     
     */
    public TopicsList getTopics() {
        return topics;
    }

    /**
     * Define o valor da propriedade topics.
     * 
     * @param value
     *     allowed object is
     *     {@link TopicsList }
     *     
     */
    public void setTopics(TopicsList value) {
        this.topics = value;
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
