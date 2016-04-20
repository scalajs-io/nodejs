package com.github.ldaniels528.meansjs.kafkanode

import scala.scalajs.js

/**
  * Kafka-Node Node.js module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait KafkaNode extends js.Object {

  def Client: ClientFactory = js.native

  def Consumer: ConsumerFactory = js.native

  def HighLevelConsumer: HighLevelConsumerFactory = js.native

  def HighLevelProducer: HighLevelProducerFactory = js.native

  def KeyedMessage: KeyedMessageFactory = js.native

  def Offset: OffsetFactory = js.native

  def Producer: ProducerFactory = js.native

}

/**
  * Kafka-Node Companion
  * @author lawrence.daniels@gmail.com
  */
object KafkaNode {
  type KafkaError = js.UndefOr[String]

}
