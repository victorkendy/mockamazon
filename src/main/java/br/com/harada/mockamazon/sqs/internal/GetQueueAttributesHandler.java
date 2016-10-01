package br.com.harada.mockamazon.sqs.internal;

import br.com.harada.mockamazon.sqs.SQSHandler;
import com.amazonaws.queue.doc._2012_11_05.GetQueueAttributes;
import com.amazonaws.queue.doc._2012_11_05.GetQueueAttributesResponse;
import com.amazonaws.queue.doc._2012_11_05.GetQueueAttributesResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by victor on 01/10/2016.
 */
@Component
public class GetQueueAttributesHandler extends SQSHandler<GetQueueAttributes>{

    private final AwsResponseFactory responseFactory;

    @Autowired
    GetQueueAttributesHandler(AwsResponseFactory responseFactory) {
        super(GetQueueAttributes.class);
        this.responseFactory = responseFactory;
    }

    @Override
    public Object handle(GetQueueAttributes req, String queue) {
        GetQueueAttributesResult result = new GetQueueAttributesResult();
        return responseFactory.createResponse(GetQueueAttributesResponse.class, result);
    }

    @Override
    public String getActionType() {
        return "GetQueueAttributes";
    }
}
