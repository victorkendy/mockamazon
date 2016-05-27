package br.com.harada.mockamazon.sns;

import static org.junit.Assert.*;

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
		PublishRequest request = new PublishRequest("topic", "message");
		sns.publish(request );
	}
}
