package io.scalajs.dom.html.canvas.webgl

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * The WebGLBuffer interface is part of the WebGL API and represents an opaque buffer object storing data such as
  * vertices or colors.
  *
  * <h1>Description</h1>
  * The WebGLBuffer object does not define any methods or properties of its own and its content is not directly
  * accessible. When working with WebGLBuffer objects, the following methods of the WebGLRenderingContext are useful:
  * <ul>
  * <li>[[WebGLRenderingContext.bindBuffer()]]</li>
  * <li>[[WebGLRenderingContext.createBuffer()]]</li>
  * <li>[[WebGLRenderingContext.deleteBuffer()]]</li>
  * <li>[[WebGLRenderingContext.isBuffer()]]</li>
  * </ul>
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("WebGLBuffer")
class WebGLBuffer extends js.Object {}
