package io.scalajs.npm.amcharts

import scala.scalajs.js

/**
  * AmCharts Formatter
  * @param precision
  * @param decimalSeparator
  * @param thousandsSeparator
  * @author lawrence.daniels@gmail.com
  */
class Formatter(val precision: Double,
                val decimalSeparator: String,
                val thousandsSeparator: String) extends js.Object