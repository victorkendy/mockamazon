package br.com.harada.mockamazon.sns;

import javax.servlet.http.HttpServletRequest;

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

@Controller
public class SNSController {

	@ResponseBody
	@RequestMapping(value="/sns", method=RequestMethod.POST, produces=MediaType.APPLICATION_XML_VALUE)
	public Object receive(
			@RequestParam(name="Action") String action, 
			@RequestBody String body,
			HttpServletRequest request) {
		Publish publish = new Publish();
		publish.setMessage(request.getParameter("Message"));
		publish.setTopicArn(request.getParameter("TopicArn"));
		
		PublishResponse response = new PublishResponse();
		PublishResult result = new PublishResult();
		result.setMessageId("aaaaaaaa");
		response.setPublishResult(result );
		ResponseMetadata metadata = new ResponseMetadata();
		metadata.setRequestId("bbbbbrequestid");
		response.setResponseMetadata(metadata );
		System.out.println(body);
		return response;
	}
	
}
