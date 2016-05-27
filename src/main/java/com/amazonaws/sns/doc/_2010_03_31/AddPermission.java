
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
 *         &lt;element name="Label" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AWSAccountId" type="{http://sns.amazonaws.com/doc/2010-03-31/}DelegatesList"/>
 *         &lt;element name="ActionName" type="{http://sns.amazonaws.com/doc/2010-03-31/}ActionsList"/>
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
    "label",
    "awsAccountId",
    "actionName"
})
@XmlRootElement(name = "AddPermission")
public class AddPermission {

    @XmlElement(name = "TopicArn", required = true)
    protected String topicArn;
    @XmlElement(name = "Label", required = true)
    protected String label;
    @XmlElement(name = "AWSAccountId", required = true)
    protected DelegatesList awsAccountId;
    @XmlElement(name = "ActionName", required = true)
    protected ActionsList actionName;

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
     * Obtém o valor da propriedade label.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Define o valor da propriedade label.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Obtém o valor da propriedade awsAccountId.
     * 
     * @return
     *     possible object is
     *     {@link DelegatesList }
     *     
     */
    public DelegatesList getAWSAccountId() {
        return awsAccountId;
    }

    /**
     * Define o valor da propriedade awsAccountId.
     * 
     * @param value
     *     allowed object is
     *     {@link DelegatesList }
     *     
     */
    public void setAWSAccountId(DelegatesList value) {
        this.awsAccountId = value;
    }

    /**
     * Obtém o valor da propriedade actionName.
     * 
     * @return
     *     possible object is
     *     {@link ActionsList }
     *     
     */
    public ActionsList getActionName() {
        return actionName;
    }

    /**
     * Define o valor da propriedade actionName.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionsList }
     *     
     */
    public void setActionName(ActionsList value) {
        this.actionName = value;
    }

}
