package io.scalajs.dom.html
package phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * phaser - A fast, free and fun HTML5 Game Framework for Desktop and Mobile web browsers.
  * @version 2.6.2
  * @see [[https://www.npmjs.com/package/phaser]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser")
object Phaser extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Constants
  /////////////////////////////////////////////////////////////////////////////////

  val AUTO: Int = js.native
  val CANVAS: Int = js.native
  val HEADLESS: Int = js.native
  val SPRITE: js.Any = js.native
  val TEXT: js.Any = js.native
  val VERSION: String = js.native
  val VIDEO: Int = js.native
  val WEBGL: Int = js.native

  val ANGLE_UP: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Class References
  /////////////////////////////////////////////////////////////////////////////////

  type Animation = phaser.Animation
  type AnimationManager = phaser.AnimationManager
  type AudioSprite = phaser.AudioSprite
  type BitmapData = phaser.BitmapData
  type BitmapText = phaser.BitmapText
  type Bullet = phaser.Bullet
  type Button = phaser.Button
  type Cache = phaser.Cache
  type Camera = phaser.Camera
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
  type GameObjectCreator = phaser.GameObjectCreator
  type GameObjectFactory = phaser.GameObjectFactory
  type Graphics = phaser.Graphics
  type Group[T] = phaser.Group[T]
  type Image = phaser.Image
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
  type Signal = phaser.Signal
  type SignalBinding = phaser.SignalBinding
  type Sound = phaser.Sound
  type SoundManager = phaser.SoundManager
  type Sprite = phaser.Sprite
  type State = phaser.State
  type Text = phaser.Text
  type Texture = phaser.Texture
  type TileSprite = phaser.TileSprite
  type Time = phaser.Time
  type Timer = phaser.Timer
  type TimerEvent = phaser.TimerEvent
  type Tween = phaser.Tween
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
    type LifeSpan = phaser.component.LifeSpan
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
    @JSName("P2")
    object P2 extends js.Object {

      type Material = phaser.physics.p2.Material

    }

    @js.native
    @JSName("Arcade")
    object Arcade extends js.Object {

      type Body = phaser.physics.arcade.Body

    }

  }

  /**
    * Phaser.Utils class references
    */
  @js.native
  @JSName("Phaser.Utils")
  object Utils extends js.Object {

    type ArrayUtils = phaser.utils.ArrayUtils
    type Debug = phaser.utils.Debug
    type Utils = phaser.utils.Utils

  }

}