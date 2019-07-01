package io.scalajs.npm.aws.sns

import io.scalajs.RawOptions
import io.scalajs.npm.aws.{AWSCallback, AWSRequest, Service}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Amazon Simple Notification Service (Amazon SNS) is a web service that enables you to build distributed web-enabled
  * applications. Applications can use Amazon SNS to easily push real-time notification messages to interested subscribers
  * over multiple delivery protocols. For more information about this product see https://aws.amazon.com/sns. For detailed
  * information about Amazon SNS features and their associated API calls, see the Amazon SNS Developer Guide.
  *
  * We also provide SDKs that enable you to access Amazon SNS from your preferred programming language. The SDKs contain
  * functionality that automatically takes care of tasks such as: cryptographically signing your service requests,
  * retrying requests, and handling error responses. For a list of available SDKs, go to Tools for Amazon Web Services.
  * @example {{{
  *
  * var sns = new AWS.SNS();
  * sns.addPermission(params, function (err, data) {
  *   if (err) console.log(err, err.stack); // an error occurred
  *   else     console.log(data);           // successful response
  * });
  *
  * }}}
  * @see [[https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/SNS.html]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("aws-sdk", "SNS")
class SNS(options: SNSOptions | RawOptions = js.native) extends Service {

  /**
    * Adds a statement to a topic's access control policy, granting access for the specified AWS accounts
    * to the specified actions.
    * @param params
    * @param callback
    */
  def addPermission(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Accepts a phone number and indicates whether the phone holder has opted out of receiving SMS messages from your account.
    * @param params
    * @param callback
    * @return
    */
  def checkIfPhoneNumberIsOptedOut(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Verifies an endpoint owner's intent to receive messages by validating the token sent to the endpoint by an
    * earlier Subscribe action.
    * @param params
    * @param callback
    * @return
    */
  def confirmSubscription(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Creates a platform application object for one of the supported push notification services, such as APNS and FCM,
    * to which devices and mobile apps may register.
    * @param params
    * @param callback
    * @return
    */
  def createPlatformApplication(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Creates an endpoint for a device and mobile app on one of the supported push notification services, such as GCM and APNS.
    * @param params
    * @param callback
    * @return
    */
  def createPlatformEndpoint(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Creates a topic to which notifications can be published.
    * @param params
    * @param callback
    * @return
    */
  def createTopic(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Deletes the endpoint for a device and mobile app from Amazon SNS.
    * @param params
    * @param callback
    * @return
    */
  def deleteEndpoint(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Deletes a platform application object for one of the supported push notification services, such as APNS and GCM.
    * @param params
    * @param callback
    * @return
    */
  def deletePlatformApplication(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Deletes a topic and all its subscriptions.
    * @param params
    * @param callback
    * @return
    */
  def deleteTopic(params: DeleteTopic | RawOptions, callback: AWSCallback[DeleteTopicResult] = js.native): AWSRequest[DeleteTopicResult] = js.native

  /**
    * Retrieves the endpoint attributes for a device on one of the supported push notification services, such as GCM and APNS.
    * @param params
    * @param callback
    * @return
    */
  def getEndpointAttributes(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Retrieves the attributes of the platform application object for the supported push notification services, such as APNS and GCM.
    * @param params
    * @param callback
    * @return
    */
  def getPlatformApplicationAttributes(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Returns the settings for sending SMS messages from your account.
    * @param params
    * @param callback
    * @return
    */
  def getSMSAttributes(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Returns all of the properties of a subscription.
    * @param params
    * @param callback
    * @return
    */
  def getSubscriptionAttributes(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Returns all of the properties of a topic.
    * @param params
    * @param callback
    * @return
    */
  def getTopicAttributes(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Lists the endpoints and endpoint attributes for devices in a supported push notification service, such as GCM and APNS.
    * @param params
    * @param callback
    * @return
    */
  def listEndpointsByPlatformApplication(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Returns a list of phone numbers that are opted out, meaning you cannot send SMS messages to them.
    * @param params
    * @param callback
    * @return
    */
  def listPhoneNumbersOptedOut(params: ListPhoneNumbersOptedOut | RawOptions, callback: AWSCallback[ListPhoneNumbersOptedOutResult] = js.native): AWSRequest[ListPhoneNumbersOptedOutResult] = js.native

  /**
    * Lists the platform application objects for the supported push notification services, such as APNS and GCM.
    * @param params
    * @param callback
    * @return
    */
  def listPlatformApplications(params: ListPlatformApplications | RawOptions, callback: AWSCallback[ListPlatformApplicationsResult] = js.native): AWSRequest[ListPlatformApplicationsResult] = js.native

  /**
    * Returns a list of the requester's subscriptions.
    * @param params
    * @param callback
    * @return
    */
  def listSubscriptions(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Returns a list of the subscriptions to a specific topic.
    * @param params
    * @param callback
    * @return
    */
  def listSubscriptionsByTopic(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * List all tags added to the specified Amazon SNS topic.
    * @param params
    * @param callback
    * @return
    */
  def listTagsForResource(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Returns a list of the requester's topics.
    * @param params
    * @param callback
    * @return
    */
  def listTopics(params: ListTopics | RawOptions, callback: AWSCallback[ListTopicsResult] = js.native): AWSRequest[ListTopicsResult] = js.native

  /**
    * Use this request to opt in a phone number that is opted out, which enables you to resume sending SMS messages to the number.
    * @param params
    * @param callback
    * @return
    */
  def optInPhoneNumber(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Sends a message to an Amazon SNS topic or sends a text message (SMS message) directly to a phone number.
    * @param params
    * @param callback
    * @return
    */
  def publish(params: SNSMessage | RawOptions, callback: AWSCallback[SNSDataObject] = js.native): AWSRequest[SNSDataObject] = js.native

  /**
    * Removes a statement from a topic's access control policy.
    * @param params
    * @param callback
    * @return
    */
  def removePermission(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Sets the attributes for an endpoint for a device on one of the supported push notification services, such as GCM and APNS.
    * @param params
    * @param callback
    * @return
    */
  def setEndpointAttributes(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Sets the attributes of the platform application object for the supported push notification services, such as APNS and GCM.
    * @param params
    * @param callback
    * @return
    */
  def setPlatformApplicationAttributes(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Use this request to set the default settings for sending SMS messages and receiving daily SMS usage reports.
    * @param params
    * @param callback
    * @return
    */
  def setSMSAttributes(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Allows a subscription owner to set an attribute of the subscription to a new value.
    * @param params
    * @param callback
    * @return
    */
  def setSubscriptionAttributes(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Allows a topic owner to set an attribute of the topic to a new value.
    * @param params
    * @param callback
    * @return
    */
  def setTopicAttributes(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Prepares to subscribe an endpoint by sending the endpoint a confirmation message.
    * @param params
    * @param callback
    * @return
    */
  def subscribe(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Add tags to the specified Amazon SNS topic.
    * @param params
    * @param callback
    * @return
    */
  def tagResource(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Deletes a subscription.
    * @param params
    * @param callback
    * @return
    */
  def unsubscribe(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

  /**
    * Remove tags from the specified Amazon SNS topic.
    * @param params
    * @param callback
    * @return
    */
  def untagResource(params: RawOptions, callback: AWSCallback[js.Any] = js.native): AWSRequest[js.Any] = js.native

}
