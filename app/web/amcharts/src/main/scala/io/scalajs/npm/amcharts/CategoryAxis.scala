package io.scalajs.npm.amcharts

import scala.scalajs.js

/**
  * Extension for AxisBase, gets automatically populated if none has been specified.
  * @example
  * {{{
  * var chart = AmCharts.makeChart("chartdiv",{
  *   ...
  *   "categoryAxis": {
  *     "gridPosition": "start"
  *   }
  * });
  * }}}
  * @see https://docs.amcharts.com/3/javascriptstockchart/CategoryAxis
  */
@js.native
trait CategoryAxis extends AxisBase {

}
