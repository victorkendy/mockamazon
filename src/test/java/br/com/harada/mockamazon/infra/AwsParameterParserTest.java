package br.com.harada.mockamazon.infra;

import com.amazonaws.queue.doc._2012_11_05.MessageAttribute;
import com.amazonaws.queue.doc._2012_11_05.ReceiveMessage;
import com.amazonaws.queue.doc._2012_11_05.SendMessage;
import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by victor on 29/09/2016.
 */
public class AwsParameterParserTest {

    private AwsParameterParser subject = new AwsParameterParser();


    @Test
    public void shouldParseSingleLevelParameters() throws Exception {
        Map<String, String[]> params = new HashMap<>();
        params.put("MaxNumberOfMessages", new String[]{"1"});
        params.put("WaitTimeSeconds", new String[]{"0"});

        ReceiveMessage receiveMessage = subject.parse(ReceiveMessage.class, params);
        assertEquals(0, BigInteger.ONE.compareTo(receiveMessage.getMaxNumberOfMessages()));
        assertEquals(0, BigInteger.ZERO.compareTo(receiveMessage.getWaitTimeSeconds()));
    }

    @Test
    public void shouldParseMultiLevelParameters() throws Exception {
        Map<String, String[]> params = new HashMap<>();
        params.put("Name", new String[]{"Attr Name"});
        params.put("Value.DataType", new String[]{"Value Data Type"});
        params.put("Value.StringValue", new String[]{"My String Value"});

        MessageAttribute attributes = subject.parse(MessageAttribute.class, params);
        assertEquals("Attr Name", attributes.getName());
        assertEquals("Value Data Type", attributes.getValue().getDataType());
        assertEquals("My String Value", attributes.getValue().getStringValue());
    }

    @Test
    public void shouldParseListParameters() throws Exception {
        Map<String, String[]> params = new HashMap<>();
        params.put("MessageAttribute.1.Name", new String[]{"Attr Name"});
        params.put("MessageAttribute.1.Value.DataType", new String[]{"Value Data Type"});
        params.put("MessageAttribute.1.Value.StringValue", new String[]{"My String Value"});
        params.put("MessageAttribute.2.Name", new String[]{"Attr Name1"});
        params.put("MessageAttribute.2.Value.DataType", new String[]{"Value Data Type1"});
        params.put("MessageAttribute.2.Value.StringValue", new String[]{"My String Value1"});
        SendMessage sendMessage = subject.parse(SendMessage.class, params);

        MessageAttribute attribute = sendMessage.getMessageAttribute().get(0);
        assertEquals("Attr Name", attribute.getName());
        assertEquals("Value Data Type", attribute.getValue().getDataType());
        assertEquals("My String Value", attribute.getValue().getStringValue());

        MessageAttribute attribute1 = sendMessage.getMessageAttribute().get(1);
        assertEquals("Attr Name1", attribute1.getName());
        assertEquals("Value Data Type1", attribute1.getValue().getDataType());
        assertEquals("My String Value1", attribute1.getValue().getStringValue());
    }
}