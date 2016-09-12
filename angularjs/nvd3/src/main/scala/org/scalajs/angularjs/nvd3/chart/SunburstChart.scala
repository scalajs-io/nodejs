package org.scalajs.angularjs.nvd3
package chart

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * nvD3 Sunburst Chart
  * @author Lawrence Daniels <lawrence.daniels@gmail.com>
  */
@ScalaJSDefined
class SunburstChart(val id: js.UndefOr[String] = js.undefined,
                    val width: js.UndefOr[Int] = js.undefined,
                    val height: js.UndefOr[Int] = js.undefined,
                    val donutRatio: js.UndefOr[Double] = js.undefined,
                    val donut: js.UndefOr[Boolean] = js.undefined,
                    val x: js.Function,
                    val y: js.Function,
                    val duration: js.UndefOr[Int] = js.undefined,
                    val labelThreshold: js.UndefOr[Double] = js.undefined,
                    val labelSunbeamLayout: js.UndefOr[Boolean] = js.undefined,
                    val showLegend: js.UndefOr[Boolean] = js.undefined,
                    val showLabels: js.UndefOr[Boolean] = js.undefined,
                    val legend: js.UndefOr[Legend] = js.undefined) extends Chart {

  override def `type` = "sunburstChart"

}
