package com.github.ldaniels528.meansjs.kafkanode

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * High Level Producer Payload
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Payload extends js.Object {
  var topic: String = js.native
  var messages: js.Any = js.native
  var partition: js.UndefOr[Int] = js.native
}

/**
  * High Level Producer Payload Companion
  * @author lawrence.daniels@gmail.com
  */
object Payload {

  def apply(topic: String, messages: js.Any) = {
    val payload = makeNew[Payload]
    payload.topic = topic
    payload.messages = messages
    payload
  }

  def apply(topic: String, messages: js.Any, partition: Int) = {
    val payload = makeNew[Payload]
    payload.topic = topic
    payload.messages = messages
    payload.partition = partition
    payload
  }

}
