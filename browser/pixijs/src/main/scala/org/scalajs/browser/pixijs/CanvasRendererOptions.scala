package org.scalajs.browser.pixijs

import org.scalajs.dom.raw.HTMLCanvasElement

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Canvas Renderer Options
  * @param view              the canvas to use as a view, optional
  * @param transparent       If the render view is transparent, default false
  * @param autoResize        If the render view is automatically resized, default false
  * @param antialias         sets antialias. If not available natively then FXAA antialiasing is used
  * @param resolution        the resolution of the renderer retina would be 2
  * @param clearBeforeRender This sets if the CanvasRenderer will clear the canvas or not before the new render pass.
  *                          If you wish to set this to false, you must set preserveDrawingBuffer to true.
  * @param roundPixels       If true Pixi will Math.floor() x/y values when rendering, stopping pixel interpolation.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class CanvasRendererOptions(var view: HTMLCanvasElement = null,
                            var transparent: Boolean = false,
                            var autoResize: Boolean = false,
                            var antialias: Boolean = false,
                            var resolution: Resolution = 1,
                            var clearBeforeRender: Boolean = false,
                            var roundPixels: Boolean = false) extends js.Object
