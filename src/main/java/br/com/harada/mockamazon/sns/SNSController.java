package br.com.harada.mockamazon.sns;

import javax.servlet.http.HttpServletRequest;

import br.com.harada.mockamazon.RequestIdGenerator;
import br.com.harada.mockamazon.infra.AwsParameterParser;
import br.com.harada.mockamazon.sqs.QueueMessage;
import br.com.harada.mockamazon.sqs.Queues;
import com.amazonaws.queue.doc._2012_11_05.MessageAttribute;
import com.amazonaws.queue.doc._2012_11_05.MessageAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazonaws.sns.doc._2010_03_31.Publish;
import com.amazonaws.sns.doc._2010_03_31.PublishResponse;
import com.amazonaws.sns.doc._2010_03_31.PublishResult;
import com.amazonaws.sns.doc._2010_03_31.ResponseMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Controller
public class SNSController {

	private static final String ARN_FORMAT = "arn:aws:sns:[^:]+:\\d+:(?<topicName>[a-zA-Z-_]+)";
	private static final Pattern PATTERN = Pattern.compile(ARN_FORMAT);

	@Autowired
	private Queues queues;
	@Autowired
	private RequestIdGenerator generator;
	@Autowired
	private AwsParameterParser parameterParser;

	@ResponseBody
	@RequestMapping(value="/sns", method=RequestMethod.POST, produces=MediaType.APPLICATION_XML_VALUE)
	public Object receive(
			@RequestParam(name="Action") String action, 
			@RequestBody String body,
			HttpServletRequest request) {
		Publish publish = parameterParser.parse(Publish.class, request.getParameterMap());
		MessageAttributesContainer messageAttributes = parameterParser.parse(MessageAttributesContainer.class, request.getParameterMap());

		String topicName = extractTopicName(publish.getTopicArn());
		QueueMessage queueMessage = new QueueMessage(publish.getMessage(),
				messageAttributes.getMessageAttributes().getentry().stream().map(attr -> {
					com.amazonaws.queue.doc._2012_11_05.MessageAttribute queueAttr = new com.amazonaws.queue.doc._2012_11_05.MessageAttribute();
					queueAttr.setName(attr.getName());
					MessageAttributeValue value = new MessageAttributeValue();
					value.setDataType(attr.getValue().getDataType());
					value.setStringValue(attr.getValue().getStringValue());
					queueAttr.setValue(value);
					return queueAttr;
				}).collect(Collectors.toList()));
		queues.sendMessage(topicName, queueMessage);

		PublishResponse response = new PublishResponse();
		PublishResult result = new PublishResult();
		result.setMessageId(generator.nextRequestId());
		response.setPublishResult(result);
		ResponseMetadata metadata = new ResponseMetadata();
		metadata.setRequestId(generator.nextRequestId());
		response.setResponseMetadata(metadata );
		System.out.println(body);
		return response;
	}

	private String extractTopicName(String topicArn) {
		Matcher matcher = PATTERN.matcher(topicArn);
		if(matcher.matches()){
			return matcher.group("topicName");
		}
		throw new IllegalArgumentException("Invalid Topic Arn");
	}

	public static class MessageAttributesContainer {
		private MessageAttributeEntry messageAttributes;

		public MessageAttributeEntry getMessageAttributes() {
			return messageAttributes;
		}

		public void setMessageAttributes(MessageAttributeEntry messageAttributes) {
			this.messageAttributes = messageAttributes;
		}
	}

	public static class MessageAttributeEntry {
		private List<MessageAttribute> entry = new ArrayList<>();

		public List<MessageAttribute> getentry() {
			return entry;
		}
	}

	public static class  MessageAttribute{
		private String name;
		private AttributeValue value;

		public AttributeValue getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setValue(AttributeValue value) {
			this.value = value;
		}
	}

	public static class AttributeValue {
		private String dataType;

		private String stringValue;

		public String getDataType() {
			return dataType;
		}

		public String getStringValue() {
			return stringValue;
		}

		public void setDataType(String dataType) {
			this.dataType = dataType;
		}

		public void setStringValue(String stringValue) {
			this.stringValue = stringValue;
		}
	}

}
