package br.com.harada.mockamazon.sqs.internal;

import br.com.harada.mockamazon.RequestIdGenerator;
import br.com.harada.mockamazon.sqs.SQSHandler;
import com.amazonaws.queue.doc._2012_11_05.GetQueueUrl;
import com.amazonaws.queue.doc._2012_11_05.GetQueueUrlResponse;
import com.amazonaws.queue.doc._2012_11_05.GetQueueUrlResult;
import com.amazonaws.queue.doc._2012_11_05.ResponseMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

/**
 * Created by victor on 01/10/2016.
 */
@Component
class GetQueueUrlHandler extends SQSHandler<GetQueueUrl> {

    private final String contextPath = "http://localhost:8080/sqs/";
    private final RequestIdGenerator generator;

    @Autowired
    GetQueueUrlHandler(RequestIdGenerator generator) {
        super(GetQueueUrl.class);
        this.generator = generator;
    }

    @Override
    public Object handle(GetQueueUrl param, String queue) {
        String queueName = param.getQueueName();
        ResponseMetadata metadata = new ResponseMetadata();
        metadata.setRequestId(generator.nextRequestId());
        GetQueueUrlResponse response = new GetQueueUrlResponse();
        response.setResponseMetadata(metadata);
        GetQueueUrlResult result = new GetQueueUrlResult();
        response.setGetQueueUrlResult(result);
        result.setQueueUrl(contextPath + queueName);

        return response;
    }

    @Override
    public String getActionType() {
        return "GetQueueUrl";
    }
}
