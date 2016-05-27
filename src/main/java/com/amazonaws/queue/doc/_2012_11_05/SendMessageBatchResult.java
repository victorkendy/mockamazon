
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
 *         &lt;element ref="{http://queue.amazonaws.com/doc/2012-11-05/}SendMessageBatchResultEntry" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://queue.amazonaws.com/doc/2012-11-05/}BatchResultErrorEntry" maxOccurs="unbounded"/>
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
    "sendMessageBatchResultEntry",
    "batchResultErrorEntry"
})
@XmlRootElement(name = "SendMessageBatchResult")
public class SendMessageBatchResult {

    @XmlElement(name = "SendMessageBatchResultEntry", required = true)
    protected List<SendMessageBatchResultEntry> sendMessageBatchResultEntry;
    @XmlElement(name = "BatchResultErrorEntry", required = true)
    protected List<BatchResultErrorEntry> batchResultErrorEntry;

    /**
     * Gets the value of the sendMessageBatchResultEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sendMessageBatchResultEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSendMessageBatchResultEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SendMessageBatchResultEntry }
     * 
     * 
     */
    public List<SendMessageBatchResultEntry> getSendMessageBatchResultEntry() {
        if (sendMessageBatchResultEntry == null) {
            sendMessageBatchResultEntry = new ArrayList<SendMessageBatchResultEntry>();
        }
        return this.sendMessageBatchResultEntry;
    }

    /**
     * Gets the value of the batchResultErrorEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the batchResultErrorEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBatchResultErrorEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BatchResultErrorEntry }
     * 
     * 
     */
    public List<BatchResultErrorEntry> getBatchResultErrorEntry() {
        if (batchResultErrorEntry == null) {
            batchResultErrorEntry = new ArrayList<BatchResultErrorEntry>();
        }
        return this.batchResultErrorEntry;
    }

}
