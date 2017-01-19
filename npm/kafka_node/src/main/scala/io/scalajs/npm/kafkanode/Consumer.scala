package io.scalajs.npm.kafkanode

import io.scalajs.RawOptions
import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Kafka-Node Consumer
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("kafka-node", "Producer")
class Consumer(client: Client, payloads: js.Array[FetchRequest], options: ConsumerOptions | RawOptions = js.native)
  extends IEventEmitter {

  /**
    * Add topics to current consumer, if any topic to be added not exists, return error
    * @example addTopics(topics, callback, fromOffset)
    */
  def addTopics(topics: String, callback: js.Function, fromOffset: Boolean): Unit = js.native

  /**
    * Add topics to current consumer, if any topic to be added not exists, return error
    * @example addTopics(topics, callback, fromOffset)
    */
  def addTopics(topics: String, callback: js.Function): Unit = js.native

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
    * Pause specific topics
    * @example consumer.pauseTopics(topics)
    */
  def pauseTopics(topics: js.Array[String]): Unit = js.native

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
    * Resume specific topics
    * @example consumer.resumeTopics(topics)
    */
  def resumeTopics(topics: js.Array[String]): Unit = js.native

  /**
    * Set offset of the given topic
    * @example consumer.setOffset('topic', 0, 0)
    */
  def setOffset(topic: String, partition: Int, offset: Int): Unit = js.native

}
