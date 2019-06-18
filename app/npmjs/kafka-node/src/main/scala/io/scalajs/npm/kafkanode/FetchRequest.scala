package io.scalajs.npm.kafkanode

import scala.scalajs.js


/**
  * Kafka Fetch Request
  * @author lawrence.daniels@gmail.com
  */

class FetchRequest(val topic: String,
                   val offset: js.UndefOr[Int] = js.undefined,
                   val partition: js.UndefOr[Int] = js.undefined)
    extends js.Object
