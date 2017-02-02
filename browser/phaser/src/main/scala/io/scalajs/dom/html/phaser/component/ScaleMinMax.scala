package io.scalajs.dom.html.phaser.component

import io.scalajs.dom.html.phaser.Phaser

import scala.scalajs.js

/**
  * The ScaleMinMax component allows a Game Object to limit how far it can be scaled by its parent.
  * @see http://phaser.io/docs/2.6.2/Phaser.Component.ScaleMinMax.html#scaleMax
  */
@js.native
trait ScaleMinMax extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The maximum scale this Game Object will scale up to.
    *
    * It allows you to prevent a parent from scaling this Game Object higher than the given value.
    *
    * Set it to null to remove the limit.
    */
  var scaleMax: Phaser.Point = js.native

  /**
    * The minimum scale this Game Object will scale down to.
    *
    * It allows you to prevent a parent from scaling this Game Object lower than the given value.
    *
    * Set it to null to remove the limit.
    */
  var scaleMin: Phaser.Point = js.native

  /**
    * The callback that will apply any scale limiting to the worldTransform.
    */
  var transformCallback: js.Function = js.native

  /**
    * The context under which `transformCallback` is called.
    */
  var transformCallbackContext: js.Object = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Sets the scaleMin and scaleMax values. These values are used to limit how far this Game Object will scale based on its parent.
    * For example if this Game Object has a minScale value of 1 and its parent has a scale value of 0.5, the 0.5 will be ignored
    * and the scale value of 1 will be used, as the parents scale is lower than the minimum scale this Game Object should adhere to.
    * By setting these values you can carefully control how Game Objects deal with responsive scaling.
    * If only one parameter is given then that value will be used for both scaleMin and scaleMax:
    * setScaleMinMax(1) = scaleMin.x, scaleMin.y, scaleMax.x and scaleMax.y all = 1
    * If only two parameters are given the first is set as scaleMin.x and y and the second as scaleMax.x and y:
    * setScaleMinMax(0.5, 2) = scaleMin.x and y = 0.5 and scaleMax.x and y = 2
    * If you wish to set scaleMin with different values for x and y then either modify Game Object.scaleMin directly,
    * or pass null for the maxX and maxY parameters.
    * Call setScaleMinMax(null) to clear all previously set values.
    * @param minX The minimum horizontal scale value this Game Object can scale down to.
    * @param minY The minimum vertical scale value this Game Object can scale down to.
    * @param maxX The maximum horizontal scale value this Game Object can scale up to.
    * @param maxY The maximum vertical scale value this Game Object can scale up to.
    */
  def setScaleMinMax(minX: Double = js.native, minY: Double = js.native, maxX: Double = js.native, maxY: Double = js.native): Unit = js.native

}
