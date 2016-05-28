package br.com.harada.mockamazon.sqs.internal;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.amazonaws.queue.doc._2012_11_05.DeleteMessage;

import br.com.harada.mockamazon.sqs.ParameterParser;

@Component
class DeleteMessageParser extends ParameterParser<DeleteMessage> {

	@Override
	public DeleteMessage parse(Map<String, String[]> params) {
		DeleteMessage request = new DeleteMessage();
		
		request.setReceiptHandle(getFirstOrDefault(params.get("ReceiptHandle"), ""));
		
		return request;
	}
	
}
