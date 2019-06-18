package io.scalajs.npm.amcharts

import scala.scalajs.js

/**
  * Slice is an item of AmPieChart's chartData Array and holds all the information about the slice.
  * When working with a pie chart, you do not create slices or change it's properties directly,
  * instead you set array of data using dataProvider property. Consider properties of a Slice
  * read-only - change values in chart's data provider if you need to.
  * @see https://docs.amcharts.com/3/javascriptcharts/Slice
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Slice extends js.Object {

  /**
    * Opacity of a slice.
    */
  var alpha: Double = js.native

  /**
    * Color of a slice.
    */
  var color: Color = js.native

  /**
    * Original object from data provider.
    */
  var dataContext: js.Object = js.native

  /**
    * Slice description.
    */
  var description: String = js.native

  /**
    * Specifies whether the slice is hidden
    */
  var hidden: Boolean = js.native

  /**
    * Percent value of a slice.
    */
  var percents: Double = js.native

  /**
    * Specifies whether the slice is pulled or not.
    */
  var pulled: Boolean = js.native

  /**
    * Slice title
    */
  var title: String = js.native

  /**
    * Url of a slice
    */
  var url: String = js.native

  /**
    * Value of a slice
    */
  var value: Double = js.native

  /**
    * specifies whether this slice has a legend entry
    */
  var visibleInLegend: Boolean = js.native

}
