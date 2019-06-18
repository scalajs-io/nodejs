package io.scalajs.npm.amcharts

import scala.scalajs.js

/**
  * Extension for ValueAxis to create an axis for AmSerialChart, AmRadarChart, AmXYChart charts, multiple can be assigned.
  * Gets automatically populated, one for AmSerialChart and two for AmXYChart charts, if none has been specified.
  * @example
  * {{{
  * var chart = AmCharts.makeChart("chartdiv",{
  *   ...
  *   "valueAxes": [
  *     {
  *       "title": "Axis title"
  *     }
  *   ]
  * });
  * }}}
  * @see https://docs.amcharts.com/3/javascriptstockchart/ValueAxis
  */
@js.native
trait ValueAxis extends AxisBase