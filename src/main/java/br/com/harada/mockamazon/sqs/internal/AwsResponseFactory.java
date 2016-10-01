package br.com.harada.mockamazon.sqs.internal;

import br.com.harada.mockamazon.RequestIdGenerator;
import com.amazonaws.queue.doc._2012_11_05.ResponseMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by victor on 01/10/2016.
 */
@Component
public class AwsResponseFactory {

    @Autowired
    private RequestIdGenerator idGenerator;

    public <T, U> T createResponse(Class<T> clazz, U result){
        ResponseMetadata metadata = new ResponseMetadata();
        try {
            T response = clazz.newInstance();
            clazz.getMethod("setResponseMetadata", ResponseMetadata.class).invoke(response, metadata);
            clazz.getMethod("set" + result.getClass().getSimpleName(), result.getClass()).invoke(response, result);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
