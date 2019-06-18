package io.scalajs.npm.amcharts

import scala.scalajs.js

/**
  * Base class for ValueAxis and CategoryAxis. It can not be instantiated explicitly.
  * @see https://docs.amcharts.com/3/javascriptstockchart/AxisBase
  */
@js.native
trait AxisBase extends js.Object {

  /**
    * Adds guide to the axis.
    * @param guide the instance of Guide
    */
  def addGuide(guide: Guide): Unit = js.native

  /**
    * Removes guide from the axis.
    * @param guide the instance of Guide
    */
  def removeGuide(guide: Guide): Unit = js.native

}
