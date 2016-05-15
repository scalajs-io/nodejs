package com.github.ldaniels528.meansjs.nodejs.amqplib

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Ack / No Ack Options
  * @param noAck if true, the message will be assumed by the server to be acknowledged (i.e., dequeued) as soon
  *              as it's been sent over the wire. Default is false, that is, you will be expected to acknowledge the message.
  */
@ScalaJSDefined
class NoAckOptions(noAck: js.UndefOr[Boolean]) extends js.Object

/**
  * Ack / No Ack Options Companion
  * @author lawrence.daniels@gmail.com
  */
object NoAckOptions {

  def apply(noAck: js.UndefOr[Boolean] = js.undefined) = new NoAckOptions(noAck)

}