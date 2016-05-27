
package com.amazonaws.sns.doc._2010_03_31;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AmazonSimpleNotificationServicePortType", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AmazonSimpleNotificationServicePortType {


    /**
     * 
     *     <p>The ConfirmSubscription action verifies an endpoint owner's intent to receive messages by validating
     *       the token sent to the endpoint by an earlier Subscribe action. If the
     *       token is valid, the action creates a new subscription and returns its
     *       Amazon Resource Name (ARN). This call requires an AWS signature only when the AuthenticateOnUnsubscribe flag is set to "true".</p>
     * <examples>
     *  <queryrequest>
     * 
     *   https://sns.us-east-1.amazonaws.com/
     *   ?Action=ConfirmSubscription
     *   &TopicArn=arn:aws:sns:us-east-1:123456789012:My-Topic
     *   &Token=51b2ff3edb475b7d91550e0ab6edf0c1de2a34e6ebaf6
     *    c2262a001bcb7e051c43aa00022ceecce70bd2a67b2042da8d8
     *    eb47fef7a4e4e942d23e7fa56146b9ee35da040b4b8af564cc4
     *    184a7391c834cb75d75c22981f776ad1ce8805e9bab29da2329
     *    985337bb8095627907b46c8577c8440556b6f86582a95475802
     *    6f41fc62041c4b3f67b0f5921232b5dae5aaca1
     * 
     *  </queryrequest>
     *  <queryresponse>
     *   
     * <ConfirmSubscriptionResponse xmlns="http://sns.amazonaws.com/doc/2010-03-31/">
     *   <ConfirmSubscriptionResult>
     *     <SubscriptionArn>arn:aws:sns:us-east-1:123456789012:My-Topic:80289ba6-0fd4-4079-afb4-ce8c8260f0ca</SubscriptionArn>
     *   </ConfirmSubscriptionResult>
     *   <ResponseMetadata>
     *     <RequestId>7a50221f-3774-11df-a9b7-05d48da6f042</RequestId>
     *   </ResponseMetadata>
     * </ConfirmSubscriptionResponse>
     *   
     *  </queryresponse>
     * </examples>
     * 
     * 
     *   
     * 
     * @param responseMetadata
     * @param confirmSubscriptionResult
     * @param topicArn
     * @param token
     * @param authenticateOnUnsubscribe
     */
    @WebMethod(operationName = "ConfirmSubscription", action = "ConfirmSubscription")
    @RequestWrapper(localName = "ConfirmSubscription", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.ConfirmSubscription")
    @ResponseWrapper(localName = "ConfirmSubscriptionResponse", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.ConfirmSubscriptionResponse")
    public void confirmSubscription(
        @WebParam(name = "TopicArn", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String topicArn,
        @WebParam(name = "Token", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String token,
        @WebParam(name = "AuthenticateOnUnsubscribe", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String authenticateOnUnsubscribe,
        @WebParam(name = "ConfirmSubscriptionResult", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<ConfirmSubscriptionResult> confirmSubscriptionResult,
        @WebParam(name = "ResponseMetadata", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<ResponseMetadata> responseMetadata);

    /**
     * 
     *     <p>The GetTopicAttribtues action returns all of the properties of a topic customers have created. Topic
     *       properties returned might differ based on the authorization of the user. </p>
     * <examples>
     *  <queryrequest>
     * 
     *   http://sns.us-east-1.amazonaws.com/
     *   ?TopicArn=arn%3Aaws%3Asns%3Aus-east-1%3A123456789012%3AMy-Topic
     *   &Action=GetTopicAttributes
     *   &SignatureVersion=2
     *   &SignatureMethod=HmacSHA256
     *   &Timestamp=2010-03-31T12%3A00%3A00.000Z
     *   &AWSAccessKeyId=(AWS Access Key Id)
     *   &Signature=92lBGRVq0%2BxhaACaBGqtdemy%2Bi9isfgyTljCbJM80Yk%3D
     * 
     *  </queryrequest>
     *  <queryresponse>
     *   
     * <GetTopicAttributesResponse xmlns="http://sns.amazonaws.com/doc/2010-03-31/">
     *   <GetTopicAttributesResult>
     *     <Attributes>
     *       <entry>
     *         <key>Owner</key>
     *         <value>123456789012</value>
     *       </entry>
     *       <entry>
     *         <key>Policy</key>
     *         <value>{
     * &quot;Version&quot;:&quot;2008-10-17&quot;,&quot;Id&quot;:&quot;us-east-1/698519295917/test__default_policy_ID&quot;,&quot;Statement&quot; : [{&quot;Effect&quot;:&quot;Allow&quot;,&quot;Sid&quot;:&quot;us-east-1/698519295917/test__default_statement_ID&quot;,&quot;Principal&quot; : {&quot;AWS&quot;: &quot;*&quot;},&quot;Action&quot;:[&quot;SNS:GetTopicAttributes&quot;,&quot;SNS:SetTopicAttributes&quot;,&quot;SNS:AddPermission&quot;,&quot;SNS:RemovePermission&quot;,&quot;SNS:DeleteTopic&quot;,&quot;SNS:Subscribe&quot;,&quot;SNS:ListSubscriptionsByTopic&quot;,&quot;SNS:Publish&quot;,&quot;SNS:Receive&quot;],&quot;Resource&quot;:&quot;arn:aws:sns:us-east-1:698519295917:test&quot;,&quot;Condition&quot; : {&quot;StringLike&quot; : {&quot;AWS:SourceArn&quot;: &quot;arn:aws:*:*:698519295917:*&quot;}}}]}</value>
     *       </entry>
     *       <entry>
     *         <key>TopicArn</key>
     *         <value>arn:aws:sns:us-east-1:123456789012:My-Topic</value>
     *       </entry>
     *     </Attributes>
     *   </GetTopicAttributesResult>
     *   <ResponseMetadata>
     *     <RequestId>057f074c-33a7-11df-9540-99d0768312d3</RequestId>
     *   </ResponseMetadata>
     * </GetTopicAttributesResponse>
     *   
     *  </queryresponse>
     * </examples>
     *   
     * 
     * @param getTopicAttributesResult
     * @param responseMetadata
     * @param topicArn
     */
    @WebMethod(operationName = "GetTopicAttributes", action = "GetTopicAttributes")
    @RequestWrapper(localName = "GetTopicAttributes", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.GetTopicAttributes")
    @ResponseWrapper(localName = "GetTopicAttributesResponse", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.GetTopicAttributesResponse")
    public void getTopicAttributes(
        @WebParam(name = "TopicArn", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String topicArn,
        @WebParam(name = "GetTopicAttributesResult", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<GetTopicAttributesResult> getTopicAttributesResult,
        @WebParam(name = "ResponseMetadata", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<ResponseMetadata> responseMetadata);

    /**
     * 
     *     <p>The Subscribe action prepares to subscribe an endpoint by sending the endpoint a confirmation message. To actually create a
     *       subscription, the endpoint owner must call the ConfirmSubscription
     *       action with the token from the confirmation message. Confirmation tokens are
     *       valid for twenty-four hours.</p>
     * <examples>
     *  <queryrequest>
     * 
     *   http://sns.us-east-1.amazonaws.com/
     *   ?TopicArn=arn%3Aaws%3Asns%3Aus-east-1%3A123456789012%3AMy-Topic
     *   &Endpoint=example%40amazon.com
     *   &Protocol=email
     *   &Action=Subscribe
     *   &SignatureVersion=2
     *   &SignatureMethod=HmacSHA256
     *   &Timestamp=2010-03-31T12%3A00%3A00.000Z
     *   &AWSAccessKeyId=(AWS Access Key ID)
     *   &Signature=1%2FeGaDphxXq%2Fa89x6HvKh%2Fc1yLGXzuhS7vS2MslToDM%3D
     * 
     *  </queryrequest>
     *  <queryresponse>
     *   
     * <SubscribeResponse xmlns="http://sns.amazonaws.com/doc/2010-03-31/">
     *   <SubscribeResult>
     *     <SubscriptionArn>pending confirmation</SubscriptionArn>
     *   </SubscribeResult>
     *   <ResponseMetadata>
     *     <RequestId>a169c740-3766-11df-8963-01868b7c937a</RequestId>
     *   </ResponseMetadata>
     * </SubscribeResponse>
     *   
     *  </queryresponse>
     * </examples>
     *   
     * 
     * @param protocol
     * @param endpoint
     * @param subscribeResult
     * @param responseMetadata
     * @param topicArn
     */
    @WebMethod(operationName = "Subscribe", action = "Subscribe")
    @RequestWrapper(localName = "Subscribe", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.Subscribe")
    @ResponseWrapper(localName = "SubscribeResponse", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.SubscribeResponse")
    public void subscribe(
        @WebParam(name = "TopicArn", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String topicArn,
        @WebParam(name = "Protocol", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String protocol,
        @WebParam(name = "Endpoint", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String endpoint,
        @WebParam(name = "SubscribeResult", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<SubscribeResult> subscribeResult,
        @WebParam(name = "ResponseMetadata", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<ResponseMetadata> responseMetadata);

    /**
     * 
     *     <p>The SetTopicAttributes action allows a topic owner to set an attribute of the topic to a new value.</p>
     * <examples>
     *  <queryrequest>
     * 
     *   http://sns.us-east-1.amazonaws.com/
     *   ?AttributeValue=MyTopicName
     *   &TopicArn=arn%3Aaws%3Asns%3Aus-east-1%3A123456789012%3AMy-Topic
     *   &AttributeName=DisplayName
     *   &Action=SetTopicAttributes
     *   &SignatureVersion=2
     *   &SignatureMethod=HmacSHA256
     *   &Timestamp=2010-03-31T12%3A00%3A00.000Z
     *   &AWSAccessKeyId=(AWS Access Key Id)
     *   &Signature=mQA3nJI%2BcmAIY7r8HCArGElSqPX5JG4UGzF4yo0RygE%3D
     * 
     *  </queryrequest>
     *  <queryresponse>
     *   
     * <SetTopicAttributesResponse xmlns="http://sns.amazonaws.com/doc/2010-03-31/">
     *   <ResponseMetadata>
     *     <RequestId>a8763b99-33a7-11df-a9b7-05d48da6f042</RequestId>
     *   </ResponseMetadata>
     * </SetTopicAttributesResponse>
     *   
     *  </queryresponse>
     * </examples>
     * 
     * 
     *   
     * 
     * @param attributeValue
     * @param attributeName
     * @param topicArn
     * @return
     *     returns com.amazonaws.sns.doc._2010_03_31.ResponseMetadata
     */
    @WebMethod(operationName = "SetTopicAttributes", action = "SetTopicAttributes")
    @WebResult(name = "ResponseMetadata", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
    @RequestWrapper(localName = "SetTopicAttributes", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.SetTopicAttributes")
    @ResponseWrapper(localName = "SetTopicAttributesResponse", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.SetTopicAttributesResponse")
    public ResponseMetadata setTopicAttributes(
        @WebParam(name = "TopicArn", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String topicArn,
        @WebParam(name = "AttributeName", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String attributeName,
        @WebParam(name = "AttributeValue", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String attributeValue);

    /**
     * 
     *     <p>The DeleteTopic action deletes a topic and all its subscriptions. Deleting a topic might
     *       prevent some messages previously sent to the topic from being delivered to
     *       subscribers. This action is idempotent, so deleting a topic that does not
     *       exist will not result in an error.</p>
     * <examples>
     * <queryrequest>
     * 
     *   http://sns.us-east-1.amazonaws.com/
     *   &TopicArn=arn%3Aaws%3Asns%3Aus-east-1%3A123456789012%3AMy-Topic
     *   &Action=DeleteTopic
     *   &SignatureVersion=2
     *   &SignatureMethod=HmacSHA256
     *   &Timestamp=2010-03-31T12%3A00%3A00.000Z
     *   &AWSAccessKeyId=(AWS Access Key Id)
     *   &Signature=mQA3nJI%2BcmAIY7r8HCArGElSqPX5JG4UGzF4yo0RygE%3D
     * 
     * </queryrequest>
     * <queryresponse>
     * 
     * <DeleteTopicResponse xmlns="http://sns.amazonaws.com/doc/2010-03-31/">
     *   <ResponseMetadata>
     *     <RequestId>f3aa9ac9-3c3d-11df-8235-9dab105e9c32</RequestId>
     *   </ResponseMetadata>
     * </DeleteTopicResponse>
     * 
     * </queryresponse>
     * </examples>
     *   
     * 
     * @param topicArn
     * @return
     *     returns com.amazonaws.sns.doc._2010_03_31.ResponseMetadata
     */
    @WebMethod(operationName = "DeleteTopic", action = "DeleteTopic")
    @WebResult(name = "ResponseMetadata", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
    @RequestWrapper(localName = "DeleteTopic", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.DeleteTopic")
    @ResponseWrapper(localName = "DeleteTopicResponse", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.DeleteTopicResponse")
    public ResponseMetadata deleteTopic(
        @WebParam(name = "TopicArn", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String topicArn);

    /**
     * 
     *     <p>The RemovePermission action removes a statement from a topic's access control policy.</p>
     * <examples>
     *  <queryrequest>
     * 
     *   http://sns.us-east-1.amazonaws.com/
     *   ?TopicArn=arn%3Aaws%3Asns%3Aus-east-1%3A123456789012%3AMy-Test
     *   &Label=NewPermission
     *   &Action=RemovePermission
     *   &SignatureVersion=2
     *   &SignatureMethod=HmacSHA256
     *   &Timestamp=2010-03-31T12%3A00%3A00.000Z
     *   &AWSAccessKeyId=(AWS Access Key ID)
     *   &Signature=N1abwRY9i7zaSQmbAlm71pPf9EEFOqNbQL1alzw2yCg%3D
     * 
     *  </queryrequest>
     *  <queryresponse>
     *   
     * <RemovePermissionResponse xmlns="http://sns.amazonaws.com/doc/2010-03-31/">
     *   <ResponseMetadata>
     *     <RequestId>d170b150-33a8-11df-995a-2d6fbe836cc1</RequestId>
     *   </ResponseMetadata>
     * </RemovePermissionResponse>
     *   
     *  </queryresponse>
     * </examples>
     *   
     * 
     * @param label
     * @param topicArn
     * @return
     *     returns com.amazonaws.sns.doc._2010_03_31.ResponseMetadata
     */
    @WebMethod(operationName = "RemovePermission", action = "RemovePermission")
    @WebResult(name = "ResponseMetadata", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
    @RequestWrapper(localName = "RemovePermission", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.RemovePermission")
    @ResponseWrapper(localName = "RemovePermissionResponse", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.RemovePermissionResponse")
    public ResponseMetadata removePermission(
        @WebParam(name = "TopicArn", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String topicArn,
        @WebParam(name = "Label", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String label);

    /**
     * 
     *     <p>The ListSubscriptions action returns a list of the requester's subscriptions. Each call returns a limited list
     *      of subscriptions. If there are more subscriptions, a NextToken is also returned. Use the NextToken parameter in a 
     *      new ListSubscriptions call to get further results.</p>
     * <examples>
     *  <queryrequest>
     * 
     *   http://sns.us-east-1.amazonaws.com/
     *   &Action=ListSubscriptions
     *   &SignatureVersion=2
     *   &SignatureMethod=HmacSHA256
     *   &Timestamp=2010-03-31T12%3A00%3A00.000Z
     *   &AWSAccessKeyId=(AWS Access Key ID)
     *   &Signature=SZmBxEPqfs9R7xxhSt6C1b7PnOEvg%2BSVyyMYJfLRFCA%3D
     * 
     *  </queryrequest>
     *  <queryresponse>
     *   
     * <ListSubscriptionsResponse xmlns="http://sns.amazonaws.com/doc/2010-03-31/">
     *   <ListSubscriptionsResult>
     *     <Subscriptions>
     *       <member>
     *         <TopicArn>arn:aws:sns:us-east-1:698519295917:My-Topic</TopicArn>
     *         <Protocol>email</Protocol>
     *         <SubscriptionArn>arn:aws:sns:us-east-1:123456789012:My-Topic:80289ba6-0fd4-4079-afb4-ce8c8260f0ca</SubscriptionArn>
     *         <Owner>123456789012</Owner>
     *         <Endpoint>example@amazon.com</Endpoint>
     *       </member>
     *     </Subscriptions>
     *   </ListSubscriptionsResult>
     *   <ResponseMetadata>
     *     <RequestId>384ac68d-3775-11df-8963-01868b7c937a</RequestId>
     *   </ResponseMetadata>
     * </ListSubscriptionsResponse>
     *   
     *  </queryresponse>
     * </examples>
     *   
     * 
     * @param nextToken
     * @param responseMetadata
     * @param listSubscriptionsResult
     */
    @WebMethod(operationName = "ListSubscriptions", action = "ListSubscriptions")
    @RequestWrapper(localName = "ListSubscriptions", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.ListSubscriptions")
    @ResponseWrapper(localName = "ListSubscriptionsResponse", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.ListSubscriptionsResponse")
    public void listSubscriptions(
        @WebParam(name = "NextToken", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String nextToken,
        @WebParam(name = "ListSubscriptionsResult", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<ListSubscriptionsResult> listSubscriptionsResult,
        @WebParam(name = "ResponseMetadata", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<ResponseMetadata> responseMetadata);

    /**
     * 
     *     <p>The AddPermission action adds a statement to a topic's access control policy, granting access for the specified AWS accounts to the specified actions.</p>
     * <examples>
     *  <queryrequest>
     * 
     *   http://sns.us-east-1.amazonaws.com/
     *   ?TopicArn=arn%3Aaws%3Asns%3Aus-east-1%3A123456789012%3AMy-Test
     *   &ActionName.member.1=SNS%3APublish
     *   &ActionName.member.2=SNS%3AGetTopicAttributes
     *   &Label=NewPermission
     *   &AWSAccountId.member.1=987654321000
     *   &AWSAccountId.member.2=876543210000
     *   &Action=AddPermission
     *   &SignatureVersion=2
     *   &SignatureMethod=HmacSHA256
     *   &Timestamp=2010-03-31T12%3A00%3A00.000Z
     *   &AWSAccessKeyId=(AWS Access Key ID)
     *   &Signature=k%2FAU%2FKp13pjndwJ7rr1sZszy6MZMlOhRBCHx1ZaZFiw%3D
     * 
     *  </queryrequest>
     *  <queryresponse>
     *   
     * <AddPermissionResponse xmlns="http://sns.amazonaws.com/doc/2010-03-31/">
     *   <ResponseMetadata>
     *     <RequestId>6a213e4e-33a8-11df-9540-99d0768312d3</RequestId>
     *   </ResponseMetadata>
     * </AddPermissionResponse>
     *   
     *  </queryresponse>
     * </examples>
     *   
     * 
     * @param awsAccountId
     * @param label
     * @param topicArn
     * @param actionName
     * @return
     *     returns com.amazonaws.sns.doc._2010_03_31.ResponseMetadata
     */
    @WebMethod(operationName = "AddPermission", action = "AddPermission")
    @WebResult(name = "ResponseMetadata", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
    @RequestWrapper(localName = "AddPermission", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.AddPermission")
    @ResponseWrapper(localName = "AddPermissionResponse", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.AddPermissionResponse")
    public ResponseMetadata addPermission(
        @WebParam(name = "TopicArn", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String topicArn,
        @WebParam(name = "Label", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String label,
        @WebParam(name = "AWSAccountId", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        DelegatesList awsAccountId,
        @WebParam(name = "ActionName", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        ActionsList actionName);

    /**
     * 
     *     <p>The CreateTopic action creates a topic to which notifications can be published. Users can create
     *      at most 25 topics. This action is idempotent, so if the requester 
     *      already owns a topic with the specified name, that topic's ARN will be 
     *      returned without creating a new topic.</p>
     * <examples>
     *  <queryrequest>
     * 
     *   http://sns.us-east-1.amazonaws.com/
     *   ?Name=My-Topic
     *   &Action=CreateTopic
     *   &SignatureVersion=2
     *   &SignatureMethod=HmacSHA256
     *   &Timestamp=2010-03-31T12%3A00%3A00.000Z
     *   &AWSAccessKeyId=(AWS Access Key ID)
     *   &Signature=gfzIF53exFVdpSNb8AiwN3Lv%2FNYXh6S%2Br3yySK70oX4%3D
     * 
     *  </queryrequest>
     *  <queryresponse>
     *   
     *    <CreateTopicResponse xmlns="http://sns.amazonaws.com/doc/2010-03-31/">
     *      <CreateTopicResult>
     *        <TopicArn>arn:aws:sns:us-east-1:123456789012:My-Topic</TopicArn>
     *      </CreateTopicResult>
     *      <ResponseMetadata>
     *        <RequestId>a8dec8b3-33a4-11df-8963-01868b7c937a</RequestId>
     *      </ResponseMetadata>
     *    </CreateTopicResponse>
     *   
     *  </queryresponse>
     * </examples>
     *   
     * 
     * @param name
     * @param responseMetadata
     * @param createTopicResult
     */
    @WebMethod(operationName = "CreateTopic", action = "CreateTopic")
    @RequestWrapper(localName = "CreateTopic", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.CreateTopic")
    @ResponseWrapper(localName = "CreateTopicResponse", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.CreateTopicResponse")
    public void createTopic(
        @WebParam(name = "Name", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String name,
        @WebParam(name = "CreateTopicResult", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<CreateTopicResult> createTopicResult,
        @WebParam(name = "ResponseMetadata", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<ResponseMetadata> responseMetadata);

    /**
     * 
     *     <p>The ListTopics action returns a list of the requester's topics. Each call returns a limited list of topics. If
     *      there are more topics, a NextToken is also returned. Use the NextToken parameter in a new ListTopics call to get 
     *      further results.</p>
     * <examples>
     *  <queryrequest>
     * 
     *   http://sns.us-east-1.amazonaws.com/
     *   ?Action=ListTopics
     *   &SignatureVersion=2
     *   &SignatureMethod=HmacSHA256
     *   &Timestamp=2010-03-31T12%3A00%3A00.000Z
     *   &AWSAccessKeyId=(AWS Access Key ID)
     *   &Signature=tPg1qKNTNVPydnL3Yx5Fqm2O9GxCr9vh3EF5r9%2F5%2BJs%3D
     * 
     *  </queryrequest>
     *  <queryresponse>
     *   
     * <ListTopicsResponse xmlns="http://sns.amazonaws.com/doc/2010-03-31/">
     *   <ListTopicsResult>
     *     <Topics>
     *       <member>
     *         <TopicArn>arn:aws:sns:us-east-1:123456789012:My-Topic</TopicArn>
     *       </member>
     *     </Topics>
     *   </ListTopicsResult>
     *   <ResponseMetadata>
     *     <RequestId>3f1478c7-33a9-11df-9540-99d0768312d3</RequestId>
     *   </ResponseMetadata>
     * </ListTopicsResponse>
     *   
     *  </queryresponse>
     * </examples>
     *   
     * 
     * @param nextToken
     * @param responseMetadata
     * @param listTopicsResult
     */
    @WebMethod(operationName = "ListTopics", action = "ListTopics")
    @RequestWrapper(localName = "ListTopics", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.ListTopics")
    @ResponseWrapper(localName = "ListTopicsResponse", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.ListTopicsResponse")
    public void listTopics(
        @WebParam(name = "NextToken", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String nextToken,
        @WebParam(name = "ListTopicsResult", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<ListTopicsResult> listTopicsResult,
        @WebParam(name = "ResponseMetadata", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<ResponseMetadata> responseMetadata);

    /**
     * 
     *     <p>The Unsubscribe action deletes a subscription. If the subscription requires authentication for 
     *     deletion, only the owner of the subscription or the its topic's owner 
     *     can unsubscribe, and an AWS signature is required. If the 
     *     Unsubscribe call does not require authentication and the requester is not 
     *     the subscription owner, a final cancellation message is delivered to the 
     *     endpoint, so that the endpoint owner can easily resubscribe to the topic if 
     *     the Unsubscribe request was unintended.</p>
     * <examples>
     *  <queryrequest>
     * 
     *   http://sns.us-east-1.amazonaws.com/
     *   ?SubscriptionArn=arn%3Aaws%3Asns%3Aus-east-1%3A123456789012%3AMy-Topic%3A80289ba6-0fd4-4079-afb4-ce8c8260f0ca
     *   &Action=Unsubscribe
     *   &SignatureVersion=2
     *   &SignatureMethod=HmacSHA256
     *   &Timestamp=2010-03-31T12%3A00%3A00.000Z
     *   &AWSAccessKeyId=(AWS Access Key ID)
     *   &Signature=e8IwhPzuWeMvPDVrN7jUVxasd3Wv2LuO8x6rE23VCv8%3D
     * 
     *  </queryrequest>
     *  <queryresponse>
     *   
     * <UnsubscribeResponse xmlns="http://sns.amazonaws.com/doc/2010-03-31/">
     *   <ResponseMetadata>
     *     <RequestId>18e0ac39-3776-11df-84c0-b93cc1666b84</RequestId>
     *   </ResponseMetadata>
     * </UnsubscribeResponse>
     *   
     *  </queryresponse>
     * </examples>
     *   
     * 
     * @param subscriptionArn
     * @return
     *     returns com.amazonaws.sns.doc._2010_03_31.ResponseMetadata
     */
    @WebMethod(operationName = "Unsubscribe", action = "Unsubscribe")
    @WebResult(name = "ResponseMetadata", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
    @RequestWrapper(localName = "Unsubscribe", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.Unsubscribe")
    @ResponseWrapper(localName = "UnsubscribeResponse", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.UnsubscribeResponse")
    public ResponseMetadata unsubscribe(
        @WebParam(name = "SubscriptionArn", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String subscriptionArn);

    /**
     * 
     *     <p>The ListSubscriptionsByTopic action returns a list of the subscriptions to a specific topic. Each call returns 
     *     a limited list of subscriptions. If there are more subscriptions, a NextToken is also returned. Use the NextToken 
     *     parameter in a new ListSubscriptionsByTopic call to get further results.</p>
     * <examples>
     *  <queryrequest>
     * 
     *   http://sns.us-east-1.amazonaws.com/
     *   ?TopicArn=arn%3Aaws%3Asns%3Aus-east-1%3A123456789012%3AMy-Topic
     *   &Action=ListSubscriptionsByTopic
     *   &SignatureVersion=2
     *   &SignatureMethod=HmacSHA256
     *   &Timestamp=2010-03-31T12%3A00%3A00.000Z
     *   &AWSAccessKeyId=(AWS Access Key ID)
     *   &Signature=SZmBxEPqfs9R7xxhSt6C1b7PnOEvg%2BSVyyMYJfLRFCA%3D
     * 
     *  </queryrequest>
     *  <queryresponse>
     *   
     * <ListSubscriptionsByTopicResponse xmlns="http://sns.amazonaws.com/doc/2010-03-31/">
     *   <ListSubscriptionsByTopicResult>
     *     <Subscriptions>
     *       <member>
     *         <TopicArn>arn:aws:sns:us-east-1:123456789012:My-Topic</TopicArn>
     *         <Protocol>email</Protocol>
     *         <SubscriptionArn>arn:aws:sns:us-east-1:123456789012:My-Topic:80289ba6-0fd4-4079-afb4-ce8c8260f0ca</SubscriptionArn>
     *         <Owner>123456789012</Owner>
     *         <Endpoint>example@amazon.com</Endpoint>
     *       </member>
     *     </Subscriptions>
     *   </ListSubscriptionsByTopicResult>
     *   <ResponseMetadata>
     *     <RequestId>b9275252-3774-11df-9540-99d0768312d3</RequestId>
     *   </ResponseMetadata>
     * </ListSubscriptionsByTopicResponse>
     *   
     *  </queryresponse>
     * </examples>
     *   
     * 
     * @param nextToken
     * @param responseMetadata
     * @param listSubscriptionsByTopicResult
     * @param topicArn
     */
    @WebMethod(operationName = "ListSubscriptionsByTopic", action = "ListSubscriptionsByTopic")
    @RequestWrapper(localName = "ListSubscriptionsByTopic", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.ListSubscriptionsByTopic")
    @ResponseWrapper(localName = "ListSubscriptionsByTopicResponse", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.ListSubscriptionsByTopicResponse")
    public void listSubscriptionsByTopic(
        @WebParam(name = "TopicArn", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String topicArn,
        @WebParam(name = "NextToken", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String nextToken,
        @WebParam(name = "ListSubscriptionsByTopicResult", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<ListSubscriptionsByTopicResult> listSubscriptionsByTopicResult,
        @WebParam(name = "ResponseMetadata", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<ResponseMetadata> responseMetadata);

    /**
     * 
     *     <p>The Publish action sends a message to all of a topic's subscribed endpoints. When a
     *     messageId is returned, the message has been saved and Amazon SNS will attempt to deliver it 
     *     to the topic's subscribers shortly. The format of the outgoing message to each
     *     subscribed endpoint depends on the notification protocol selected.</p>
     * <examples>
     *  <queryrequest>
     * 
     *   http://sns.us-east-1.amazonaws.com/
     *   ?Subject=My%20first%20message
     *   &TopicArn=arn%3Aaws%3Asns%3Aus-east-1%3A698519295917%3AMy-Topic
     *   &Message=Hello%20world%21
     *   &Action=Publish
     *   &SignatureVersion=2
     *   &SignatureMethod=HmacSHA256
     *   &Timestamp=2010-03-31T12%3A00%3A00.000Z
     *   &AWSAccessKeyId=AKIAJHS4T6XPF7XIURNA
     *   &Signature=9GZysQ4Jpnz%2BHklqM7VFTvEcjR2LIUtn6jW47054xxE%3D
     * 
     *  </queryrequest>
     *  <queryresponse>
     *   
     * <PublishResponse xmlns="http://sns.amazonaws.com/doc/2010-03-31/">
     *   <PublishResult>
     *     <MessageId>94f20ce6-13c5-43a0-9a9e-ca52d816e90b</MessageId>
     *   </PublishResult>
     *   <ResponseMetadata>
     *     <RequestId>f187a3c1-376f-11df-8963-01868b7c937a</RequestId>
     *   </ResponseMetadata>
     * </PublishResponse>
     *   
     *  </queryresponse>
     * </examples>
     *   
     * 
     * @param publishResult
     * @param subject
     * @param responseMetadata
     * @param message
     * @param topicArn
     */
    @WebMethod(operationName = "Publish", action = "Publish")
    @RequestWrapper(localName = "Publish", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.Publish")
    @ResponseWrapper(localName = "PublishResponse", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", className = "com.amazonaws.sns.doc._2010_03_31.PublishResponse")
    public void publish(
        @WebParam(name = "TopicArn", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String topicArn,
        @WebParam(name = "Message", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String message,
        @WebParam(name = "Subject", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/")
        String subject,
        @WebParam(name = "PublishResult", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<PublishResult> publishResult,
        @WebParam(name = "ResponseMetadata", targetNamespace = "http://sns.amazonaws.com/doc/2010-03-31/", mode = WebParam.Mode.OUT)
        Holder<ResponseMetadata> responseMetadata);

}
