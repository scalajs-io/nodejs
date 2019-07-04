package io.scalajs.npm.kafkanode

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Consumer Group - The new consumer group uses Kafka broker coordinators instead of Zookeeper
  * to manage consumer groups. This is supported in Kafka version 0.9 and above only.
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("kafka-node", "ConsumerGroup")
class ConsumerGroup(options: ConsumerGroupOptions)
  extends IEventEmitter {

  def this(options: ConsumerGroupOptions, topics: String) = this(options)

  def this(options: ConsumerGroupOptions, topics: js.Array[String]) = this(options)

}
