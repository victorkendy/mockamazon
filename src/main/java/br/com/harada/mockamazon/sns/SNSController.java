package br.com.harada.mockamazon.sns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SNSController {

	@RequestMapping(value="/sns")
	@ResponseBody
	public Object receive(
			@RequestParam(name="Action") String action, 
			@RequestBody String body,
			HttpServletRequest request) {
		System.out.println(body);
		return "AAA";
	}
	
}
