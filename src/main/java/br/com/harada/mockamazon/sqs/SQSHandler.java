package br.com.harada.mockamazon.sqs;

public interface SQSHandler<T> {
	Object handle(T map, String queue);
	
	String getActionType();
	
	Class<? extends ParameterParser<T>> getParameterParser();
}
