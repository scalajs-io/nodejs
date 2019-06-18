package io.scalajs.npm.kafkanode

import scala.scalajs.js


/**
  * No Ack Batch Options
  * @author lawrence.daniels@gmail.com
  */

class NoAckBatchOptions(var noAckBatchSize: js.UndefOr[Int] = js.undefined,
                        var noAckBatchAge: js.UndefOr[Int] = js.undefined)
    extends js.Object
