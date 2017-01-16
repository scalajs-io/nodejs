package io.scalajs.npm.kafkarest

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Confluent REST Proxy wrapper library
  * @version 0.0.4
  * @see http://www.confluent.io/blog/getting-started-with-kafka-in-node-js-with-the-confluent-rest-proxy/
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("kafka-rest", JSImport.Namespace)
class KafkaRest(options: KafkaRestOptions) extends js.Object {

  def brokers: BrokerCollection = js.native

  def consumer(name: String): Consumer = js.native

  def consumers: ConsumerCollection = js.native

  def topic(name: String): Topic = js.native

  def topicPartition(name: String, partition: Int): Partition = js.native

  def topics: TopicCollection = js.native


}
