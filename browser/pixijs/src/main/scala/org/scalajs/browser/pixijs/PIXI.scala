package org.scalajs.browser
package pixijs

import org.scalajs.dom.browser.DOMHighResTimeStamp
import org.scalajs.dom.CanvasRenderingContext2D
import org.scalajs.dom.html.Image
import org.scalajs.dom.raw.{HTMLCanvasElement, WebGLRenderingContext}

import scala.scalajs.js
import scala.scalajs.js._
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.typedarray.Float32Array

/**
  * Pixi.js — A 2D JavaScript Renderer
  *
  * The aim of this project is to provide a fast lightweight 2D library that works across all devices. The Pixi renderer
  * allows everyone to enjoy the power of hardware acceleration without prior knowledge of WebGL. Also, it's fast. Really fast.
  *
  * If you want to keep up to date with the latest pixi.js news then feel free to follow us on twitter  (@doormat23, and @rolnaaba)
  * and we will keep you posted! You can also check back on our site as any breakthroughs will be posted up there too!
  * @version 3.0
  * @see [[http://pixijs.github.io/docs]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("PIXI")
object PIXI extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A premade instance of the loader that can be used to loader resources.
    */
  var loader: loaders.Loader = js.native

  /**
    * Constant: Two Pi
    */
  val PI_2: Double = js.native

  /**
    * Constant conversion factor for converting radians to degrees.
    */
  val RAD_TO_DEG: Double = js.native

  /**
    * The prefix that denotes a URL is for a retina asset.
    */
  val RETINA_PREFIX: String = js.native

  /**
    * Target frames per millisecond.
    */
  val TARGET_FPMS: Double = js.native

  /**
    * String of the current PIXI version
    */
  val VERSION: String = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * This helper function will automatically detect which renderer you should be using. WebGL is the preferred renderer
    * as it is a lot faster. If webGL is not supported by the browser then this function will return a canvas renderer.
    * @param width   the width of the renderers view
    * @param height  the height of the renderers view
    * @param options The optional renderer parameters
    * @param noWebGL prevents selection of WebGL renderer, even if such is present
    * @return WebGL renderer if available, otherwise CanvasRenderer
    */
  def autoDetectRenderer(width: Double = 800, height: Double = 600, options: AutoDetectRendererOptions | js.Any = null, noWebGL: Boolean = false): AbstractRenderer = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Class Definitions
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * This is the base class for creating a PIXI filter. Currently only WebGL supports filters. If you want to make a
    * custom filter this should be your base class.
    * @param vertexSrc   The vertex shader source as an array of strings.
    * @param fragmentSrc The fragment shader source as an array of strings.
    * @param uniforms    An object containing the uniforms for this filter.
    */
  @js.native
  @JSName("AbstractFilter")
  class AbstractFilter(var vertexSrc: String | js.Array[String], var fragmentSrc: String | js.Array[String], var uniforms: js.Object) extends js.Object {

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

  /**
    * A texture stores the information that represents an image. All textures have a base texture.
    */
  @js.native
  @JSName("BaseTexture")
  trait BaseTexture extends js.Object {

    /////////////////////////////////////////////////////////////////////////////////
    //      Properties
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * Set to true once the base texture has successfully loaded.
      * This is never true if the underlying source fails to load or has no texture data.
      */
    def hasLoaded: Boolean = js.native

    /**
      * The height of the base texture set when the image has loaded
      */
    def height: Double = js.native

    /**
      * TODO
      */
    var imageUrlstring: String = js.native

    /**
      * Set to true if the source is currently loading.
      * If an Image source is loading the 'loaded' or 'error' event will be dispatched when the operation ends.
      * An underyling source that is immediately-available bypasses loading entirely.
      */
    def isLoading: Boolean = js.native

    /**
      * Set this to true if a mipmap of this texture needs to be generated. This value needs to be set before the
      * texture is used Also the texture must be a power of two size to work.
      */
    var mipmap: Boolean = js.native

    /**
      * Controls if RGB channels should be pre-multiplied by Alpha (WebGL only)
      */
    var premultipliedAlpha: Boolean = js.native

    /**
      * Used to store the actual height of the source of this texture
      */
    def realHeight: Double = js.native

    /**
      * Used to store the actual width of the source of this texture
      */
    def realWidth: Double = js.native

    /**
      * The Resolution of the texture.
      */
    var resolution: Resolution = js.native

    /**
      * The scale mode to apply when scaling this texture
      * @see [[PIXI.SCALE_MODES]]
      */
    var scaleMode: Int = js.native

    /**
      * The image source that is used to create the texture.
      * @return an image or the canvas
      */
    def source: js.Any = js.native

    /**
      * The width of the base texture set when the image has loaded
      */
    def width: Double = js.native

    /////////////////////////////////////////////////////////////////////////////////
    //      Methods
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * Destroys this base texture
      */
    def destroy(): Unit = js.native

    /**
      * Frees the texture from WebGL memory without destroying this texture object. This means you can still use the
      * texture later which will upload it to GPU memory again.
      */
    def dispose(): Unit = js.native

    /**
      * Load a source.
      * If the source is not-immediately-available, such as an image that needs to be downloaded, then the 'loaded'
      * or 'error' event will be dispatched in the future and hasLoaded will remain false after this call.
      * @param source the source object of the texture.
      */
    def loadSource(source: Image | HTMLCanvasElement): Unit = js.native

    /**
      * Updates the texture on all the webgl renderers, this also assumes the src has changed.
      */
    def update(): Unit = js.native

    /**
      * Changes the source image of the texture. The original source must be an Image element.
      * @param newSrc the path of the image
      */
    def updateSourceImage(newSrc: String): Unit = js.native

    /////////////////////////////////////////////////////////////////////////////////
    //      Events
    /////////////////////////////////////////////////////////////////////////////////

    def on(event: String, callback: js.Function): this.type = js.native

  }

  /**
    * BaseTexture Singleton
    */
  @js.native
  @JSName("BaseTexture")
  object BaseTexture extends js.Object {

    /**
      * Helper function that creates a base texture from the given canvas element.
      * @param canvas    The canvas element source of the texture
      * @param scaleMode @see [[PIXI.SCALE_MODES]]
      * @return the base texture
      */
    def fromCanvas(canvas: HTMLCanvasElement, scaleMode: Int = PIXI.SCALE_MODES.DEFAULT): BaseTexture = js.native

    /**
      * Helper function that creates a base texture from the given image url. If the image is not in the base texture
      * cache it will be created and loaded.
      * @param imageUrl    The image url of the texture
      * @param crossorigin Should use anonymous CORS? Defaults to true if the URL is not a data-URI.
      * @param scaleMode   @see [[PIXI.SCALE_MODES]]
      * @return the base texture
      */
    def fromImage(imageUrl: String, crossorigin: Boolean = false, scaleMode: Int = PIXI.SCALE_MODES.DEFAULT): BaseTexture = js.native

  }

  @js.native
  @JSName("CanvasMaskManager")
  trait CanvasMaskManager extends js.Object

  /**
    * The CanvasRenderer draws the scene and all its content onto a 2d canvas. This renderer should be used for browsers
    * that do not support webGL. Don't forget to add the CanvasRenderer.view to your DOM or you will not see anything :)
    * @param width   the width of the canvas view
    * @param height  the height of the canvas view
    * @param options The optional renderer parameters
    */
  @js.native
  @JSName("CanvasRenderer")
  class CanvasRenderer(var width: Double = 800, var height: Double = 600, var options: CanvasRendererOptions | js.Any) extends AbstractRenderer {

    /**
      * Whether the render view should be resized automatically
      */
    var autoResize: Boolean = js.native

    /**
      * The background color to fill if not transparent
      */
    var backgroundColor: Color = js.native

    /**
      * Tracks the blend modes useful for this renderer.
      */
    var blendModes: js.Any = js.native

    /**
      * This sets if the CanvasRenderer will clear the canvas or not before the new render pass. If the scene is NOT
      * transparent Pixi will use a canvas sized fillRect operation every frame to set the canvas background color.
      * If the scene is transparent Pixi will use clearRect to clear the canvas every frame. Disable this by setting
      * this to false. For example if your game has a canvas filling background image you often don't need this set.
      */
    var clearBeforeRender: Boolean = js.native

    /**
      * The canvas 2d context that everything is drawn with.
      */
    var context: CanvasRenderingContext2D = js.native

    /**
      * Instance of a CanvasMaskManager, handles masking when using the canvas renderer.
      */
    var maskManager: CanvasMaskManager = js.native

    /**
      * The value of the preserveDrawingBuffer flag affects whether or not the contents of the stencil buffer is
      * retained after rendering.
      */
    var preserveDrawingBuffer: Boolean = js.native

    /**
      * Boolean flag controlling canvas refresh.
      */
    var refresh: Boolean = js.native

    /**
      * The resolution of the renderer
      */
    var resolution: Resolution = js.native

    /**
      * If true Pixi will Math.floor() x/y values when rendering, stopping pixel interpolation. Handy for crisp pixel
      * art and speed on legacy devices.
      */
    var roundPixels: Double = js.native

    /**
      * The canvas property used to set the canvas smoothing property.
      */
    var smoothProperty: String = js.native

    /**
      * Whether the render view is transparent
      */
    var transparent: Boolean = js.native

    /**
      * The type of the renderer.
      * Default: PIXI.RENDERER_TYPE.UNKNOWN
      */
    var `type`: Int = js.native

  }

  /**
    * The Circle object can be used to specify a hit area for displayObjects.
    * @param x      The x coordinate of the center of the circle.
    * @param y      The y coordinate of the center of the circle.
    * @param radius The radius of the circle.
    */
  @js.native
  @JSName("Circle")
  class Circle(var x: Double, var y: Double, var radius: Double) extends js.Object {

    /**
      * The const type of this object.
      */
    def `type`: Int = js.native

    /**
      * Creates a clone of this Circle instance
      */
    override def clone(): this.type = js.native

    /**
      * Checks whether the x and y coordinates given are contained within this circle.
      * @param x The X coordinate of the point to test.
      * @param y The Y coordinate of the point to test.
      * @return Whether the x/y coordinates are within this Circle.
      */
    def contains(x: Double, y: Double): Boolean = js.native

    /**
      * Returns the framing rectangle of the circle as a Rectangle object.
      * @return the framing rectangle
      */
    def getBounds(): Rectangle = js.native

  }

  /**
    * A Container represents a collection of display objects. It is the base class of all display objects that act as a
    * container for other objects.
    */
  @js.native
  @JSName("Container")
  trait Container extends DisplayObject {

    /////////////////////////////////////////////////////////////////////////////////
    //      Properties
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * The opacity of the object.
      */
    var alphanumber: Double = js.native

    /**
      * The array of children of this container.
      */
    def children: js.Array[DisplayObject] = js.native

    /**
      * The area the filter is applied to. This is used as more of an optimisation rather than figuring out the
      * dimensions of the displayObject each frame you can set this rectangle.
      */
    var filterArea: Rectangle = js.native

    /**
      * Sets the filters for the displayObject.
      * IMPORTANT: This is a webGL only feature and will be ignored by the canvas renderer. To remove filters simply
      * set this property to 'null'
      */
    var filters: js.Array[AbstractFilter] = js.native

    /**
      * The height of the Container, setting this will actually modify the scale to achieve the value set.
      */
    var height: Double = js.native

    /**
      * Sets a mask for the displayObject. A mask is an object that limits the visibility of an object to the shape of
      * the mask applied to it. In PIXI a regular mask must be a PIXI.Graphics or a PIXI.Sprite object. This allows for
      * much faster masking in canvas as it utilises shape clipping. To remove a mask, set this property to null.
      */
    var mask: Graphics | Sprite = js.native

    /**
      * The display object container that contains this display object.
      */
    def parent: Container = js.native

    /**
      * The pivot point of the displayObject that it rotates around
      */
    var pivot: Point = js.native

    /**
      * The coordinate of the object relative to the local coordinates of the parent.
      */
    var position: Point = js.native

    /**
      * Can this object be rendered, if false the object will not be drawn but the updateTransform methods will still be called.
      */
    var renderable: Boolean = js.native

    /**
      * The rotation of the object in radians.
      */
    var rotation: Double = js.native

    /**
      * The scale factor of the object.
      */
    var scale: Point = js.native

    /**
      * The width of the Container, setting this will actually modify the scale to achieve the value set.
      */
    var width: Double = js.native

    /**
      * The multiplied alpha of the displayObject.
      */
    def worldAlpha: Alpha = js.native

    /////////////////////////////////////////////////////////////////////////////////
    //      Methods
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * Adds a child to the container.
      * @param child The DisplayObject to add to the container.
      * @return The child that was added.
      */
    def addChild(child: DisplayObject): DisplayObject = js.native

    /**
      * Adds a child to the container at a specified index. If the index is out of bounds an error will be thrown
      * @param child The DisplayObject to add to the container.
      * @param index The index to place the child in
      * @return The child that was added.
      */
    def addChildAt(child: DisplayObject, index: Int): DisplayObject = js.native

    /**
      * Destroys the container
      * @param destroyChildren if set to true, all the children will have their destroy method called as well
      */
    def destroy(destroyChildren: Boolean = false): Unit = js.native

  }

  /**
    * The base class for all objects that are rendered on the screen. This is an abstract class and should not be used
    * on its own rather it should be extended.
    */
  @js.native
  @JSName("DisplayObject")
  trait DisplayObject extends js.Object {

    /////////////////////////////////////////////////////////////////////////////////
    //      Properties
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * The alpha value of the group container.
      */
    var alpha: Alpha = js.native

    var anchor: Point = js.native

    /**
      * The angle of rotation of the group container, in degrees.
      * This adjusts the group itself by modifying its local rotation transform.
      * This has no impact on the rotation/angle properties of the children, but it will update their worldTransform
      * and on-screen orientation and position.
      */
    var angle: Double = js.native

    /**
      * Set if this display object is cached as a bitmap. This basically takes a snap shot of the display object as it
      * is at that moment. It can provide a performance benefit for complex static displayObjects. To remove simply set
      * this property to 'null'
      */
    var cacheAsBitmap: Boolean = js.native

    var visible: Boolean = js.native

    /**
      * Current transform of the object based on world (parent) factors
      */
    def worldTransform: Matrix = js.native

    /**
      * Indicates if the sprite is globally visible.
      */
    def worldVisible: Boolean = js.native

    /**
      * The position of the displayObject on the x axis relative to the local coordinates of the parent.
      */
    var x: Double = js.native

    /**
      * The position of the displayObject on the y axis relative to the local coordinates of the parent.
      */
    var y: Double = js.native

    /////////////////////////////////////////////////////////////////////////////////
    //      Methods
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * Base destroy method for generic display objects.
      */
    def destroy(): Unit = js.native

    /**
      * Set the parent Container of this DisplayObject.
      * @param container The Container to add this DisplayObject to.
      * @return The Container that this DisplayObject was added to.
      */
    def setParent(container: Container): Container = js.native

    /**
      * Calculates the global position of the display object.
      * @param position The world origin to calculate from.
      * @return A point object representing the position of this object.
      */
    def toGlobal(position: Point): Point = js.native

    /**
      * Calculates the local position of the display object relative to another point.
      * @param position The world origin to calculate from.
      * @param from     The DisplayObject to calculate the global position from.
      * @return A point object representing the position of this object.
      */
    def toLocal(position: Point, from: DisplayObject = null): Point = js.native

  }

  @js.native
  @JSName("DisplayObjectContainer")
  trait DisplayObjectContainer extends DisplayObject

  /**
    * The Ellipse object can be used to specify a hit area for displayObjects
    * @param x      The X coordinate of the center of the ellipse
    * @param y      The Y coordinate of the center of the ellipse
    * @param width  The half width of this ellipse
    * @param height The half height of this ellipse
    */
  @js.native
  @JSName("Ellipse")
  class Ellipse(var x: Double, var y: Double, var width: Double, var height: Double) extends js.Object {

    /**
      * The const type of this object.
      */
    def `type`: Int = js.native

    /**
      * Creates a clone of this Circle instance
      */
    override def clone(): this.type = js.native

    /**
      * Checks whether the x and y coordinates given are contained within this circle.
      * @param x The X coordinate of the point to test.
      * @param y The Y coordinate of the point to test.
      * @return Whether the x/y coordinates are within this Circle.
      */
    def contains(x: Double, y: Double): Boolean = js.native

    /**
      * Returns the framing rectangle of the circle as a Rectangle object.
      * @return the framing rectangle
      */
    def getBounds(): Rectangle = js.native

  }

  /**
    * Basic FXAA implementation based on the code on geeks3d.com with the modification that the texture2DLod stuff was
    * removed since it's unsupported by WebGL.
    */
  @js.native
  @JSName("FXAAFilter")
  trait FXAAFilter extends AbstractFilter

  @js.native
  @JSName("FilterManager")
  class FilterManager(renderer: WebGLRenderer) extends WebGLManager(renderer)

  /**
    * The Graphics class contains methods used to draw primitive shapes such as lines, circles and rectangles to the
    * display, and to color and fill them.
    */
  @js.native
  @JSName("Graphics")
  trait Graphics extends Container {

    /**
      * The blend mode to be applied to the graphic shape. Apply a value of PIXI.BLEND_MODES.NORMAL to reset the blend mode.
      * @see [[PIXI.BLEND_MODES]]
      */
    def blendMode: BlendMode = js.native

    /**
      * The bounds' padding used for bounds calculation.
      */
    def boundsPadding: Padding = js.native

    /**
      * The alpha value used when filling the Graphics object.
      */
    def fillAlpha: Alpha = js.native

    /**
      * Whether this shape is being used as a mask.
      */
    def isMask: Boolean = js.native

    /**
      * The color of any lines drawn.
      */
    def lineColor: Color = js.native

    /**
      * The width (thickness) of any lines drawn.
      */
    def lineWidth: LineWidth = js.native

    /**
      * The tint applied to the graphic shape. This is a hex value. Apply a value of 0xFFFFFF to reset the tint.
      */
    def tint: Color = js.native

  }

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
  class GraphicsData(lineWidth: LineWidth, lineColor: Color, lineAlpha: Alpha, fillColor: Color, fillAlpha: Alpha, fill: Boolean, shape: GraphicalShape) extends js.Object {

    /**
      * Creates a new GraphicsData object with the same values as this one.
      */
    override def clone(): this.type = js.native

    /**
      * Destroys the Graphics data.
      */
    def destroy(): Unit = js.native

  }

  /**
    * The pixi Matrix class as an object, which makes it a lot faster, here is a representation of it:
    * {{{
    * | a | b | tx|
    * +---+---+---+
    * | c | d | ty|
    * +---+---+---+
    * | 0 | 0 | 1 |
    * }}}
    */
  @js.native
  @JSName("Matrix")
  class Matrix extends js.Object {

    var a: Double = js.native

    var b: Double = js.native

    var c: Double = js.native

    var d: Double = js.native

    var tx: Double = js.native

    var ty: Double = js.native

    /**
      * Appends the given Matrix to this Matrix.
      * @param matrix the given Matrix
      * @return This matrix. Good for chaining method calls.
      */
    def append(matrix: Matrix): this.type = js.native

    /**
      * Get a new position with the current transformation applied. Can be used to go from a child's coordinate space
      * to the world coordinate space. (e.g. rendering)
      * @param pos    The origin
      * @param newPos The point that the new position is assigned to (allowed to be same as input)
      * @return The new point, transformed through this matrix
      */
    def apply(pos: Point, newPos: Point = null): Point = js.native

    /**
      * Get a new position with the inverse of the current transformation applied. Can be used to go from the world
      * coordinate space to a child's coordinate space. (e.g. input)
      * @param pos    The origin
      * @param newPos The point that the new position is assigned to (allowed to be same as input)
      * @return The new point, inverse-transformed through this matrix
      */
    def applyInverse(pos: Point, newPos: Point = null): Point = js.native

    /**
      * Creates a new Matrix object with the same values as this one.
      * @return A copy of this matrix. Good for chaining method calls.
      */
    override def clone(): this.type = js.native

    /**
      * Changes the values of the given matrix to be the same as the ones in this matrix.
      * @return The matrix given in parameter with its values updated.
      */
    def copy(): Matrix = js.native

    /**
      * Creates a Matrix object based on the given array. The Element to Matrix mapping order is as follows:
      * a = array[0] b = array[1] c = array[3] d = array[4] tx = array[2] ty = array[5]
      * @param array The array that the matrix will be populated from.
      */
    def fromArray(array: js.Array[Double]): Unit = js.native

    /**
      * Resets this Matrix to an identity (default) matrix.
      * @return This matrix. Good for chaining method calls.
      */
    def identity(): this.type = js.native

    /**
      * Inverts this matrix.
      * @return This matrix. Good for chaining method calls.
      */
    def invert(): this.type = js.native

    /**
      * Prepends the given Matrix to this Matrix.
      * @param matrix the given Matrix
      * @return This matrix. Good for chaining method calls.
      */
    def prepend(matrix: Matrix): this.type = js.native

    /**
      * Applies a rotation transformation to the matrix.
      * @param angle The angle in radians.
      * @return This matrix. Good for chaining method calls.
      */
    def rotate(angle: Double): this.type = js.native

    /**
      * Applies a scale transformation to the matrix.
      * @param x The amount to scale horizontally.
      * @param y The amount to scale vertically.
      * @return This matrix. Good for chaining method calls.
      */
    def scale(x: Double, y: Double): this.type = js.native

    /**
      * Creates an array from the current Matrix object.
      * @param transpose Whether we need to transpose the matrix or not.
      * @return The newly created array which contains the matrix.
      */
    def toArray(transpose: Boolean): js.Array[Double] = js.native

    /**
      * Translates the matrix on the x and y.
      * @param x the X-coordinate delta
      * @param y the Y-coordinate delta
      * @return This matrix. Good for chaining method calls.
      */
    def translate(x: Double, y: Double): this.type = js.native

  }

  /**
    * Matrix Singleton
    */
  @js.native
  @JSName("Matrix")
  object Matrix extends js.Object {

    /**
      * A default (identity) matrix
      */
    def IDENTITY: Matrix = js.native

    /**
      * A temp matrix
      */
    def TEMP_MATRIX: Matrix = js.native

  }

  /**
    * The Point object represents a location in a two-dimensional coordinate system, where x represents the horizontal
    * axis and y represents the vertical axis.
    * @param x position of the point on the x axis
    * @param y position of the point on the x axis
    */
  @js.native
  @JSName("Point")
  class Point(var x: Double = 0, var y: Double = 0) extends js.Object {

    /**
      * Creates a clone of this Circle instance
      */
    override def clone(): this.type = js.native

    /**
      * Checks whether the x and y coordinates given are contained within this circle.
      * @param x The X coordinate of the point to test.
      * @param y The Y coordinate of the point to test.
      * @return Whether the x/y coordinates are within this Circle.
      */
    def contains(x: Double, y: Double): Boolean = js.native

    /**
      * Copies x and y from the given point
      * @param p the given point
      */
    def copy(p: Point): Unit = js.native

    /**
      * Returns true if the given point is equal to this point.
      * @param p the given point
      * @return true, if the given point is equal to this point.
      */
    def equals(p: Point): Boolean = js.native

    /**
      * Sets the point to a new x and y position. If y is omitted, both x and y will be set to x.
      * @param x position of the point on the x axis
      * @param y position of the point on the x axis
      */
    def set(x: Double = 0, y: Double = 0): Unit = js.native

    def setTo(x: Double = 0, y: Double = 0): Unit = js.native

  }

  /**
    * The Polygon object
    * @param points_ This can be an array of Points that form the polygon, a flat array of numbers that will be
    *                interpreted as [x,y, x,y, ...], or the arguments passed can be all the points of the polygon
    *                e.g. new PIXI.Polygon(new PIXI.Point(), new PIXI.Point(), ...), or the arguments passed can be
    *                flat x,y values e.g. new Polygon(x,y, x,y, x,y, ...) where x and y are Numbers.
    */
  @js.native
  @JSName("Polygon")
  class Polygon(points_ : js.Array[Point | Double]) extends js.Object {

    /**
      * An array of the points of this polygon
      */
    def points: js.Array[Double] = js.native

    /**
      * The const type of this object.
      */
    def `type`: Int = js.native

    /**
      * Creates a clone of this Circle instance
      */
    override def clone(): this.type = js.native

    /**
      * Checks whether the x and y coordinates given are contained within this circle.
      * @param x The X coordinate of the point to test.
      * @param y The Y coordinate of the point to test.
      * @return Whether the x/y coordinates are within this Circle.
      */
    def contains(x: Double, y: Double): Boolean = js.native

  }

  /**
    * Helper class to create a quad
    */
  @js.native
  @JSName("Quad")
  class Quad(gl: WebGLRenderingContext) extends js.Object {

    /**
      * The color components of the triangles
      */
    var colors: Float32Array = js.native

    /**
      * The Uvs of the quad
      */
    var uvs: Float32Array = js.native

    /**
      * An array of vertices
      */
    var vertices: Float32Array = js.native

    /**
      * Maps two Rectangle to the quad
      * @param rect  the first rectangle
      * @param rect2 the second rectangle
      */
    def map(rect: Rectangle, rect2: Rectangle): Unit = js.native

    /**
      * Binds the buffer and uploads the data
      */
    def upload(): Unit = js.native

  }

  /**
    * The Rectangle object is an area defined by its position, as indicated by its top-left corner point (x, y) and by
    * its width and its height.
    * @param x      The X coordinate of the upper-left corner of the rectangle.
    * @param y      The Y coordinate of the upper-left corner of the rectangle.
    * @param width  The overall width of this rectangle.
    * @param height The overall height of this rectangle.
    */
  @js.native
  @JSName("Rectangle")
  class Rectangle(var x: Double, var y: Double, var width: Double, var height: Double) extends js.Object {

    /**
      * Creates a clone of this Circle instance
      */
    override def clone(): this.type = js.native

    /**
      * Checks whether the x and y coordinates given are contained within this circle.
      * @param x The X coordinate of the point to test.
      * @param y The Y coordinate of the point to test.
      * @return Whether the x/y coordinates are within this Circle.
      */
    def contains(x: Double, y: Double): Boolean = js.native

  }

  @js.native
  @JSName("RenderTarget")
  trait RenderTarget extends js.Object

  /**
    * This trait serves as a base class for Canvas and WEBGL renderers
    */
  @js.native
  trait AbstractRenderer extends js.Object

  @js.native
  @JSName("ResourceLoader")
  trait ResourceLoader extends js.Object

  @js.native
  @JSName("Sprite")
  trait Sprite extends Container

  /**
    * A Text Object will create a line or multiple lines of text. To split a line you can use '\n' in your text string,
    * or add a wordWrap property set to true and and wordWrapWidth property with a value in the style object.
    * @param text  The copy that you would like the text to display
    * @param style The style parameters
    */
  @js.native
  @JSName("Text")
  class Text(var text: String, var style: TextStyle | RawOptions) extends js.Object {

    /**
      * The opacity of the object.
      */
    var alpha: Alpha = js.native

    /**
      * The anchor sets the origin point of the texture. The default is 0,0 this means the texture's origin is the
      * top left Setting the anchor to 0.5,0.5 means the texture's origin is centered Setting the anchor to 1,1 would
      * mean the texture's origin point will be the bottom right corner
      */
    var anchor: Point = js.native

    /**
      * The blend mode to be applied to the sprite. Apply a value of PIXI.BLEND_MODES.NORMAL to reset the blend mode.
      */
    var blendMode: BlendMode = js.native

    /**
      * Set this to true if you want this display object to be cached as a bitmap. This basically takes a snap shot of
      * the display object as it is at that moment. It can provide a performance benefit for complex static displayObjects.
      * To remove simply set this property to 'null'
      */
    var cacheAsBitmap: java.lang.Boolean = js.native

    /**
      * An internal cached value of the tint.
      */
    var cachedTint: Color = js.native

    /**
      * The canvas element that everything is drawn to
      */
    var canvas: HTMLCanvasElement = js.native

    /**
      * The array of children of this container.
      */
    def children: js.Array[DisplayObject] = js.native

    /**
      * The canvas 2d context that everything is drawn with
      */
    var context: HTMLCanvasElement = js.native

    /**
      * The area the filter is applied to. This is used as more of an optimisation rather than figuring out the
      * dimensions of the displayObject each frame you can set this rectangle
      */
    var filterArea: Rectangle = js.native

    /**
      * Sets the filters for the displayObject.
      * IMPORTANT: This is a webGL only feature and will be ignored by the canvas renderer. To remove filters simply
      * set this property to 'null'
      */
    var filters: js.Array[AbstractFilter] = js.native

  }

  /**
    * A texture stores the information that represents an image or part of an image. It cannot be added to the display
    * list directly. Instead use it as the texture for a Sprite. If no frame is provided then the whole image is used.
    * @param baseTexture The base texture source to create the texture from
    * @param frame       The rectangle frame of the texture to show
    * @param crop        The area of original texture
    * @param trim        Trimmed texture rectangle
    * @param rotate      indicates whether the texture should be rotated by 90 degrees ( used by texture packer )
    */
  @js.native
  @JSName("Texture")
  class Texture(var baseTexture: BaseTexture, var frame: Rectangle = null, var crop: Rectangle = null, var trim: Rectangle = null, var rotate: Rectangle = null) extends BaseTexture

  /**
    * Texture Singleton
    */
  @js.native
  @JSName("Texture")
  object Texture extends js.Object {

    /**
      * An empty texture, used often to not have to create multiple empty textures.
      */
    val EMPTY: js.Any = js.native

  }

  @js.native
  @JSName("WebGLManager")
  class WebGLManager(var renderer: WebGLRenderer) extends js.Object {

    /**
      * Generic destroy methods to be overridden by the subclass
      */
    def destroy(): Unit = js.native

    /**
      * Generic method called when there is a WebGL context change.
      */
    def onContextChange(callback: js.Function): Unit = js.native

  }

  /**
    * The WebGLRenderer draws the scene and all its content onto a webGL enabled canvas. This renderer should be used
    * for browsers that support webGL. This Render works by automatically managing webGLBatchs. So no need for Sprite
    * Batches or Sprite Clouds. Don't forget to add the view to your DOM or you will not see anything :)
    * @param width   the width of the canvas view
    * @param height  the height of the canvas view
    * @param options The optional renderer parameters
    */
  @js.native
  @JSName("WebGLRenderer")
  class WebGLRenderer(width: Double = 0, height: Double = 0, options: WebGLRendererOptions | js.Any = null) extends AbstractRenderer {

  }

  /////////////////////////////////////////////////////////////////////////////////
  //      Constants
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Various blend modes supported by PIXI.
    * IMPORTANT - The WebGL renderer only supports the NORMAL, ADD, MULTIPLY and SCREEN blend modes.
    * Anything else will silently act like NORMAL.
    */
  @js.native
  @JSName("BLEND_MODES")
  object BLEND_MODES extends js.Object {
    val NORMAL: BlendMode = js.native
    val ADD: BlendMode = js.native
    val MULTIPLY: BlendMode = js.native
    val SCREEN: BlendMode = js.native
    val OVERLAY: BlendMode = js.native
    val DARKEN: BlendMode = js.native
    val LIGHTEN: BlendMode = js.native
    val COLOR_DODGE: BlendMode = js.native
    val COLOR_BURN: BlendMode = js.native
    val HARD_LIGHT: BlendMode = js.native
    val SOFT_LIGHT: BlendMode = js.native
    val DIFFERENCE: BlendMode = js.native
    val EXCLUSION: BlendMode = js.native
    val HUE: BlendMode = js.native
    val SATURATION: BlendMode = js.native
    val COLOR: BlendMode = js.native
    val LUMINOSITY: BlendMode = js.native
  }

  /**
    * The default render options if none are supplied to PIXI.WebGLRenderer or PIXI.CanvasRenderer.
    * @see [[http://pixijs.github.io/docs/PIXI.html#.RENDERER_TYPE]]
    */
  @js.native
  @JSName("DEFAULT_RENDER_OPTIONS")
  object DEFAULT_RENDER_OPTIONS extends js.Object {
    var view: HTMLCanvasElement = js.native
    var transparent: Boolean = js.native
    var antialias: Boolean = js.native
    var forceFXAA: Boolean = js.native
    var preserveDrawingBuffer: Boolean = js.native
    var resolution: Resolution = js.native
    var backgroundColor: Color = js.native
    var clearBeforeRender: Boolean = js.native
    var autoResize: Boolean = js.native
  }

  /**
    * Various webgl draw modes. These can be used to specify which GL drawMode to use under certain situations and renderers.
    */
  @js.native
  @JSName("DRAW_MODES")
  object DRAW_MODES extends js.Object {
    var POINTS: Int = js.native
    var LINES: Int = js.native
    var LINE_LOOP: Int = js.native
    var LINE_STRIP: Int = js.native
    var TRIANGLES: Int = js.native
    var TRIANGLE_STRIP: Int = js.native
    var TRIANGLE_FAN: Int = js.native
  }

  /**
    * Filter implementations
    */
  @js.native
  @JSName("filters")
  object filters extends js.Object {

    /**
      * An ASCII filter.
      */
    @js.native
    @JSName("AsciiFilter")
    trait AsciiFilter extends AbstractFilter

    /**
      * The BloomFilter applies a Gaussian blur to an object. The strength of the blur can be set for x- and y-axis separately.
      */
    @js.native
    @JSName("BloomFilter")
    trait BloomFilter extends AbstractFilter

    /**
      * The BlurDirFilter applies a Gaussian blur toward a direction to an object.
      */
    @js.native
    @JSName("BlurDirFilter")
    trait BlurDirFilter extends AbstractFilter

    /**
      * The BlurFilter applies a Gaussian blur to an object. The strength of the blur can be set for x- and y-axis separately.
      */
    @js.native
    @JSName("BlurFilter")
    trait BlurFilter extends AbstractFilter

    /**
      * The BlurXFilter applies a horizontal Gaussian blur to an object.
      */
    @js.native
    @JSName("BlurXFilter")
    trait BlurXFilter extends AbstractFilter

    /**
      * The BlurYFilter applies a horizontal Gaussian blur to an object.
      */
    @js.native
    @JSName("BlurYFilter")
    trait BlurYFilter extends AbstractFilter

    /**
      * The BlurYTintFilter applies a vertical Gaussian blur to an object.
      */
    @js.native
    @JSName("BlurYTintFilter")
    trait BlurYTintFilter extends AbstractFilter

  }

  /**
    * PIXI.loaders object
    */
  @js.native
  @JSName("loaders")
  object loaders extends js.Object {

    /**
      * The new loader, extends Resource Loader by Chad Engler : https://github.com/englercj/resource-loader
      * @param baseUrl     The base url for all resources loaded by this loader.
      * @param concurrency The number of resources to load concurrently.
      */
    @js.native
    @JSName("Loader")
    class Loader(baseUrl: String = "", concurrency: Int = 10) extends ResourceLoader

  }

  /**
    * Constant to identify the Renderer Type.
    */
  @js.native
  @JSName("RENDERER_TYPE")
  object RENDERER_TYPE extends js.Object {
    val CANVAS: Int = js.native
    val UNKNOWN: Int = js.native
    val WEBGL: Int = js.native
  }

  /**
    * The scale modes that are supported by pixi.
    * The DEFAULT scale mode affects the default scaling mode of future operations. It can be re-assigned to either
    * LINEAR or NEAREST, depending upon suitability.
    */
  @js.native
  @JSName("SCALE_MODES")
  object SCALE_MODES extends js.Object {
    val DEFAULT: Int = js.native

    /** Smooth scaling */
    val LINEAR: Int = js.native

    /** Pixelating scaling */
    val NEAREST: Int = js.native
  }

  /**
    * Constants that identify shapes, mainly to prevent instanceof calls.
    */
  @js.native
  @JSName("SHAPES")
  object SHAPES extends js.Object {
    val POLY: js.Any = js.native
    val RECT: js.Any = js.native
    val CIRC: js.Any = js.native
    val ELIP: js.Any = js.native
    val RREC: js.Any = js.native
  }

  @js.native
  @JSName("tickers")
  object tickers extends js.Object {

    /**
      * A Ticker class that runs an update loop that other objects listen to. This class is composed around an
      * EventEmitter object to add listeners meant for execution on the next requested animation frame. Animation
      * frames are requested only when necessary, e.g. When the ticker is started and the emitter has listeners.
      */
    @js.native
    @JSName("Ticker")
    class Ticker extends js.Object {

      /////////////////////////////////////////////////////////////////////////////////
      //      Properties
      /////////////////////////////////////////////////////////////////////////////////

      /**
        * Whether or not this ticker should invoke the method PIXI.ticker.Ticker#start automatically when a listener is added.
        */
      var autoStart: Boolean = js.native

      /**
        * Scalar time value from last frame to this frame. This value is capped by setting PIXI.ticker.Ticker#minFPS
        * and is scaled with PIXI.ticker.Ticker#speed. Note: The cap may be exceeded by scaling.
        */
      var deltaTime: Int = js.native

      /**
        * Time elapsed in milliseconds from last frame to this frame. Opposed to what the scalar PIXI.ticker.Ticker#deltaTime
        * is based, this value is neither capped nor scaled. If the platform supports DOMHighResTimeStamp, this value will
        * have a precision of 1 µs.
        */
      var elapsedMS: Double = js.native

      /**
        * The frames per second at which this ticker is running. The default is approximately 60 in most modern browsers.
        * Note: This does not factor in the value of PIXI.ticker.Ticker#speed, which is specific to scaling PIXI.ticker.Ticker#deltaTime.
        */
      def FPS: Double = js.native

      /**
        * The last time PIXI.ticker.Ticker#update was invoked. This value is also reset internally outside of invoking
        * update, but only when a new animation frame is requested. If the platform supports DOMHighResTimeStamp, this
        * value will have a precision of 1 µs.
        */
      var lastTime: Double = js.native

      /**
        * Manages the maximum amount of milliseconds allowed to elapse between invoking PIXI.ticker.Ticker#update.
        * This value is used to cap PIXI.ticker.Ticker#deltaTime, but does not effect the measured value of
        * PIXI.ticker.Ticker#FPS. When setting this property it is clamped to a value between 0 and PIXI.TARGET_FPMS * 1000.
        */
      var minFPS: Double = js.native

      /**
        * Factor of current PIXI.ticker.Ticker#deltaTime.
        */
      var speed: Int = js.native

      /**
        * Whether or not this ticker has been started. true if PIXI.ticker.Ticker#start has been called. false if
        * PIXI.ticker.Ticker#stop has been called. While false, this value may change to true in the event of
        * PIXI.ticker.Ticker#autoStart being true and a listener is added.
        */
      var started: Boolean = js.native

      /////////////////////////////////////////////////////////////////////////////////
      //      Methods
      /////////////////////////////////////////////////////////////////////////////////

      /**
        * Calls module:eventemitter3.EventEmitter#on internally for the internal 'tick' event. It checks if the emitter
        * has listeners, and if so it requests a new animation frame at this point.
        * @param fn      The listener function to be added for updates
        * @param context The listener context
        * @return this
        */
      def add(fn: js.Function, context: js.Function = null): this.type = js.native

      /**
        * Calls module:eventemitter3.EventEmitter#once internally for the internal 'tick' event. It checks if the emitter
        * has listeners, and if so it requests a new animation frame at this point.
        * @param fn      The listener function to be added for one update
        * @param context The listener context
        * @return this
        */
      def addOnce(fn: js.Function, context: js.Function = null): this.type = js.native

      /**
        * Calls module:eventemitter3.EventEmitter#off internally for 'tick' event. It checks if the emitter has listeners
        * for 'tick' event. If it does, then it cancels the animation frame.
        * @param fn      The listener function to be added for one update
        * @param context The listener context
        * @return this
        */
      def remove(fn: js.Function, context: js.Function = null): this.type = js.native

      /**
        * Starts the ticker. If the ticker has listeners a new animation frame is requested at this point.
        */
      def start(): Unit = js.native

      /**
        * Stops the ticker. If the ticker has requested an animation frame it is canceled at this point.
        */
      def stop(): Unit = js.native

      /**
        * Triggers an update. An update entails setting the current PIXI.ticker.Ticker#elapsedMS, the current
        * PIXI.ticker.Ticker#deltaTime, invoking all listeners with current deltaTime, and then finally setting
        * PIXI.ticker.Ticker#lastTime with the value of currentTime that was provided. This method will be called
        * automatically by animation frame callbacks if the ticker instance has been started and listeners are added.
        * @param currentTime the current time of execution (Type: Number/DOMHighResTimeStamp, Default: performance.now())
        */
      def update(currentTime: Int | DOMHighResTimeStamp = js.native): Unit = js.native

    }

  }

}
