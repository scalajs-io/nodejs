package io.scalajs.npm.amcharts

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Creates the visualization of the data in following types: line, column, step line, smoothed line, olhc and candlestick.
  * @example
  * {{{
  * var chart = AmCharts.makeChart("chartdiv",{
  *   ...
  *   "graphs": [
  *     {
  *       "id"      : "AmGraph-1",
  *       "title"   : "Column graph",
  *       "type"    : "column",
  *       "valueField"  : "column-1",
  *       "fillAlphas"  : 1
  *     }
  *   ]
  * });
  * }}}
  * @see https://docs.amcharts.com/3/javascriptstockchart/AmGraph
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
class AmGraph() extends js.Object {

  def hideBullets(): Unit = js.native

  def showBullets(): Unit = js.native

}
