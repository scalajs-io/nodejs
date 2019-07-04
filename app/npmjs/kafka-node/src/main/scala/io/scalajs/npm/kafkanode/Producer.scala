package io.scalajs.npm.kafkanode

import io.scalajs.nodejs.Error
import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Kafka-Node Producer
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("kafka-node", "Producer")
class Producer(client: Client, options: ProducerOptions = js.native) extends IEventEmitter {

  /**
    * @example createTopics(topics, [async,] callback)
    */
  def createTopics(topics: js.Array[String], async: Boolean, callback: js.Function2[Error, js.Any, Any]): Unit = js.native

  /**
    * @example createTopics(topics, [async,] callback)
    */
  def createTopics(topics: js.Array[String], callback: js.Function2[Error, js.Any, Any]): Unit = js.native

  /**
    * @example send(payloads, callback)
    */
  def send(payloads: js.Array[ProduceRequest], callback: js.Function1[Error, Any]): Unit = js.native

}
