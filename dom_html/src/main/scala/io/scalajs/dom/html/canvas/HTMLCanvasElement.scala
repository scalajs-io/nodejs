package io.scalajs.dom.html.canvas

import java.lang.{Double => JDouble}

import io.scalajs.dom.html.canvas.webgl.{WebGL2RenderingContext, WebGLRenderingContext}
import io.scalajs.dom.html.{Blob, File, HTMLElement}
import io.scalajs.util.ScalaJsHelper._

import scala.concurrent.Promise
import scala.scalajs.js

/**
  * The HTMLCanvasElement interface provides properties and methods for manipulating the layout and presentation of
  * canvas elements. The HTMLCanvasElement interface also inherits the properties and methods of the HTMLElement interface.
  * @see [[https://developer.mozilla.org/en-US/docs/Web/API/HTMLCanvasElement]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HTMLCanvasElement extends HTMLElement {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A positive integer reflecting the height HTML attribute of the <canvas> element interpreted in CSS pixels. When the
    * attribute is not specified, or if it is set to an invalid value, like a negative, the default value of 150 is used.
    */
  var height: Int = js.native

  /**
    * A Boolean reflecting the moz-opaque HTML attribute of the <canvas> element. It lets the canvas know whether or not
    * translucency will be a factor. If the canvas knows there's no translucency, painting performance can be optimized.
    */
  var mozOpaque: Boolean = js.native

  /**
    * A positive integer reflecting the width HTML attribute of the <canvas> element interpreted in CSS pixels. When the
    * attribute is not specified, or if it is set to an invalid value, like a negative, the default value of 300 is used.
    */
  var width: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns a [[CanvasCaptureMediaStream]] that is a real-time video capture of the surface of the canvas.
    */
  def captureStream(): CanvasCaptureMediaStream = js.native

  /**
    * Returns a drawing context on the canvas, or null if the context ID is not supported. A drawing context lets you
    * draw on the canvas. Calling getContext with "2d" returns a [[CanvasRenderingContext2D]] object, whereas calling it
    * with "experimental-webgl" (or "webgl") returns a [[WebGLRenderingContext]] object. This context is only available on
    * browsers that implement WebGL.
    * @param contextType       Is a DOMString containing the context identifier defining the drawing context associated
    *                          to the canvas. Possible values are:
    *                          "2d", leading to the creation of a [[CanvasRenderingContext2D]] object representing a
    *                          two-dimensional rendering context.
    *                          "webgl" (or "experimental-webgl") which will create a [[WebGLRenderingContext]] object
    *                          representing a three-dimensional rendering context. This context is only available on
    *                          browsers that implement WebGL version 1 (OpenGL ES 2.0).
    *                          "webgl2" (or "experimental-webgl2") which will create a [[WebGL2RenderingContext]] object
    *                          representing a three-dimensional rendering context. This context is only available on
    *                          browsers that implement WebGL version 2 (OpenGL ES 3.0).
    *                          "bitmaprenderer" which will create a [[ImageBitmapRenderingContext]] which only provides
    *                          functionality to replace the content of the canvas with a given ImageBitmap.
    * @param contextAttributes You can use several context attributes when creating your rendering context
    * @return a [[RenderingContext]] implementation
    */
  def getContext(contextType: String, contextAttributes: CanvasAttributeOptions = null): RenderingContext = js.native

  /**
    * Returns a [[File]] object representing the image contained in the canvas; this file is a memory-based file, with the
    * specified name. If type is not specified, the image type is image/png.
    * @return
    */
  def mozGetAsFile(): File = js.native

  /**
    * The HTMLCanvasElement.toBlob() method creates a Blob object representing the image contained in the canvas; this
    * file may be cached on the disk or stored in memory at the discretion of the user agent. If type is not specified,
    * the image type is image/png. The created image is in a resolution of 96dpi.
    * The third argument is used with image/jpeg images to specify the quality of the output.
    * @param callback        A callback function with the resulting Blob object as a single argument.
    * @param mimeType        A DOMString indicating the image format. The default type is image/png.
    * @param qualityArgument A Number between 0 and 1 indicating image quality if the requested type is image/jpeg or
    *                        image/webp. If this argument is anything else, the default value for image quality is used.
    *                        Other arguments are ignored.
    */
  def toBlob(callback: js.Function, mimeType: String = null, qualityArgument: JDouble = js.native): Unit = js.native

  /**
    * The HTMLCanvasElement.toDataURL() method returns a data URI containing a representation of the image in the format
    * specified by the type parameter (defaults to PNG). The returned image is in a resolution of 96 dpi.
    *
    * * If the height or width of the canvas is 0, the string "data:," is returned.
    * * If the requested type is not image/png, but the returned value starts with data:image/png, then the requested type is not supported.
    * * Chrome also supports the image/webp type.
    * @param `type`         A DOMString indicating the image format. The default type is image/png.
    * @param encoderOptions A Number between 0 and 1 indicating image quality if the requested type is image/jpeg or image/webp.
    *                       If this argument is anything else, the default value for image quality is used. The default value is 0.92.
    *                       Other arguments are ignored.
    * @return A DOMString containing the requested data URI.
    */
  def toDataURL(`type`: String = js.native, encoderOptions: CanvasEncoderOptions = js.native): String = js.native

  /**
    * The HTMLCanvasElement.transferControlToOffscreen() method transfers control to an OffscreenCanvas object, either
    * on the main thread or on a worker.
    */
  def transferControlToOffscreen(): OffscreenCanvas = js.native

}

/**
  * HTMLCanvasElement Companion
  * @author lawrence.daniels@gmail.com
  */
object HTMLCanvasElement {

  /**
    * HTML Canvas Element Extensions
    * @param canvas the given [[HTMLCanvasElement canvas]]
    */
  final implicit class HTMLCanvasElementExtensions(val canvas: HTMLCanvasElement) extends AnyVal {

    @inline
    def get2DContext(contextAttributes: CanvasAttributeOptions = null): CanvasRenderingContext2D = {
      canvas.getContext("2d", contextAttributes).asInstanceOf[CanvasRenderingContext2D]
    }

    @inline
    def getBitmapContext(contextAttributes: CanvasAttributeOptions = null): ImageBitmapRenderingContext = {
      canvas.getContext("bitmaprenderer", contextAttributes).asInstanceOf[ImageBitmapRenderingContext]
    }

    @inline
    def getWebGLContext(contextAttributes: CanvasAttributeOptions = null): WebGLRenderingContext = {
      canvas.getContext("webgl", contextAttributes).asInstanceOf[WebGLRenderingContext]
    }

    @inline
    def getWebGL2Context(contextAttributes: CanvasAttributeOptions = null): WebGL2RenderingContext = {
      canvas.getContext("webgl2", contextAttributes).asInstanceOf[WebGL2RenderingContext]
    }

    @inline
    def toBlobFuture(mimeType: String = null, qualityArgument: JDouble = null): Promise[Blob] = {
      futureCallbackA1[Blob](canvas.toBlob(_, mimeType, qualityArgument))
    }

  }

}