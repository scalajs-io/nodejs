package io.scalajs.dom.html.canvas

import io.scalajs.dom.html.{Blob, File, ImageBitmap}

import scala.scalajs.js

/**
  * The OffscreenCanvas interface provides a canvas that can be rendered off screen. It is available in both the window
  * and worker contexts.
  * @see [[https://developer.mozilla.org/en-US/docs/Web/API/OffscreenCanvas]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait OffscreenCanvas extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The height of the offscreen canvas.
    */
  var height: Double = js.native

  /**
    * The width of the offscreen canvas.
    */
  var width: Double = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns a rendering context for the offscreen canvas.
    */
  def getContext(contextType: String, contextAttributes: CanvasAttributeOptions): RenderingContext = js.native

  /**
    * The HTMLCanvasElement.mozGetAsFille() method returns a File object representing the image contained in the canvas;
    * this file is a memory-based file, with the specified name. If type is not specified, the image type is image/png.
    */
  def mozGetAsFile(name: String, `type`: String): File = js.native

  /**
    * Creates a Blob object representing the image contained in the canvas.
    * @param `type`         A DOMString indicating the image format. The default type is image/png.
    * @param encoderOptions A Number between 0 and 1 indicating image quality if the requested type is image/jpeg or
    *                       image/webp. If this argument is anything else, the default value for image quality is used.
    *                       Other arguments are ignored.
    * @return A Promise returning a Blob object representing the image contained in the canvas.
    */
  def toBlob(`type`: String = js.native, encoderOptions: Double = js.native): js.Promise[Blob] = js.native

  /**
    * The OffscreenCanvas.transferToImageBitmap() method creates an ImageBitmap object from the most recently rendered
    * image of the OffscreenCanvas.
    * @return An [[ImageBitmap]].
    */
  def transferToImageBitmap(): ImageBitmap = js.native

}
