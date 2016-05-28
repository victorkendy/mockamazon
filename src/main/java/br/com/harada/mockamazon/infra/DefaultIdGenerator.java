package br.com.harada.mockamazon.infra;

import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.harada.mockamazon.RequestIdGenerator;
import br.com.harada.mockamazon.sqs.MessageIdGenerator;

@Component
class DefaultIdGenerator implements RequestIdGenerator, MessageIdGenerator {

	@Override
	public String nextMessageId() {
		return UUID.randomUUID().toString();
	}

	@Override
	public String nextRequestId() {
		return UUID.randomUUID().toString();
	}

	@Override
	public String nextReceiptHandle() {
		return UUID.randomUUID().toString();
	}
}
