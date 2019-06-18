package io.scalajs.npm.amcharts

import scala.scalajs.js

/**
  * Base class of AmCharts. It can not be instantiated explicitly. Its makeChart method gives you the possibility
  * to create charts easily with a single object.
  * @example
  * {{{
  * var chart = AmCharts.makeChart("chartdiv",{
  *   "type": "serial",
  *   "categoryField": "category",
  *   "categoryAxis": {
  *     "gridPosition": "start"
  *   },
  *   "graphs": [
  *     {
  *       "title": "Graph title",
  *       "valueField": "column-1"
  *     }
  *   ],
  *   "valueAxes": [
  *     {
  *       "title": "Axis title"
  *     }
  *   ],
  *   "legend": {
  *     "useGraphSettings": true
  *   },
  *   "titles": [
  *     {
  *       "size": 15,
  *       "text": "Chart Title"
  *     }
  *   ],
  *   "dataProvider": [
  *     {
  *       "category": "category 1",
  *       "column-1": 8
  *     },
  *     {
  *       "category": "category 2",
  *       "column-1": 10
  *     },
  *   ]
  * });
  * }}}
  * @see https://docs.amcharts.com/3/javascriptstockchart/AmChart
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AmChart extends js.Object {

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
    * When enabled, chart adds aria-label attributes to columns, bullets or map objects. You can control values
    * of these labels using properties like accessibleLabel of AmGraph. Note, not all screen readers support these
    * tags. We tested this mostly with NVDA Screen reader. WAI-ARIA is now official W3 standard, so in future more
    * readers will handle this well. We will be improving accessibility on our charts, so we would be glad to hear
    * your feedback.
    */
  var accessible: Boolean = js.native

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
    * Adds a label on a chart. You can use it for labeling axes, adding chart title, etc. x and y coordinates
    * can be set in number, percent, or a number with ! in front of it - coordinate will be calculated from
    * right or bottom instead of left or top.
    * @param x        the  horizontal coordinate
    * @param y        the vertical coordinate
    * @param text     the label's text align
    * @param align    the alignment (left/right/center) size
    * @param size     the text size color
    * @param color    the text color rotation
    * @param rotation the angle of rotation alpha
    * @param alpha    the label alpha bold
    * @param bold     the specifies if text is bold (true/false)
    * @param url      the URL
    */
  def addLabel(x: Double, y: Double, text: String, align: String, size: Double, color: String, rotation: Double, alpha: Double, bold: Boolean, url: String): Unit = js.native

  /**
    * Adds a legend to the chart. By default, you don't need to create div for your legend, however if you want
    * it to be positioned in some different way, you can create div anywhere you want and pass id or reference
    * to your div as a second parameter. (NOTE: This method will not work on StockPanel.)
    * @param legend      the given [[AmLegend legend]]
    * @param legendDivID the id or reference to legend div (optional)
    */
  def addLegend(legend: AmLegend, legendDivID: String): Unit = js.native

  /**
    * Adds event listener to the object.
    * @param `type`  string like 'dataUpdated' (should be listed in 'events' section of this class or classes
    *                which extend this class).
    * @param handler function which is called when event happens
    */
  def addListener(`type`: String, handler: js.Function): Unit = js.native

  /**
    * Adds title to the top of the chart. Pie, Radar positions are updated so that they won't overlap.
    * Plot area of Serial/XY chart is also updated unless autoMargins property is set to false. You can
    * add any number of titles - each of them will be placed in a new line. To remove titles, simply clear
    * titles array: chart.titles = []; and call chart.validateNow() method.
    * @param text  the text of a title
    * @param size  the font size
    * @param color the title color
    * @param alpha the title opacity
    * @param bold  a boolean value indicating if title should be bold.
    */
  def addTitle(text: String, size: Double, color: String, alpha: String, bold: Boolean): Unit = js.native

  /**
    * Clears the chart area, intervals, etc.
    */
  def clear(): Unit = js.native

  /**
    * Removes all labels added to the chart.
    */
  def clearLabels(): Unit = js.native

  /**
    * Use this method to force the chart to resize to it's current container size.
    */
  def invalidateSize(): Unit = js.native

  /**
    * This method allows to create charts with a single config.
    * @param container id of a DIV or reference of the container element
    * @param config    contains the whole setup for the chart
    * @param delay     delay in milliseconds to delay the initiation of the chart
    * @return a [[AmChart chart instance]]
    */
  def makeChart[A <: AmChart](container: String, config: ChartConfig[A], delay: Double = js.native): A = js.native

  /**
    * Removes chart's legend.
    */
  def removeLegend(): Unit = js.native

  /**
    * Removes event listener from chart object.
    * @param chart   the given [[AmChart chart]]
    * @param `type`  the type
    * @param handler the callback function
    */
  def removeListener(chart: AmChart, `type`: String, handler: js.Function): Unit = js.native

  /**
    * This method should be called after data in your data provider changed or a new array was set to dataProvider.
    * After calling this method the chart will parse data and redraw.
    */
  def validateData(): Unit = js.native

  /**
    * This method should be called after you changed one or more properties of any class. The chart will redraw
    * after this method is called. Both attributes, validateData and skipEvents are optional (false by default).
    * @param validateData validate data indicator
    * @param skipEvents   skip events indicator
    */
  def validateNow(validateData: Boolean = js.native, skipEvents: Boolean = js.native): Unit = js.native

  /**
    * Adds chart to the specified DIV.
    * @param container id of a DIV or DIV object which will hold the chart
    */
  def write(container: String): Unit = js.native

}

/**
  * AmChart Companion
  * @author lawrence.daniels@gmail.com
  */
object AmChart {

  /**
    * AmCharts Chart Export Options
    * @author lawrence.daniels@gmail.com
    */
  class Export(val enabled: js.UndefOr[Boolean] = js.undefined) extends js.Object

}