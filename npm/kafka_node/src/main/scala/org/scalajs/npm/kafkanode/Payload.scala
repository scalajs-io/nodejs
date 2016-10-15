package org.scalajs.npm.kafkanode

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * High Level Producer Payload
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class Payload extends js.Object {
  var topic: String = _
  var messages: js.Any = _
  var partition: js.UndefOr[Int] = _
}

/**
  * High Level Producer Payload Companion
  * @author lawrence.daniels@gmail.com
  */
object Payload {

  def apply(topic: String,
            messages: js.Any,
            partition: js.UndefOr[Int] = js.undefined) = {
    val payload = new Payload()
    payload.topic = topic
    payload.messages = messages
    payload.partition = partition
    payload
  }

}
