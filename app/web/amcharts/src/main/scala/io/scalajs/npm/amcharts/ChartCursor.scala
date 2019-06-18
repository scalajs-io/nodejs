package io.scalajs.npm.amcharts

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * ChartCursor - Creates a cursor for the chart which follows the mouse movements. In case of [[AmSerialChart]] charts
  * it shows the balloons of hovered data points.
  * @example
  * {{{
  * var chart = AmCharts.makeChart("chartdiv",{
  *   ...
  *   "chartCursor": {
  *     "oneBalloonOnly": true
  *   }
  * });
  * }}}
  * @see https://docs.amcharts.com/3/javascriptstockchart/ChartCursor
  * @author lawrence.daniels@gmail.com
  */
@JSGlobal
@js.native
class ChartCursor extends js.Object {

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////


  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
    * Adds event listener to the object.
    * @param `type`  string like 'changed' (should be listed in 'events' section of this class or classes which extend this class).
    * @param handler function which is called when event happens
    */
  def addListener(`type`: String, handler: js.Function): Unit = js.native

  /**
    * This method can be used when selectWithoutZooming is set to true and you need to clear the selection made by user.
    */
  def clearSelection(): Unit = js.native

  /**
    * Hides cursor.
    */
  def hideCursor(): Unit = js.native

  /**
    * Removes event listener from the object.
    * @param obj     the object
    * @param `type`  string like 'changed' (should be listed in 'events' section of this class or classes which extend this class).
    * @param handler function which is called when event happens
    */
  def removeListener(obj: js.Any, `type`: String, handler: js.Function): Unit = js.native

  /**
    * You can force cursor to appear at specified cateogry or date.
    * @param category the given category
    */
  def showCursorAt(category: String): Unit = js.native

  /**
    * Allows to sync one serial chart’s cursor with another chart’s cursor.
    * Important! This method will work correctly only if plot area of both charts is identically equal in width.
    * @param cursor the given [[ChartCursor cursor]]
    */
  def syncWithCursor(cursor: ChartCursor): Unit = js.native

}
