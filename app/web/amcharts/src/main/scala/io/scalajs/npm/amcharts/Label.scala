package io.scalajs.npm.amcharts

import scala.scalajs.js

/**
  * Creates a label on the chart which can be placed anywhere, multiple can be assigned.
  * @example
  * {{{
  *   var chart = AmCharts.makeChart("chartdiv",{
  *   	...
  *   	"allLabels": [
  *   		{
  *   			"text": "Free label",
  *   			"bold": true,
  *   			"x": 20,
  *   			"y": 20
  *   		}
  *   	]
  *   });
  * }}}
  * @param align    the label's alignment (default: "left").
  * @param alpha    the label's opacity (default: 1).
  * @param bold     specifies if label is bold or not.
  * @param color    the color of a label.
  * @param id       the id of a Label. You don't need to set it, unless you want to.
  * @param rotation the rotation angle (default: 0).
  * @param size     the text size
  * @param tabIndex in case you set it to some number, the chart will set focus on the label when user clicks tab key.
  *                 When a focus is set, screen readers like NVDA Screen reader will read the title.
  *                 Note, not all browsers and readers support this.
  * @param text     the text of a label.
  * @param url      the URL which will be access if user clicks on a label.
  * @param x        the X position of a label.
  * @param y        the Y position of a label.
  * @see https://docs.amcharts.com/3/javascriptstockchart/Label
  * @author lawrence.daniels@gmail.com
  */
class Label(val align: js.UndefOr[String] = js.undefined,
            val alpha: js.UndefOr[Double] = js.undefined,
            val bold: js.UndefOr[Boolean] = js.undefined,
            val color: js.UndefOr[Color] = js.undefined,
            val id: js.UndefOr[String] = js.undefined,
            val rotation: js.UndefOr[Double] = js.undefined,
            val size: js.UndefOr[Double] = js.undefined,
            val tabIndex: js.UndefOr[Double] = js.undefined,
            val text: js.UndefOr[String] = js.undefined,
            val url: js.UndefOr[String] = js.undefined,
            val x: js.UndefOr[Double] = js.undefined,
            val y: js.UndefOr[Double] = js.undefined) extends js.Object
