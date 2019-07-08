package io.scalajs.dom.html
package phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

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
  type Component = phaser.Component
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
  type GameObjectFactory = phaser.GameObjectFactory
  type Graphics = phaser.Graphics
  type Group[T] = phaser.Group[T]
  type Image = phaser.Image
  type Input = phaser.Input
  type InputHandler = phaser.InputHandler
  type Keyboard = phaser.Keyboard
  type Line = phaser.Line
  type Math = phaser.Math
  type Physics = phaser.Physics
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
  type Text = phaser.Text
  type Texture = phaser.Texture
  type Tilemap = phaser.Tilemap
  type TilemapLayer = phaser.TilemapLayer
  type TileSprite = phaser.TileSprite
  type Time = phaser.Time
  type Timer = phaser.Timer
  type TimerEvent = phaser.TimerEvent
  type Tween = phaser.Tween
  type Utils = phaser.Utils
  type Video = phaser.Video
  type Weapon = phaser.Weapon
  type World = phaser.World

}