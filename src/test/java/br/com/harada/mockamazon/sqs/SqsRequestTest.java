package br.com.harada.mockamazon.sqs;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class SqsRequestTest {
	
	private AmazonSQS sqs;

	private static String QUEUE = "queue";
	@Before
	public void setup() {
		AWSCredentials credentials = new BasicAWSCredentials("key", "secret");
        sqs = new AmazonSQSClient(credentials);
        sqs.setEndpoint("http://localhost:8080/sqs");
	}

	@Test
	public void send_message() throws Exception {
		SendMessageRequest send = new SendMessageRequest(QUEUE, "test body 1");
		send.addMessageAttributesEntry("contentType", new MessageAttributeValue()
				.withStringValue("text/plain")
				.withDataType("String"));
		send.addMessageAttributesEntry("contentType2", new MessageAttributeValue()
				.withStringValue("application/json")
				.withDataType("String"));
		sqs.sendMessage(send);
	}
	
	@Test
	public void receive_message() throws Exception {
		ReceiveMessageRequest receive = new ReceiveMessageRequest(QUEUE );
		receive.setMaxNumberOfMessages(10);
		receive.setWaitTimeSeconds(10);
		
		List<Message> messages = sqs.receiveMessage(receive).getMessages();
		for (Message message : messages) {
			System.out.println(message.getBody());
			for (Entry<String, MessageAttributeValue> attr : message.getMessageAttributes().entrySet()) {
				System.out.println(attr.getKey() + " -> " + attr.getValue().getStringValue() + "(" + attr.getValue().getDataType() + ")");
			}
		}
		Optional<Message> first = messages.stream().findFirst();
		if(first.isPresent()) {
			DeleteMessageRequest request = new DeleteMessageRequest(QUEUE, first.get().getReceiptHandle());
			sqs.deleteMessage(request);
		}
	}
	
	@Test
	public void receive_message_delete_batch() throws Exception {
		ReceiveMessageRequest receive = new ReceiveMessageRequest(QUEUE );
		receive.setMaxNumberOfMessages(10);
		receive.setWaitTimeSeconds(10);
		
		List<Message> messages = sqs.receiveMessage(receive).getMessages();
		for (Message message : messages) {
			System.out.println(message.getBody());
			for (Entry<String, MessageAttributeValue> attr : message.getMessageAttributes().entrySet()) {
				System.out.println(attr.getKey() + " -> " + attr.getValue().getStringValue() + "(" + attr.getValue().getDataType() + ")");
			}
		}
		
		DeleteMessageBatchRequest deleteRequest = new DeleteMessageBatchRequest(QUEUE);
		AtomicInteger counter = new AtomicInteger();
		deleteRequest.withEntries(
				messages.stream().map(
						m->new DeleteMessageBatchRequestEntry("" + counter.incrementAndGet(), m.getReceiptHandle())
				).collect(Collectors.toList()));
		sqs.deleteMessageBatch(deleteRequest);
	}
	
	@Test
	public void send_message_batch() throws Exception {
		SendMessageBatchRequest request = new SendMessageBatchRequest(QUEUE);
		Map<String, MessageAttributeValue> attributes = new HashMap<>();
		attributes.put("contentType", new MessageAttributeValue().withStringValue("application/json").withDataType("String"));
		SendMessageBatchRequestEntry entry1 = new SendMessageBatchRequestEntry().withId("1").withMessageBody("Message Body in Batch").withMessageAttributes(attributes);
		SendMessageBatchRequestEntry entry2 = new SendMessageBatchRequestEntry().withId("2").withMessageBody("Another Message Body in Batch").withMessageAttributes(attributes);
		request.withEntries(entry1, entry2);
		sqs.sendMessageBatch(request);
	}
}
