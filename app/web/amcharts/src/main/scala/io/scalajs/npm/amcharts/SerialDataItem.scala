package io.scalajs.npm.amcharts

import scala.scalajs.js

/**
  * SerialDataItem holds all the information about each series. When working with a chart, you do not create
  * SerialDataItem objects or change it's properties directly. Consider properties of a SerialDataItem
  * read-only - change values in chart's data provider if you need to. When serial chart parses dataProvider,
  * it generates "chartData" array. Objects of this array are SerialDataItem objects.
  * @param axes        You can access each GraphDataItem using this object. The data structure is:
  *                    graphDataItem = serialDataItem.axes[axisId].graphs[graphId].
  * @param category    category value. String if parseDates is false, Date if true.
  * @param dataContext Reference to original data object, from dataProvider.
  * @param time        Time stamp of a series date. Avalable only if parseDates property of CategoryAxis is set to true.
  * @param x           Coordinate (horizontal or vertical, depends on chart's rotate property) of the series.
  * @see https://docs.amcharts.com/3/javascriptstockchart/SerialDataItem
  * @author lawrence.daniels@gmail.com
  */
class SerialDataItem(val axes: js.Any = js.undefined,
                     val category: js.UndefOr[String] = js.undefined,
                     val dataContext: js.Any = js.undefined,
                     val time: js.UndefOr[Double] = js.undefined,
                     val x: js.UndefOr[Double] = js.undefined) extends js.Object
