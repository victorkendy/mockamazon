package br.com.harada.mockamazon.sqs.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.queue.doc._2012_11_05.ResponseMetadata;
import com.amazonaws.queue.doc._2012_11_05.SendMessage;
import com.amazonaws.queue.doc._2012_11_05.SendMessageResponse;
import com.amazonaws.queue.doc._2012_11_05.SendMessageResult;

import br.com.harada.mockamazon.RequestIdGenerator;
import br.com.harada.mockamazon.infra.MD5;
import br.com.harada.mockamazon.sqs.QueueMessage;
import br.com.harada.mockamazon.sqs.Queues;
import br.com.harada.mockamazon.sqs.SQSHandler;

@Component
class SendMessageHandler extends SQSHandler<SendMessage>{

	private Queues queues;
	
	private RequestIdGenerator generator;

	@Autowired
	public SendMessageHandler(Queues queues, RequestIdGenerator generator) {
		super(SendMessage.class);
		this.queues = queues;
		this.generator = generator;
	}

	@Override
	public Object handle(SendMessage request, String queue) {
		QueueMessage queueMessage = new QueueMessage(request);
		queues.sendMessage(queue, queueMessage);
		
		SendMessageResponse response = new SendMessageResponse();
		SendMessageResult result = new SendMessageResult();
		result.setMessageId(queueMessage.getId());
		result.setMD5OfMessageBody(MD5.from(request.getMessageBody()).get());
		result.setMD5OfMessageAttributes(MD5.from(request.getMessageAttribute()).orElse(null));
		response.setSendMessageResult(result);
		ResponseMetadata metadata = new ResponseMetadata();
		metadata.setRequestId(generator.nextRequestId());
		response.setResponseMetadata(metadata);
		
		return response;
	}

	@Override
	public String getActionType() {
		return "SendMessage";
	}
}
