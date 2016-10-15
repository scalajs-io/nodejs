package org.scalajs.npm.kafkarest

import scala.scalajs.js

/**
  * Kafka Rest Instance
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait KafkaRestInstance extends js.Object {

  def brokers: BrokerCollection = js.native

  def consumer(name: String): Consumer = js.native

  def consumers: ConsumerCollection = js.native

  def topic(name: String): Topic = js.native

  def topicPartition(name: String, partition: Int): Partition = js.native

  def topics: TopicCollection = js.native

}
