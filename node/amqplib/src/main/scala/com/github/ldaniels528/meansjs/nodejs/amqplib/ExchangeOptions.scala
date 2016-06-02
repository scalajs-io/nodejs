package com.github.ldaniels528.meansjs.nodejs.amqplib

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Exchange Options
  */
@js.native
trait ExchangeOptions extends js.Object {
  var durable: js.UndefOr[Boolean] = js.native
  var internal: js.UndefOr[Boolean] = js.native
  var autoDelete: js.UndefOr[Boolean] = js.native
  var alternateExchange: js.UndefOr[String] = js.native
  var arguments: js.UndefOr[js.Any] = js.native
}

/**
  * Exchange Options
  * @author lawrence.daniels@gmail.com
  */
object ExchangeOptions {

  /**
    * Specific exchange types may use the arguments table to supply parameters.
    * The options:
    * @param durable           if true, the exchange will survive broker restarts. Defaults to true.
    * @param internal          if true, messages cannot be published directly to the exchange (i.e., it can only be the target of
    *                          bindings, or possibly create messages ex-nihilo). Defaults to false.
    * @param autoDelete        if true, the exchange will be destroyed once the number of bindings for which it is the source
    *                          drop to zero. Defaults to false.
    * @param alternateExchange is an exchange to send messages to if this exchange can't route them to any queues.
    * @param arguments         any additional arguments that may be needed by an exchange type.
    */
  def apply(durable: js.UndefOr[Boolean] = js.undefined,
            internal: js.UndefOr[Boolean] = js.undefined,
            autoDelete: js.UndefOr[Boolean] = js.undefined,
            alternateExchange: js.UndefOr[String] = js.undefined,
            arguments: js.UndefOr[js.Any] = js.undefined) = {
    val options = New[ExchangeOptions]
    options.durable = durable
    options.internal = internal
    options.autoDelete = autoDelete
    options.alternateExchange = alternateExchange
    options.arguments = arguments
  }

}