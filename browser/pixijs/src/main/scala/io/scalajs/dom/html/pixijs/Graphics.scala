package io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * The Graphics class contains methods used to draw primitive shapes such as lines, circles and rectangles to the
  * display, and to color and fill them.
  */
@js.native
@JSName("Graphics")
class Graphics extends Container {

  /**
    * The blend mode to be applied to the graphic shape. Apply a value of PIXI.BLEND_MODES.NORMAL to reset the blend mode.
    * @see [[PIXI.BLEND_MODES]]
    */
  def blendMode: BlendMode = js.native

  /**
    * The bounds' padding used for bounds calculation.
    */
  def boundsPadding: Padding = js.native

  /**
    * The alpha value used when filling the Graphics object.
    */
  def fillAlpha: Alpha = js.native

  /**
    * Whether this shape is being used as a mask.
    */
  def isMask: Boolean = js.native

  /**
    * The color of any lines drawn.
    */
  def lineColor: Color = js.native

  /**
    * The width (thickness) of any lines drawn.
    */
  def lineWidth: LineWidth = js.native

  /**
    * The tint applied to the graphic shape. This is a hex value. Apply a value of 0xFFFFFF to reset the tint.
    */
  def tint: Color = js.native

}
