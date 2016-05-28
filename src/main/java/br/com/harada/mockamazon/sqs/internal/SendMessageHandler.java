package br.com.harada.mockamazon.sqs.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.queue.doc._2012_11_05.ResponseMetadata;
import com.amazonaws.queue.doc._2012_11_05.SendMessage;
import com.amazonaws.queue.doc._2012_11_05.SendMessageResponse;
import com.amazonaws.queue.doc._2012_11_05.SendMessageResult;

import br.com.harada.mockamazon.infra.MD5;
import br.com.harada.mockamazon.sqs.MessageIdGenerator;
import br.com.harada.mockamazon.sqs.ParameterParser;
import br.com.harada.mockamazon.sqs.QueueMessage;
import br.com.harada.mockamazon.sqs.Queues;
import br.com.harada.mockamazon.sqs.SQSHandler;

@Component
class SendMessageHandler implements SQSHandler<SendMessage>{

	@Autowired
	private Queues queues;
	
	@Autowired
	private MessageIdGenerator generator;

	@Override
	public Object handle(SendMessage request, String queue) {
		queues.sendMessage(queue, new QueueMessage(request));
		
		SendMessageResponse response = new SendMessageResponse();
		SendMessageResult result = new SendMessageResult();
		result.setMD5OfMessageBody(MD5.from(request.getMessageBody()).get());
		result.setMD5OfMessageAttributes(MD5.from(request.getMessageAttribute()).orElse(null));
		response.setSendMessageResult(result);
		ResponseMetadata metadata = new ResponseMetadata();
		metadata.setRequestId(generator.nextMessageId());
		response.setResponseMetadata(metadata);
		
		return response;
	}

	@Override
	public String getActionType() {
		return "SendMessage";
	}

	@Override
	public Class<? extends ParameterParser<SendMessage>> getParameterParser() {
		return SendMessagesParameterParser.class;
	}

}
