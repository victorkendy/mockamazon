package br.com.harada.mockamazon.sqs;

import br.com.harada.mockamazon.infra.ActionHandler;

public abstract class SQSHandler<T>{
	private final Class<T> clazz;

	public SQSHandler(Class<T> clazz) {
		this.clazz = clazz;
	}

	public abstract Object handle(T map, String queue);
	
	public abstract String getActionType();

	public final Class<T> getParameterClass(){
		return this.clazz;
	}
}
