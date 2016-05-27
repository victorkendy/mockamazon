package br.com.harada.mockamazon.sqs.internal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.amazonaws.queue.doc._2012_11_05.MessageAttribute;
import com.amazonaws.queue.doc._2012_11_05.MessageAttributeValue;
import com.amazonaws.queue.doc._2012_11_05.SendMessage;

@Component
class SendMessagesParameterParser extends ParameterParser<SendMessage>{
	private static Pattern ATTR_PATTERN = Pattern.compile("MessageAttribute\\.(?<index>\\d+)\\.(?<attribute>[a-zA-Z]+)(\\.(?<valueAttr>[a-zA-Z]+))?");

	@Override
	public SendMessage parse(Map<String, String[]> params) {
		SendMessage request = new SendMessage();
		
		request.setMessageBody(getFirstOrDefault(params.get("MessageBody"), ""));
		request.getMessageAttribute().addAll(parseAttributes(params));
		return request;
	}

	private Collection<? extends com.amazonaws.queue.doc._2012_11_05.MessageAttribute> parseAttributes(Map<String, String[]> params) {
		Map<String, MessageAttribute> attributes = new HashMap<>();
		for (Entry<String, String[]> entry : params.entrySet()) {
			Matcher matcher = ATTR_PATTERN.matcher(entry.getKey());
			if(matcher.matches()) {
				String index = matcher.group("index");
				String attr = matcher.group("attribute");
				String valueAttr = matcher.group("valueAttr");
				MessageAttribute attribute = attributes.computeIfAbsent(index, k->new MessageAttribute());
				if("Name".equals(attr)) {
					attribute.setName(getFirstOrDefault(entry.getValue(), ""));
				} else if("Value".equals(attr)) {
					MessageAttributeValue value = attribute.getValue();
					if(value == null) {
						value = new MessageAttributeValue();
					}
					if("DataType".equals(valueAttr)) {
						value.setDataType(entry.getValue()[0]);
					}
					else if("StringValue".equals(valueAttr)) {
						value.setStringValue(entry.getValue()[0]);
					}
					attribute.setValue(value);
				}
			}
		}
		return attributes.values();
	}

}
