package io.scalajs.npm

import io.scalajs.nodejs.Error
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js

/**
  * kafkanode package object
  * @author lawrence.daniels@gmail.com
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
    def closeFuture(): Future[Unit] = promiseWithError0[Error](client.close)

  }

  /**
    * Consumer Extensions
    * @param consumer the given [[Consumer consumer]]
    */
  implicit class ConsumerExtensions(val consumer: Consumer) extends AnyVal {

    /**
      * @see [[Consumer.addTopics()]]
      */
    @inline
    def addTopicsFuture(topics: String, fromOffset: Boolean): Future[js.Any] = {
      promiseWithError1[Error, js.Any](consumer.addTopics(topics, _, fromOffset))
    }

    /**
      * @see [[Consumer.addTopics()]]
      */
    @inline
    def addTopicsFuture(topics: String): Future[js.Any] = {
      promiseWithError1[Error, js.Any](consumer.addTopics(topics, _))
    }

    /**
      * @see [[Consumer.close()]]
      */
    @inline
    def closeFuture: Future[js.Any] = promiseWithError1[Error, js.Any](consumer.close)

    /**
      * @see [[Consumer.commit()]]
      */
    @inline
    def commitFuture[T <: js.Any]: Future[T] = promiseWithError1[Error, T](consumer.commit)

    /**
      * @see [[Consumer.removeTopics()]]
      */
    @inline
    def removeTopicsFuture(topics: js.Array[String]): Future[Boolean] = {
      promiseWithError1[Error, Boolean](consumer.removeTopics(topics, _))
    }

    /**
      * @see [[Consumer.on()]]
      */
    @inline
    def onError(callback: js.Function1[Error, Any]): consumer.type = consumer.on("error", callback)

    /**
      * @see [[Consumer.on()]]
      */
    @inline
    def onMessage(callback: js.Function): consumer.type = consumer.on("message", callback)

    /**
      * @example on('offsetOutOfRange', function (err) {})
      * @see [[Consumer.on()]]
      */
    @inline
    def onOffsetOutOfRange(callback: js.Function): consumer.type = consumer.on("offsetOutOfRange", callback)

  }

  /**
    * High Level Consumer Extensions
    * @param consumer the given [[HighLevelConsumer consumer]]
    */
  implicit class HighLevelConsumerExtensions(val consumer: HighLevelConsumer) extends AnyVal {

    /**
      * @see [[HighLevelConsumer.addTopics()]]
      */
    @inline
    def addTopicsFuture(topics: String, fromOffset: Boolean): Future[js.Any] = {
      promiseWithError1[Error, js.Any](consumer.addTopics(topics, _, fromOffset))
    }

    /**
      * @see [[HighLevelConsumer.addTopics()]]
      */
    @inline
    def addTopicsFuture(topics: String): Future[js.Any] =
      promiseWithError1[Error, js.Any](consumer.addTopics(topics, _))

    /**
      * @see [[HighLevelConsumer.close()]]
      */
    @inline
    def closeFuture: Future[Unit] = promiseWithError0[Error](consumer.close)

    /**
      * @see [[HighLevelConsumer.close()]]
      */
    @inline
    def closeFuture(force: Boolean): Future[Unit] = promiseWithError0[Error](consumer.close(force, _))

    /**
      * @see [[HighLevelConsumer.commit()]]
      */
    @inline
    def commitFuture[A]: Future[A] = promiseWithError1[Error, A](consumer.commit)

    /**
      * @see [[HighLevelConsumer.removeTopics()]]
      */
    @inline
    def removeTopicsFuture(topics: js.Array[String]): Future[Boolean] = {
      promiseWithError1[Error, Boolean](consumer.removeTopics(topics, _))
    }

    /**
      * @example consumer.on('error', function (message) {})
      * @see [[HighLevelConsumer.on()]]
      */
    @inline
    def onError(callback: js.Function): consumer.type = consumer.on("error", callback)

    /**
      * @example consumer.on('message', function (message) {})
      * @see [[HighLevelConsumer.on()]]
      */
    @inline
    def onMessage(callback: js.Function): consumer.type = consumer.on("message", callback)

    /**
      * @example on('offsetOutOfRange', function (err) {})
      * @see [[HighLevelConsumer.on()]]
      */
    @inline
    def onOffsetOutOfRange(callback: js.Function): consumer.type = consumer.on("offsetOutOfRange", callback)

  }

  /**
    * High Level Producer Extensions
    * @param producer the given [[Producer producer]]
    */
  implicit class HighLevelProducerExtensions(val producer: HighLevelProducer) extends AnyVal {

    /**
      * @see [[HighLevelProducer.createTopics()]]
      */
    @inline
    def createTopicsFuture(topics: js.Array[String], async: Boolean): Future[Unit] = {
      promiseWithError0[Error](producer.createTopics(topics, async, _))
    }

    /**
      * @see [[HighLevelProducer.send()]]
      */
    @inline
    def sendFuture(payloads: js.Array[ProduceRequest]): Future[Unit] = {
      promiseWithError0[Error](producer.send(payloads, _))
    }

    /**
      * @see [[HighLevelProducer.on()]]
      */
    @inline
    def onError(callback: js.Function): producer.type = producer.on("error", callback)

    /**
      * @see [[HighLevelProducer.on()]]
      */
    @inline
    def onReady(callback: js.Function): producer.type = producer.on("ready", callback)

  }

  /**
    * Offset Extensions
    * @param offset the given [[Offset offset]]
    */
  implicit class OffsetExtensions(val offset: Offset) extends AnyVal {

    /**
      * @see [[Offset.commit()]]
      */
    @inline
    def commitFuture(groupId: String, payloads: js.Array[Payload]): Future[js.Any] = {
      promiseWithError1[Error, js.Any](offset.commit(groupId, payloads, _))
    }

    /**
      * @see [[Offset.fetch()]]
      */
    @inline
    def fetchFuture[T](payloads: js.Array[FetchRequest]): Future[T] = {
      promiseWithError1[Error, T](offset.fetch(payloads, _))
    }

    /**
      * @see [[Offset.fetchCommits()]]
      */
    @inline
    def fetchCommitsFuture(groupId: String, payloads: js.Array[FetchRequest]): Future[js.Any] = {
      promiseWithError1[Error, js.Any](offset.fetchCommits(groupId, payloads, _))
    }

  }

  /**
    * Producer Extensions
    * @param producer the given [[Producer producer]]
    */
  implicit class ProducerExtensions(val producer: Producer) extends AnyVal {

    /**
      * @see [[Producer.on()]]
      */
    @inline
    def onError(callback: js.Function1[Error, Any]): producer.type = producer.on("error", callback)

    /**
      * @see [[Producer.on()]]
      */
    @inline
    def onReady(callback: js.Function): producer.type = producer.on("ready", callback)

    /**
      * @see [[Producer.createTopics()]]
      */
    @inline
    def createTopicsFuture(topics: js.Array[String], async: Boolean): Future[js.Any] = {
      promiseWithError1[Error, js.Any](producer.createTopics(topics, async, _))
    }

    /**
      * @see [[Producer.send()]]
      */
    @inline
    def sendFuture(payloads: js.Array[ProduceRequest]): Future[Unit] = {
      promiseWithError0[Error](producer.send(payloads, _))
    }

  }

}
