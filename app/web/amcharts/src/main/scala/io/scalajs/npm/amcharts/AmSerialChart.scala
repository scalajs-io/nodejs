package io.scalajs.npm.amcharts

import scala.scalajs.js

/**
  * Extension for [[AmRectangularChart]] to create line, area, column, bar, step line, smoothed line, candlestick and OHLC charts.
  * The charts support multiple axes with simple or logarithmic scales, the data points can be displayed at
  * equal / irregular intervals or on timeline basis.
  * @example
  * {{{
  * var chart = AmCharts.makeChart("chartdiv",{
  *   "type": "serial",
  *   "categoryField": "category",
  *   "graphs": [
  *     {
  *       "valueField": "value"
  *     }
  *   ],
  *   "dataProvider": [
  *     {
  *       "category": "category 1",
  *       "value": 8,
  *     },
  *     {
  *       "category": "category 2",
  *       "value": 4,
  *     }
  *   ]
  * });
  * }}}
  * @see https://docs.amcharts.com/3/javascriptstockchart/AmSerialChart
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AmSerialChart extends AmRectangularChart {

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  // TODO

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
    * Number	Returns index of the specified category value.
    * @param value the series (category value) which index you want to find.
    * @return
    */
  def getCategoryIndexByValue(value: String): js.Any = js.native

  /**
    * Zooms out, charts shows all available data.
    */
  def zoomOut(): Unit = js.native

  /**
    * Zooms the chart by the value of the category axis.
    * @param start the start category value
    * @param end   the end category value
    */
  def zoomToCategoryValues(start: String, end: String): Unit = js.native

  /**
    * Zooms the chart from one date to another.
    * @param start the start date
    * @param end   the end date
    */
  def zoomToDates(start: js.Date, end: js.Date): Unit = js.native

  /**
    * Zooms the chart by the index of the category.
    * @param start the start index
    * @param end   the end index
    */
  def zoomToIndexes(start: Double, end: Double): Unit = js.native

}

/**
  * AmSerialChart Companion
  * @author lawrence.daniels@gmail.com
  */
object AmSerialChart {

  /**
    * Serial Chart Configuration
    * @author lawrence.daniels@gmail.com
    */
  class SerialChartConfig(val categoryField: js.UndefOr[String] = js.undefined,
                          val chartCursor: js.UndefOr[ChartCursor] = js.undefined,
                          val dataProvider: js.Any,
                          val graphs: js.UndefOr[js.Array[AmGraph]] = js.undefined,
                          val listeners: js.Array[EventListener] = js.Array(),
                          val theme: js.UndefOr[String] = js.undefined,
                          val `type`: js.UndefOr[String] = "serial") extends ChartConfig[AmSerialChart]

}