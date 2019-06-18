package io.scalajs.dom.html.canvas

import io.scalajs.dom.html.Image

import scala.scalajs.js

/**
  * The CanvasRenderingContext2D interface is used for drawing rectangles, text, images and other objects onto the canvas
  * element. It provides the 2D rendering context for the drawing surface of a <canvas> element.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CanvasRenderingContext2D extends RenderingContext {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The CanvasRenderingContext2D.fillStyle property of the Canvas 2D API specifies the color or style to use inside shapes.
    * The default is #000 (black).
    */
  var fillStyle: String = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Drawing rectangles
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Sets all pixels in the rectangle defined by starting point (x, y) and size (width, height) to transparent black,
    * erasing any previously drawn content.
    */
  def clearRect(x: Double, y: Double, width: Double, height: Double): Unit = js.native

  /**
    * The CanvasRenderingContext2D.drawImage() method of the Canvas 2D API provides different ways to draw an image onto the canvas.
    * @param image an element to draw into the context. The specification permits any canvas image source
    *              (CanvasImageSource), such as an HTMLImageElement, an HTMLVideoElement, an HTMLCanvasElement
    *              or an ImageBitmap.
    * @param dx    the X coordinate in the destination canvas at which to place the top-left corner of the source image.
    * @param dy    the Y coordinate in the destination canvas at which to place the top-left corner of the source image.
    */
  def drawImage(image: Image, dx: Double, dy: Double): Unit = js.native

  /**
    * The CanvasRenderingContext2D.drawImage() method of the Canvas 2D API provides different ways to draw an image onto the canvas.
    * @param image   an element to draw into the context. The specification permits any canvas image source
    *                (CanvasImageSource), such as an HTMLImageElement, an HTMLVideoElement, an HTMLCanvasElement
    *                or an ImageBitmap.
    * @param dx      the X coordinate in the destination canvas at which to place the top-left corner of the source image.
    * @param dy      the Y coordinate in the destination canvas at which to place the top-left corner of the source image.
    * @param dwidth  the width to draw the image in the destination canvas. This allows scaling of the drawn image.
    *                If not specified, the image is not scaled in width when drawn.
    * @param dheight the height to draw the image in the destination canvas. This allows scaling of the drawn image.
    *                If not specified, the image is not scaled in height when drawn.
    */
  def drawImage(image: Image, dx: Double, dy: Double, dwidth: Double, dheight: Double): Unit = js.native

  /**
    * The CanvasRenderingContext2D.drawImage() method of the Canvas 2D API provides different ways to draw an image onto the canvas.
    * @param image   an element to draw into the context. The specification permits any canvas image source
    *                (CanvasImageSource), such as an HTMLImageElement, an HTMLVideoElement, an HTMLCanvasElement
    *                or an ImageBitmap.
    * @param sx      the X coordinate of the top left corner of the sub-rectangle of the source image to draw into the
    *                destination context.
    * @param sy      the Y coordinate of the top left corner of the sub-rectangle of the source image to draw into the
    *                destination context.
    * @param sWidth  the width of the sub-rectangle of the source image to draw into the destination context.
    *                If not specified, the entire rectangle from the coordinates specified by sx and sy to the
    *                bottom-right corner of the image is used.
    * @param sHeight the height of the sub-rectangle of the source image to draw into the destination context.
    * @param dx      the X coordinate in the destination canvas at which to place the top-left corner of the source image.
    * @param dy      the Y coordinate in the destination canvas at which to place the top-left corner of the source image.
    * @param dwidth  the width to draw the image in the destination canvas. This allows scaling of the drawn image.
    *                If not specified, the image is not scaled in width when drawn.
    * @param dheight the height to draw the image in the destination canvas. This allows scaling of the drawn image.
    *                If not specified, the image is not scaled in height when drawn.
    */
  def drawImage(image: Image,
                sx: Double,
                sy: Double,
                sWidth: Double,
                sHeight: Double,
                dx: Double,
                dy: Double,
                dwidth: Double,
                dheight: Double): Unit = js.native

  /**
    * Draws a filled rectangle at (x, y) position whose size is determined by width and height.
    */
  def fillRect(x: Double, y: Double, width: Double, height: Double): Unit = js.native

  /**
    * Paints a rectangle which has a starting point at (x, y) and has a w width and an h height onto the canvas, using
    * the current stroke style.
    */
  def strokeRect(x: Double, y: Double, width: Double, height: Double): Unit = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Drawing text
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Draws (fills) a given text at the given (x,y) position.
    */
  def fillText(text: String, x: Double, y: Double, maxWidth: Double = js.native): Unit = js.native

  /**
    * Draws (strokes) a given text at the given (x, y) position.
    */
  def strokeText(text: String, x: Double, y: Double, maxWidth: Double = js.native): Unit = js.native

  /**
    * The CanvasRenderingContext2D.measureText() method returns a TextMetrics object that contains information about
    * the measured text (such as its width for example).
    * @param text the text to measure.
    * @return the [[TextMetrics text metrics]]
    */
  def measureText(text: String): TextMetrics = js.native

}
