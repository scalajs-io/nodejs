package com.github.ldaniels528.meansjs.kafkanode

import com.github.ldaniels528.meansjs.kafkanode.KafkaNode.KafkaError
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.concurrent.{ExecutionContext, Promise}
import scala.scalajs.js

/**
  * High-Level Consumer
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HighLevelConsumer extends KafkaNodeEventListener {

  /**
    * Add topics to current consumer, if any topic to be added not exists, return error
    * @example addTopics(topics, callback, fromOffset)
    */
  def addTopics(topics: String, callback: js.Function, fromOffset: js.UndefOr[Boolean] = js.undefined): Unit = js.native

  /**
    * Closes the consumer
    * @param force    if set to true, it forces the consumer to commit the current offset before closing, default false
    * @param callback the callback
    * @example consumer.close(force, callback)
    */
  def close(force: Boolean, callback: js.Function): Unit = js.native

  /**
    * Closes the consumer
    * @param callback the callback
    * @example consumer.close(force, callback)
    */
  def close(callback: js.Function): Unit = js.native

  /**
    * Commit offset of the current topics manually, this method should be called when a consumer leaves.
    * @example consumer.commit(function(err, data) { .. });
    */
  def commit(callback: js.Function): Unit = js.native

  /**
    * Pauses the consumer
    * @example consumer.pause()
    */
  def pause(): Unit = js.native

  /**
    * Removes an array of topics
    * @param topics   the array of topics to remove
    * @param callback the callback
    * @example consumer.removeTopics(['t1', 't2'], function (err, removed) { .. })
    */
  def removeTopics(topics: js.Array[String], callback: js.Function): Unit = js.native

  /**
    * Resume the consumers
    * @example consumer.resume()
    */
  def resume(): Unit = js.native

  /**
    * Set offset of the given topic
    * @example consumer.setOffset('topic', 0, 0)
    */
  def setOffset(topic: String, partition: Int, offset: Int): Unit = js.native

}

/**
  * High-Level Consumer Companion
  * @author lawrence.daniels@gmail.com
  */
object HighLevelConsumer {

  /**
    * High Level Consumer Extensions
    * @param consumer the given [[HighLevelConsumer consumer]]
    */
  implicit class HighLevelConsumerExtensions(val consumer: HighLevelConsumer) extends AnyVal {

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

    /**
      * @see [[HighLevelConsumer.addTopics()]]
      */
    def addTopicsAsync(topics: String, fromOffset: js.UndefOr[Boolean] = js.undefined) = {
      val promise = Promise[js.Any]()
      consumer.addTopics(topics, (err: KafkaError, result: js.Any) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      }, fromOffset)
      promise.future
    }

    /**
      * @see [[HighLevelConsumer.close()]]
      */
    def closeAsync(implicit ec: ExecutionContext) = {
      val promise = Promise[js.Any]()
      consumer.close((err: KafkaError, result: js.Any) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    /**
      * @see [[HighLevelConsumer.close()]]
      */
    def closeAsync(force: Boolean)(implicit ec: ExecutionContext) = {
      val promise = Promise[js.Any]()
      consumer.close(force, (err: KafkaError, result: js.Any) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    /**
      * @see [[HighLevelConsumer.commit()]]
      */
    def commitAsync[T <: js.Any](implicit ec: ExecutionContext) = {
      val promise = Promise[T]()
      consumer.commit((err: KafkaError, result: T) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    /**
      * @see [[HighLevelConsumer.removeTopics()]]
      */
    def removeTopicsAsync(topics: js.Array[String])(implicit ec: ExecutionContext) = {
      val promise = Promise[Boolean]()
      consumer.removeTopics(topics, (err: KafkaError, result: Boolean) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

  }

}