package io.scalajs.npm.amcharts

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Extension for [[AmCoordinateChart]] to create radar/polar charts.
  * @see https://docs.amcharts.com/3/javascriptstockchart/AmRadarChart
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AmRadarChart extends AmCoordinateChart {

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
    * Field in your data provider containing categories.
    */
  var categoryField: String = js.native

  /**
    * Bottom margin of the chart.
    */
  var marginBottom: Double = js.native

  /**
    * Left margin of the chart.
    */
  var marginLeft: Double = js.native

  /**
    * Right margin of the chart.
    */
  var marginRight: Double = js.native

  /**
    * Top margin of the chart.
    */
  var marginTop: Double = js.native

  /**
    * Radius of a radar.
    */
  var radius: String | Double = js.native

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  // TODO

}

/**
  * AmRadarChart Companion
  * @author lawrence.daniels@gmail.com
  */
object AmRadarChart {

  /**
    * Radar Chart Configuration
    * @author lawrence.daniels@gmail.com
    */
  class RadarChartConfig(val categoryField: js.UndefOr[String] = js.undefined,
                         val chartCursor: js.UndefOr[ChartCursor] = js.undefined,
                         val dataProvider: js.Any,
                         val graphs: js.UndefOr[js.Array[AmGraph]] = js.undefined,
                         val listeners: js.Array[EventListener] = js.Array(),
                         val theme: js.UndefOr[String] = js.undefined,
                         val `type`: js.UndefOr[String] = "radar") extends ChartConfig[AmRadarChart]

}