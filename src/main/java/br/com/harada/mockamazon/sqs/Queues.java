package br.com.harada.mockamazon.sqs;

import java.util.List;

public interface Queues {
	void sendMessage(String queue, QueueMessage request);
	
	List<MessageInFlight> poll(String queue, Integer maxMessages, Integer timeout);
	
	void remove(String id);
}
