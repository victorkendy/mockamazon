package br.com.harada.mockamazon.sqs.internal;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.queue.doc._2012_11_05.Message;
import com.amazonaws.queue.doc._2012_11_05.ReceiveMessage;
import com.amazonaws.queue.doc._2012_11_05.ReceiveMessageResponse;
import com.amazonaws.queue.doc._2012_11_05.ReceiveMessageResult;
import com.amazonaws.queue.doc._2012_11_05.ResponseMetadata;

import br.com.harada.mockamazon.RequestIdGenerator;
import br.com.harada.mockamazon.infra.MD5;
import br.com.harada.mockamazon.sqs.MessageInFlight;
import br.com.harada.mockamazon.sqs.Queues;
import br.com.harada.mockamazon.sqs.SQSHandler;

@Component
class ReceiveMessageHandler extends SQSHandler<ReceiveMessage>{

	private Queues queues;
	
	private RequestIdGenerator generator;

	@Autowired
	ReceiveMessageHandler(Queues queues, RequestIdGenerator generator) {
		super(ReceiveMessage.class);
		this.queues = queues;
		this.generator = generator;
	}

	@Override
	public Object handle(ReceiveMessage request, String queue) {
		int maxNumberOfMessages = Optional.ofNullable(request.getMaxNumberOfMessages()).orElse(BigInteger.ONE).intValue();
		int requestWaitTimeout = Optional.ofNullable(request.getWaitTimeSeconds()).orElse(new BigInteger("5")).intValue();
		List<MessageInFlight> nextMessages = queues.poll(queue, maxNumberOfMessages, requestWaitTimeout);

		ReceiveMessageResponse response = new ReceiveMessageResponse();
		ResponseMetadata metadata = new ResponseMetadata();
		metadata.setRequestId(generator.nextRequestId());
		response.setResponseMetadata(metadata);
		ReceiveMessageResult result = new ReceiveMessageResult();
		for (MessageInFlight nextMessage : nextMessages) {
			Message message = new Message();
			message.setBody(nextMessage.getBody());
			message.setMD5OfBody(MD5.from(message.getBody()).get());
			message.setMessageId(nextMessage.getId());
			message.setReceiptHandle(nextMessage.getReceiptHandle());
			message.getMessageAttribute().addAll(nextMessage.getAttributes());
			message.setMD5OfMessageAttributes(MD5.from(message.getMessageAttribute()).orElse(null));
			result.getMessage().add(message);
		}
		response.setReceiveMessageResult(result);
		
		return response;
	}

	@Override
	public String getActionType() {
		return "ReceiveMessage";
	}
}
