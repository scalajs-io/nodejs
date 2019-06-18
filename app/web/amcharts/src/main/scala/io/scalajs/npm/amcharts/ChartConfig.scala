package io.scalajs.npm.amcharts

import scala.scalajs.js

/**
  * AmCharts Chart Configuration
  * @tparam T the desired chart implementation type
  */
trait ChartConfig[+T <: AmChart] extends js.Object