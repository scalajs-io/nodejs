package io.scalajs.npm.amcharts

import scala.scalajs.js

/**
  * AmXYChart - Extension for [[AmRectangularChart]] to create XY/bubble/scatter charts.
  * The charts support multiple axes with simple or logarithmic scales.
  * @see https://docs.amcharts.com/3/javascriptstockchart/AmXYChart
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AmXYChart extends AmRectangularChart {

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
    * In case you have date-based value axis in your XY chart, you can specify your corresponding values as strings.
    * In that case you will need to set this setting to whatever format your are using for date/time.
    */
  var dataDateFormat: String = js.native

  /**
    * Specifies if Scrollbar of X axis (horizontal) should be hidden.
    */
  var hideXScrollbar: Boolean = js.native

  /**
    * Specifies if Scrollbar of Y axis (vertical) should be hidden.
    */
  var hideYScrollbar: Boolean = js.native

  /**
    * These can be used to adjust size/scale of bubbles. If these properties are not set, the bubble with smallest
    * value will be of minBulletSize and bubble with biggest value will be of maxBulletSize. However, you might want
    * bubble size to change relative to 0 or some other value. In this case you can use minValue and maxValue properties.
    * Note, if you use these two settings, you might also want to set minBulletSize to 0.
    */
  var maxValue: Double = js.native

  /**
    * Maximum zoom factor of the chart.
    */
  var maxZoomFactor: Double = js.native

  /**
    * These can be used to adjust size/scale of bubbles. If these properties are not set, the bubble with smallest
    * value will be of minBulletSize and bubble with biggest value will be of maxBulletSize. However, you might want
    * bubble size to change relative to 0 or some other value. In this case you can use minValue and maxValue properties.
    * Note, if you use these two settings, you might also want to set minBulletSize to 0.
    */
  var minValue: Double = js.native

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
    * Zooms out, charts shows all available data.
    */
  def zoomOut(): Unit = js.native

}

/**
  * AmXYChart Companion
  * @author lawrence.daniels@gmail.com
  */
object AmXYChart {

  /**
    * XY Chart Configuration
    * @author lawrence.daniels@gmail.com
    */
  class XYChartConfig(val colorField: js.UndefOr[String] = js.undefined,
                      val dataProvider: js.Any = js.undefined,
                      val graphs: js.UndefOr[js.Array[AmGraph]] = js.undefined,
                      val listeners: js.Array[EventListener] = js.Array(),
                      val valueField: js.UndefOr[String] = js.undefined,
                      val theme: js.UndefOr[String] = js.undefined,
                      val titleField: js.UndefOr[String] = js.undefined,
                      val `type`: js.UndefOr[String] = "xy") extends ChartConfig[AmXYChart]

}