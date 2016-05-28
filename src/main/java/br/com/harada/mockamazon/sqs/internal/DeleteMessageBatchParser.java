package br.com.harada.mockamazon.sqs.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.amazonaws.queue.doc._2012_11_05.DeleteMessageBatch;
import com.amazonaws.queue.doc._2012_11_05.DeleteMessageBatchRequestEntry;

import br.com.harada.mockamazon.sqs.ParameterParser;

@Component
public class DeleteMessageBatchParser extends ParameterParser<DeleteMessageBatch>{
	
	private static final Pattern PATTERN = Pattern.compile("DeleteMessageBatchRequestEntry\\.(?<index>\\d+)\\.(?<attributeName>[a-zA-Z]+)");

	@Override
	public DeleteMessageBatch parse(Map<String, String[]> params) {
		DeleteMessageBatch request = new DeleteMessageBatch();
		Map<String, DeleteMessageBatchRequestEntry> messages = new HashMap<>();
		
		for (Entry<String, String[]> entry : params.entrySet()) {
			Matcher matcher = PATTERN.matcher(entry.getKey());
			if(matcher.matches()){
				String index = matcher.group("index");
				String attributeName = matcher.group("attributeName");
				DeleteMessageBatchRequestEntry deleteRequest = messages.computeIfAbsent(index, k->new DeleteMessageBatchRequestEntry());
				if("Id".equals(attributeName)) {
					deleteRequest.setId(getFirstOrDefault(entry.getValue(), ""));
				} else if("ReceiptHandle".equals(attributeName)){
					deleteRequest.setReceiptHandle(getFirstOrDefault(entry.getValue(), ""));
				}
			}
		}
		
		request.getDeleteMessageBatchRequestEntry().addAll(messages.values());
		return request;
	}

}
