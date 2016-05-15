package com.github.ldaniels528.meansjs.nodejs.amqplib

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

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
@ScalaJSDefined
class ExchangeOptions(var durable: js.UndefOr[Boolean],
                      var internal: js.UndefOr[Boolean],
                      var autoDelete: js.UndefOr[Boolean],
                      var alternateExchange: js.UndefOr[String],
                      var arguments: js.UndefOr[js.Any]) extends js.Object

/**
  * Exchange Options
  * @author lawrence.daniels@gmail.com
  */
object ExchangeOptions {

  def apply(durable: js.UndefOr[Boolean] = js.undefined,
            internal: js.UndefOr[Boolean] = js.undefined,
            autoDelete: js.UndefOr[Boolean] = js.undefined,
            alternateExchange: js.UndefOr[String] = js.undefined,
            arguments: js.UndefOr[js.Any] = js.undefined) = {
    new ExchangeOptions(durable, internal, autoDelete, alternateExchange, arguments)
  }

}