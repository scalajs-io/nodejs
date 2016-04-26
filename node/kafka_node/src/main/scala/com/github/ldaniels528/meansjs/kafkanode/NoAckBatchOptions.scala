package com.github.ldaniels528.meansjs.kafkanode

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * No Ack Batch Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class NoAckBatchOptions extends js.Object {
  var noAckBatchSize: js.UndefOr[Int] = _
  var noAckBatchAge: js.UndefOr[Int] = _
}

/**
  * No Ack Batch Options Companion
  * @author lawrence.daniels@gmail.com
  */
object NoAckBatchOptions {

  def apply(noAckBatchSize: js.UndefOr[Int] = js.undefined,
            noAckBatchAge: js.UndefOr[Int] = js.undefined) = {
    val options = new NoAckBatchOptions()
    options.noAckBatchSize = noAckBatchSize
    options.noAckBatchAge = noAckBatchAge
    options
  }
}
