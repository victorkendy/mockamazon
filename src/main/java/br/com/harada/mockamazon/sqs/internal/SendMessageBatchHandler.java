package br.com.harada.mockamazon.sqs.internal;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.queue.doc._2012_11_05.ResponseMetadata;
import com.amazonaws.queue.doc._2012_11_05.SendMessageBatch;
import com.amazonaws.queue.doc._2012_11_05.SendMessageBatchRequestEntry;
import com.amazonaws.queue.doc._2012_11_05.SendMessageBatchResponse;
import com.amazonaws.queue.doc._2012_11_05.SendMessageBatchResult;
import com.amazonaws.queue.doc._2012_11_05.SendMessageBatchResultEntry;

import br.com.harada.mockamazon.infra.MD5;
import br.com.harada.mockamazon.sqs.MessageIdGenerator;
import br.com.harada.mockamazon.sqs.QueueMessage;
import br.com.harada.mockamazon.sqs.Queues;
import br.com.harada.mockamazon.sqs.SQSHandler;

@Component
class SendMessageBatchHandler implements SQSHandler{

	@Autowired
	private Queues queues;
	
	@Autowired
	private SendMessagesBatchParameterParser parser;
	
	@Autowired
	private MessageIdGenerator generator;

	@Override
	public Object handle(Map<String, String[]> params, String queue) {
		SendMessageBatch request = parser.parse(params);

		SendMessageBatchResult result = new SendMessageBatchResult();
		for (SendMessageBatchRequestEntry entry : request.getSendMessageBatchRequestEntry()) {
			queues.sendMessage(queue, new QueueMessage(entry.getMessageBody(), entry.getMessageAttribute()));
			SendMessageBatchResultEntry resultEntry = new SendMessageBatchResultEntry();
			resultEntry.setId(entry.getId());
			resultEntry.setMessageId(generator.nextMessageId());
			resultEntry.setMD5OfMessageBody(MD5.from(entry.getMessageBody()).get());
			resultEntry.setMD5OfMessageAttributes(MD5.from(entry.getMessageAttribute()).orElse(null));
		}
		
		SendMessageBatchResponse response = new SendMessageBatchResponse();
		response.setSendMessageBatchResult(result);
		
		ResponseMetadata metadata = new ResponseMetadata();
		metadata.setRequestId(generator.nextMessageId());
		response.setResponseMetadata(metadata);
		
		return response;
	}

	@Override
	public String getActionType() {
		return "SendMessageBatch";
	}

}
