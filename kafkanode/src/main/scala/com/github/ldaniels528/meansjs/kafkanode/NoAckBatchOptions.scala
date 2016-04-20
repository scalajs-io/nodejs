package com.github.ldaniels528.meansjs.kafkanode

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js


/**
  * No Ack Batch Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait NoAckBatchOptions extends js.Object {
  var noAckBatchSize: js.UndefOr[Int] = js.native
  var noAckBatchAge: js.UndefOr[Int] = js.native
}

/**
  * No Ack Batch Options Companion
  * @author lawrence.daniels@gmail.com
  */
object NoAckBatchOptions {

  def apply(noAckBatchSize: js.UndefOr[Int] = js.undefined,
            noAckBatchAge: js.UndefOr[Int] = js.undefined) = {
    val options = makeNew[NoAckBatchOptions]
    options.noAckBatchSize = noAckBatchSize
    options.noAckBatchAge = noAckBatchAge
    options
  }
}
