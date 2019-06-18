package io.scalajs.npm.amcharts

import scala.scalajs.js

/**
  * GraphDataItem holds all the information about the graph's data item. When working with a chart, you do not create
  * GraphDataItem objects or change it's properties directly. GraphDataItem is passed to you by events when user
  * interacts with data item on the chart. The list of properties below will help you to extract data item's
  * value/coordinate/etc.
  * @param alpha          Opacity of the data item.
  * @param bullet         Bullet type.
  * @param bulletSize     Bullet size.
  * @param category       Category value.
  * @param color          Color of the data item.
  * @param customBullet   Custom bullet (path to file name).
  * @param dataContext    Original object from data provider.
  * @param description    Description.
  * @param fillColors     Array of colors of the data item, used by column and candlestick chart only.
  * @param percents       Object		Object which holds percents when recalculateToPercents is set to true.
  * @param serialDataItem SerialDataItem of this graphDataItem
  * @param url            the url
  * @param values         Object which holds values of the data item (value, open, close, low, high).
  * @param x              x coordinate of the data item.
  * @param y              y coordinate of the data item.
  * @see https://docs.amcharts.com/3/javascriptstockchart/GraphDataItem
  * @author lawrence.daniels@gmail.com
  */
class GraphDataItem(val alpha: js.UndefOr[Double] = js.undefined,
                    val bullet: js.UndefOr[String] = js.undefined,
                    val bulletSize: js.UndefOr[Double] = js.undefined,
                    val category: js.UndefOr[String] = js.undefined,
                    val color: js.UndefOr[Color] = js.undefined,
                    val customBullet: js.UndefOr[String] = js.undefined,
                    val dataContext: js.Any = js.undefined,
                    val description: js.UndefOr[String] = js.undefined,
                    val fillColors: js.UndefOr[js.Array[Color]] = js.undefined,
                    val percents: js.Any = js.undefined,
                    val serialDataItem: js.UndefOr[SerialDataItem] = js.undefined,
                    val url: js.UndefOr[String] = js.undefined,
                    val values: js.Any = js.undefined,
                    val x: js.UndefOr[Double] = js.undefined,
                    val y: js.UndefOr[Double] = js.undefined) extends js.Object


