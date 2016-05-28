package br.com.harada.mockamazon.sqs;

import java.util.Map;

public abstract class ParameterParser<T> {
	public abstract T parse(Map<String, String[]> params);
	
	public String getFirstOrDefault(String[] values, String defaultValue) {
		if(values == null || values.length == 0) {
			return defaultValue;
		}
		return values[0];
	}
}
