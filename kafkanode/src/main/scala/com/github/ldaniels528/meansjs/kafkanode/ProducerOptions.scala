package com.github.ldaniels528.meansjs.kafkanode

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Producer Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ProducerOptions extends js.Object {
  /** Configuration for when to consider a message as acknowledged, default 1  */
  var requireAcks: js.UndefOr[Int] = js.native

  /** The amount of time in milliseconds to wait for all acks before considered, default 100ms */
  var ackTimeoutMs: js.UndefOr[Int] = js.native

  /** Partitioner type (default = 0, random = 1, cyclic = 2, keyed = 3), default 0 */
  var partitionerType: js.UndefOr[Int] = js.native
}

/**
  * Producer Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ProducerOptions {

  def apply(requireAcks: js.UndefOr[Int] = js.undefined,
            ackTimeoutMs: js.UndefOr[Int] = js.undefined,
            partitionerType: js.UndefOr[Int] = js.undefined) = {
    val options = makeNew[ProducerOptions]
    options.requireAcks = requireAcks
    options.ackTimeoutMs = ackTimeoutMs
    options.partitionerType = partitionerType
    options
  }
}