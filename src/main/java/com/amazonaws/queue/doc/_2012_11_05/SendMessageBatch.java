
package com.amazonaws.queue.doc._2012_11_05;

import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element ref="{http://queue.amazonaws.com/doc/2012-11-05/}SendMessageBatchRequestEntry" maxOccurs="unbounded"/>
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
    "sendMessageBatchRequestEntry"
})
@XmlRootElement(name = "SendMessageBatch")
public class SendMessageBatch {

    @XmlElement(name = "SendMessageBatchRequestEntry", required = true)
    protected List<SendMessageBatchRequestEntry> sendMessageBatchRequestEntry;

    /**
     * Gets the value of the sendMessageBatchRequestEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sendMessageBatchRequestEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSendMessageBatchRequestEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SendMessageBatchRequestEntry }
     * 
     * 
     */
    public List<SendMessageBatchRequestEntry> getSendMessageBatchRequestEntry() {
        if (sendMessageBatchRequestEntry == null) {
            sendMessageBatchRequestEntry = new ArrayList<SendMessageBatchRequestEntry>();
        }
        return this.sendMessageBatchRequestEntry;
    }

}
