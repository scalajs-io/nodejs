package org.scalajs.npm.kafkarest

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Kafka Keyed Message
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class KeyedMessage(var key: js.Any = js.undefined,
                   var value: js.Any = js.undefined,
                   var partition: js.UndefOr[Int] = js.undefined) extends js.Object