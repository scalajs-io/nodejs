package io.scalajs.npm.amcharts

import scala.scalajs.js

/**
  * Creates a horizontal/vertical guideline-/area for [[AmSerialChart]], [[AmXYChart]] and [[AmRadarChart]] charts,
  * automatically adapts it's settings from the axes if none has been specified.
  * @example
  * {{{
  * var chart = AmCharts.makeChart("chartdiv",{
  *   ...
  *   "guides": [
  *     {
  *       "fillAlpha": 0.10,
  *       "value": 0,
  *       "toValue": 10
  *     }
  *   ]
  * });
  * }}}
  * @param above         Boolean	false	If you set it to true, the guide will be displayed above the graphs.
  * @param angle         Number		Radar chart only. Specifies angle at which guide should start. Affects only fills, not lines.
  * @param balloonColor  Color		Baloon fill color.
  * @param balloonText   String		The text which will be displayed if the user rolls-over the guide.
  * @param boldLabel     Boolean	false	Specifies if label should be bold or not.
  * @param category      String		Category of the guide (in case the guide is for category axis).
  * @param color         Color		Color of a guide label.
  * @param dashLength    Number		Dash length.
  * @param date          Date		Date of the guide (in case the guide is for category axis and parseDates is set to true).
  * @param expand        Boolean	false	Works if a guide is added to CategoryAxis and this axis is non-date-based. If you set it to true, the guide will start (or be placed, if it's not a fill) on the beginning of the category cell and will end at the end of toCategory cell.
  * @param fillAlpha     Number		Fill opacity. Value range is 0 - 1.
  * @param fillColor     Color		Fill color.
  * @param fontSize      Number		Font size of guide label.
  * @param id            String		Unique id of a Guide. You don't need to set it, unless you want to.
  * @param inside        Boolean		Specifies whether label should be placed inside or outside plot area.
  * @param label         String		The label which will be displayed near the guide.
  * @param labelRotation Number		Rotation angle of a guide label.
  * @param lineAlpha     Number		Line opacity.
  * @param lineColor     Color		Line color.
  * @param lineThickness Number		Line thickness.
  * @param position      String		Position of guide label. Possible values are "left" or "right" for horizontal axis and "top" or "bottom" for vertical axis.
  * @param tickLength    Number		Tick length.
  * @param toAngle       Number		Radar chart only. Specifies angle at which guide should end. Affects only fills, not lines.
  * @param toCategory    String		"To" category of the guide (in case the guide is for category axis).
  * @param toDate        Date		"To" date of the guide (in case the guide is for category axis and parseDates is set to true) If you have both date and toDate, the space between these two dates can be filled with color.
  * @param toValue       Number		"To" value of the guide (in case the guide is for value axis).
  * @param value         Number		Value of the guide (in case the guide is for value axis).
  * @param valueAxis     ValueAxis		Value axis of a guide. As you can add guides directly to the chart, you might need to specify which which value axis should be used.
  * @see https://docs.amcharts.com/3/javascriptstockchart/Guide
  */
class Guide(val above: js.UndefOr[Boolean] = js.undefined,
            val angle: js.UndefOr[Double] = js.undefined,
            val balloonColor: js.UndefOr[Color] = js.undefined,
            val balloonText: js.UndefOr[String] = js.undefined,
            val boldLabel: js.UndefOr[Boolean] = js.undefined,
            val category: js.UndefOr[String] = js.undefined,
            val color: js.UndefOr[Color] = js.undefined,
            val dashLength: js.UndefOr[Double] = js.undefined,
            val date: js.UndefOr[js.Date] = js.undefined,
            val expand: js.UndefOr[Boolean] = js.undefined,
            val fillAlpha: js.UndefOr[Double] = js.undefined,
            val fillColor: js.UndefOr[Color] = js.undefined,
            val fontSize: js.UndefOr[Double] = js.undefined,
            val id: js.UndefOr[String] = js.undefined,
            val inside: js.UndefOr[Boolean] = js.undefined,
            val label: js.UndefOr[String] = js.undefined,
            val labelRotation: js.UndefOr[Double] = js.undefined,
            val lineAlpha: js.UndefOr[Double] = js.undefined,
            val lineColor: js.UndefOr[Color] = js.undefined,
            val lineThickness: js.UndefOr[Double] = js.undefined,
            val position: js.UndefOr[String] = js.undefined,
            val tickLength: js.UndefOr[Double] = js.undefined,
            val toAngle: js.UndefOr[Double] = js.undefined,
            val toCategory: js.UndefOr[String] = js.undefined,
            val toDate: js.UndefOr[js.Date] = js.undefined,
            val toValue: js.UndefOr[Double] = js.undefined,
            val value: js.UndefOr[Double] = js.undefined,
            val valueAxis: js.UndefOr[ValueAxis] = js.undefined) extends js.Object