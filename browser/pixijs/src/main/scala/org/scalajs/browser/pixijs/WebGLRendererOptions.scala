package org.scalajs.browser.pixijs

import org.scalajs.dom.raw.HTMLCanvasElement

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * WebGL Renderer Options
  * @param view                  the canvas to use as a view, optional
  * @param transparent           If the render view is transparent, default false
  * @param autoResize            If the render view is automatically resized, default false
  * @param antialias             sets antialias. If not available natively then FXAA antialiasing is used
  * @param forceFXAA             forces FXAA antialiasing to be used over native. FXAA is faster, but may not always lok as great
  * @param resolution            the resolution of the renderer retina would be 2
  * @param clearBeforeRender     This sets if the CanvasRenderer will clear the canvas or not before the new render pass.
  *                              If you wish to set this to false, you must set preserveDrawingBuffer to true.
  * @param preserveDrawingBuffer enables drawing buffer preservation, enable this if you need to call toDataUrl
  *                              on the webgl context.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class WebGLRendererOptions(var view: HTMLCanvasElement = null,
                           var transparent: Boolean = false,
                           var autoResize: Boolean = false,
                           var antialias: Boolean = false,
                           var forceFXAA: Boolean = false,
                           var resolution: Resolution = 1,
                           var clearBeforeRender: Boolean = false,
                           var preserveDrawingBuffer: Boolean = false) extends js.Object
