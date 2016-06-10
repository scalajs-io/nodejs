package com.github.ldaniels528.meansjs.nodejs.amqplib

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * The assertion queue options is an object and may be empty or null, or outright omitted if it's the last argument.
  * The relevant fields in options are:
  * @param exclusive if true, scopes the queue to the connection (defaults to false)
  * @param durable   if true, the queue will survive broker restarts, modulo the effects of exclusive and autoDelete;
  *                  this defaults to true if not supplied, unlike the others
  * @param arguments additional arguments, usually parameters for some kind of broker-specific extension e.g.,
  *                  high availability, TTL.
  */
@ScalaJSDefined
class QueueOptions(exclusive: js.UndefOr[Boolean] = js.undefined,
                   durable: js.UndefOr[Boolean] = js.undefined,
                   autoDelete: js.UndefOr[Boolean] = js.undefined,
                   arguments: js.UndefOr[String] = js.undefined) extends js.Object

/**
  * Assert Queue Options Companion
  * @author lawrence.daniels@gmail.com
  */
object QueueOptions {

  @inline
  def apply(exclusive: js.UndefOr[Boolean] = js.undefined,
            durable: js.UndefOr[Boolean] = js.undefined,
            autoDelete: js.UndefOr[Boolean] = js.undefined,
            arguments: js.UndefOr[String] = js.undefined) = {
    new QueueOptions(exclusive, durable, autoDelete, arguments)
  }

}