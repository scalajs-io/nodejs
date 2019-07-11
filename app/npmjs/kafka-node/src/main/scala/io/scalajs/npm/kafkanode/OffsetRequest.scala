package io.scalajs.npm.kafkanode

import scala.scalajs.js


/**
  * Kafka Offset Request
  * @author lawrence.daniels@gmail.com
  */

class OffsetRequest(val topic: String,
                    val partition: js.UndefOr[Int] = js.undefined,
                    val time: js.UndefOr[Double] = js.undefined,
                    val maxNum: js.UndefOr[Int] = js.undefined)
  extends js.Object
