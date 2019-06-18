package io.scalajs.npm.amcharts

import io.scalajs.npm.amcharts.AmChart.Export

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Extension for AmChart and base class of AmPieChart and AmFunnelChart. It can not be instantiated explicitly.
  * @see https://docs.amcharts.com/3/javascriptstockchart/AmSlicedChart
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AmSlicedChart extends AmChart {

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
    * Text which screen readers will read if user rolls-over the slice or sets focus using tab key (this is
    * possible only if tabIndex property of AmSlicedChart is set to some number). Text is added as aria-label
    * tag. Note - not all screen readers and browsers support this.
    */
  var accessibleLabel: String = js.native

  /**
    * Opacity of all slices.
    */
  var alpha: Double = js.native

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
    * You can trigger the animation of the chart.
    */
  def animateAgain(): Unit = js.native

  /**
    * You can trigger the click on a slice from outside.
    * @param index the number of a slice or Slice object.
    */
  def clickSlice(index: Int): Unit = js.native

  /**
    * Hides slice.
    * @param index the number of a slice or Slice object.
    */
  def hideSlice(index: Int): Unit = js.native

  /**
    * You can simulate roll-out of a slice from outside.
    * @param index the number of a slice or Slice object.
    */
  def rollOutSlice(index: Int): Unit = js.native

  /**
    * You can simulate roll-over a slice from outside.
    * @param index the number of a slice or Slice object.
    */
  def rollOverSlice(index: Int): Unit = js.native

  /**
    * Shows slice.
    * @param index the number of a slice or Slice object.
    */
  def showSlice(index: Int): Unit = js.native

}

/**
  * AmSlicedChart Companion
  * @author lawrence.daniels@gmail.com
  */
object AmSlicedChart {

  /**
    * Constructs a new Slice Chart Configuration
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
    * @return a new [[SliceChartConfig Slice Chart Configuration]]
    * @author lawrence.daniels@gmail.com
    */
  def apply[T <: AmChart](adjustPrecision: js.UndefOr[Boolean] = js.undefined,
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
                          `type`: String,
                          valueField: js.UndefOr[String] = js.undefined) = new SliceChartConfig[T](
    adjustPrecision = adjustPrecision,
    angle = angle,
    balloonFunction = balloonFunction,
    balloonText = balloonText,
    colorField = colorField,
    dataProvider = dataProvider,
    depth3D = depth3D,
    export = export,
    gradientType = gradientType,
    //innerRadius = innerRadius,
    labelRadius = labelRadius,
    labelRadiusField = labelRadiusField,
    //labelText = labelText,
    listeners = listeners,
    //minRadius = minRadius,
    //neckHeight = js.undefined,
    //neckWidth = js.undefined,
    outlineAlpha = outlineAlpha,
    pieX = pieX,
    pieY = pieY,
    //pullOutRadius = pullOutRadius,
    radius = radius,
    startAngle = startAngle,
    startDuration = startDuration,
    startRadius = startRadius,
    theme = theme,
    titleField = titleField,
    `type` = `type`,
    valueField = valueField
  )

  /**
    * Slice Chart Configuration
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
    * @author lawrence.daniels@gmail.com
    */
  class SliceChartConfig[+T <: AmChart](val adjustPrecision: js.UndefOr[Boolean] = js.undefined,
                                        val angle: js.UndefOr[Double] = js.undefined,
                                        val balloonFunction: js.UndefOr[js.Function] = js.undefined,
                                        val balloonText: js.UndefOr[String] = js.undefined,
                                        val colorField: js.UndefOr[String] = js.undefined,
                                        val dataProvider: js.Array[_ <: js.Any],
                                        val depth3D: js.UndefOr[Double] = js.undefined,
                                        val export: js.UndefOr[Export] = js.undefined,
                                        val gradientType: js.UndefOr[String] = js.undefined,
                                        //val innerRadius: js.UndefOr[Double | String] = js.undefined,
                                        val labelRadius: js.UndefOr[Double] = js.undefined,
                                        val labelRadiusField: js.UndefOr[String] = js.undefined,
                                        //val labelText: js.UndefOr[String] = js.undefined,
                                        val listeners: js.Array[EventListener],
                                        //val minRadius: js.UndefOr[Double] = js.undefined,
                                        //val neckHeight: js.UndefOr[Double | String] = js.undefined,
                                        //val neckWidth: js.UndefOr[Double | String] = js.undefined,
                                        val outlineAlpha: js.UndefOr[Double] = js.undefined,
                                        val pieX: js.UndefOr[Double | String] = js.undefined,
                                        val pieY: js.UndefOr[Double | String] = js.undefined,
                                        //val pullOutRadius: js.UndefOr[Double | String] = js.undefined,
                                        val radius: js.UndefOr[Double | String] = js.undefined,
                                        val startAngle: js.UndefOr[Double] = js.undefined,
                                        val startDuration: js.UndefOr[Double] = js.undefined,
                                        val startRadius: js.UndefOr[Double | String] = js.undefined,
                                        val theme: js.UndefOr[String] = js.undefined,
                                        val `type`: String,
                                        val titleField: js.UndefOr[String] = js.undefined,
                                        val valueField: js.UndefOr[String] = js.undefined) extends ChartConfig[T]

}