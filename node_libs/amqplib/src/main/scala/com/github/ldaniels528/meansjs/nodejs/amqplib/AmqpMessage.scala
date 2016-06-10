package com.github.ldaniels528.meansjs.nodejs.amqplib

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer

import scala.scalajs.js

/**
  * AMQP Message
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AmqpMessage extends js.Object {

  val content: Buffer = js.native

}
