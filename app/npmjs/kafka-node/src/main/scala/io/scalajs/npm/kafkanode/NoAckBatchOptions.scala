package io.scalajs.npm.kafkanode

import io.scalajs.FlexibleOptions

import scala.scalajs.js


/**
  * No Ack Batch Options
  * @param noAckBatchSize
  * @param noAckBatchAge
  */
class NoAckBatchOptions(var noAckBatchSize: js.UndefOr[Int] = js.undefined,
                        var noAckBatchAge: js.UndefOr[Int] = js.undefined)
  extends js.Object

/**
  * No Ack Batch Options Companion
  * @author lawrence.daniels@gmail.com
  */
object NoAckBatchOptions extends FlexibleOptions[NoAckBatchOptions]