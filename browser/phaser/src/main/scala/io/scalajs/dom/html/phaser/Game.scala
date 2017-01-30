package io.scalajs.dom.html.phaser

import io.scalajs.dom.html.HTMLElement
import io.scalajs.dom.html.canvas.CanvasRenderingContext2D
import io.scalajs.dom.html.phaser.utils.Debug
import io.scalajs.{JsNumber, RawOptions}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * This is where the magic happens. The Game object is the heart of your game, providing quick access to
  * common functions and handling the boot process.
  * @param width         The width of your game in game pixels. If given as a string the value must be between 0 and 100
  *                      and will be used as the percentage width of the parent container, or the browser window if no parent is given.
  * @param height        The height of your game in game pixels. If given as a string the value must be between 0 and 100
  *                      and will be used as the percentage height of the parent container, or the browser window if no parent is given.
  * @param renderer      Which renderer to use: Phaser.AUTO will auto-detect, [[Phaser.WEBGL]], [[Phaser.CANVAS]] or
  *                      [[Phaser.HEADLESS]] (no rendering at all).
  * @param parent        The DOM element into which this games canvas will be injected. Either a DOM ID (string) or the element itself.
  * @param state         The default state object. A object consisting of Phaser.State functions (preload, create, update, render) or null.
  * @param transparent   Use a transparent canvas background or not.
  * @param antialias     Draw all image textures anti-aliased or not. The default is for smooth textures, but disable
  *                      if your game features pixel art.
  * @param physicsConfig A physics configuration object to pass to the Physics world on creation.
  * @see https://phaser.io/docs/2.6.2/Phaser.Game.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.Game")
class Game(val width: JsNumber | String = js.native,
           val height: JsNumber | String = js.native,
           val renderer: Int = js.native,
           val parent: String | HTMLElement = js.native,
           val state: State = js.native,
           val transparent: Boolean = js.native,
           val antialias: Boolean = js.native,
           val physicsConfig: RawOptions = js.native)
  extends js.Object {

  /**
    * Reference to the Phaser.GameObjectFactory.
    */
  def add: GameObjectFactory = js.native

  /**
    * Reference to the assets cache.
    */
  def cache: Cache = js.native

  /**
    * A handy reference to world.camera.
    */
  def camera: Camera = js.native

  /**
    * Clear the Canvas each frame before rendering the display list.
    * You can set this to `false` to gain some performance if your game always contains a background that completely fills the display.
    */
  var clearBeforeRender: Boolean = js.native

  /**
    * The Phaser.Game configuration object.
    */
  def config: GameConfigObject = js.native

  /**
    * A handy reference to renderer.context (only set for CANVAS games, not WebGL)
    */
  def context: CanvasRenderingContext2D = js.native

  /**
    * The Asset Generator.
    */
  def create: Create = js.native

  /**
    * A set of useful debug utilities.
    */
  def debug: Debug = js.native

  /**
    * Contains device information and capabilities.
    */
  def device: Device = js.native

  /**
    * Should the game loop force a logic update, regardless of the delta timer? Set to true if you know you need this.
    * You can toggle it on the fly.
    */
  def forceSingleUpdate: Boolean = js.native

  /**
    * If the game is struggling to maintain the desired FPS, this signal will be dispatched.
    * The desired/chosen FPS should probably be closer to the Phaser.Time#suggestedFps value.
    */
  def fpsProblemNotifier: Signal = js.native

  /**
    * Phaser Game ID (for when Pixi supports multiple instances).
    */
  def id: Int = js.native

  /**
    * Reference to the input manager
    */
  def input: Input = js.native

  /**
    * Whether the game engine is booted, aka available.
    */
  def isBooted: Boolean = js.native

  /**
    * Is game running or paused?
    */
  def isRunning: Boolean = js.native

  /**
    * Reference to the assets loader.
    */
  def load: Loader = js.native

  /**
    * If false Phaser will automatically render the display list every update. If true the render loop will be skipped.
    * You can toggle this value at run-time to gain exact control over when Phaser renders. This can be useful in certain
    * types of game or application.
    *
    * Please note that if you don't render the display list then none of the game object transforms will be updated,
    * so use this value carefully.
    */
  def lockRender: Boolean = js.native

  /**
    *
    * @return
    */
  def make: GameObjectCreator = js.native

  /**
    *
    */
  def physics: Physics = js.native

  def rnd: RandomDataGenerator = js.native

  def time: Time = js.native

  def world: World = js.native

}
