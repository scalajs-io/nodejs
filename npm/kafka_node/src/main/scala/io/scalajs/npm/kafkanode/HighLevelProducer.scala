package io.scalajs.npm.kafkanode

import io.scalajs.nodejs.NodeOptions
import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Kafka-Node High-level Producer
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("kafka-node", "HighLevelProducer")
class HighLevelProducer(client: Client, options: ProducerOptions | NodeOptions  = js.native)
  extends IEventEmitter {

  /**
    * @example createTopics(topics, [async,] callback)
    */
  def createTopics(topics: js.Array[String], async: Boolean, callback: js.Function): Unit = js.native

  /**
    * @example createTopics(topics, [async,] callback)
    */
  def createTopics(topics: js.Array[String], callback: js.Function): Unit = js.native

  /**
    * @example send(payloads, callback)
    */
  def send(payloads: js.Array[Payload], callback: js.Function): Unit = js.native

}
