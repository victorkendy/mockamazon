package br.com.harada.mockamazon.sns;

import static org.junit.Assert.*;

import com.amazonaws.services.sns.model.MessageAttributeValue;
import org.junit.Before;
import org.junit.Test;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;

public class SNSRequestTest {

	private AmazonSNS sns;
	
	@Before
	public void setup(){
		AWSCredentials credentials = new BasicAWSCredentials("key", "secret");
		sns = new AmazonSNSClient(credentials);
		sns.setEndpoint("http://localhost:8080/sns");
	}
	
	@Test
	public void publish_to_topic() throws Exception {
		PublishRequest request = new PublishRequest("arn:aws:sns:sa-east-1:72183721893723:worker-queue", "my sns message");
		MessageAttributeValue value = new MessageAttributeValue();
		value.setDataType("String");
		value.setStringValue("application/json");
		request.addMessageAttributesEntry("contentType", value);
		sns.publish(request);
	}
}
