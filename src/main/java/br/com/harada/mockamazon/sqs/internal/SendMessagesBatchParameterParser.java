package br.com.harada.mockamazon.sqs.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.amazonaws.queue.doc._2012_11_05.MessageAttribute;
import com.amazonaws.queue.doc._2012_11_05.MessageAttributeValue;
import com.amazonaws.queue.doc._2012_11_05.SendMessageBatch;
import com.amazonaws.queue.doc._2012_11_05.SendMessageBatchRequestEntry;

/*Action=SendMessageBatch&
  Version=2012-11-05&
  SendMessageBatchRequestEntry.1.Id=1&
  SendMessageBatchRequestEntry.1.MessageBody=Message+Body+in+Batch&
  SendMessageBatchRequestEntry.1.MessageAttribute.1.Name=contentType&
  SendMessageBatchRequestEntry.1.MessageAttribute.1.Value.StringValue=application%2Fjson&
  SendMessageBatchRequestEntry.1.MessageAttribute.1.Value.DataType=String&
  SendMessageBatchRequestEntry.2.Id=2&
  SendMessageBatchRequestEntry.2.MessageBody=Another+Message+Body+in+Batch&
  SendMessageBatchRequestEntry.2.MessageAttribute.1.Name=contentType&
  SendMessageBatchRequestEntry.2.MessageAttribute.1.Value.StringValue=application%2Fjson&
  SendMessageBatchRequestEntry.2.MessageAttribute.1.Value.DataType=String
*/

@Component
class SendMessagesBatchParameterParser extends ParameterParser<SendMessageBatch>{
	
	private static Pattern ATTR_PATTERN = Pattern.compile(
		"SendMessageBatchRequestEntry\\.(?<messageIndex>\\d+)\\.(?<attrName>[a-zA-Z]+)(\\.(?<value>.+))?");
	private static Pattern VALUE_PATTERN = Pattern.compile(
		"(?<index>\\d+)\\.(?<valueAttr>[a-zA-Z]+)(\\.(?<attrInfo>[a-zA-Z]+))?");

	@Override
	public SendMessageBatch parse(Map<String, String[]> params) {
		Map<String, BatchRequestEntryBuilder> messages = new HashMap<>();
		for (Entry<String, String[]> entry : params.entrySet()) {
			Matcher attrMatcher = ATTR_PATTERN.matcher(entry.getKey());
			
			if(attrMatcher.matches()){
				String messageIndex = attrMatcher.group("messageIndex");
				String attrName = attrMatcher.group("attrName");
				String value = attrMatcher.group("value");
				BatchRequestEntryBuilder builder = messages.computeIfAbsent(messageIndex, k->new BatchRequestEntryBuilder());
				if("Id".equals(attrName)) {
					builder.setMessageId(getFirstOrDefault(entry.getValue(), ""));
				} else if ("MessageBody".equals(attrName)) {
					builder.setMessageBody(getFirstOrDefault(entry.getValue(), ""));
				} else if("MessageAttribute".equals(attrName) && value != null) {
					Matcher valueMatcher = VALUE_PATTERN.matcher(value);
					if(valueMatcher.matches()) {
						String messageAttrIndex = valueMatcher.group("index");
						String messageAttrField = valueMatcher.group("valueAttr");
						String messageAttrValueField = valueMatcher.group("attrInfo");
						if("Name".equals(messageAttrField)) {
							builder.putAttributeName(messageAttrIndex, getFirstOrDefault(entry.getValue(), ""));
						} else if("Value".equals(messageAttrField) && "StringValue".equals(messageAttrValueField)) {
							builder.putAttributeValue(messageAttrIndex, getFirstOrDefault(entry.getValue(), ""));
						} else if("Value".equals(messageAttrField) && "DataType".equals(messageAttrValueField)) {
							builder.putAttributeValueType(messageAttrIndex, getFirstOrDefault(entry.getValue(), ""));
						}
					}
				}
			}
			
		}
		SendMessageBatch request = new SendMessageBatch();
		messages.values().forEach(b -> request.getSendMessageBatchRequestEntry().add(b.build()));
		return request;
	}
	
	class BatchRequestEntryBuilder {
		private SendMessageBatchRequestEntry requestEntry = new SendMessageBatchRequestEntry();
		private Map<String, MessageAttribute> attributes = new HashMap<>();
		
		void setMessageId(String id) {
			requestEntry.setId(id);
		}
		
		void setMessageBody(String body) {
			requestEntry.setMessageBody(body);
		}
		
		void putAttributeName(String index, String name) {
			getAttribute(index).setName(name);
		}
		
		void putAttributeValue(String index, String value) {
			getAttributeValue(index).setStringValue(value);
		}
		
		void putAttributeValueType(String index, String type) {
			getAttributeValue(index).setDataType(type);
		}
		
		SendMessageBatchRequestEntry build() {
			requestEntry.getMessageAttribute().addAll(attributes.values());
			return requestEntry;
		}

		private MessageAttributeValue getAttributeValue(String index) {
			MessageAttribute attribute = getAttribute(index);
			MessageAttributeValue value = attribute.getValue();
			if(value == null) {
				value = new MessageAttributeValue();
				attribute.setValue(value);
			}
			return value;
		}

		private MessageAttribute getAttribute(String index) {
			return attributes.computeIfAbsent(index, k->new MessageAttribute());
		}
	}
}
