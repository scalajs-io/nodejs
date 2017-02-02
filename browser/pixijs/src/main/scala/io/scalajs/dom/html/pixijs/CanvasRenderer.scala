package io.scalajs.dom.html.pixijs

import io.scalajs.RawOptions
import io.scalajs.dom.html.canvas.CanvasRenderingContext2D

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * The CanvasRenderer draws the scene and all its content onto a 2d canvas. This renderer should be used for browsers
  * that do not support webGL. Don't forget to add the CanvasRenderer.view to your DOM or you will not see anything :)
  * @param width   the width of the canvas view
  * @param height  the height of the canvas view
  * @param options The optional renderer parameters
  */
@js.native
@JSName("CanvasRenderer")
class CanvasRenderer(var width: Double = js.native,
                     var height: Double = js.native,
                     var options: CanvasRendererOptions | RawOptions = js.native)
    extends AbstractRenderer {

  /**
    * Whether the render view should be resized automatically
    */
  var autoResize: Boolean = js.native

  /**
    * The background color to fill if not transparent
    */
  var backgroundColor: Color = js.native

  /**
    * Tracks the blend modes useful for this renderer.
    */
  var blendModes: js.Any = js.native

  /**
    * This sets if the CanvasRenderer will clear the canvas or not before the new render pass. If the scene is NOT
    * transparent Pixi will use a canvas sized fillRect operation every frame to set the canvas background color.
    * If the scene is transparent Pixi will use clearRect to clear the canvas every frame. Disable this by setting
    * this to false. For example if your game has a canvas filling background image you often don't need this set.
    */
  var clearBeforeRender: Boolean = js.native

  /**
    * The canvas 2d context that everything is drawn with.
    */
  var context: CanvasRenderingContext2D = js.native

  /**
    * Instance of a CanvasMaskManager, handles masking when using the canvas renderer.
    */
  var maskManager: CanvasMaskManager = js.native

  /**
    * The value of the preserveDrawingBuffer flag affects whether or not the contents of the stencil buffer is
    * retained after rendering.
    */
  var preserveDrawingBuffer: Boolean = js.native

  /**
    * Boolean flag controlling canvas refresh.
    */
  var refresh: Boolean = js.native

  /**
    * The resolution of the renderer
    */
  var resolution: Resolution = js.native

  /**
    * If true Pixi will Math.floor() x/y values when rendering, stopping pixel interpolation. Handy for crisp pixel
    * art and speed on legacy devices.
    */
  var roundPixels: Double = js.native

  /**
    * The canvas property used to set the canvas smoothing property.
    */
  var smoothProperty: String = js.native

  /**
    * Whether the render view is transparent
    */
  var transparent: Boolean = js.native

  /**
    * The type of the renderer.
    * Default: PIXI.RENDERER_TYPE.UNKNOWN
    */
  var `type`: Int = js.native

}
