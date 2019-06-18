package io.scalajs.dom.html.pixijs

import io.scalajs.RawOptions
import io.scalajs.dom.html.canvas.HTMLCanvasElement

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * A Text Object will create a line or multiple lines of text. To split a line you can use '\n' in your text string,
  * or add a wordWrap property set to true and and wordWrapWidth property with a value in the style object.
  * @param text  The copy that you would like the text to display
  * @param style The style parameters
  */
@js.native
@JSGlobal("Text")
class Text(var text: String, var style: TextStyleOptions | RawOptions = js.native) extends js.Object {

  /**
    * The opacity of the object.
    */
  var alpha: Alpha = js.native

  /**
    * The anchor sets the origin point of the texture. The default is 0,0 this means the texture's origin is the
    * top left Setting the anchor to 0.5,0.5 means the texture's origin is centered Setting the anchor to 1,1 would
    * mean the texture's origin point will be the bottom right corner
    */
  var anchor: Point = js.native

  /**
    * The blend mode to be applied to the sprite. Apply a value of PIXI.BLEND_MODES.NORMAL to reset the blend mode.
    */
  var blendMode: BlendMode = js.native

  /**
    * Set this to true if you want this display object to be cached as a bitmap. This basically takes a snap shot of
    * the display object as it is at that moment. It can provide a performance benefit for complex static displayObjects.
    * To remove simply set this property to 'null'
    */
  var cacheAsBitmap: java.lang.Boolean = js.native

  /**
    * An internal cached value of the tint.
    */
  var cachedTint: Color = js.native

  /**
    * The canvas element that everything is drawn to
    */
  var canvas: HTMLCanvasElement = js.native

  /**
    * The array of children of this container.
    */
  def children: js.Array[DisplayObject] = js.native

  /**
    * The canvas 2d context that everything is drawn with
    */
  var context: HTMLCanvasElement = js.native

  /**
    * The area the filter is applied to. This is used as more of an optimisation rather than figuring out the
    * dimensions of the displayObject each frame you can set this rectangle
    */
  var filterArea: Rectangle = js.native

  /**
    * Sets the filters for the displayObject.
    * IMPORTANT: This is a webGL only feature and will be ignored by the canvas renderer. To remove filters simply
    * set this property to 'null'
    */
  var filters: js.Array[AbstractFilter] = js.native

}