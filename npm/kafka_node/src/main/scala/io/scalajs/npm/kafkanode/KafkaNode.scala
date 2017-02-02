package io.scalajs.npm.kafkanode

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * kafka-node - Client for Apache Kafka v0.8+
  * @version 1.3.1
  * @see https://www.npmjs.com/package/kafka-node
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait KafkaNode extends IEventEmitter {}

/**
  * KafkaNode Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("kafka-node", JSImport.Namespace)
object KafkaNode extends KafkaNode
