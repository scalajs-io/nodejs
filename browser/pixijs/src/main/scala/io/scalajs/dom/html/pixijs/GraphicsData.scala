package io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * A GraphicsData object.
  * @param lineWidth the width of the line to draw
  * @param lineColor the color of the line to draw
  * @param lineAlpha the alpha of the line to draw
  * @param fillColor the color of the fill
  * @param fillAlpha the alpha of the fill
  * @param fill      whether or not the shape is filled with a colour
  * @param shape     The shape object to draw.
  */
@js.native
@JSName("GraphicsData")
class GraphicsData(lineWidth: LineWidth,
                   lineColor: Color,
                   lineAlpha: Alpha,
                   fillColor: Color,
                   fillAlpha: Alpha,
                   fill: Boolean,
                   shape: GraphicalShape)
    extends js.Object {

  /**
    * Creates a new GraphicsData object with the same values as this one.
    */
  override def clone(): this.type = js.native

  /**
    * Destroys the Graphics data.
    */
  def destroy(): Unit = js.native

}
