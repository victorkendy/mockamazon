package br.com.harada.mockamazon.sqs;

import java.util.Map;

public interface SQSHandler {
	Object handle(Map<String, String[]> map, String queue);
	
	String getActionType();
}
