package org.scalajs.nodejs.azure

import scala.scalajs.js

/**
  * Azure Service Bus Service
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ServiceBusService extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Service Bus Queues
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Creates a queue (if it doesn't already exist)
    * @param queueName the name of the queue
    * @param callback  the error callback
    */
  def createQueueIfNotExists(queueName: String, callback: js.Function): Unit = js.native

  /**
    * Sends a message to a named queue
    * @param queueName the name of the queue
    * @param message   the message to send
    * @param callback  the error callback
    */
  def sendQueueMessage(queueName: String, message: js.Any, callback: js.Function): Unit = js.native

  /**
    * Dequeues a message from a named queue
    * @param queueName the name of the queue
    * @param callback  the error callback
    */
  def receiveQueueMessage(queueName: String, callback: js.Function): Unit = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Service Bus Topics
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Creates a subscription for a topic
    * @param topicName    the name of the topic
    * @param subscription the name of the subscription
    * @param callback     the error callback
    */
  def createSubscription(topicName: String, subscription: String, callback: js.Function): Unit = js.native

  /**
    * Creates a topic (if it doesn't already exist)
    * @param topicName the name of the topic
    * @param callback  the error callback
    */
  def createTopicIfNotExists(topicName: String, callback: js.Function): Unit = js.native

  /**
    * Sends a message to a named topic
    * @param topicName the name of the topic
    * @param message   the message to send
    * @param callback  the error callback
    */
  def sendTopicMessage(topicName: String, message: js.Any, callback: js.Function): Unit = js.native

  /**
    * Receives a subscription message from a named topic
    * @param topicName the name of the topic
    * @param callback  the error callback
    */
  def receiveSubscriptionMessage(topicName: String, callback: js.Function): Unit = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Notification Hubs
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Creates a notification hub (if it doesn't already exist)
    * @param hubName  the name of the hub
    * @param callback the error callback
    */
  def createNotificationHub(hubName: String, callback: js.Function): Unit = js.native

  /**
    * Creates a notification hub service
    * @param serviceName the name of the service
    * @return a new [[NotificationHubService service]]
    */
  def createNotificationHubService(serviceName: String): NotificationHubService = js.native

}
