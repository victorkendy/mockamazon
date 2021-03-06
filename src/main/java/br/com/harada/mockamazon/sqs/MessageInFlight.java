package br.com.harada.mockamazon.sqs;

import java.util.List;

import com.amazonaws.queue.doc._2012_11_05.MessageAttribute;

public class MessageInFlight {
	private String id;
	
	private String body;

	private List<MessageAttribute> attributes;

	private String receiptHandle;
	
	public MessageInFlight(String id, String body, List<MessageAttribute> attributes, String receiptHandle) {
		this.id = id;
		this.body = body;
		this.attributes = attributes;
		this.receiptHandle = receiptHandle;
	}

	public String getId() {
		return id;
	}

	public String getBody() {
		return body;
	}
	
	public List<MessageAttribute> getAttributes() {
		return attributes;
	}
	
	public String getReceiptHandle() {
		return receiptHandle;
	}
}
