
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
 *         &lt;element ref="{http://queue.amazonaws.com/doc/2012-11-05/}DeleteMessageBatchRequestEntry" maxOccurs="unbounded"/>
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
    "deleteMessageBatchRequestEntry"
})
@XmlRootElement(name = "DeleteMessageBatch")
public class DeleteMessageBatch {

    @XmlElement(name = "DeleteMessageBatchRequestEntry", required = true)
    protected List<DeleteMessageBatchRequestEntry> deleteMessageBatchRequestEntry;

    /**
     * Gets the value of the deleteMessageBatchRequestEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deleteMessageBatchRequestEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeleteMessageBatchRequestEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeleteMessageBatchRequestEntry }
     * 
     * 
     */
    public List<DeleteMessageBatchRequestEntry> getDeleteMessageBatchRequestEntry() {
        if (deleteMessageBatchRequestEntry == null) {
            deleteMessageBatchRequestEntry = new ArrayList<DeleteMessageBatchRequestEntry>();
        }
        return this.deleteMessageBatchRequestEntry;
    }

}
