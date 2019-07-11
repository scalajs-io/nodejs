package io.scalajs.dom.html.canvas

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * HTML Canvas Attribute Options
  * @author lawrence.daniels@gmail.com
  * @param width  the canvas width
  * @param height the canvas height
  */
class CanvasAttributeOptions(var width: js.UndefOr[Double] = js.undefined,
                             var height: js.UndefOr[Double] = js.undefined)
  extends js.Object

/**
  * Canvas Attribute Options Companion
  * @author lawrence.daniels@gmail.com
  */
object CanvasAttributeOptions extends FlexibleOptions[CanvasAttributeOptions]