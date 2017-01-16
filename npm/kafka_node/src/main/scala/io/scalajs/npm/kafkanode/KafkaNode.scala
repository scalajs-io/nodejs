package io.scalajs.npm.kafkanode

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * kafka-node - Client for Apache Kafka v0.8+
  * @see https://www.npmjs.com/package/kafka-node
  * @version 1.3.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("kafka-node", JSImport.Namespace)
object KafkaNode extends IEventEmitter {

}