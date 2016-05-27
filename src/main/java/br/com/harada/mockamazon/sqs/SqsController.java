package br.com.harada.mockamazon.sqs;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SqsController {
	
	@Autowired
	private List<SQSHandler> handlers;
	
	@ResponseBody
	@RequestMapping(value="/sqs/{queueName}",method=RequestMethod.POST, produces=MediaType.APPLICATION_XML_VALUE)
	public Object receive(@RequestParam(name="Action") String action, 
			HttpServletRequest req,
			@RequestBody String body,
			@PathVariable("queueName") String queue) throws Exception {
		
		System.out.println(body);
		System.out.println(action);
		System.out.println(queue);
		Optional<SQSHandler> handler = handlers.stream().filter(h -> h.getActionType().equals(action)).findFirst();
		Object response = null;
		if(handler.isPresent()) {
			response = handler.get().handle(req.getParameterMap(), queue);
		}
		return response;
	}
}
