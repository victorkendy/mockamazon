
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
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://queue.amazonaws.com/doc/2012-11-05/}DeleteMessageBatchResultEntry" maxOccurs="unbounded"/>
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
    "deleteMessageBatchResultEntry",
    "batchResultErrorEntry"
})
@XmlRootElement(name = "DeleteMessageBatchResult")
public class DeleteMessageBatchResult {

    @XmlElement(name = "DeleteMessageBatchResultEntry", required = true)
    protected List<DeleteMessageBatchResultEntry> deleteMessageBatchResultEntry;
    @XmlElement(name = "BatchResultErrorEntry", required = true)
    protected List<BatchResultErrorEntry> batchResultErrorEntry;

    /**
     * Gets the value of the deleteMessageBatchResultEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deleteMessageBatchResultEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeleteMessageBatchResultEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeleteMessageBatchResultEntry }
     * 
     * 
     */
    public List<DeleteMessageBatchResultEntry> getDeleteMessageBatchResultEntry() {
        if (deleteMessageBatchResultEntry == null) {
            deleteMessageBatchResultEntry = new ArrayList<DeleteMessageBatchResultEntry>();
        }
        return this.deleteMessageBatchResultEntry;
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
