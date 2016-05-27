
package com.amazonaws.queue.doc._2012_11_05;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de MessageAttributeValue complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="MessageAttributeValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="StringValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="BinaryValue" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;/choice>
 *         &lt;element name="DataType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageAttributeValue", propOrder = {
    "stringValue",
    "binaryValue",
    "dataType"
})
public class MessageAttributeValue {

    @XmlElement(name = "StringValue")
    protected String stringValue;
    @XmlElement(name = "BinaryValue")
    protected byte[] binaryValue;
    @XmlElement(name = "DataType", required = true)
    protected String dataType;

    /**
     * Obtém o valor da propriedade stringValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * Define o valor da propriedade stringValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStringValue(String value) {
        this.stringValue = value;
    }

    /**
     * Obtém o valor da propriedade binaryValue.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBinaryValue() {
        return binaryValue;
    }

    /**
     * Define o valor da propriedade binaryValue.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBinaryValue(byte[] value) {
        this.binaryValue = value;
    }

    /**
     * Obtém o valor da propriedade dataType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * Define o valor da propriedade dataType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataType(String value) {
        this.dataType = value;
    }

}
