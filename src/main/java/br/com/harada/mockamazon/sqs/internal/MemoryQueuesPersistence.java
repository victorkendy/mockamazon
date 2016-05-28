package br.com.harada.mockamazon.sqs.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.harada.mockamazon.sqs.MessageIdGenerator;
import br.com.harada.mockamazon.sqs.MessageInFlight;
import br.com.harada.mockamazon.sqs.QueueMessage;
import br.com.harada.mockamazon.sqs.Queues;

@Component
class MemoryQueuesPersistence implements Queues{
	
	private ConcurrentHashMap<String, BlockingQueue<QueueMessage>> messages = new ConcurrentHashMap<>();
	private ConcurrentHashMap<String, MessageInFlight> messagesInFlight = new ConcurrentHashMap<>();
	
	@Autowired
	private MessageIdGenerator generator;

	@Override
	public void sendMessage(String queue, QueueMessage request) {
		messages.computeIfAbsent(queue, k->new LinkedBlockingQueue<>()).add(request);
		request.setId(generator.nextMessageId());
	}

	@Override
	public List<MessageInFlight> poll(String queueName, Integer maxMessages, Integer timeout) {
		try{
			BlockingQueue<QueueMessage> queue = messages.get(queueName);
			if(queue != null) {
				ArrayList<QueueMessage> polledMessages = new ArrayList<>();
				queue.drainTo(polledMessages, maxMessages);
				if(polledMessages.isEmpty()) {
					QueueMessage possibleMessage = queue.poll(timeout, TimeUnit.SECONDS);
					if(possibleMessage != null) {
						polledMessages.add(possibleMessage);
					}
				}
				List<MessageInFlight> result = new ArrayList<>();
				for (QueueMessage message : polledMessages) {
					MessageInFlight messageInFlight = new MessageInFlight(message.getId(), message.getBody(), message.getAttributes(), generator.nextMessageId());
					messagesInFlight.put(messageInFlight.getReceiptHandle(), messageInFlight);
					result.add(messageInFlight);
				}
				
				return result;
			}
			return Collections.emptyList();
		} catch(Exception e) {
			return Collections.emptyList();
		}
	}

	@Override
	public void remove(String receiptHandle) {
		messagesInFlight.remove(receiptHandle);
	}

}
