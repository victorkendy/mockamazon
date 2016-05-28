package br.com.harada.mockamazon.sqs.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.queue.doc._2012_11_05.DeleteMessageBatch;
import com.amazonaws.queue.doc._2012_11_05.DeleteMessageBatchRequestEntry;
import com.amazonaws.queue.doc._2012_11_05.DeleteMessageBatchResponse;
import com.amazonaws.queue.doc._2012_11_05.DeleteMessageBatchResult;
import com.amazonaws.queue.doc._2012_11_05.DeleteMessageBatchResultEntry;
import com.amazonaws.queue.doc._2012_11_05.ResponseMetadata;

import br.com.harada.mockamazon.sqs.ParameterParser;
import br.com.harada.mockamazon.sqs.Queues;
import br.com.harada.mockamazon.sqs.RequestIdGenerator;
import br.com.harada.mockamazon.sqs.SQSHandler;

@Component
class DeleteMessageBatchHandler implements SQSHandler<DeleteMessageBatch> {

	@Autowired
	private Queues queues;
	
	@Autowired
	private RequestIdGenerator idGenerator;

	@Override
	public Object handle(DeleteMessageBatch request, String queue) {
		DeleteMessageBatchResult result = new DeleteMessageBatchResult();
		for (DeleteMessageBatchRequestEntry deleteEntry : request.getDeleteMessageBatchRequestEntry()) {
			queues.remove(deleteEntry.getReceiptHandle());
			DeleteMessageBatchResultEntry entry = new DeleteMessageBatchResultEntry();
			entry.setId(deleteEntry.getId());
			result.getDeleteMessageBatchResultEntry().add(entry);
		}
		DeleteMessageBatchResponse response = new DeleteMessageBatchResponse();
		response.setDeleteMessageBatchResult(result);
		
		ResponseMetadata metadata = new ResponseMetadata();
		metadata.setRequestId(idGenerator.nextRequestId());
		response.setResponseMetadata(metadata );
		
		return response;
	}

	@Override
	public String getActionType() {
		return "DeleteMessageBatch";
	}

	@Override
	public Class<? extends ParameterParser<DeleteMessageBatch>> getParameterParser() {
		return DeleteMessageBatchParser.class;
	}
}
