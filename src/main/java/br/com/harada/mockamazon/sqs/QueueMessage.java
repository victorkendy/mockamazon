package br.com.harada.mockamazon.sqs;

import java.util.List;

import com.amazonaws.queue.doc._2012_11_05.MessageAttribute;
import com.amazonaws.queue.doc._2012_11_05.SendMessage;

public class QueueMessage {

	private List<MessageAttribute> attributes;
	private String body;

	public QueueMessage(SendMessage message) {
		this.attributes = message.getMessageAttribute();
		this.body = message.getMessageBody();
	}
	
	public QueueMessage(String body, List<MessageAttribute> attributes) {
		this.body = body;
		this.attributes = attributes;
		
	}

	public List<MessageAttribute> getAttributes() {
		return attributes;
	}

	public String getBody() {
		return body;
	}
}
