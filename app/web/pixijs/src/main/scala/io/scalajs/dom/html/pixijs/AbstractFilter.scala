package io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * This is the base class for creating a PIXI filter. Currently only WebGL supports filters. If you want to make a
  * custom filter this should be your base class.
  * @param vertexSrc   The vertex shader source as an array of strings.
  * @param fragmentSrc The fragment shader source as an array of strings.
  * @param uniforms    An object containing the uniforms for this filter.
  */
@js.native
@JSGlobal("PIXI.AbstractFilter")
abstract class AbstractFilter(var vertexSrc: String | js.Array[String],
                              var fragmentSrc: String | js.Array[String],
                              var uniforms: js.Object)
    extends js.Object {

  def this() = this(vertexSrc = js.native, fragmentSrc = js.native, uniforms = js.native)

  /**
    * The extra padding that the filter might need
    */
  def padding: Padding = js.native

  /**
    * Applies the filter
    * @param renderer The renderer to retrieve the filter from
    * @param input    the input render target
    * @param output   the output render target
    * @param clear    Whether or not we want to clear the outputTarget
    */
  def applyFilter(renderer: WebGLRenderer, input: RenderTarget, output: RenderTarget, clear: Boolean): Unit = js.native

  /**
    * Grabs a shader from the current renderer
    * @param renderer The renderer to retrieve the shader from.
    */
  def getShader(renderer: WebGLRenderer): Unit = js.native

  /**
    * Syncs a uniform between the class object and the shaders.
    */
  def syncUniform(): Unit = js.native

}
