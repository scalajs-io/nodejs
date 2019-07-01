package io.scalajs.npm.aws.sns

import scala.scalajs.js

/**
  * Represents an SNS message
  * @param Message           The message you want to send.
  * @param MessageAttributes Message attributes for Publish action.
  * @param MessageStructure  Set MessageStructure to json if you want to send a different message for each protocol.
  *                          For example, using one publish action, you can send a short message to your SMS subscribers
  *                          and a longer message to your email subscribers.
  * @param PhoneNumber       The phone number to which you want to deliver an SMS message. Use E.164 format.
  * @param Subject           Optional parameter to be used as the "Subject" line when the message is delivered to email endpoints.
  *                          This field will also be included, if present, in the standard JSON messages delivered to other endpoints.
  * @param TargetArn         If you don't specify a value for the TargetArn parameter, you must specify a value for
  *                          the PhoneNumber or TopicArn parameters.
  * @param TopicArn          The topic you want to publish to.
  * @example {{{
  *
  * var params = {
  *   Message: 'STRING_VALUE', /* required */
  *   MessageAttributes: {
  *     '<String>': {
  *       DataType: 'STRING_VALUE', /* required */
  *       BinaryValue: Buffer.from('...') || 'STRING_VALUE' /* Strings will be Base-64 encoded on your behalf */,
  *       StringValue: 'STRING_VALUE'
  *     },
  *     /* '<String>': ... */
  *   },
  *   MessageStructure: 'STRING_VALUE',
  *   PhoneNumber: 'STRING_VALUE',
  *   Subject: 'STRING_VALUE',
  *   TargetArn: 'STRING_VALUE',
  *   TopicArn: 'STRING_VALUE'
  * };
  * sns.publish(params, function(err, data) {
  *   if (err) console.log(err, err.stack); // an error occurred
  *   else     console.log(data);           // successful response
  * });
  *
  * }}}
  * @see [[https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/SNS.html#publish-property]]
  */
class SNSMessage(Message: String,
                 MessageAttributes: js.Dictionary[String] = js.Dictionary.empty,
                 MessageStructure: js.UndefOr[String] = js.undefined,
                 PhoneNumber: js.UndefOr[String] = js.undefined,
                 Subject: js.UndefOr[String] = js.undefined,
                 TargetArn: js.UndefOr[String] = js.undefined,
                 TopicArn: js.UndefOr[String] = js.undefined) extends js.Object