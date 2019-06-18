package io.scalajs.npm.amcharts

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * Creates the legend for the chart, automatically adapts the color settings of the graphs.
  * @example
  * {{{
  * var chart = AmCharts.makeChart("chartdiv",{
  *   ...
  *   "legend": {
  *     "useGraphSettings": true
  *   },
  * });
  * }}}
  * @param accessibleLabel         Text which screen readers will read if user rolls-over the element or sets focus on it using tab key (this is possible only if tabIndex property of AmLegend is set to some number). Text is added as aria-label tag. Note - not all screen readers and browsers support this.
  * @param align                   Alignment of legend entries. Possible values are: "left", "center", "right".
  * @param autoMargins             Used if chart is Serial or XY. In case true, margins of the legend are adjusted and made equal to chart's margins.
  * @param backgroundAlpha         Opacity of legend's background. Value range is 0 - 1
  * @param backgroundColor         Background color. You should set backgroundAlpha to >0 vallue in order background to be visible.
  * @param borderAlpha             Opacity of chart's border. Value range is 0 - 1.
  * @param borderColor             Color of legend's border. You should set borderAlpha >0 in order border to be visible.
  * @param bottom                  In case legend position is set to "absolute", you can set distance from bottom of the chart, in pixels.
  * @param color                   Text color.
  * @param combineLegend           If you set it to true, and you have some legend items set using legend.data property, both graph’s entries and those added using data property will be displayed.
  * @param data                    You can pass array of objects with title, color, markerType values, for example: [{title: "One", color: "#3366CC"},{title: "Two", color: "#FFCC33"}]
  * @param divId                   You can set id of a div or a reference to div object in case you want the legend to be placed in a separate container.
  * @param enabled                 Specifies if legend is enabled or not.
  * @param equalWidths             Specifies if each of legend entry should be equal to the most wide entry. Won't look good if legend has more than one line.
  * @param fontSize                Font size.
  * @param forceWidth              If you set this property to true, width of legend item labels won't be adjusted. Useful when you have more than one chart and want to align all the legends.
  * @param gradientRotation        Can be used if legend uses custom data. Set it to 0, 90, 180 or 270.
  * @param horizontalGap           Horizontal space between legend item and left/right border.
  * @param labelText               The text which will be displayed in the legend. Tag `[[title]]` will be replaced with the title of the graph.
  * @param labelWidth              If width of the label is bigger than labelWidth, it will be wrapped.
  * @param left                    In case legend position is set to "absolute", you can set distance from left side of the chart, in pixels.
  * @param listeners               You can add listeners of events using this property. Example: listeners = [{"event":"clickLabel", "method":handleEvent}];
  * @param marginBottom            Bottom margin.
  * @param marginLeft              Left margin. This property will be ignored if chart is Serial or XY and autoMargins property of the legend is true (default).
  * @param marginRight             Right margin. This property will be ignored if chart is Serial or XY and autoMargins property of the legend is true (default).
  * @param marginTop               Top margin.
  * @param markerBorderAlpha       Marker border opacity.
  * @param markerBorderColor       Marker border color. If not set, will use the same color as marker.
  * @param markerBorderThickness   Thickness of the legend border. The default value (0) means the line will be a "hairline" (1 px). In case marker type is line, this style will be used for line thickness.
  * @param markerDisabledColor     The color of the disabled marker (when the graph is hidden).
  * @param markerLabelGap          Space between legend marker and legend text, in pixels.
  * @param markerSize              Size of the legend marker (key).
  * @param markerType              Shape of the legend marker (key). Possible values are: square, circle, diamond, triangleUp, triangleDown, triangleLeft, triangleDown, bubble, line, none.
  * @param maxColumns              Maximum number of columns in the legend. If Legend's position is set to "right" or "left", maxColumns is automatically set to 1.
  * @param periodValueText         The text which will be displayed in the value portion of the legend when user is not hovering above any data point. The tags should be made out of two parts - the name of a field (value / open / close / high / low) and the value of the period you want to be show - open / close / high / low / sum / average / count. For example: `[[value.sum]]` means that sum of all data points of value field in the selected period will be displayed.
  * @param position                Position of a legend. Possible values are: "bottom", "top", "left", "right" and "absolute". In case "absolute", you should set left and top properties too. (this setting is ignored in Stock charts). In case legend is used with AmMap, position is set to "absolute" automatically.
  * @param reversedOrder           Specifies whether legend entries should be placed in reversed order.
  * @param right                   In case legend position is set to "absolute", you can set distance from right side of the chart, in pixels.
  * @param rollOverColor           Legend item text color on roll-over.
  * @param rollOverGraphAlpha      When you roll-over the legend entry, all other graphs can reduce their opacity, so that the graph you rolled-over would be distinguished. This style specifies the opacity of the non-hovered graphs.
  * @param showEntries             You can use this property to turn all the legend entries off.
  * @param spacing                 Horizontal space between legend items, in pixels.
  * @param switchable              Whether showing/hiding of graphs by clicking on the legend marker is enabled or not. In case legend is used with AmMap, this is set to false automatically.
  * @param switchColor             Legend switch color.
  * @param switchType              Legend switch type (in case the legend is switchable). Possible values are "x" and "v".
  * @param tabIndex                In case you set it to some number, the chart will set focus on legend entry when user clicks tab key. When a focus is set, screen readers like NVDA Screen reader will read label which is set using accessibleLabel property of AmLegend. If legend has switchable set to true, pressing Enter (Return) key will show/hide the graph. Note, not all browsers and readers support this.
  * @param textClickEnabled        If true, clicking on the text will show/hide balloon of the graph. Otherwise it will show/hide graph/slice, if switchable is set to true.
  * @param top                     In case legend position is set to "absolute", you can set distance from top of the chart, in pixels.
  * @param useGraphSettings        Legend markers can mirror graph’s settings, displaying a line and a real bullet as in the graph itself. Set this property to true if you want to enable this feature. Note, if you set graph colors in dataProvider, they will not be reflected in the marker.
  * @param useMarkerColorForLabels Labels will use marker color if you set this to true.
  * @param useMarkerColorForValues Specifies if legend values should be use same color as corresponding markers.
  * @param valueAlign              Alignment of the value text. Possible values are "left" and "right".
  * @param valueFunction           You can use it to format value labels in any way you want. Legend will call this method and will pass GraphDataItem and formatted text of currently hovered item (works only with ChartCursor added to the chart). This method should return string which will be displayed as value in the legend.
  * @param valueText               The text which will be displayed in the value portion of the legend. You can use tags like `[[value]]`, `[[open]]`, `[[high]]`, `[[low]]`, `[[close]]`, `[[percents]]`, `[[description]]`.
  * @param valueWidth              Width of the value text.
  * @param verticalGap             Vertical space between legend items also between legend border and first and last legend row.
  * @param width                   Width of a legend, when position is set to absolute.
  * @see https://docs.amcharts.com/3/javascriptstockchart/AmLegend
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
class AmLegend(val accessibleLabel: js.UndefOr[String] = js.undefined,
               val align: js.UndefOr[String] = js.undefined,
               val autoMargins: js.UndefOr[Boolean] = js.undefined,
               val backgroundAlpha: js.UndefOr[Double] = js.undefined,
               val backgroundColor: js.UndefOr[Color] = js.undefined,
               val borderAlpha: js.UndefOr[Double] = js.undefined,
               val borderColor: js.UndefOr[Color] = js.undefined,
               val bottom: js.UndefOr[Double] = js.undefined,
               val color: js.UndefOr[Color] = js.undefined,
               val combineLegend: js.UndefOr[Boolean] = js.undefined,
               val data: js.Any = js.undefined,
               val divId: js.UndefOr[String] = js.undefined,
               val enabled: js.UndefOr[Boolean] = js.undefined,
               val equalWidths: js.UndefOr[Boolean] = js.undefined,
               val fontSize: js.UndefOr[Double] = js.undefined,
               val forceWidth: js.UndefOr[Boolean] = js.undefined,
               val gradientRotation: js.UndefOr[Double] = js.undefined,
               val horizontalGap: js.UndefOr[Double] = js.undefined,
               val labelText: js.UndefOr[String] = js.undefined,
               val labelWidth: js.UndefOr[Double] = js.undefined,
               val left: js.UndefOr[Double] = js.undefined,
               val listeners: js.Array[EventListener] = js.Array(),
               val marginBottom: js.UndefOr[Double] = js.undefined,
               val marginLeft: js.UndefOr[Double] = js.undefined,
               val marginRight: js.UndefOr[Double] = js.undefined,
               val marginTop: js.UndefOr[Double] = js.undefined,
               val markerBorderAlpha: js.UndefOr[Double] = js.undefined,
               val markerBorderColor: js.UndefOr[Color] = js.undefined,
               val markerBorderThickness: js.UndefOr[Double] = js.undefined,
               val markerDisabledColor: js.UndefOr[Color] = js.undefined,
               val markerLabelGap: js.UndefOr[Double] = js.undefined,
               val markerSize: js.UndefOr[Double] = js.undefined,
               val markerType: js.UndefOr[String] = js.undefined,
               val maxColumns: js.UndefOr[Double] = js.undefined,
               val periodValueText: js.UndefOr[String] = js.undefined,
               val position: js.UndefOr[String] = js.undefined,
               val reversedOrder: js.UndefOr[Boolean] = js.undefined,
               val right: js.UndefOr[Double] = js.undefined,
               val rollOverColor: js.UndefOr[Color] = js.undefined,
               val rollOverGraphAlpha: js.UndefOr[Double] = js.undefined,
               val showEntries: js.UndefOr[Boolean] = js.undefined,
               val spacing: js.UndefOr[Double] = js.undefined,
               val switchable: js.UndefOr[Boolean] = js.undefined,
               val switchColor: js.UndefOr[Color] = js.undefined,
               val switchType: js.UndefOr[String] = js.undefined,
               val tabIndex: js.UndefOr[Int] = js.undefined,
               val textClickEnabled: js.UndefOr[Boolean] = js.undefined,
               val top: js.UndefOr[Double] = js.undefined,
               val useGraphSettings: js.UndefOr[Boolean] = js.undefined,
               val useMarkerColorForLabels: js.UndefOr[Boolean] = js.undefined,
               val useMarkerColorForValues: js.UndefOr[Boolean] = js.undefined,
               val valueAlign: js.UndefOr[String] = js.undefined,
               val valueFunction: js.UndefOr[js.Function] = js.undefined,
               val valueText: js.UndefOr[String] = js.undefined,
               val valueWidth: js.UndefOr[Double] = js.undefined,
               val verticalGap: js.UndefOr[Double] = js.undefined,
               val width: js.UndefOr[Double] = js.undefined) extends js.Object {

  /**
    * Adds event listener to the object.
    * @param `type`  a string like 'clickLabel' (should be listed in 'events' section of this class or classes which extend this class).
    * @param handler a function which is called when event happens
    */
  def addListener(`type`: String, handler: js.Function): Unit = js.native

  /**
    * Removes event listener from the legend object.
    * @param legend  the legend
    * @param `type`  a string like 'clickLabel' (should be listed in 'events' section of this class or classes which extend this class).
    * @param handler a function which is called when event happens
    */
  def removeListener(legend: AmLegend | String, `type`: String, handler: js.Function): Unit = js.native

}