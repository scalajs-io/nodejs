package io.scalajs.dom.html.phaser

import io.scalajs.dom.html.HTMLElement
import io.scalajs.dom.html.canvas.{CanvasRenderingContext2D, HTMLCanvasElement}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * The Canvas class handles everything related to creating the canvas DOM tag that Phaser will use,
  * including styles, offset and aspect ratio.
  * @see http://phaser.io/docs/2.6.2/Phaser.Canvas.html
  */
@js.native
@JSGlobal("Phaser.Canvas")
class Canvas() extends js.Object

/**
  * Canvas Singleton
  */
@js.native
@JSGlobal("Phaser.Canvas")
object Canvas extends js.Object {

  /**
    * Adds the given canvas element to the DOM. The canvas will be added as a child of the given parent.
    * If no parent is given it will be added as a child of the document.body.
    * @param canvas         The canvas to be added to the DOM.
    * @param parent         The DOM element to add the canvas to.
    * @param overflowHidden If set to true it will add the overflow='hidden' style to the parent DOM element.
    * @return Returns the source canvas.
    */
  def addToDOM(canvas: HTMLCanvasElement, parent: String | HTMLElement, overflowHidden: Boolean = js.native): HTMLCanvasElement = js.native

  /**
    * Creates a `canvas` DOM element. The element is not automatically added to the document.
    * @param parent   The object that will own the canvas that is created.
    * @param width    The width of the canvas element.
    * @param height   The height of the canvas element.
    * @param id       If specified, and not the empty string, this will be set as the ID of the
    *                 canvas element. Otherwise no ID will be set.
    * @param skipPool If `true` the canvas will not be placed in the CanvasPool global.
    * @return The newly created canvas element.
    */
  def create(parent: js.Any,
             width: Int = js.native,
             height: Int = js.native,
             id: String = js.native,
             skipPool: Boolean = js.native): HTMLCanvasElement = js.native

  /**
    * Returns `true` if the given context has image smoothing enabled, otherwise returns `false`.
    * @param context The context to check for smoothing on.
    * @return True if the given context has image smoothing enabled, otherwise false.¬
    */
  def getSmoothingEnabled(context: CanvasRenderingContext2D): Boolean = js.native

  /**
    * Gets the Smoothing Enabled vendor prefix being used on the given context, or null if not set.
    * @param context The context to enable or disable the image smoothing on.
    * @return Returns the smoothingEnabled vendor prefix, or null if not set on the context.
    */
  def getSmoothingPrefix(context: CanvasRenderingContext2D): String = js.native

  /**
    * Removes the given canvas element from the DOM.
    * @param canvas The canvas to be removed from the DOM.
    */
  def removeFromDOM(canvas: HTMLCanvasElement): Unit = js.native

  /**
    * Sets the background color behind the canvas. This changes the canvas style property.
    * @param canvas The canvas to set the background color on.
    * @param color  The color to set. Can be in the format 'rgb(r,g,b)', or '#RRGGBB' or any valid CSS color.
    * @return the source canvas.
    */
  def setBackgroundColor(canvas: HTMLCanvasElement, color: String): HTMLCanvasElement = js.native

  /**
    * Sets the CSS image-rendering property on the given canvas to be 'bicubic' (aka 'auto').
    * Note that if this doesn't given the desired result then see the CanvasUtils.setSmoothingEnabled method.
    * @param canvas The canvas to set image-rendering bicubic on.
    * @return the source canvas.
    */
  def setImageRenderingBicubic(canvas: HTMLCanvasElement): HTMLCanvasElement = js.native

  /**
    * Sets the CSS image-rendering property on the given canvas to be 'crisp' (aka 'optimize contrast' on webkit).
    * Note that if this doesn't given the desired result then see the setSmoothingEnabled.
    * @param canvas The canvas to set image-rendering crisp on.
    * @return the source canvas.
    */
  def setImageRenderingCrisp(canvas: HTMLCanvasElement): HTMLCanvasElement = js.native

  /**
    * Sets the Image Smoothing property on the given context. Set to false to disable image smoothing.
    * By default browsers have image smoothing enabled, which isn't always what you visually want, especially
    * when using pixel art in a game. Note that this sets the property on the context itself, so that any image
    * drawn to the context will be affected. This sets the property across all current browsers but support is
    * patchy on earlier browsers, especially on mobile.
    * @param context The context to enable or disable the image smoothing on.
    * @param value   If set to true it will enable image smoothing, false will disable it.
    * @return the source context.
    */
  def setSmoothingEnabled(context: CanvasRenderingContext2D, value: Boolean): CanvasRenderingContext2D = js.native

  /**
    * Sets the touch-action property on the canvas style. Can be used to disable default browser touch actions.
    * @param canvas The canvas to set the touch action on.
    * @param value  The touch action to set. Defaults to 'none'.
    * @return The source canvas.
    */
  def setTouchAction(canvas: HTMLCanvasElement, value: String = js.native): HTMLCanvasElement = js.native

  /**
    * Sets the transform of the given canvas to the matrix values provided.
    * @param context    The context to set the transform on.
    * @param translateX The value to translate horizontally by.
    * @param translateY The value to translate vertically by.
    * @param scaleX     The value to scale horizontally by.
    * @param scaleY     The value to scale vertically by.
    * @param skewX      The value to skew horizontally by.
    * @param skewY      The value to skew vertically by.
    * @return the source context.
    */
  def setTransform(context: CanvasRenderingContext2D,
                   translateX: Double,
                   translateY: Double,
                   scaleX: Double,
                   scaleY: Double,
                   skewX: Double,
                   skewY: Double): CanvasRenderingContext2D = js.native

  /**
    * Sets the user-select property on the canvas style. Can be used to disable default browser selection actions.
    * @param canvas The canvas to set the touch action on.
    * @param value  The touch action to set. Defaults to 'none'.
    * @return The source canvas.
    */
  def setUserSelect(canvas: HTMLCanvasElement, value: String = js.native): HTMLCanvasElement = js.native

}