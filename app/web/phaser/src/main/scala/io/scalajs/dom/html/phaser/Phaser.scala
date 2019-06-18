package io.scalajs.dom.html
package phaser

import io.scalajs.RawOptions
import io.scalajs.dom.html.pixijs.DisplayObject

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSName}
import scala.scalajs.js.|

/**
  * phaser - A fast, free and fun HTML5 Game Framework for Desktop and Mobile web browsers.
  * @version 2.6.2
  * @see [[https://www.npmjs.com/package/phaser]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal("Phaser")
object Phaser extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Constants
  /////////////////////////////////////////////////////////////////////////////////

  val AUTO: Int = js.native
  val CANVAS: Int = js.native
  val HEADLESS: Int = js.native
  val VIDEO: Int = js.native
  val WEBGL: Int = js.native

  val ANGLE_UP: Int = js.native

  // Alignment Constants

  val BOTTOM_LEFT: Int = js.native
  val BOTTOM_CENTER: Int = js.native
  val BOTTOM_RIGHT: Int = js.native
  val CENTER: Int = js.native
  val LEFT_BOTTOM: Int = js.native
  val LEFT_CENTER: Int = js.native
  val LEFT_TOP: Int = js.native
  val RIGHT_BOTTOM: Int = js.native
  val RIGHT_CENTER: Int = js.native
  val RIGHT_TOP: Int = js.native
  val TOP_CENTER: Int = js.native
  val TOP_LEFT: Int = js.native
  val TOP_RIGHT: Int = js.native

  // Entity Type Constants

  val SPRITE: js.Any = js.native
  val TEXT: js.Any = js.native

  // Version Constants

  val VERSION: String = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Class References
  /////////////////////////////////////////////////////////////////////////////////

  type Animation = phaser.Animation
  type AnimationManager = phaser.AnimationManager
  type ArraySet[T] = phaser.ArraySet[T]
  type AudioSprite = phaser.AudioSprite
  type BitmapData = phaser.BitmapData
  type BitmapText = phaser.BitmapText
  type Bullet = phaser.Bullet
  type Button = phaser.Button
  type Cache = phaser.Cache
  type Camera = phaser.Camera
  type Canvas = phaser.Canvas
  type Circle = phaser.Circle
  type Create = phaser.Create
  type CursorKeys = phaser.CursorKeys
  type Device = phaser.Device
  type DeviceButton = phaser.DeviceButton
  type Easing = phaser.Easing
  type Ellipse = phaser.Ellipse
  type Events = phaser.Events
  type Frame = phaser.Frame
  type FrameData = phaser.FrameData
  type Game = phaser.Game
  type Gamepad = phaser.Gamepad
  type GameObjectCreator = phaser.GameObjectCreator

  /**
    * A reference to the GameObjectFactory which can be used to add new objects to the World.
    * @param game the running [[Game]].
    */
  @js.native
  class GameObjectFactory(var game: Game = js.native) extends js.Object {

    /**
      * A reference to the game world.
      */
    var world: World = js.native

    def tween(aliens: DisplayObject): Tween = js.native

    def text(x: Double = js.native,
             y: Double = js.native,
             text: String = js.native,
             style: js.Dictionary[_] = js.native,
             group: Group[_] = js.native): Text = js.native

    def sprite(x: Int = js.native, y: Int = js.native, key: String = js.native, frame: Any = js.native, group: Group[_] = js.native): Sprite = js.native

    def group(parent: Any = js.native,
              name: String = js.native,
              addToStage: Boolean = js.native,
              enableBody: Boolean = js.native,
              physicsBodyType: Int = js.native): Group[Sprite] = js.native

    def tileSprite(x: Int, y: Int, width: Int, height: Int, key: String, frame: Any = js.native, group: Group[_] = js.native): TileSprite = js.native
  }

  type Graphics = phaser.Graphics
  type Group[T] = phaser.Group[T]
  type Image = phaser.Image
  type Input = phaser.Input
  type InputHandler = phaser.InputHandler
  type Keyboard = phaser.Keyboard
  type Line = phaser.Line
  type Math = phaser.Math
  type Plugin = phaser.Plugin
  type PluginManager = phaser.PluginManager
  type Point = phaser.Point
  type Pointer = phaser.Pointer
  type PointerMode = phaser.PointerMode
  type Polygon = phaser.Polygon
  type QuadTree = phaser.QuadTree
  type Rectangle = phaser.Rectangle
  type RenderTexture = phaser.RenderTexture
  type RoundedRectangle = phaser.RoundedRectangle
  type SinglePad = phaser.SinglePad
  type Signal = phaser.Signal
  type SignalBinding = phaser.SignalBinding
  type Sound = phaser.Sound
  type SoundManager = phaser.SoundManager
  type Sprite = phaser.Sprite
  type State = phaser.State
  type Texture = phaser.Texture
  type Tilemap = phaser.Tilemap
  type TilemapLayer = phaser.TilemapLayer
  type TileSprite = phaser.TileSprite
  type Time = phaser.Time
  type Timer = phaser.Timer
  type TimerEvent = phaser.TimerEvent
  type Tween = phaser.Tween
  type Video = phaser.Video
  type Weapon = phaser.Weapon
  type World = phaser.World

  /**
    * Phaser.Component class references
    */
  @js.native
  @JSName("Component")
  object Component extends js.Object {

    type Angle = phaser.component.Angle
    type Animation = phaser.component.Animation
    type AutoCull = phaser.component.AutoCull
    type Bounds = phaser.component.Bounds
    type BringToTop = phaser.component.BringToTop
    type Core = phaser.component.Core
    type Crop = phaser.component.Crop
    type Delta = phaser.component.Delta
    type Destroy = phaser.component.Destroy
    type FixedToCamera = phaser.component.FixedToCamera
    type Health = phaser.component.Health
    type InCamera = phaser.component.InCamera
    type InputEnabled = phaser.component.InputEnabled
    type InWorld = phaser.component.InWorld

    @js.native
    trait LifeSpan extends js.Object {

      /**
        * A useful flag to control if the Game Object is alive or dead.
        *
        * This is set automatically by the Health components damage method should the object run out of health.
        * Or you can toggle it via your game code.
        *
        * This property is mostly just provided to be used by your game - it doesn't effect rendering or logic updates.
        * However you can use Group.getFirstAlive in conjunction with this property for fast object pooling and recycling.
        */
      var alive: Boolean = js.native

      def kill(): DisplayObject = js.native

      def revive(health: Double = 1): DisplayObject = js.native
    }

    type LoadTexture = phaser.component.LoadTexture
    type Overlap = phaser.component.Overlap
    type PhysicsBody = phaser.component.PhysicsBody
    type Reset = phaser.component.Reset
    type ScaleMinMax = phaser.component.ScaleMinMax
    type Smoothed = phaser.component.Smoothed

  }

  /**
    * Phaser.Utils class references
    */
  @js.native
  @JSName("Physics")
  object Physics extends js.Object {

    type Arcade = phaser.physics.Arcade
    type Box2D = phaser.physics.Box2D
    type Chipmunk = phaser.physics.Chipmunk
    type Matter = phaser.physics.Matter
    type Ninja = phaser.physics.Ninja
    type P2 = phaser.physics.P2

    @js.native
    @JSName("Arcade")
    object Arcade extends js.Object {

      type Body = phaser.physics.arcade.Body

    }

    @js.native
    @JSName("Ninja")
    object Ninja extends js.Object {

      type AABB = phaser.physics.ninja.AABB
      type Body = phaser.physics.ninja.Body

    }

    @js.native
    @JSName("P2")
    object P2 extends js.Object {

      type Material = phaser.physics.p2.Material

    }

  }

  /**
    * Create a new game object for displaying Text.
    *
    * This uses a local hidden Canvas object and renders the type into it. It then makes a texture from this for rendering to the view.
    * Because of this you can only display fonts that are currently loaded and available to the browser: fonts must be pre-loaded.
    * @param game  Current game instance.
    * @param x     X position of the new text object.
    * @param y     Y position of the new text object.
    * @param text  The actual text that will be written.
    * @param style The style properties to be set on the Text.
    */
  @js.native
  @JSName("Text")
  class Text(game: Phaser.Game,
             x: Double,
             y: Double,
             var text: String,
             var style: StyleOptions | RawOptions = js.native) extends Sprite

  /**
    * Phaser.Utils class references
    */
  @js.native
  @JSName("Utils")
  object Utils extends js.Object {

    type ArrayUtils = phaser.utils.ArrayUtils
    type Debug = phaser.utils.Debug
    type Utils = phaser.utils.Utils

  }

}