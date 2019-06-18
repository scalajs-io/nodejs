package io.scalajs.dom.html.pixijs

import io.scalajs.dom.html.canvas.HTMLCanvasElement

import scala.scalajs.js


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

class CanvasRendererOptions(var view: js.UndefOr[HTMLCanvasElement] = js.undefined,
                            var transparent: js.UndefOr[Boolean] = js.undefined,
                            var autoResize: js.UndefOr[Boolean] = js.undefined,
                            var antialias: js.UndefOr[Boolean] = js.undefined,
                            var resolution: js.UndefOr[Resolution] = js.undefined,
                            var clearBeforeRender: js.UndefOr[Boolean] = js.undefined,
                            var roundPixels: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
