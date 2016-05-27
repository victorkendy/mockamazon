package br.com.harada.mockamazon.sqs;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
class DefaultIdGenerator implements RequestIdGenerator, MessageIdGenerator {

	public void release(String id) {
		
	}

	@Override
	public String nextMessageId() {
		return UUID.randomUUID().toString();
	}

	@Override
	public String nextRequestId() {
		return UUID.randomUUID().toString();
	}
}
