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
class DeleteMessageHandler extends SQSHandler<DeleteMessage> {

	private Queues queues;
	
	private RequestIdGenerator idGenerator;

	@Autowired
	DeleteMessageHandler(Queues queues, RequestIdGenerator idGenerator) {
		super(DeleteMessage.class);
		this.queues = queues;
		this.idGenerator = idGenerator;
	}

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
}
