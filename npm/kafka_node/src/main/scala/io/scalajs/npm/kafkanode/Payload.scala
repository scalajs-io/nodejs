package io.scalajs.npm.kafkanode

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|

/**
  * High Level Producer Payload
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class Payload(var topic: js.UndefOr[String] = js.undefined,
              var messages: js.Any = js.undefined,
              var partition: js.UndefOr[Int] = js.undefined,
              var time: js.UndefOr[Double | js.Date] = js.undefined,
              var maxNum: js.UndefOr[Int] = js.undefined) extends js.Object