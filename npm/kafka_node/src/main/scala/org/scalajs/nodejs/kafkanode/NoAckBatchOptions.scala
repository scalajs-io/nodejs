package org.scalajs.nodejs.kafkanode

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * No Ack Batch Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class NoAckBatchOptions(var noAckBatchSize: js.UndefOr[Int] = js.undefined,
                        var noAckBatchAge: js.UndefOr[Int] = js.undefined) extends js.Object

