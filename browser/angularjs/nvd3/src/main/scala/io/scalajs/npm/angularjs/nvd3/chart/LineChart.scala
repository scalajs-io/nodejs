package io.scalajs.npm.angularjs.nvd3.chart

import io.scalajs.npm.angularjs.nvd3._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * nvD3 Line Chart
  * @author lawrence.daniels@gmail.com
  * @see [[http://krispo.github.io/angular-nvd3/#/lineChart]]
  */
@ScalaJSDefined
class LineChart(val id: js.UndefOr[String] = js.undefined,
                val width: js.UndefOr[Int] = js.undefined,
                val height: js.UndefOr[Int] = js.undefined,
                val x: js.Function,
                val y: js.Function,
                val duration: js.UndefOr[Int] = js.undefined,
                val labelSunbeamLayout: js.UndefOr[Boolean] = js.undefined,
                val showLegend: js.UndefOr[Boolean] = js.undefined,
                val showLabels: js.UndefOr[Boolean] = js.undefined,
                val caption: js.UndefOr[Caption] = js.undefined,
                val margin: js.UndefOr[Margin] = js.undefined,
                val title: js.UndefOr[Title] = js.undefined,
                val subtitle: js.UndefOr[Title] = js.undefined,
                val useInteractiveGuideline: js.UndefOr[Boolean] = js.undefined,
                val xAxis: js.UndefOr[AxisLabel] = js.undefined,
                val yAxis: js.UndefOr[AxisLabel] = js.undefined)
    extends Chart {

  override val `type`: String = "lineChart"

}
