package io.scalajs.dom.html.canvas

import scala.scalajs.js

/**
  * The TextMetrics interface represents the dimension of a text in the canvas, as created by the
  * [[CanvasRenderingContext2D.measureText()]] method.
  * @see [[]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TextMetrics extends js.Object {

  /**
    * TextMetrics.actualBoundingBoxLeft Is a double giving the distance parallel to the baseline from the alignment
    * point given by the CanvasRenderingContext2D.textAlign property to the left side of the bounding rectangle of the
    * given text, in CSS pixels.
    */
  def actualBoundingBoxLeft: Double = js.native

  /**
    * TextMetrics.width is a double giving the calculated width of a segment of inline text in CSS pixels. It takes
    * into account the current font of the context.
    */
  def width: Double = js.native

}
