package org.scalajs.npm.kafkanode

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Kafka Fetch Request
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FetchRequest(val topic: String,
                   val offset: js.UndefOr[Int] = js.undefined,
                   val partition: js.UndefOr[Int] = js.undefined) extends js.Object

/**
  * Kafka Fetch Request Companion
  * @author lawrence.daniels@gmail.com
  */
object FetchRequest {

  def apply(topic: String, partition: js.UndefOr[Int] = js.undefined) = {
    new FetchRequest(topic, partition)
  }

}