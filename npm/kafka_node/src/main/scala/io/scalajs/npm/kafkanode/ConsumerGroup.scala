package io.scalajs.npm.kafkanode

import io.scalajs.RawOptions
import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Consumer Group - The new consumer group uses Kafka broker coordinators instead of Zookeeper
  * to manage consumer groups. This is supported in Kafka version 0.9 and above only.
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("kafka-node", "ConsumerGroup")
class ConsumerGroup(options: ConsumerGroupOptions | RawOptions, topics: String | js.Array[String])
    extends IEventEmitter {}
