package org.scalajs.nodejs.kafkanode

import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.{NodeModule, NodeRequire}
import org.scalajs.nodejs.NodeModule
import org.scalajs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * node-kafka - a node binding for librdkafka
  * @see https://www.npmjs.com/package/node-kafka
  * @version 0.0.11
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait KafkaNode extends NodeModule with EventEmitter {

  def Client: ClientClass = js.native

  def Consumer: ConsumerClass = js.native

  def HighLevelConsumer: HighLevelConsumerClass = js.native

  def HighLevelProducer: HighLevelProducerClass = js.native

  def KeyedMessage: KeyedMessageClass = js.native

  def Offset: OffsetClass = js.native

  def Producer: ProducerClass = js.native

}

/**
  * KafkaNode Companion
  * @author lawrence.daniels@gmail.com
  */
object KafkaNode {

  /**
    * Convenience method for retrieving the 'kafka-node' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the KafkaNode instance
    */
  def apply()(implicit require: NodeRequire) = require[KafkaNode]("kafka-node")

}