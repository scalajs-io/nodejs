package io.scalajs.dom.html.canvas.webgl

import scala.scalajs.js

/**
  * The WebGLShaderPrecisionFormat interface is part of the WebGL API and represents the information returned
  * by calling the WebGLRenderingContext.getShaderPrecisionFormat() method.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WebGLShaderPrecisionFormat extends js.Object {

  /**
    * The base 2 log of the absolute value of the minimum value that can be represented.
    */
  def rangeMin: Int = js.native

  /**
    * The base 2 log of the absolute value of the maximum value that can be represented.
    */
  def rangeMax: Int = js.native

  /**
    * The number of bits of precision that can be represented. For integer formats this value is always 0.
    */
  def precision: Int = js.native

}