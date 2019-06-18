package io.scalajs.npm.amcharts

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Creates the balloons ( tooltips ) of the chart, It follows the mouse cursor when you roll-over the data items.
  * The framework generates the instances automatically you only need to adjust the appearance to your needs.
  * @example
  * {{{
  * var chart = AmCharts.makeChart("chartdiv", {
  *   ...
  *   "balloon": {
  *    "adjustBorderColor": true,
  *     "color": "#000000",
  *     "cornerRadius": 5,
  *     "fillColor": "#FFFFFF"
  *   }
  * });
  * }}}
  * @param adjustBorderColor  Boolean	true	If this is set to true, border color instead of background color will be changed when user rolls-over the slice, graph, etc.
  * @param animationDuration  Number	0.3	Duration of balloon movement from previous point to current point, in seconds.
  * @param borderAlpha        Number	1	Balloon border opacity. Value range is 0 - 1.
  * @param borderColor        Color	#FFFFFF	Balloon border color. Will only be used of adjustBorderColor is false.
  * @param borderThickness    Number	2	Balloon border thickness.
  * @param color              Color	#000000	Color of text in the balloon.
  * @param cornerRadius       Number	0	Balloon corner radius.
  * @param disableMouseEvents Boolean	true	If your balloon has links, you have to set this to false in order for those links to be clickable.
  * @param drop               Boolean	false	Allows having drop-shaped balloons. Note, these balloons will not check for overlapping with other balloons, or if they go outside plot area. It also does not change pointer orientation automatically based on its vertical position like regular balloons do. You can use pointerOrientation property if you want it to point to different direction. Not supported by IE8.
  * @param enabled            Boolean	true	Use this property to disable balloons for certain value axes. I.e.:
  *                           {{{
  *                            "valueAxes": [{
  *                              // ...
  *                              // value balloons are shown
  *                            }, {
  *                              // ...
  *                              "balloon": {
  *                                "enabled": false
  *                              }
  *                              // value balloons are not shown
  *                            }]
  *                           }}}
  * @param fadeOutDuration    Number	0.3	Duration of a fade out animation, in seconds.
  * @param fillAlpha          Number	0.8	Balloon background opacity.
  * @param fillColor          Color	#FFFFFF	Balloon background color. Usually balloon background color is set by the chart. Only if "adjustBorderColor" is "true" this color will be used.
  * @param fixedPosition      Boolean	true	Specifies if balloon should follow mouse when hovering the slice/column/bullet or stay in fixed position (this does not affect balloon behavior if ChartCursor is used).
  *                           Note: This setting is ignored in JavaScript Maps.
  * @param fontSize           Number		Size of text in the balloon. Chart's fontSize is used by default.
  * @param horizontalPadding  Number	8	Horizontal padding of the balloon.
  * @param maxWidth           Number		Maximum width of a balloon.
  * @param offsetX            Number	1	Defines horizontal distance from mouse pointer to balloon pointer. If you set it to a small value, the balloon might flicker, as mouse might lose focus on hovered object.
  *                           NOTE: this setting is ignored unless fixedPosition is set to false or Chart Cursor is enabled.
  * @param offsetY            Number	6	Defines vertical distance from mouse pointer to balloon pointer. If you set it to a small value, the balloon might flicker, as mouse might lose focus on hovered object.
  *                           NOTE: this setting is ignored unless fixedPosition is set to false or Chart Cursor is enabled.
  * @param pointerOrientation String	down	Works only if balloon.drop set to true, specifies direction of a pointer.
  * @param pointerWidth       Number	6	The width of the pointer (arrow) "root". Only used if cornerRadius is 0.
  * @param shadowAlpha        Number	0.4	Opacity of a shadow.
  * @param shadowColor        Color	#000000	Color of a shadow.
  * @param showBullet         Boolean	false	If cornerRadius of a balloon is >0, showBullet is set to true for value balloons when ChartCursor is used. If you don't want the bullet near the balloon, set it to false: chart.balloon.showBullet = false
  * @param textAlign          String	middle	Text alignment, possible values "left", "middle" and "right"
  * @param verticalPadding    Number	4	Vertical padding of the balloon.
  * @see https://docs.amcharts.com/3/javascriptcharts/AmBalloon
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
class AmBalloon(var adjustBorderColor: js.UndefOr[Boolean] = js.undefined,
                var animationDuration: js.UndefOr[Double] = js.undefined,
                var borderAlpha: js.UndefOr[Double] = js.undefined,
                var borderColor: js.UndefOr[Color] = js.undefined,
                var borderThickness: js.UndefOr[Double] = js.undefined,
                var color: js.UndefOr[Color] = js.undefined,
                var cornerRadius: js.UndefOr[Double] = js.undefined,
                var disableMouseEvents: js.UndefOr[Boolean] = js.undefined,
                var drop: js.UndefOr[Boolean] = js.undefined,
                var enabled: js.UndefOr[Boolean] = js.undefined,
                var fadeOutDuration: js.UndefOr[Double] = js.undefined,
                var fillAlpha: js.UndefOr[Double] = js.undefined,
                var fillColor: js.UndefOr[Color] = js.undefined,
                var fixedPosition: js.UndefOr[Boolean] = js.undefined,
                var fontSize: js.UndefOr[Double] = js.undefined,
                var horizontalPadding: js.UndefOr[Double] = js.undefined,
                var maxWidth: js.UndefOr[Double] = js.undefined,
                var offsetX: js.UndefOr[Double] = js.undefined,
                var offsetY: js.UndefOr[Double] = js.undefined,
                var pointerOrientation: js.UndefOr[Double] = js.undefined,
                var pointerWidth: js.UndefOr[Double] = js.undefined,
                var shadowAlpha: js.UndefOr[Double] = js.undefined,
                var shadowColor: js.UndefOr[Color] = js.undefined,
                var showBullet: js.UndefOr[Boolean] = js.undefined,
                var textAlign: js.UndefOr[String] = js.undefined,
                var verticalPadding: js.UndefOr[Double] = js.undefined) extends js.Object {

  /**
    * Hides balloon.
    */
  def hide(): Unit = js.native

  /**
    * Defines a square within which the balloon should appear. Bounds are set by chart class, you don't need to call this method yourself.
    * @param left   the left bounds
    * @param top    the top bounds
    * @param right  the right bounds
    * @param bottom the bottom bounds
    */
  def setBounds(left: Double, top: Double, right: Double, bottom: Double): Unit = js.native

  /**
    * Sets coordinates the balloon should point to.
    * @param x the X-axis value
    * @param y the Y-axis value
    */
  def setPosition(x: Double, y: Double): Unit = js.native

}