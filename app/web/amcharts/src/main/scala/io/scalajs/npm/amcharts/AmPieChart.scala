package io.scalajs.npm.amcharts

import io.scalajs.npm.amcharts.AmChart.Export
import io.scalajs.npm.amcharts.AmSlicedChart.SliceChartConfig

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Extension for [[AmSlicedChart]] to create pie/donut charts.
  * @example
  * {{{
  *   var chart = AmCharts.makeChart("chartdiv",{
  *     "type"    : "pie",
  *     "titleField"  : "category",
  *     "valueField"  : "column-1",
  *     "dataProvider"  : [
  *       {
  *         "category": "category 1",
  *         "column-1": 8
  *       },
  *       {
  *         "category": "category 2",
  *         "column-1": 6
  *       },
  *       {
  *         "category": "category 3",
  *         "column-1": 2
  *       }
  *     ]
  *   });
  * }}}
  * @see https://docs.amcharts.com/3/javascriptstockchart/AmPieChart
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AmPieChart extends AmSlicedChart {

  /**
    * Sometimes, because of a rounding, percent of a sum of all slices is not equal to 100%.
    * If you set this to true, when this case happens, number of decimals will be increased
    * so that sum would become 100%.
    */
  var adjustPrecision: Boolean = js.native

  /**
    * Pie lean angle (for 3D effect). Valid range is 0 - 90.
    */
  var angle: Double = js.native

  /**
    * If you set some function, the graph will call it and pass GraphDataItem object to it.
    * This function should return a string which will be displayed in a balloon.
    */
  var balloonFunction: js.Function = js.native

  /**
    * `[[title]]: [[percents]]% ([[value]])\n[[description]]`	Balloon text.
    * The following tags can be used: `[[value]]`, `[[title]]`, `[[percents]]`, `[[description]]`
    * or any other field name from your data provider. HTML tags can also be used.
    */
  var balloonText: String = js.native

  /**
    * Name of the field in chart's dataProvider which holds slice's color.
    */
  var colorField: String = js.native

  /**
    *
    */
  var dataProvider: js.Any = js.native

  /**
    * Depth of the pie (for 3D effect).
    */
  var depth3D: Double = js.native

  /**
    * Export config. Specifies how export to image/data export/print/annotate menu will look and behave.
    * You can find a lot of examples in amcharts/plugins/export folder. More details can be found here.
    */
  var export: Export = js.native

  /**
    * Type of gradient. Use gradientRatio to create gradients.
    */
  var gradientType: String = js.native

  /**
    * Inner radius of the pie, in pixels or percents.
    */
  var innerRadius: Double | String = js.native

  /**
    * The distance between the label and the slice, in pixels. You can use negative values to put the label on the slice.
    */
  var labelRadius: Double = js.native

  /**
    * Name of the field in dataProvider which specifies the length of a tick.
    * Note, the chart will not try to arrange labels automatically if this property is set.
    */
  var labelRadiusField: String = js.native

  /**
    * `[[title]]: [[percents]]%`	Label text.
    * The following tags can be used: `[[value]]`, `[[title]]`, `[[percents]]`, `[[description]]`
    * or any other field name from your data provider.
    */
  var labelText: String = js.native

  /**
    *
    */
  var listeners: js.Array[EventListener] = js.native

  /**
    * Minimum radius of the pie, in pixels.
    */
  var minRadius: Double = js.native

  /**
    *
    */
  var outlineAlpha: Double = js.native

  /**
    * You can set fixed position of a pie center, in pixels or in percents.
    */
  var pieX: Double | String = js.native

  /**
    * You can set fixed position of a pie center, in pixels or in percents.
    */
  var pieY: Double | String = js.native

  /**
    * Pull out radius, in pixels or percents
    */
  var pullOutRadius: Double | String = js.native

  /**
    * Radius of a pie, in pixels or percents. By default, radius is calculated automatically.
    */
  var radius: Double | String = js.native

  /**
    * Angle of the first slice, in degrees. This will work properly only if "depth3D" is set to 0.
    * If "depth3D" is greater than 0, then there can be two angles only: 90 and 270. Value range is 0-360.
    */
  var startAngle: Double = js.native

  /**
    * Radius of the positions from which the slices will fly in.
    */
  var startRadius: Double | String = js.native

  /**
    * Theme of a chart. Config files of themes can be found in amcharts/themes/ folder. More info about using themes.
    */
  var theme: String = js.native

  /**
    * Name of the field in chart's dataProvider which holds slice's title.
    */
  var titleField: String = js.native

  /**
    * Type of a chart. Required when creating chart using JSON. Possible types are:
    * `serial`, `pie`, `xy`, `radar`, `funnel`, `gauge`, `map`, `gantt`, `stock`.
    */
  var `type`: String = js.native

  /**
    * Name of the field in chart's dataProvider which holds slice's value.
    */
  var valueField: String = js.native

}

/**
  * AmPieChart Companion
  * @author lawrence.daniels@gmail.com
  */
object AmPieChart extends SliceEventShortcuts {

  type PieChartConfig = SliceChartConfig[AmPieChart]

  /**
    * Constructs a new Pie Chart Configuration
    * @param adjustPrecision  Sometimes, because of a rounding, percent of a sum of all slices is not equal to 100%.
    *                         If you set this to true, when this case happens, number of decimals will be increased
    *                         so that sum would become 100%.
    * @param angle            Pie lean angle (for 3D effect). Valid range is 0 - 90.
    * @param balloonFunction  If you set some function, the graph will call it and pass GraphDataItem object to it.
    *                         This function should return a string which will be displayed in a balloon.
    * @param balloonText      `[[title]]: [[percents]]% ([[value]])\n[[description]]`	Balloon text.
    *                         The following tags can be used: `[[value]]`, `[[title]]`, `[[percents]]`, `[[description]]`
    *                         or any other field name from your data provider. HTML tags can also be used.
    * @param colorField       Name of the field in chart's dataProvider which holds slice's color.
    * @param dataProvider     TODO
    * @param depth3D          Depth of the pie (for 3D effect).
    * @param export           Export config. Specifies how export to image/data export/print/annotate menu will look and
    *                         behave. You can find a lot of examples in amcharts/plugins/export folder. More details can be found here.
    * @param gradientType     Type of gradient. Use gradientRatio to create gradients.
    * @param innerRadius      Inner radius of the pie, in pixels or percents.
    * @param labelRadius      The distance between the label and the slice, in pixels. You can use negative values to put the label on the slice.
    * @param labelRadiusField Name of the field in dataProvider which specifies the length of a tick.
    *                         Note, the chart will not try to arrange labels automatically if this property is set.
    * @param labelText        `[[title]]: [[percents]]%`	Label text.
    *                         The following tags can be used: `[[value]]`, `[[title]]`, `[[percents]]`, `[[description]]`
    *                         or any other field name from your data provider.
    * @param listeners        TODO
    * @param minRadius        Minimum radius of the pie, in pixels.
    * @param outlineAlpha     TODO
    * @param pieX             You can set fixed position of a pie center, in pixels or in percents.
    * @param pieY             You can set fixed position of a pie center, in pixels or in percents.
    * @param pullOutRadius    Pull out radius, in pixels or percents
    * @param radius           Radius of a pie, in pixels or percents. By default, radius is calculated automatically.
    * @param startAngle       Angle of the first slice, in degrees. This will work properly only if "depth3D" is set to 0.
    *                         If "depth3D" is greater than 0, then there can be two angles only: 90 and 270. Value range is 0-360.
    * @param startRadius      Radius of the positions from which the slices will fly in.
    * @param theme            Theme of a chart. Config files of themes can be found in amcharts/themes/ folder. More info about using themes.
    * @param titleField       Name of the field in chart's dataProvider which holds slice's title.
    * @param `type`           Type of a chart. Required when creating chart using JSON. Possible types are:
    *                         `serial`, `pie`, `xy`, `radar`, `funnel`, `gauge`, `map`, `gantt`, `stock`.
    * @param valueField       Name of the field in chart's dataProvider which holds slice's value.
    * @return a new [[PieChartConfig Pie Chart Configuration]]
    * @author lawrence.daniels@gmail.com
    */
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
            outlineAlpha: js.UndefOr[Double] = js.undefined,
            pieX: js.UndefOr[Double | String] = js.undefined,
            pieY: js.UndefOr[Double | String] = js.undefined,
            pullOutRadius: js.UndefOr[Double | String] = js.undefined,
            radius: js.UndefOr[Double | String] = js.undefined,
            startAngle: js.UndefOr[Double] = js.undefined,
            startDuration: js.UndefOr[Double] = js.undefined,
            startRadius: js.UndefOr[Double | String] = js.undefined,
            theme: js.UndefOr[String] = js.undefined,
            titleField: js.UndefOr[String] = js.undefined,
            `type`: String = "pie",
            valueField: js.UndefOr[String] = js.undefined): PieChartConfig = {
    AmSlicedChart[AmPieChart](
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
      startDuration = startDuration,
      startRadius = startRadius,
      theme = theme,
      titleField = titleField,
      `type` = `type`,
      valueField = valueField
    )
  }

}