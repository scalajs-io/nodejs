package io.scalajs.dom.html
package pixijs

import io.scalajs.RawOptions
import io.scalajs.dom.html.canvas.HTMLCanvasElement

import scala.scalajs.js
import scala.scalajs.js._
import scala.scalajs.js.annotation.JSName

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
    * A pre-made instance of the loader that can be used to loader resources.
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
  //      Class References
  /////////////////////////////////////////////////////////////////////////////////

  type DisplayObject = pixijs.DisplayObject
  type DisplayObjectContainer = pixijs.DisplayObjectContainer
  type Matrix = pixijs.Matrix

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
  def autoDetectRenderer(width: Double = js.native,
                         height: Double = js.native,
                         options: AutoDetectRendererOptions | RawOptions = js.native,
                         noWebGL: Boolean = js.native): AbstractRenderer = js.native

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
    class AsciiFilter extends AbstractFilter()

    /**
      * The BloomFilter applies a Gaussian blur to an object. The strength of the blur can be set for x- and y-axis separately.
      */
    @js.native
    @JSName("BloomFilter")
    class BloomFilter extends AbstractFilter()

    /**
      * The BlurDirFilter applies a Gaussian blur toward a direction to an object.
      */
    @js.native
    @JSName("BlurDirFilter")
    class BlurDirFilter extends AbstractFilter()

    /**
      * The BlurFilter applies a Gaussian blur to an object. The strength of the blur can be set for x- and y-axis separately.
      */
    @js.native
    @JSName("BlurFilter")
    class BlurFilter extends AbstractFilter()

    /**
      * The BlurXFilter applies a horizontal Gaussian blur to an object.
      */
    @js.native
    @JSName("BlurXFilter")
    class BlurXFilter extends AbstractFilter()

    /**
      * The BlurYFilter applies a horizontal Gaussian blur to an object.
      */
    @js.native
    @JSName("BlurYFilter")
    class BlurYFilter extends AbstractFilter()

    /**
      * The BlurYTintFilter applies a vertical Gaussian blur to an object.
      */
    @js.native
    @JSName("BlurYTintFilter")
    class BlurYTintFilter extends AbstractFilter()

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
    class Loader(baseUrl: String = js.native, concurrency: Int = js.native) extends ResourceLoader

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
  object tickers extends js.Object

}
