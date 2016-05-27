package br.com.harada.mockamazon.sqs.internal;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.queue.doc._2012_11_05.Message;
import com.amazonaws.queue.doc._2012_11_05.ReceiveMessage;
import com.amazonaws.queue.doc._2012_11_05.ReceiveMessageResponse;
import com.amazonaws.queue.doc._2012_11_05.ReceiveMessageResult;
import com.amazonaws.queue.doc._2012_11_05.ResponseMetadata;

import br.com.harada.mockamazon.infra.MD5;
import br.com.harada.mockamazon.sqs.MessageInFlight;
import br.com.harada.mockamazon.sqs.Queues;
import br.com.harada.mockamazon.sqs.RequestIdGenerator;
import br.com.harada.mockamazon.sqs.SQSHandler;

@Component
class ReceiveMessageHandler implements SQSHandler{

	@Autowired
	private Queues queues;
	
	@Autowired
	private ReceiveMessageParamsParser parser;
	
	@Autowired
	private RequestIdGenerator generator;
	
	@Override
	public Object handle(Map<String, String[]> params, String queue) {
		ReceiveMessage request = parser.parse(params);
		List<MessageInFlight> nextMessages = queues.poll(queue, request.getMaxNumberOfMessages().intValue(), request.getWaitTimeSeconds().intValue());
		
		ReceiveMessageResponse response = new ReceiveMessageResponse();
		ResponseMetadata metadata = new ResponseMetadata();
		metadata.setRequestId(generator.nextRequestId());
		response.setResponseMetadata(metadata);
		ReceiveMessageResult result = new ReceiveMessageResult();
		for (MessageInFlight nextMessage : nextMessages) {
			Message message = new Message();
			message.setBody(nextMessage.getBody());
			message.setMD5OfBody(MD5.from(message.getBody()).get());
			if(nextMessage.getAttributes() != null) {
				message.getMessageAttribute().addAll(nextMessage.getAttributes());
				message.setMD5OfMessageAttributes(MD5.from(message.getMessageAttribute()).orElse(null));
				message.setMessageId(nextMessage.getId());
				message.setReceiptHandle(nextMessage.getId());
			}
			result.getMessage().add(message);
		}
		response.setReceiveMessageResult(result );
		
		return response;
	}

	@Override
	public String getActionType() {
		return "ReceiveMessage";
	}

}
