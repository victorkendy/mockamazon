package br.com.harada.mockamazon.sqs.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.queue.doc._2012_11_05.ResponseMetadata;
import com.amazonaws.queue.doc._2012_11_05.SendMessageBatch;
import com.amazonaws.queue.doc._2012_11_05.SendMessageBatchRequestEntry;
import com.amazonaws.queue.doc._2012_11_05.SendMessageBatchResponse;
import com.amazonaws.queue.doc._2012_11_05.SendMessageBatchResult;
import com.amazonaws.queue.doc._2012_11_05.SendMessageBatchResultEntry;

import br.com.harada.mockamazon.RequestIdGenerator;
import br.com.harada.mockamazon.infra.MD5;
import br.com.harada.mockamazon.sqs.ParameterParser;
import br.com.harada.mockamazon.sqs.QueueMessage;
import br.com.harada.mockamazon.sqs.Queues;
import br.com.harada.mockamazon.sqs.SQSHandler;

@Component
class SendMessageBatchHandler extends SQSHandler<SendMessageBatch>{

	private Queues queues;
	
	private RequestIdGenerator generator;

	@Autowired
	SendMessageBatchHandler(Queues queues, RequestIdGenerator generator) {
		super(SendMessageBatch.class);
		this.queues = queues;
		this.generator = generator;
	}

	@Override
	public Object handle(SendMessageBatch request, String queue) {
		SendMessageBatchResult result = new SendMessageBatchResult();
		for (SendMessageBatchRequestEntry entry : request.getSendMessageBatchRequestEntry()) {
			QueueMessage queueMessage = new QueueMessage(entry.getMessageBody(), entry.getMessageAttribute());
			queues.sendMessage(queue, queueMessage);
			SendMessageBatchResultEntry resultEntry = new SendMessageBatchResultEntry();
			resultEntry.setId(entry.getId());
			resultEntry.setMessageId(queueMessage.getId());
			resultEntry.setMD5OfMessageBody(MD5.from(entry.getMessageBody()).get());
			resultEntry.setMD5OfMessageAttributes(MD5.from(entry.getMessageAttribute()).orElse(null));
		}
		
		SendMessageBatchResponse response = new SendMessageBatchResponse();
		response.setSendMessageBatchResult(result);
		
		ResponseMetadata metadata = new ResponseMetadata();
		metadata.setRequestId(generator.nextRequestId());
		response.setResponseMetadata(metadata);
		
		return response;
	}

	@Override
	public String getActionType() {
		return "SendMessageBatch";
	}
}
