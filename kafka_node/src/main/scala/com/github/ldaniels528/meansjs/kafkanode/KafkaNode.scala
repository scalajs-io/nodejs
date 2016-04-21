package com.github.ldaniels528.meansjs.kafkanode

import scala.scalajs.js

/**
  * Kafka-Node Node.js module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait KafkaNode extends js.Object {

  def Client: ClientClass = js.native

  def Consumer: ConsumerClass = js.native

  def HighLevelConsumer: HighLevelConsumerClass = js.native

  def HighLevelProducer: HighLevelProducerClass = js.native

  def KeyedMessage: KeyedMessageClass = js.native

  def Offset: OffsetClass = js.native

  def Producer: ProducerClass = js.native

}

/**
  * Kafka-Node Companion
  * @author lawrence.daniels@gmail.com
  */
object KafkaNode {
  type KafkaError = js.UndefOr[String]

}
