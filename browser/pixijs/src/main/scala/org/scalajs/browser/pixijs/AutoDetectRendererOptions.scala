package org.scalajs.browser.pixijs

import org.scalajs.dom.raw.HTMLCanvasElement

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Auto-Detect Renderer Options
  * @param view                  the canvas to use as a view, optional
  * @param transparent           If the render view is transparent, default false
  * @param antialias             sets antialias (only applicable in chrome at the moment)
  * @param preserveDrawingBuffer enables drawing buffer preservation, enable this if you need to call toDataUrl
  *                              on the webgl context
  * @param resolution            the resolution of the renderer, retina would be 2
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class AutoDetectRendererOptions(var view: HTMLCanvasElement = null,
                                var transparent: Boolean = false,
                                var antialias: Boolean = false,
                                var preserveDrawingBuffer: Boolean = false,
                                var resolution: Resolution = 1) extends js.Object