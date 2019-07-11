package io.scalajs.npm.angularjs.nvd3

import io.scalajs.FlexibleOptions
import io.scalajs.npm.angularjs.nvd3.chart.Chart

import scala.scalajs.js

/**
  * nvD3 Chart Options
  * @author lawrence.daniels@gmail.com
  */
class ChartOptions(val chart: Chart) extends js.Object

/**
  * nvD3 Chart Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ChartOptions extends FlexibleOptions[ChartOptions]