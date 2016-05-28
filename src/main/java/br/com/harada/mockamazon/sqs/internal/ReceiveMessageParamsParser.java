package br.com.harada.mockamazon.sqs.internal;

import java.math.BigInteger;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.amazonaws.queue.doc._2012_11_05.ReceiveMessage;

import br.com.harada.mockamazon.sqs.ParameterParser;

@Component
class ReceiveMessageParamsParser extends ParameterParser<ReceiveMessage> {
	
	public ReceiveMessage parse(Map<String, String[]> params) {
		ReceiveMessage request = new ReceiveMessage();
		
		request.setMaxNumberOfMessages(new BigInteger(getFirstOrDefault(params.get("MaxNumberOfMessages"), "1")));
		request.setWaitTimeSeconds(new BigInteger(getFirstOrDefault(params.get("WaitTimeSeconds"), "0")));
		
		return request;
	}

	
}
