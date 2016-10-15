package org.scalajs.npm.kafkarest

import org.scalajs.nodejs.NodeRequire

import scala.scalajs.js

/**
  * Confluent REST Proxy wrapper library
  * @see {{{http://www.confluent.io/blog/getting-started-with-kafka-in-node-js-with-the-confluent-rest-proxy/}}}
  * @version 0.0.4
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait KafkaRest extends KafkaRestClass {

  def AvroSchema: AvroSchemaClass = js.native

  def BinarySchema: BinarySchemaClass = js.native

  def Schema: js.Object = js.native

}

/**
  * Kafka Rest Companion
  * @author lawrence.daniels@gmail.com
  */
object KafkaRest {

  /**
    * Convenience method for retrieving the 'kafka-rest' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the KafkaRest instance
    */
  def apply()(implicit require: NodeRequire) = require[KafkaRest]("kafka-rest")

}