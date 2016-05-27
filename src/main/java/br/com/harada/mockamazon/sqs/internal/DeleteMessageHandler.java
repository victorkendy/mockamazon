package br.com.harada.mockamazon.sqs.internal;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.queue.doc._2012_11_05.DeleteMessage;
import com.amazonaws.queue.doc._2012_11_05.DeleteMessageResponse;
import com.amazonaws.queue.doc._2012_11_05.ResponseMetadata;

import br.com.harada.mockamazon.sqs.Queues;
import br.com.harada.mockamazon.sqs.RequestIdGenerator;
import br.com.harada.mockamazon.sqs.SQSHandler;

@Component
class DeleteMessageHandler implements SQSHandler {

	@Autowired
	private DeleteMessageParser parser;
	
	@Autowired
	private Queues queues;
	
	@Autowired
	private RequestIdGenerator idGenerator;

	@Override
	public Object handle(Map<String, String[]> params, String queue) {
		DeleteMessage request = parser.parse(params);
		queues.remove(request.getReceiptHandle());
		
		DeleteMessageResponse response = new DeleteMessageResponse();
		ResponseMetadata metadata = new ResponseMetadata();
		metadata.setRequestId(idGenerator.nextRequestId());
		response.setResponseMetadata(metadata );
		
		return response;
	}

	@Override
	public String getActionType() {
		return "DeleteMessage";
	}
}
