package br.com.harada.mockamazon.sqs;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import br.com.harada.mockamazon.infra.AwsParameterParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SuppressWarnings({ "rawtypes", "unchecked" })
public class SqsController {
	
	@Autowired
	private List<SQSHandler> handlers;

	@Autowired
	private AwsParameterParser parameterParser;
	
	@ResponseBody
	@RequestMapping(value="/sqs/{queueName}", method = RequestMethod.POST, produces=MediaType.APPLICATION_XML_VALUE)
	public Object receive(@RequestParam(name="Action") String action, 
			HttpServletRequest req,
			@RequestBody String body,
			@PathVariable("queueName") String queue) throws Exception {
		
		Optional<SQSHandler> handler = handlers.stream().filter(h -> h.getActionType().equals(action)).findFirst();
		Object response = null;
		if(handler.isPresent()) {
			SQSHandler sqsHandler = handler.get();
			Class parameterClass = handler.get().getParameterClass();
			Object parsedParam = parameterParser.parse(parameterClass, req.getParameterMap());
			return sqsHandler.handle(parsedParam, queue);
		}
		return response;
	}

	@ResponseBody
	@RequestMapping(value={"/sqs", "/sqs/"}, method = RequestMethod.POST, produces=MediaType.APPLICATION_XML_VALUE)
	public Object consult(@RequestParam(name="Action") String action,
						  HttpServletRequest req,
						  @RequestBody String body) throws Exception {

		Optional<SQSHandler> handler = handlers.stream().filter(h -> h.getActionType().equals(action)).findFirst();
		Object response = null;
		if(handler.isPresent()) {
			SQSHandler sqsHandler = handler.get();
			Class parameterClass = handler.get().getParameterClass();
			Object parsedParam = parameterParser.parse(parameterClass, req.getParameterMap());
			return sqsHandler.handle(parsedParam, null);
		}
		return null;
	}
}
