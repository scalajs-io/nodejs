package io.scalajs.npm

import io.scalajs.util.ScalaJsHelper.futureCallbackE1

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.Any

/**
  * kafkanode package object
  *  @author lawrence.daniels@gmail.com
  */
package object kafkanode {

  /**
    * Client Extensions
    * @param client the given [[Client client]]
    */
  implicit class ClientExtensions(val client: Client) extends AnyVal {

    /**
      * @see [[Client.close()]]
      */
    @inline
    def closeAsync(): Promise[Any] = futureCallbackE1[js.Error, js.Any](client.close)

  }

  /**
    * Consumer Extensions
    * @param consumer the given [[Consumer consumer]]
    */
  implicit class ConsumerExtensions(val consumer: Consumer) extends AnyVal {

    /**
      * @see [[Consumer.addTopics()]]
      */
    def addTopicsAsync(topics: String, fromOffset: Boolean) = futureCallbackE1[js.Error, js.Any](consumer.addTopics(topics, _, fromOffset))

    /**
      * @see [[Consumer.addTopics()]]
      */
    def addTopicsAsync(topics: String) = futureCallbackE1[js.Error, js.Any](consumer.addTopics(topics, _))

    /**
      * @see [[Consumer.close()]]
      */
    def closeAsync = futureCallbackE1[js.Error, js.Any](consumer.close)

    /**
      * @see [[Consumer.commit()]]
      */
    def commitAsync[T <: js.Any] = futureCallbackE1[js.Error, T](consumer.commit)

    /**
      * @see [[Consumer.removeTopics()]]
      */
    def removeTopicsAsync(topics: js.Array[String]) = futureCallbackE1[js.Error, Boolean](consumer.removeTopics(topics, _))

    /**
      * @see [[Consumer.on()]]
      */
    def onError(callback: js.Function) = consumer.on("error", callback)

    /**
      * @see [[Consumer.on()]]
      */
    def onMessage(callback: js.Function) = consumer.on("message", callback)

    /**
      * @example on('offsetOutOfRange', function (err) {})
      * @see [[Consumer.on()]]
      */
    def onOffsetOutOfRange(callback: js.Function) = consumer.on("offsetOutOfRange", callback)

  }

  /**
    * High Level Consumer Extensions
    * @param consumer the given [[HighLevelConsumer consumer]]
    */
  implicit class HighLevelConsumerExtensions(val consumer: HighLevelConsumer) extends AnyVal {

    /**
      * @see [[HighLevelConsumer.addTopics()]]
      */
    def addTopicsAsync(topics: String, fromOffset: Boolean) = futureCallbackE1[js.Error, js.Any](consumer.addTopics(topics, _, fromOffset))

    /**
      * @see [[HighLevelConsumer.addTopics()]]
      */
    def addTopicsAsync(topics: String) = futureCallbackE1[js.Error, js.Any](consumer.addTopics(topics, _))

    /**
      * @see [[HighLevelConsumer.close()]]
      */
    def closeAsync = futureCallbackE1[js.Error, js.Any](consumer.close)

    /**
      * @see [[HighLevelConsumer.close()]]
      */
    def closeAsync(force: Boolean) = futureCallbackE1[js.Error, js.Any](consumer.close(force, _))

    /**
      * @see [[HighLevelConsumer.commit()]]
      */
    def commitAsync[T <: js.Any] = futureCallbackE1[js.Error, T](consumer.commit)

    /**
      * @see [[HighLevelConsumer.removeTopics()]]
      */
    def removeTopicsAsync(topics: js.Array[String]) = futureCallbackE1[js.Error, Boolean](consumer.removeTopics(topics, _))

    /**
      * @example consumer.on('error', function (message) {})
      * @see [[HighLevelConsumer.on()]]
      */
    def onError(callback: js.Function) = consumer.on("error", callback)

    /**
      * @example consumer.on('message', function (message) {})
      * @see [[HighLevelConsumer.on()]]
      */
    def onMessage(callback: js.Function) = consumer.on("message", callback)

    /**
      * @example on('offsetOutOfRange', function (err) {})
      * @see [[HighLevelConsumer.on()]]
      */
    def onOffsetOutOfRange(callback: js.Function) = consumer.on("offsetOutOfRange", callback)

  }

  /**
    * High Level Producer Extensions
    * @param producer the given [[Producer producer]]
    */
  implicit class HighLevelProducerExtensions(val producer: HighLevelProducer) extends AnyVal {

    /**
      * @see [[HighLevelProducer.createTopics()]]
      */
    def createTopicsAsync(topics: js.Array[String], async: Boolean) = futureCallbackE1[js.Error, js.Any](producer.createTopics(topics, async, _))

    /**
      * @see [[HighLevelProducer.send()]]
      */
    def sendAsync(payloads: js.Array[Payload]) = futureCallbackE1[js.Error, js.Any](producer.send(payloads, _))

    /**
      * @see [[HighLevelProducer.on()]]
      */
    def onError(callback: js.Function) = producer.on("error", callback)

    /**
      * @see [[HighLevelProducer.on()]]
      */
    def onReady(callback: js.Function) = producer.on("ready", callback)

  }

  /**
    * Offset Extensions
    * @param offset the given [[Offset offset]]
    */
  implicit class OffsetExtensions(val offset: Offset) extends AnyVal {

    /**
      * @see [[Offset.commit()]]
      */
    def commitAsync(groupId: String, payloads: js.Array[Payload]) = futureCallbackE1[js.Error, js.Any](offset.commit(groupId, payloads, _))

    /**
      * @see [[Offset.fetch()]]
      */
    def fetchAsync(payloads: js.Array[Payload]) = futureCallbackE1[js.Error, js.Any](offset.fetch(payloads, _))

    /**
      * @see [[Offset.fetchCommits()]]
      */
    def fetchCommitsAsync(groupId: String, payloads: js.Array[Payload]) = futureCallbackE1[js.Error, js.Any](offset.fetchCommits(groupId, payloads, _))

  }

  /**
    * Producer Extensions
    * @param producer the given [[Producer producer]]
    */
  implicit class ProducerExtensions(val producer: Producer) extends AnyVal {

    /**
      * @see [[Producer.on()]]
      */
    @inline def onError(callback: js.Function) = producer.on("error", callback)

    /**
      * @see [[Producer.on()]]
      */
    @inline def onReady(callback: js.Function) = producer.on("ready", callback)

    /**
      * @see [[Producer.createTopics()]]
      */
    @inline def createTopicsFuture(topics: js.Array[String], async: Boolean): Promise[js.Any] = {
      futureCallbackE1[js.Error, js.Any](producer.createTopics(topics, async, _))
    }

    /**
      * @see [[Producer.send()]]
      */
    @inline def sendFuture(payloads: js.Array[Payload]) = futureCallbackE1[js.Error, js.Any](producer.send(payloads, _))

  }

}
