package br.com.harada.mockamazon.sqs.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.queue.doc._2012_11_05.DeleteMessage;
import com.amazonaws.queue.doc._2012_11_05.DeleteMessageResponse;
import com.amazonaws.queue.doc._2012_11_05.ResponseMetadata;

import br.com.harada.mockamazon.RequestIdGenerator;
import br.com.harada.mockamazon.sqs.ParameterParser;
import br.com.harada.mockamazon.sqs.Queues;
import br.com.harada.mockamazon.sqs.SQSHandler;

@Component
class DeleteMessageHandler implements SQSHandler<DeleteMessage> {

	@Autowired
	private Queues queues;
	
	@Autowired
	private RequestIdGenerator idGenerator;

	@Override
	public Object handle(DeleteMessage request, String queue) {
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
	
	@Override
	public Class<? extends ParameterParser<DeleteMessage>> getParameterParser() {
		return DeleteMessageParser.class;
	}
}
