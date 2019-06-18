package io.scalajs.npm.amcharts

import io.scalajs.npm.amcharts.events.AmEvent

import scala.scalajs.js

/**
  * AmCharts Event Listener
  * @author lawrence.daniels@gmail.com
  */
class EventListener(val event: String, val method: js.Function1[_ <: AmEvent, Any]) extends js.Object