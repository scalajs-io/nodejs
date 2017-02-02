package io.scalajs.dom.html.canvas.webgl

import scala.scalajs.js
import scala.scalajs.js.typedarray.ArrayBuffer

/**
  * The WebGL2RenderingContext interface provides the OpenGL ES 3.0 rendering context for the drawing surface
  * of an HTML <canvas> element.
  *
  * WebGL 2 is an extension to WebGL 1. The WebGL2RenderingContext interface implements all members of
  * the [[WebGLRenderingContext]] interface. Some methods of the WebGL 1 context can accept additional values
  * when used in a WebGL 2 context. You will find this info noted on the WebGL 1 reference pages.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/WebGL2RenderingContext
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WebGL2RenderingContext extends WebGLRenderingContext {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  def COLOR_BUFFER_BIT: GLbitfield = js.native

  def DEPTH_BUFFER_BIT: GLbitfield = js.native

  def STENCIL_BUFFER_BIT: GLbitfield = js.native

  def NEAREST: GLenum = js.native

  def LINEAR: GLenum = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Transfers a block of pixels from the read framebuffer to the draw framebuffer.
    * @param srcX0  A GLint specifying the bounds of the source rectangle.
    * @param srcY0  A GLint specifying the bounds of the source rectangle.
    * @param srcX1  A GLint specifying the bounds of the source rectangle.
    * @param srcY1  A GLint specifying the bounds of the source rectangle.
    * @param dstX0  A GLint specifying the bounds of the destination rectangle.
    * @param dstY0  A GLint specifying the bounds of the destination rectangle.
    * @param dstX1  A GLint specifying the bounds of the destination rectangle.
    * @param dstY1  A GLint specifying the bounds of the destination rectangle.
    * @param mask   A GLbitfield specifying a bitwise OR mask indicating which buffers are to be copied.
    * @param filter A GLenum specifying the interpolation to be applied if the image is stretched.
    */
  def blitFramebuffer(srcX0: GLint,
                      srcY0: GLint,
                      srcX1: GLint,
                      srcY1: GLint,
                      dstX0: GLint,
                      dstY0: GLint,
                      dstX1: GLint,
                      dstY1: GLint,
                      mask: GLbitfield,
                      filter: GLenum): Unit = js.native

  /**
    * Copies part of the data of a buffer to another buffer.
    * @param readTarget  A GLenum specifying the binding point (target) from whose data store should be read.
    * @param writeTarget A GLenum specifying the binding point (target) from whose data store should be written.
    * @param readOffset  A GLintptr specifying the byte offset from which to start reading from the buffer.
    * @param writeOffset A GLintptr specifying the byte offset from which to start writing to the buffer.
    * @param size        A GLsizei in bytes specifying the size of the data to be copied from readTarget to writeTarget.
    */
  def copyBufferSubData(readTarget: GLenum,
                        writeTarget: GLenum,
                        readOffset: GLintptr,
                        writeOffset: GLintptr,
                        size: GLsizei): Unit = js.native

  /**
    * Reads data from a buffer binding point and writes them to an [[ArrayBuffer]] or SharedArrayBuffer.
    * @param target        A [[GLenum]] specifying the binding point (target).
    * @param srcByteOffset A [[GLintptr]] specifying the byte offset from which to start reading from the buffer.
    * @param dstData       An [[ArrayBuffer]] or SharedArrayBuffer to which to write the buffer data.
    * @param dstOffset     A [[GLuint]] specifying the element index offset where to start reading the buffer.
    * @param length        A [[GLuint]] defaulting to 0.
    */
  def getBufferSubData(target: GLenum,
                       srcByteOffset: GLintptr,
                       dstData: ArrayBuffer,
                       dstOffset: GLuint = js.native,
                       length: Int = js.native): Unit = js.native

  /**
    * Returns the indexed value for the given target.
    * @param target A Glenum specifying the target for which to return information
    * @param index  A GLuint specifying the index of the target that is queried.
    * @return Depends on the requested information (as specified with target).
    */
  def getIndexedParameter(target: GLenum, index: Int): js.Any = js.native

}
