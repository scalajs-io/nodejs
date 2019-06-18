package io.scalajs.npm.amcharts

import io.scalajs.npm.amcharts.AmChart.Export
import io.scalajs.npm.amcharts.AmSlicedChart.SliceChartConfig

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * AmCharts Funnel Chart
  * @example
  * {{{
  *   var chart = AmCharts.makeChart("chartdiv",{
  *     "type"    : "funnel",
  *     "neckHeight"  : "30%",
  *     "neckWidth" : "40%",
  *     "titleField"  : "title",
  *     "valueField"  : "value",
  *     "dataProvider"  : [
  *       {
  *         "title": "Website visits",
  *         "value": 300
  *       },
  *       {
  *         "title": "Downloads",
  *         "value": 123
  *       }
  *     ]
  *   });
  * }}}
  * @see https://docs.amcharts.com/3/javascriptstockchart/AmFunnelChart
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AmFunnelChart extends AmSlicedChart {

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  var neckHeight: Double | String = js.native

  var neckWidth: Double | String = js.native

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////


}

/**
  * AmFunnelChart Companion
  * @author lawrence.daniels@gmail.com
  */
object AmFunnelChart extends SliceEventShortcuts {

  type FunnelChartConfig = SliceChartConfig[AmFunnelChart]

  def apply(adjustPrecision: js.UndefOr[Boolean] = js.undefined,
            angle: js.UndefOr[Double] = js.undefined,
            balloonFunction: js.UndefOr[js.Function] = js.undefined,
            balloonText: js.UndefOr[String] = js.undefined,
            colorField: js.UndefOr[String] = js.undefined,
            dataProvider: js.Array[_ <: js.Any],
            depth3D: js.UndefOr[Double] = js.undefined,
            export: js.UndefOr[Export] = js.undefined,
            gradientType: js.UndefOr[String] = js.undefined,
            innerRadius: js.UndefOr[Double | String] = js.undefined,
            labelRadius: js.UndefOr[Double] = js.undefined,
            labelRadiusField: js.UndefOr[String] = js.undefined,
            labelText: js.UndefOr[String] = js.undefined,
            listeners: js.Array[EventListener] = js.Array(),
            minRadius: js.UndefOr[Double] = js.undefined,
            neckHeight: js.UndefOr[Double | String] = js.undefined,
            neckWidth: js.UndefOr[Double | String] = js.undefined,
            outlineAlpha: js.UndefOr[Double] = js.undefined,
            pieX: js.UndefOr[Double | String] = js.undefined,
            pieY: js.UndefOr[Double | String] = js.undefined,
            pullOutRadius: js.UndefOr[Double | String] = js.undefined,
            radius: js.UndefOr[Double | String] = js.undefined,
            startAngle: js.UndefOr[Double] = js.undefined,
            startRadius: js.UndefOr[Double | String] = js.undefined,
            theme: js.UndefOr[String] = js.undefined,
            titleField: js.UndefOr[String] = js.undefined,
            `type`: String = "funnel",
            valueField: js.UndefOr[String] = js.undefined): FunnelChartConfig = {
    AmSlicedChart[AmFunnelChart](
      adjustPrecision = adjustPrecision,
      angle = angle,
      balloonFunction = balloonFunction,
      balloonText = balloonText,
      colorField = colorField,
      dataProvider = dataProvider,
      depth3D = depth3D,
      export = export,
      gradientType = gradientType,
      innerRadius = innerRadius,
      labelRadius = labelRadius,
      labelRadiusField = labelRadiusField,
      labelText = labelText,
      listeners = listeners,
      minRadius = minRadius,
      outlineAlpha = outlineAlpha,
      pieX = pieX,
      pieY = pieY,
      pullOutRadius = pullOutRadius,
      radius = radius,
      startAngle = startAngle,
      startRadius = startRadius,
      theme = theme,
      titleField = titleField,
      `type` = `type`,
      valueField = valueField
    )
  }

}
