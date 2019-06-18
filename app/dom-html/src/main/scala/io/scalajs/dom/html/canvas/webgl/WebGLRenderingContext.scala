package io.scalajs.dom.html.canvas.webgl

import io.scalajs.dom.DOMString
import io.scalajs.dom.html.canvas.{HTMLCanvasElement, RenderingContext}

import scala.scalajs.js

/**
  * The WebGLRenderingContext interface provides the OpenGL ES 2.0 rendering context for the drawing surface
  * of an HTML <canvas> element.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/WebGLRenderingContext
  * @see https://developer.mozilla.org/en-US/docs/Web/API/WebGL_API/Constants
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WebGLRenderingContext extends RenderingContext {

  /////////////////////////////////////////////////////////////////////////////////
  //      Constants
  /////////////////////////////////////////////////////////////////////////////////

  def ARRAY_BUFFER: GLenum = js.native

  def ELEMENT_ARRAY_BUFFER: GLenum = js.native

  def COPY_READ_BUFFER: GLenum = js.native

  def COPY_WRITE_BUFFER: GLenum = js.native

  def TRANSFORM_FEEDBACK_BUFFER: GLenum = js.native

  def UNIFORM_BUFFER: GLenum = js.native

  def PIXEL_PACK_BUFFER: GLenum = js.native

  def PIXEL_UNPACK_BUFFER: GLenum = js.native

  def TRANSFORM_FEEDBACK_BUFFER_BINDING: GLenum = js.native

  def TRANSFORM_FEEDBACK_BUFFER_SIZE: GLenum = js.native

  def TRANSFORM_FEEDBACK_BUFFER_START: GLenum = js.native

  def UNIFORM_BUFFER_BINDING: GLenum = js.native

  def UNIFORM_BUFFER_SIZE: GLenum = js.native

  def UNIFORM_BUFFER_START: GLenum = js.native

  def TEXTURE_2D: GLenum = js.native

  def TEXTURE_CUBE_MAP: GLenum = js.native

  def TEXTURE_3D: GLenum = js.native

  def TEXTURE_2D_ARRAY: GLenum = js.native

  def FRAGMENT_SHADER: GLenum = js.native

  def VERTEX_SHADER: GLenum = js.native

  def DELETE_STATUS: GLenum = js.native

  def COMPILE_STATUS: GLenum = js.native

  def SHADER_TYPE: GLenum = js.native

  def LOW_FLOAT: GLprecision = js.native

  def MEDIUM_FLOAT: GLprecision = js.native

  def HIGH_FLOAT: GLprecision = js.native

  def LOW_INT: GLprecision = js.native

  def MEDIUM_INT: GLprecision = js.native

  def HIGH_INT: GLprecision = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A read-only back-reference to the HTMLCanvasElement. Might be null if it is not associated with a <canvas> element.
    */
  def canvas: HTMLCanvasElement = js.native

  /**
    * The read-only height of the current drawing buffer. Should match the height of the canvas element associated with this context.
    */
  def drawingBufferHeight: Int = js.native

  /**
    * The read-only width of the current drawing buffer. Should match the width of the canvas element associated with this context.
    */
  def drawingBufferWidth: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Buffer Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Binds a given [[WebGLBuffer]] to a target.
    * @param target A [[GLenum]] specifying the binding point (target). Possible values:
    *               <ul>
    *               <li>gl.[[ARRAY_BUFFER]]: Buffer containing vertex attributes, such as vertex coordinates, texture coordinate data, or vertex color data.</li>
    *               <li>gl.[[ELEMENT_ARRAY_BUFFER]]: Buffer used for element indices.</li>
    *               <li>When using a WebGL 2 context, the following values are available additionally:
    *               <ul>
    *               <li>gl.[[COPY_READ_BUFFER]]: Buffer for copying from one buffer object to another.</li>
    *               <li>gl.[[COPY_WRITE_BUFFER]]: Buffer for copying from one buffer object to another.</li>
    *               <li>gl.[[TRANSFORM_FEEDBACK_BUFFER]]: Buffer for transform feedback operations.</li>
    *               <li>gl.[[UNIFORM_BUFFER]]: Buffer used for storing uniform blocks.</li>
    *               <li>gl.[[PIXEL_PACK_BUFFER]]: Buffer used for pixel transfer operations.</li>
    *               <li>gl.[[PIXEL_UNPACK_BUFFER]]: Buffer used for pixel transfer operations.</li>
    *               </ul>
    *               </li>
    *               </ul>
    * @param buffer A [[WebGLBuffer]] to bind.
    */
  def bindBuffer(target: GLenum, buffer: WebGLBuffer): Unit = js.native

  /**
    * Returns a WebGLBuffer storing data such as vertices or colors.
    * @return a [[WebGLBuffer]] storing data such as vertices or colors.
    */
  def createBuffer(): WebGLBuffer = js.native

  /**
    * Deletes a given WebGLBuffer. This method has no effect if the buffer has already been deleted.
    * @param buffer the given [[WebGLBuffer]]
    */
  def deleteBuffer(buffer: WebGLBuffer): Unit = js.native

  /**
    * Returns true if the passed WebGLBuffer is valid and false otherwise.
    * @param buffer the given object to test
    * @return true if the passed WebGLBuffer is valid and false otherwise.
    */
  def isBuffer(buffer: js.Any): Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Program Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns a WebGLProgram object that is a combination of two compiled WebGLShaders consisting of a vertex shader
    * and a fragment shader (both written in GLSL). These are then linked into a usable program.
    * @return A WebGLProgram object that is a combination of two compiled WebGLShaders consisting of a vertex shader
    *         and a fragment shader (both written in GLSL).
    */
  def createProgram(): WebGLProgram = js.native

  /**
    * Returns information about the given program.
    * @param program A [[WebGLProgram]] to get parameter information from.
    * @param pname   A [[GLenum]] specifying the information to query. Possible values:
    * @return the requested program information (as specified with pname).
    * @example {{{ gl.getProgramParameter(program, gl.DELETE_STATUS) }}}
    */
  def getProgramParameter(program: WebGLProgram, pname: GLenum): js.Any = js.native

  /**
    * Returns true if the passed WebGLProgram is valid, false otherwise.
    * @param program A [[WebGLProgram]] to check.
    * @return true if the passed [[WebGLProgram]] is valid, false otherwise.
    */
  def isProgram(program: js.Any): Boolean = js.native

  /**
    * Links a given WebGLProgram to the attached vertex and fragment shaders.
    * @param program A [[WebGLProgram]] to link.
    */
  def linkProgram(program: WebGLProgram): Unit = js.native

  /**
    * Sets the specified WebGLProgram as part the current rendering state.
    * @param program A [[WebGLProgram]] to use.
    */
  def useProgram(program: WebGLProgram): Unit = js.native

  /**
    * Validates a WebGLProgram. It checks if it is successfully linked and if it can be used in the current WebGL state.
    * @param program A [[WebGLProgram]] to validate.
    */
  def validateProgram(program: WebGLProgram): Unit = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Shader Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Compiles a GLSL shader into binary data so that it can be used by a WebGLProgram.
    * @param shader A fragment or vertex [[WebGLShader]].
    */
  def compileShader(shader: WebGLShader): Unit = js.native

  /**
    * Creates a WebGLShader that can then be configured further using [[WebGLRenderingContext.shaderSource()]]
    * and [[WebGLRenderingContext.compileShader()]].
    * @param `type` Either gl.[[VERTEX_SHADER]] or gl.[[FRAGMENT_SHADER]]
    * @return a new [[WebGLShader]]
    */
  def createShader(`type`: GLenum): WebGLShader = js.native

  /**
    * Returns information about the given shader.
    * @param shader A [[WebGLShader]] to get parameter information from.
    * @param pname  A [[GLenum]] specifying the information to query. Possible values:
    *               <ul>
    *               <li>gl.[[DELETE_STATUS]]: Returns a GLboolean indicating whether or not the shader is flagged for deletion.</li>
    *               <li>gl.[[COMPILE_STATUS]]: Returns a GLboolean indicating whether or not the las shader compilation was successful.</li>
    *               <li>gl.[[SHADER_TYPE]]: Returns a GLenum indicating the whether the shader is a vertex shader (gl.[[VERTEX_SHADER]])
    *               or fragment shader (gl.[[FRAGMENT_SHADER]]) object.</li>
    *               </ul>
    * @return the requested shader information (as specified with pname).
    */
  def getShaderParameter(shader: WebGLShader, pname: GLenum): js.Any = js.native

  /**
    * Returns a new WebGLShaderPrecisionFormat object describing the range and precision for the specified shader numeric format.
    * @param shaderType    Either a [[FRAGMENT_SHADER]] or a [[VERTEX_SHADER]].
    * @param precisionType A precision type value. Either LOW_FLOAT, MEDIUM_FLOAT, HIGH_FLOAT, LOW_INT, MEDIUM_INT, or HIGH_INT.
    * @return A [[WebGLShaderPrecisionFormat]] object or null, if an error occurs.
    * @example {{{ gl.getShaderPrecisionFormat(gl.VERTEX_SHADER, gl.MEDIUM_FLOAT) }}}
    */
  def getShaderPrecisionFormat(shaderType: GLenum, precisionType: GLprecision): WebGLShaderPrecisionFormat = js.native

  /**
    * Sets the source code of a [[WebGLShader]].
    * @param shader A [[WebGLShader]] object in which to set the source code.
    * @param source A [[DOMString]] containing the GLSL source code to set.
    */
  def shaderSource(shader: WebGLShader, source: DOMString): Unit = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Texture Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Binds a given [[WebGLTexture]] to a target (binding point).
    * @param target  A [[GLenum]] specifying the binding point (target). Possible values:
    *                <ul>
    *                <li>gl.[[TEXTURE_2D]]: A two-dimensional texture.</li>
    *                <li>gl.[[TEXTURE_CUBE_MAP]]: A cube-mapped texture.</li>
    *                <li> When using a WebGL 2 context, the following values are available additionally:
    *                <ul>
    *                <li>gl.[[TEXTURE_3D]]: A three-dimensional texture.</li>
    *                <li>gl.[[TEXTURE_2D_ARRAY]]: A two-dimensional array texture.</li>
    *                </ul>
    *                </li>
    *                </ul>
    * @param texture A [[WebGLTexture]] object to bind.
    */
  def bindTexture(target: GLenum, texture: WebGLTexture): Unit = js.native

  /**
    * Creates and initializes a WebGLTexture object.
    * @return a [[WebGLTexture]] object.
    */
  def createTexture(): WebGLTexture = js.native

  /**
    * Deletes a given WebGLTexture object. This method has no effect if the texture has already been deleted.
    * @param texture A [[WebGLTexture]] object to delete.
    */
  def deleteTexture(texture: WebGLTexture): Unit = js.native

  /**
    * Returns true if the passed WebGLTexture is valid and false otherwise.
    * @param texture the passed [[WebGLTexture]]
    * @return true if the passed [[WebGLTexture]] is valid and false otherwise.
    */
  def isTexture(texture: js.Any): Boolean = js.native

}