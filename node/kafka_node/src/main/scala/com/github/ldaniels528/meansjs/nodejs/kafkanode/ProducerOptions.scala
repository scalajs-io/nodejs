package com.github.ldaniels528.meansjs.nodejs.kafkanode

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Producer Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ProducerOptions extends js.Object {
  /** Configuration for when to consider a message as acknowledged, default 1  */
  var requireAcks: js.UndefOr[Int] = _

  /** The amount of time in milliseconds to wait for all acks before considered, default 100ms */
  var ackTimeoutMs: js.UndefOr[Int] = _

  /** Partitioner type (default = 0, random = 1, cyclic = 2, keyed = 3), default 0 */
  var partitionerType: js.UndefOr[Int] = _
}

/**
  * Producer Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ProducerOptions {

  def apply(requireAcks: js.UndefOr[Int] = js.undefined,
            ackTimeoutMs: js.UndefOr[Int] = js.undefined,
            partitionerType: js.UndefOr[Int] = js.undefined) = {
    val options = new ProducerOptions()
    options.requireAcks = requireAcks
    options.ackTimeoutMs = ackTimeoutMs
    options.partitionerType = partitionerType
    options
  }
}