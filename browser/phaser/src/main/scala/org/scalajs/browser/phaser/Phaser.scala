package org.scalajs.browser
package phaser

import org.scalajs.browser.p2.P2
import org.scalajs.browser.pixijs.PIXI
import org.scalajs.browser.pixijs.PIXI.{DisplayObject, DisplayObjectContainer}
import org.scalajs.dom._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * phaser - A fast, free and fun HTML5 Game Framework for Desktop and Mobile web browsers.
  * @version 2.5.0
  * @see [[https://www.npmjs.com/package/phaser]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser")
object Phaser extends js.Object {
  val AUTO: Int = js.native
  val CANVAS: Int = js.native
  val SPRITE: js.Any = js.native
  val TEXT: js.Any = js.native
  val VERSION: String = js.native
  val VIDEO: Int = js.native
  val WEBGL: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Classes
  /////////////////////////////////////////////////////////////////////////////////

  @js.native
  trait AnimationManager extends js.Object {

    def add(name: String,
            frames: js.Array[_] = js.Array(),
            frameRate: js.UndefOr[Int] = 60,
            loop: js.UndefOr[Boolean] = false,
            useNumericIndex: js.UndefOr[Boolean] = true): Component.Animation = js.native
  }

  @js.native
  trait ArcadePhysics extends js.Object {

    def overlap(object1: Sprite | Group[_] | js.Array[_],
                object2: Sprite | Group[_] | js.Array[_],
                overlapCallback: js.Function2[_, _, _],
                processCallback: Option[js.Function2[_, _, Boolean]],
                callbackContext: Any = this): Unit = js.native

    def moveToObject(displayObject: DisplayObject, destination: Any, speed: Int = 60, maxTime: Long = 0): Double = js.native

  }

  /**
    * Audio Sprites are a combination of audio files and a JSON configuration. The JSON follows the format of that
    * created by https://github.com/tonistiigi/audiosprite.
    * @param game the reference to the current game instance.
    * @param key  the asset key for the sound.
    */
  @js.native
  class AudioSprite(val game: Game, val key: String) extends js.Object {

    /**
      * Is a sound set to autoplay or not?
      */
    var autoplay: Boolean = js.native

    /**
      * If a sound is set to auto play, this holds the marker key of it.
      */
    var autoplayKey: String = js.native

    /**
      * JSON audio atlas object.
      */
    var config: js.Any = js.native

    /**
      * An object containing the Phaser.Sound objects for the Audio Sprite.
      */
    var sounds: js.Any = js.native

    /**
      * Get a sound with the given name.
      * @param marker The name of sound to get.
      * @return The sound instance.
      */
    def get(marker: String): Sound = js.native

    /**
      * Play a sound with the given name.
      * @param marker The name of sound to play
      * @param volume Volume of the sound you want to play. If none is given it will use the volume given to the Sound
      *               when it was created (which defaults to 1 if none was specified).
      * @return This sound instance.
      */
    def play(marker: String, volume: Int): Sound = js.native

    /**
      * Stop a sound with the given name.
      * @param marker The name of sound to stop. If none is given it will stop all sounds in the audio sprite.
      */
    def stop(marker: String): Unit = js.native

  }

  @js.native
  trait BitmapData extends js.Object

  /**
    * A Camera is your view into the game world. It has a position and size and renders only those objects within its field of view.
    * The game automatically creates a single Stage sized camera on boot. Move the camera around the world with Phaser.Camera.x/y
    * @param game   Game reference to the currently running game.
    * @param id     Not being used at the moment, will be when Phaser supports multiple camera
    * @param x      Position of the camera on the X axis
    * @param y      Position of the camera on the Y axis
    * @param width  The width of the view rectangle
    * @param height The height of the view rectangle
    */
  @js.native
  class Camera(val game: Game, val id: Int = 0, var x: Double, var y: Double, var width: Double, var height: Double) extends js.Object {

    /**
      * Camera view.
      * The view into the world we wish to render (by default the game dimensions).
      * The x/y values are in world coordinates, not screen coordinates, the width/height is how many pixels to render.
      * Sprites outside of this view are not rendered if Sprite.autoCull is set to `true`. Otherwise they are always rendered.
      */
    val view: Rectangle = js.native

    /**
      * The Camera is bound to this Rectangle and cannot move outside of it. By default it is enabled and set to the size of the World.
      * The Rectangle can be located anywhere in the world and updated as often as you like. If you don't wish the Camera to be bound
      * at all then set this to null. The values can be anything and are in World coordinates, with 0,0 being the top-left of the world.
      * @return The Rectangle in which the Camera is bounded. Set to null to allow for movement anywhere.
      */
    val bounds: Rectangle = js.native

  }

  /**
    * Creates a new Circle object with the center coordinate specified by the x and y parameters and the diameter
    * specified by the diameter parameter. If you call this function without parameters, a circle with x, y, diameter
    * and radius properties set to 0 is created.
    * @param x        The x coordinate of the center of the circle.
    * @param y        The y coordinate of the center of the circle.
    * @param diameter The diameter of the circle.
    */
  @js.native
  class Circle(var x: Double = 0, var y: Double = 0, var diameter: Double = 0) extends js.Object {

    /**
      * The area of this Circle.
      */
    def area: Double = js.native

    /**
      * The sum of the y and radius properties. Changing the bottom property of a Circle object has no effect on
      * the x and y properties, but does change the diameter. Gets or sets the bottom of the circle.
      */
    var bottom: Double = js.native

    /**
      * Determines whether or not this Circle object is empty. Will return a value of true if the Circle objects
      * diameter is less than or equal to 0; otherwise false. If set to true it will reset all of the Circle objects
      * properties to 0. A Circle object is empty if its diameter is less than or equal to 0. Gets or sets the empty
      * state of the circle.
      */
    var empty: Boolean = js.native

    /**
      * The x coordinate of the leftmost point of the circle. Changing the left property of a Circle object has no
      * effect on the x and y properties. However it does affect the diameter, whereas changing the x value does not
      * affect the diameter property.
      */
    var left: Double = js.native

    /**
      * The length of a line extending from the center of the circle to any point on the circle itself. The same as
      * half the diameter. Gets or sets the radius of the circle.
      */
    var radius: Double = js.native

    /**
      * The x coordinate of the rightmost point of the circle. Changing the right property of a Circle object has no
      * effect on the x and y properties. However it does affect the diameter, whereas changing the x value does not
      * affect the diameter property. Gets or sets the value of the rightmost point of the circle.
      */
    var right: Double = js.native

    /**
      * The sum of the y minus the radius property. Changing the top property of a Circle object has no effect on
      * the x and y properties, but does change the diameter. Gets or sets the top of the circle.
      */
    var top: Double = js.native

    /**
      * The const type of this object.
      */
    def `type`: Double = js.native

  }

  @js.native
  object Component extends js.Object {

    @js.native
    trait Angle extends js.Object

    @js.native
    trait Animation extends js.Object {

      def play(key: String, frameRate: Double = 60, loop: Boolean = false, killOnComplete: Boolean = false): Component.Animation = js.native

    }

    @js.native
    trait AutoCull extends js.Object

    @js.native
    trait Bounds extends js.Object

    @js.native
    trait BringToTop extends js.Object

    @js.native
    trait Core extends js.Object {
      val animations: AnimationManager = js.native
    }

    @js.native
    trait Crop extends js.Object

    @js.native
    trait Delta extends js.Object

    @js.native
    trait Destroy extends js.Object

    @js.native
    trait FixedToCamera extends js.Object

    @js.native
    trait Health extends js.Object

    @js.native
    trait InCamera extends js.Object

    @js.native
    trait InputEnabled extends js.Object

    @js.native
    trait InWorld extends js.Object

    @js.native
    trait LifeSpan extends js.Object {
      var alive: Boolean = js.native

      def kill(): DisplayObject = js.native

      def revive(health: Double = 1): DisplayObject = js.native
    }

    @js.native
    trait LoadTexture extends js.Object

    @js.native
    trait Overlap extends js.Object

    // TODO should this really extend DisplayObject?
    @js.native
    trait PhysicsBody extends DisplayObject {
      //var x: Double = js.native
      //var y: Double = js.native
      var moves: Boolean = js.native
      var velocity: Point = js.native
    }

    @js.native
    trait Reset extends js.Object {
      def reset(x: Double, y: Double, health: Double = 1): DisplayObject = js.native
    }

    @js.native
    trait ScaleMinMax extends js.Object

    @js.native
    trait Smoothed extends js.Object

  }

  @js.native
  class CursorKeys extends js.Object {

    def up: Key = js.native

    def down: Key = js.native

    def left: Key = js.native

    def right: Key = js.native
  }

  @js.native
  object Easing extends js.Object {
    val Linear: Linear = js.native
  }

  /**
    * Creates a Ellipse object. A curve on a plane surrounding two focal points.
    * @param x      The X coordinate of the upper-left corner of the framing rectangle of this ellipse.
    * @param y      The Y coordinate of the upper-left corner of the framing rectangle of this ellipse.
    * @param width  The overall width of this ellipse.
    * @param height The overall height of this ellipse.
    */
  @js.native
  class Ellipse(var x: Double, var y: Double, var width: Double, var height: Double) extends js.Object

  @js.native
  class Game(val width: Int = 800, val height: Int = 600, val renderer: Int = Phaser.AUTO, val name: String = "phaser-game") extends js.Object {
    val load: Loader = js.native
    val state: State = js.native
    val physics: Physics = js.native
    val add: GameObjectFactory = js.native
    val world: World = js.native
    val input: Input = js.native
    val time: Time = js.native
    val rnd: RandomDataGenerator = js.native
  }

  /**
    * A reference to the GameObjectFactory which can be used to add new objects to the World.
    */
  @js.native
  trait GameObjectFactory extends js.Object {

    /////////////////////////////////////////////////////////////////////////////////
    //      Properties
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * A reference to the currently running Game.
      */
    var game: Phaser.Game = js.native

    /**
      * A reference to the game world.
      */
    var world: Phaser.World = js.native

    /////////////////////////////////////////////////////////////////////////////////
    //      Methods
    /////////////////////////////////////////////////////////////////////////////////

    def tween(aliens: DisplayObject): Tween = js.native

    def text(x: Double = 0, y: Double = 0, text: String = "", style: js.Dictionary[_] = null, group: Phaser.Group[_] = null): Phaser.Text = js.native

    def sprite(x: Int = 0, y: Int = 0, key: String = null, frame: Any = null, group: Phaser.Group[_] = null): Phaser.Sprite

    def group(parent: Any = null, name: String = null, addToStage: Boolean = false, enableBody: Boolean = false, physicsBodyType: Int = 0): Phaser.Group[Phaser.Sprite] = js.native

    def tileSprite(x: Int, y: Int, width: Int, height: Int, key: String, frame: Any = null, group: Phaser.Group[_] = null): TileSprite = js.native
  }

  /**
    * A Group is a container for display objects including Sprites and Images.
    *
    * Groups form the logical tree structure of the display/scene graph where local transformations are applied to
    * children. For instance, all children are also moved/rotated/scaled when the group is moved/rotated/scaled.
    *
    * In addition, Groups provides support for fast pooling and object recycling.
    *
    * Groups are also display objects and can be nested as children within other Groups.
    * @param game            A reference to the currently running game.
    * @param parent          The parent Group (or other DisplayObject) that this group will be added to. If undefined/unspecified
    *                        the Group will be added to the Game World; if null the Group will not be added to any parent.
    * @param name            A name for this group. Not used internally but useful for debugging.
    * @param addToStage      If true this group will be added directly to the Game.Stage instead of Game.World.
    * @param enableBody      If true all Sprites created with #create or #createMulitple will have a physics body created on
    *                        them. Change the body type with #physicsBodyType.
    * @param physicsBodyType The physics body type to use when physics bodies are automatically added.
    *                        See #physicsBodyType for values.
    */
  @js.native
  class Group[T](var game: Game, var parent: DisplayObject, var name: String, var addToStage: Boolean, var enableBody: Boolean, var physicsBodyType: Int) extends DisplayObjectContainer {

    /////////////////////////////////////////////////////////////////////////////////
    //      Properties
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * The alive property is useful for Groups that are children of other Groups and need to be included/excluded in
      * checks like forEachAlive.
      */
    var alive: Boolean = js.native

    /////////////////////////////////////////////////////////////////////////////////
    //      Methods
    /////////////////////////////////////////////////////////////////////////////////

    def countLiving(): Int = js.native

    def create(x: Double, y: Double, key: Any = null, frame: Any = null, exists: Boolean = true): T = js.native

    def createMultiple(quantity: Int, key: String, frame: Any = null, exists: Boolean = false): Unit = js.native

    def getFirstAlive(): js.UndefOr[T] = js.native

    def getFirstAlive(createIfNull: Boolean = false, x: Double, y: Double, key: String = null, frame: String | Int = null): js.UndefOr[T] = js.native

    def getFirstExists(exists: Boolean): js.UndefOr[T] = js.native

    def forEach(callback: js.Function1[T, Any], context: Any = this, checkExists: Boolean = false): Unit = js.native

    def forEach(callback: js.Function1[T, Any], context: Any, checkExists: Boolean, args: Any*): Unit = js.native

    def forEachAlive(callback: js.Function1[T, Any], context: Any = this): Unit = js.native

    def forEachAlive(callback: js.Function1[T, Any], context: Any, args: Any*): Unit = js.native

    def removeAll(destroy: Boolean = false, silent: Boolean = false): Unit = js.native

    def setAll(key: String, value: Any, checkAlive: Boolean = false, checkVisible: Boolean = false, operation: Int = 0, force: Boolean = false): Unit = js.native

  }

  @js.native
  trait Input extends js.Object {
    val keyboard: Keyboard = js.native
    val onTap: Signal = js.native
  }

  @js.native
  class Key extends js.Object {
    def isDown: Boolean = js.native
  }

  @js.native
  trait Keyboard extends js.Object {
    val SPACEBAR: Int = js.native

    def addKey(code: Int): Key = js.native

    def createCursorKeys(): CursorKeys = js.native
  }

  @js.native
  object Keyboard extends Keyboard

  /**
    * Creates a new Line object with a start and an end point.
    * @param x1 The x coordinate of the start of the line.
    * @param y1 The y coordinate of the start of the line.
    * @param x2 The x coordinate of the end of the line.
    * @param y2 The y coordinate of the end of the line.
    */
  @js.native
  class Line(var x1: Double, var y1: Double, var x2: Double, var y2: Double) extends js.Object

  @js.native
  trait Linear extends js.Object {
    val None: js.Function1[_, _] = js.native
  }

  @js.native
  trait Loader extends js.Object {

    def image(key: String, url: String): Unit = js.native

    def spritesheet(key: String, url: String, frameWidth: Int, frameHeight: Int, frameMax: Int = -1, margin: Int = 0, spacing: Int = 0): Unit = js.native

  }

  /**
    * A collection of useful mathematical functions.
    * These are normally accessed through [[Game.math]].
    */
  @js.native
  object Math extends js.Object {

    /**
      * Twice PI.
      */
    val PI2: Double = js.native

  }

  @js.native
  trait Physics extends js.Object {
    val ARCADE: Int = js.native
    val arcade: ArcadePhysics = js.native

    def enable(player: Sprite, system: Int, debug: Boolean = false): Unit = js.native

    def startSystem(systemId: Int): Unit = js.native
  }

  @js.native
  object Physics extends Physics {

    val P2: p2.P2 = js.native

  }

  /**
    * A Point object represents a location in a two-dimensional coordinate system, where x represents the horizontal axis
    * and y represents the vertical axis. The following code creates a point at (0,0):
    * {{{ var myPoint = new Phaser.Point(); }}}
    * You can also use them as 2D Vectors and you'll find different vector related methods in this class.
    * @param x The horizontal position of this Point.
    * @param y The vertical position of this Point.
    */
  @js.native
  class Point(var x: Double, var y: Double) extends js.Object {

    /**
      * Adds the coordinates of two points together to create a new point.
      * @param x The value to add to Point.x.
      * @param y The value to add to Point.y.
      * @return This Point object. Useful for chaining method calls.
      */
    def add(x: Double, y: Double): this.type = js.native

    /**
      * Returns the angle between this Point object and another object with public x and y properties.
      * @param a         The object to get the angle from this Point to.
      * @param asDegrees Is the given angle in radians (false) or degrees (true)?
      * @return The angle between the two objects.
      */
    def angle(a: js.Any, asDegrees: Boolean): this.type = js.native

    /**
      * Math.ceil() both the x and y properties of this Point.
      * @return This Point object.
      */
    def ceil(): this.type = js.native

    /**
      * Clamps this Point object values to be between the given min and max.
      * @param min The minimum value to clamp this Point to.
      * @param max The maximum value to clamp this Point to.
      * @return This Point object.
      */
    def clamp(min: Double, max: Double): this.type = js.native

    /**
      * Clamps the x value of this Point to be between the given min and max.
      * @param min The minimum value to clamp this Point to.
      * @param max The maximum value to clamp this Point to.
      * @return This Point object.
      */
    def clampX(min: Double, max: Double): this.type = js.native

    /**
      * Clamps the y value of this Point to be between the given min and max.
      * @param min The minimum value to clamp this Point to.
      * @param max The maximum value to clamp this Point to.
      * @return This Point object.
      */
    def clampY(min: Double, max: Double): this.type = js.native

    /**
      * Creates a copy of the given Point.
      * @param output Optional Point object. If given the values will be set into this object, otherwise a brand new
      *               Point object will be created and returned.
      * @return The new Point object.
      */
    def clone(output: Point = null): Point = js.native

    /**
      * Copies the x and y properties from any given object to this Point.
      * @param source The object to copy from.
      * @return This Point object.
      */
    def copyFrom(source: js.Any): this.type = js.native

    /**
      * Copies the x and y properties from this Point to any given object.
      * @param dest The object to copy to.
      * @return The dest object.
      */
    def copyTo(dest: js.Object): js.Object = js.native

    /**
      * The cross product of this and another Point object.
      * @param a The Point object to get the cross product combined with
      * @return The result.
      */
    def cross(a: Point): Double = js.native

    /**
      * Returns the distance of this Point object to the given object (can be a Circle, Point or anything with x/y properties)
      * @param dest  The target object. Must have visible x and y properties that represent the center of the object.
      * @param round Round the distance to the nearest integer (default false).
      * @return The distance between this Point object and the destination Point object.
      */
    def distance(dest: js.Object, round: Boolean = false): Double = js.native

    /**
      * Divides Point.x and Point.y by the given x and y values.
      * @param x The value to divide Point.x by.
      * @param y The value to divide Point.x by.
      * @return This Point object. Useful for chaining method calls.
      */
    def divide(x: Double, y: Double): this.type = js.native

    /**
      * The dot product of this and another Point object.
      * @param a The Point object to get the dot product combined with this Point.
      * @return The result.
      */
    def dot(a: Point): Double = js.native

    /**
      * Determines whether the given objects x/y values are equal to this Point object.
      * @param a The object to compare with this Point.
      * @return A value of true if the x and y points are equal, otherwise false.
      */
    def equals(a: js.Any): Boolean = js.native

    /**
      * Math.floor() both the x and y properties of this Point.
      * @return This Point object.
      */
    def floor(): this.type = js.native

    /**
      * Calculates the length of the Point object.
      * @return The length of the Point.
      */
    def getMagnitude(): Double = js.native

    /**
      * Calculates the length squared of the Point object.
      * @return The {{{ length ^ 2 }}} of the Point.
      */
    def getMagnitudeSq(): Double = js.native

    /**
      * Inverts the x and y values of this Point
      * @return This Point object.
      */
    def invert(): this.type = js.native

    /**
      * Determine if this point is at 0,0.
      * @return True if this Point is 0,0, otherwise false.
      */
    def isZero(): Boolean = js.native

    /**
      * Multiplies Point.x and Point.y by the given x and y values. Sometimes known as Scale.
      * @param x The value to multiply Point.x by.
      * @param y The value to multiply Point.x by.
      * @return This Point object. Useful for chaining method calls.
      */
    def multiply(x: Double, y: Double): this.type = js.native

    /**
      * Alters the Point object so that its length is 1, but it retains the same direction.
      * @return This Point object.
      */
    def normalize(): this.type = js.native

    /**
      * Right-hand normalize (make unit length) this Point.
      * @return This Point object.
      */
    def normalRightHand(): this.type = js.native

    /**
      * Make this Point perpendicular (90 degrees rotation)
      * @return This Point object.
      */
    def perp(): this.type = js.native

    /**
      * Rotates this Point around the x/y coordinates given to the desired angle.
      * @param x         The x coordinate of the anchor point.
      * @param y         The y coordinate of the anchor point.
      * @param angle     The angle in radians (unless asDegrees is true) to rotate the Point to.
      * @param asDegrees Is the given angle in radians (false) or degrees (true)?
      * @param distance  An optional distance constraint between the Point and the anchor.
      * @return The modified point object.
      */
    def rotate(x: Double, y: Double, angle: Double, asDegrees: Boolean, distance: Double): this.type = js.native

    /**
      * Make this Point perpendicular (-90 degrees rotation)
      * @return This Point object.
      */
    def rperp(): this.type = js.native

    /**
      * Sets the x and y values of this Point object to the given values. If you omit the y value then the x value
      * will be applied to both, for example: Point.set(2) is the same as Point.set(2, 2)
      * @param x The horizontal value of this point.
      * @param y The vertical value of this point. If not given the x value will be used in its place.
      * @return This Point object. Useful for chaining method calls.
      */
    def set(x: Double, y: Double = js.native): this.type = js.native

    /**
      * Alters the length of the Point without changing the direction.
      * @param magnitude The desired magnitude of the resulting Point.
      * @return This Point object.
      */
    def setMagnitude(magnitude: Double): this.type = js.native

    /**
      * Sets the x and y values of this Point object to the given values. If you omit the y value then the x value will
      * be applied to both, for example: Point.setTo(2) is the same as Point.setTo(2, 2)
      * @param x The horizontal value of this point.
      * @param y Optional: The vertical value of this point. If not given the x value will be used in its place.
      * @return This Point object. Useful for chaining method calls.
      */
    def setTo(x: Double, y: Double = js.native): this.type = js.native

    /**
      * Subtracts the given x and y values from this Point.
      * @param x The value to subtract from Point.x.
      * @param y The value to subtract from Point.y.
      * @return This Point object. Useful for chaining method calls.
      */
    def subtract(x: Double, y: Double): this.type = js.native

  }

  /**
    * Point Singleton
    */
  @js.native
  object Point extends js.Object {

    /**
      * Adds the coordinates of two points together to create a new point.
      * @param a   The first Point object.
      * @param b   The second Point object.
      * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
      * @return The new Point object.
      */
    def add(a: Point, b: Point, out: Point = null): Point = js.native

    /**
      * Returns the angle between two Point objects.
      * @param a The first Point object.
      * @param b The second Point object.
      * @return The angle between the two Points.
      */
    def angle(a: Point, b: Point): Double = js.native

    /**
      * Calculates centroid (or midpoint) from an array of points. If only one point is provided, that point is returned.
      * @param points The array of one or more points.
      * @param out    Optional Point to store the value in, if not supplied a new Point object will be created.
      * @return The new Point object.
      */
    def centroid(points: js.Array[Point], out: Point = null): Point = js.native

    /**
      * Returns the euclidian distance of this Point object to the given object (can be a Circle, Point or anything
      * with x/y properties).
      * @param a     The target object. Must have visible x and y properties that represent the center of the object.
      * @param b     The target object. Must have visible x and y properties that represent the center of the object.
      * @param round Round the distance to the nearest integer.
      * @return The distance between this Point object and the destination Point object.
      */
    def distance(a: Point, b: Point, round: Boolean = false): Double = js.native

    /**
      * Divides the coordinates of two points to create a new point.
      * @param a   The first Point object.
      * @param b   The second Point object.
      * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
      * @return The new Point object.
      */
    def divide(a: Point, b: Point, out: Point = null): Point = js.native

    /**
      * Determines whether the two given Point objects are equal. They are considered equal if they have the same x and y values.
      * @param a The first Point object.
      * @param b The second Point object.
      * @return A value of true if the Points are equal, otherwise false.
      */
    def equals(a: Point, b: Point): Boolean = js.native

    /**
      * Interpolates the two given Points, based on the f value (between 0 and 1) and returns a new Point.
      * @param a   The first Point object.
      * @param b   The second Point object.
      * @param f   The level of interpolation between the two points. Indicates where the new point will be, along the
      *            line between pt1 and pt2. If f=1, pt1 is returned; if f=0, pt2 is returned.
      * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
      * @return The new Point object.
      */
    def interpolate(a: Point, b: Point, f: Double, out: Point = null): Point = js.native

    /**
      * Multiplies the coordinates of two points to create a new point.
      * @param a   The first Point object.
      * @param b   The second Point object.
      * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
      * @return The new Point object.
      */
    def multiply(a: Point, b: Point, out: Point = null): Point = js.native

    /**
      * Adds two 2D Points together and multiplies the result by the given scalar.
      * @param a   The first Point object.
      * @param b   The second Point object.
      * @param s   The scaling value.
      * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
      * @return The new Point object.
      */
    def multiplyAdd(a: Point, b: Point, s: Double, out: Point = null): Point = js.native

    /**
      * Creates a negative Point.
      * @param a   The first Point object.
      * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
      * @return The new Point object.
      */
    def negative(a: Point, out: Point = null): Point = js.native

    /**
      * Normalize (make unit length) a Point.
      * @param a   The Point object.
      * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
      * @return The new Point object.
      */
    def normalize(a: Point, out: Point = null): Point = js.native

    /**
      * Right-hand normalize (make unit length) a Point.
      * @param a   The Point object.
      * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
      * @return The new Point object.
      */
    def normalRightHand(a: Point, out: Point = null): Point = js.native

    /**
      * Parses an object for x and/or y properties and returns a new Phaser.Point with matching values. If the object
      * doesn't contain those properties a Point with x/y of zero will be returned.
      * @param obj   The object to parse.
      * @param xProp The property used to set the Point.x value.
      * @param yProp The property used to set the Point.y value.
      * @return The new Point object.
      */
    def parse(obj: js.Object, xProp: String, yProp: String): Point = js.native

    /**
      * Return a perpendicular vector (90 degrees rotation)
      * @param a   The Point object.
      * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
      * @return The new Point object.
      */
    def perp(a: Point, out: Point = null): Point = js.native

    /**
      * Project two Points onto another Point.
      * @param a   The first Point object.
      * @param b   The second Point object.
      * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
      * @return The new Point object.
      */
    def project(a: Point, b: Point, out: Point = null): Point = js.native

    /**
      * Project two Points onto a Point of unit length.
      * @param a   The first Point object.
      * @param b   The second Point object.
      * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
      * @return The new Point object.
      */
    def projectUnit(a: Point, b: Point, out: Point = null): Point = js.native

    /**
      * Rotates a Point object, or any object with exposed x/y properties, around the given coordinates by the angle
      * specified. If the angle between the point and coordinates was 45 deg and the angle argument is 45 deg then the
      * resulting angle will be 90 deg, as the angle argument is added to the current angle. The distance allows you to
      * specify a distance constraint for the rotation between the point and the coordinates. If none is given the
      * distance between the two is calculated and used.
      * @param a         The Point object to rotate.
      * @param x         The x coordinate of the anchor point
      * @param y         The y coordinate of the anchor point
      * @param angle     The angle in radians (unless asDegrees is true) to rotate the Point by.
      * @param asDegrees Is the given angle in radians (false) or degrees (true)?
      * @param distance  An optional distance constraint between the Point and the anchor.
      * @return The modified point object.
      */
    def rotate(a: Point, x: Double, y: Double, angle: Boolean, asDegrees: Double, distance: Double): Point = js.native

    /**
      * Return a perpendicular vector (-90 degrees rotation)
      * @param a   The Point object.
      * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
      * @return The new Point object.
      */
    def rperp(a: Point, out: Point = null): Point = js.native

    /**
      * Subtracts the coordinates of two points to create a new point.
      * @param a   The first Point object.
      * @param b   The second Point object.
      * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
      * @return The new Point object.
      */
    def subtract(a: Point, b: Point, out: Point = null): Point = js.native

  }

  @js.native
  class Polygon(val points: js.Array[Point | js.Array[Double]]) extends js.Object

  @js.native
  trait RandomDataGenerator extends js.Object {
    def integerInRange(min: Int, max: Int): Int = js.native
  }

  @js.native
  trait RenderTexture extends js.Object

  /**
    * Creates a new Rectangle object with the top-left corner specified by the x and y parameters and with the specified
    * width and height parameters. If you call this function without parameters, a Rectangle with x, y, width, and height
    * properties set to 0 is created.
    * @param x      The x coordinate of the top-left corner of the Rectangle.
    * @param y      The y coordinate of the top-left corner of the Rectangle.
    * @param width  The width of the Rectangle. Should always be either zero or a positive value.
    * @param height The height of the Rectangle. Should always be either zero or a positive value.
    */
  @js.native
  class Rectangle(var x: Int, var y: Int, var width: Int, var height: Int) extends js.Object {

    /**
      * The sum of the y and height properties. Changing the bottom property of a Rectangle object has no effect on
      * the x, y and width properties, but does change the height property.
      */
    var bottom: Double = js.native

    /**
      * The location of the Rectangles bottom left corner as a Point object. Gets or sets the location of the Rectangles
      * bottom left corner as a Point object.
      */
    var bottomLeft: Point = js.native

    /**
      * The location of the Rectangles bottom right corner as a Point object. Gets or sets the location of the Rectangles
      * bottom right corner as a Point object.
      */
    var bottomRight: Point = js.native

    /**
      * The x coordinate of the center of the Rectangle.
      */
    var centerX: Double = js.native

    /**
      * The y coordinate of the center of the Rectangle.
      */
    var centerY: Double = js.native

    /**
      * Determines whether or not this Rectangle object is empty. A Rectangle object is empty if its width or height is
      * less than or equal to 0. If set to true then all of the Rectangle properties are set to 0. Gets or sets the
      * Rectangles empty state.
      */
    var empty: Boolean = js.native

    /**
      * Half of the height of the Rectangle.
      */
    def halfHeight: Double = js.native

    /**
      * Half of the width of the Rectangle.
      */
    def halfWidth: Double = js.native

    /**
      * The x coordinate of the left of the Rectangle. Changing the left property of a Rectangle object has no effect
      * on the y and height properties. However it does affect the width property, whereas changing the x value does
      * not affect the width property.
      */
    var left: Double = js.native

    /**
      * The perimeter size of the Rectangle. This is the sum of all 4 sides.
      */
    def perimeter: Double = js.native

    /**
      * A random value between the left and right values (inclusive) of the Rectangle.
      */
    var randomX: Double = js.native

    /**
      * A random value between the top and bottom values (inclusive) of the Rectangle.
      */
    var randomY: Double = js.native

    /**
      * The sum of the x and width properties. Changing the right property of a Rectangle object has no effect on
      * the x, y and height properties, however it does affect the width property.
      */
    var right: Double = js.native

    /**
      * The y coordinate of the top of the Rectangle. Changing the top property of a Rectangle object has no effect on
      * the x and width properties. However it does affect the height property, whereas changing the y value does not
      * affect the height property.
      */
    var top: Double = js.native

    /**
      * The location of the Rectangles top left corner as a Point object.
      */
    var topLeft: Point = js.native

    /**
      * The location of the Rectangles top right corner as a Point object. The location of the Rectangles top left
      * corner as a Point object.
      */
    var topRight: Point = js.native

    /**
      * The const type of this object.
      */
    def `type`: Double = js.native

    /**
      * The volume of the Rectangle derived from width * height.
      */
    def volume: Double = js.native

  }

  @js.native
  object Rectangle extends js.Object {

    /**
      * @param a      The Rectangle object.
      * @param output Optional: Rectangle object. If given the values will be set into the object, otherwise a brand new
      *               Rectangle object will be created and returned.
      * @return a new Rectangle object with the same values for the x, y, width, and height properties as the original
      *         Rectangle object.
      */
    def clone(a: Rectangle, output: Rectangle = js.native): this.type = js.native

  }

  /**
    * The Rounded Rectangle object is an area defined by its position and has nice rounded corners, as indicated by its
    * top-left corner point (x, y) and by its width and its height.
    * @param x      The x coordinate of the top-left corner of the Rectangle.
    * @param y      The y coordinate of the top-left corner of the Rectangle.
    * @param width  The width of the Rectangle. Should always be either zero or a positive value.
    * @param height The height of the Rectangle. Should always be either zero or a positive value.
    * @param radius Controls the radius of the rounded corners.
    */
  @js.native
  class RoundedRectangle(x: Int, y: Int, width: Int, height: Int, radius: Int) extends js.Object {

    /**
      * The const type of this object.
      */
    def `type`: Int = js.native

    /**
      * @return a new RoundedRectangle object with the same values for the x, y, width, height and radius properties
      *         as this RoundedRectangle object.
      */
    override def clone(): this.type = js.native

    /**
      * Determines whether the specified coordinates are contained within the region defined by this Rounded Rectangle object.
      * @param x The x coordinate of the point to test.
      * @param y The y coordinate of the point to test.
      * @return A value of true if the RoundedRectangle Rectangle object contains the specified point; otherwise false.
      */
    def contains(x: Int, y: Int): Boolean = js.native

  }

  @js.native
  trait Signal extends js.Object {

    def addOnce(listener: js.ThisFunction0[_, _], listenerContext: Any, priority: Int, args: Any*): SignalBinding = js.native

    def addOnce(listener: js.ThisFunction0[_, _], listenerContext: Any = this, priority: Int = 0): SignalBinding = js.native

    def add(listener: js.ThisFunction0[_, _], listenerContext: Any, priority: Int, args: Any*): SignalBinding = js.native

    def add(listener: js.ThisFunction0[_, _], listenerContext: Any = this, priority: Int = 0): SignalBinding = js.native
  }

  @js.native
  trait SignalBinding extends js.Object

  /**
    * The Sound class constructor.
    * @param game   Reference to the current game instance.
    * @param key    Asset key for the sound.
    * @param volume Default value for the volume, between 0 and 1.
    * @param loop   Whether or not the sound will loop.
    */
  @js.native
  class Sound(val game: Game, val key: String, val volume: Int = 1, val loop: Boolean = false) extends js.Object

  /**
    * The Sound Manager is responsible for playing back audio via either the Legacy HTML Audio tag or via Web Audio if
    * the browser supports it. Note: On Firefox 25+ on Linux if you have media.gstreamer disabled in about:config then
    * it cannot play back mp3 or m4a files. The audio file type and the encoding of those files are extremely important.
    * Not all browsers can play all audio formats. There is a good guide to what's supported here: http://hpr.dogphilosophy.net/test/
    *
    * If you are reloading a Phaser Game on a page that never properly refreshes (such as in an AngularJS project) then
    * you will quickly run out of AudioContext nodes. If this is the case create a global var called PhaserGlobal on the
    * window object before creating the game. The active AudioContext will then be saved to window.PhaserGlobal.audioContext
    * when the Phaser game is destroyed, and re-used when it starts again.
    *
    * Mobile warning: There are some mobile devices (certain iPad 2 and iPad Mini revisions) that cannot play 48000 Hz audio.
    * When they try to play the audio becomes extremely distorted and buzzes, eventually crashing the sound system. The
    * solution is to use a lower encoding rate such as 44100 Hz. Sometimes the audio context will be created with a
    * sampleRate of 48000. If this happens and audio distorts you should re-create the context.
    * @param game the reference to the current game instance.
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  class SoundManager(val game: Game) extends js.Object {

    /////////////////////////////////////////////////////////////////////////////////
    //      Properties
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * The number of audio channels to use in playback (default: 32).
      */
    var channels: Int = js.native

    /**
      * Used in conjunction with Sound.externalNode this allows you to stop a Sound node being connected to the SoundManager
      * master gain node (default: true).
      */
    var connectToMaster: Boolean = js.native

    /**
      * The AudioContext being used for playback.
      */
    var context: AudioContext = js.native

    /**
      * Gets or sets the muted state of the SoundManager. This effects all sounds in the game.
      */
    var mute: Boolean = js.native

    /**
      * True if audio been disabled via the PhaserGlobal (useful if you need to use a 3rd party audio library) or the
      * device doesn't support any audio.
      */
    var muteOnPause: Boolean = js.native

    /**
      * True if audio been disabled via the PhaserGlobal (useful if you need to use a 3rd party audio library) or the
      * device doesn't support any audio.
      */
    var noAudio: Boolean = js.native

    /**
      * This signal is dispatched when the SoundManager is globally un-muted, either directly via game code or as a result
      * of the game resuming from a pause.
      */
    var onMute: Phaser.Signal = js.native

    /**
      * The event dispatched when a sound decodes (typically only for mp3 files)
      */
    var onSoundDecode: Phaser.Signal = js.native

    /**
      * This signal is dispatched when the SoundManager is globally un-muted, either directly via game code or as a result
      * of the game resuming from a pause.
      */
    var onUnMute: Phaser.Signal = js.native

    /**
      * This signal is dispatched whenever the global volume changes. The new volume is passed as the only parameter to your callback.
      */
    var onVolumeChange: Phaser.Signal = js.native

    /**
      * true if the audio system is currently locked awaiting a touch event.
      */
    var touchLocked: Boolean = js.native

    /**
      * True the SoundManager and device are both using the Audio tag instead of Web Audio.
      */
    def usingAudioTag: Boolean = js.native

    /**
      * True the SoundManager and device are both using Web Audio.
      */
    def usingWebAudio: Boolean = js.native

    /**
      * Gets or sets the global volume of the SoundManager, a value between 0 and 1. The value given is clamped to the range 0 to 1.
      */
    var volume: Int = js.native

    /////////////////////////////////////////////////////////////////////////////////
    //      Methods
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * Adds a new Sound into the SoundManager.
      * @param key     Asset key for the sound.
      * @param volume  Default value for the volume.
      * @param loop    Whether or not the sound will loop.
      * @param connect Controls if the created Sound object will connect to the master gainNode of the SoundManager when
      *                running under WebAudio.
      * @return The new sound instance.
      */
    def add(key: String, volume: Int = js.native, loop: Boolean = js.native, connect: Boolean = js.native): Sound = js.native

    /**
      * Adds a new AudioSprite into the SoundManager.
      * @param key Asset key for the sound.
      * @return The new AudioSprite instance.
      */
    def addSprite(key: String): Phaser.AudioSprite = js.native

    /**
      * This member is internal (protected) and may be modified or removed in the future.
      * Internal: This member is internal (protected) and may be modified or removed in the future.
      */
    protected def boot(): Unit = js.native

    /**
      * Decode a sound by its asset key.
      * @param key   Assets key of the sound to be decoded.
      * @param sound Optional: Its buffer will be set to decoded data.
      */
    def decode(key: String, sound: Sound = js.native): Unit = js.native

    /**
      * Stops all the sounds in the game, then destroys them and finally clears up any callbacks.
      */
    def destroy(): Unit = js.native

    /**
      * Pauses all the sounds in the game.
      */
    def pauseAll(): Unit = js.native

    /**
      * Adds a new Sound into the SoundManager and starts it playing.
      * @param key    Asset key for the sound.
      * @param volume Optional: Default value for the volume (default: 1).
      * @param loop   Optional: Whether or not the sound will loop (default: false).
      * @return The new sound instance.
      */
    def play(key: String, volume: Int = js.native, loop: Boolean = js.native): Sound = js.native

    /**
      * Removes a Sound from the SoundManager. The removed Sound is destroyed before removal.
      * @param sound The sound object to remove.
      * @return True if the sound was removed successfully, otherwise false.
      */
    def remove(sound: Sound): Boolean = js.native

    /**
      * Removes all Sounds from the SoundManager that have an asset key matching the given value. The removed Sounds
      * are destroyed before removal.
      * @param key The key to match when removing sound objects.
      * @return The number of matching sound objects that were removed.
      */
    def removeByKey(key: String): Int = js.native

    /**
      * Resumes every sound in the game.
      */
    def resumeAll(): Unit = js.native

    /**
      * This method allows you to give the SoundManager a list of Sound files, or keys, and a callback. Once all of the
      * Sound files have finished decoding the callback will be invoked. The amount of time spent decoding depends on the
      * codec used and file size. If all of the files given have already decoded the callback is triggered immediately.
      * @param files           An array containing either Phaser.Sound objects or their key strings as found in the Phaser.Cache.
      * @param callback        The callback which will be invoked once all files have finished decoding.
      * @param callbackContext The context in which the callback will run.
      */
    def setDecodedCallback(files: String | js.Array[String], callback: js.Function, callbackContext: js.Any): Unit = js.native

    /**
      * Sets the Input Manager touch callback to be SoundManager.unlock. Required for iOS audio device unlocking.
      * Mostly just used internally.
      */
    def setTouchLock(): Unit = js.native

    /**
      * Stops all the sounds in the game.
      */
    def stopAll(): Unit = js.native

    /**
      * Enables the audio, usually after the first touch.
      */
    def unlock(): Boolean = js.native

    /**
      * Updates every sound in the game, checks for audio unlock on mobile and monitors the decoding watch list.
      * Internal: This member is internal (protected) and may be modified or removed in the future.
      */
    protected def update(): Unit = js.native

  }

  /**
    * Sprites are the lifeblood of your game, used for nearly everything visual.
    * At its most basic a Sprite consists of a set of coordinates and a texture that is rendered to the canvas.
    * They also contain additional properties allowing for physics motion (via Sprite.body), input handling (via Sprite.input),
    * events (via Sprite.events), animation (via Sprite.animations), camera culling and more. Please see the Examples for use cases.
    */
  @js.native
  class Sprite(val game: Game, x0: Double, y0: Double, val key: String | RenderTexture | BitmapData | Texture, val frame: String | Int)
    extends PIXI.Sprite with Component.Core with Component.Angle with Component.Animation with Component.AutoCull with Component.Bounds
      with Component.BringToTop with Component.Crop with Component.Delta with Component.Destroy with Component.FixedToCamera
      with Component.Health with Component.InCamera with Component.InputEnabled with Component.InWorld with Component.LifeSpan
      with Component.LoadTexture with Component.Overlap with Component.PhysicsBody with Component.Reset with Component.ScaleMinMax
      with Component.Smoothed {

    var body: Component.PhysicsBody = js.native

  }

  @js.native
  trait State extends js.Object {

    def add(name: String, state: GameState): Unit = js.native

    def start(name: String): Unit = js.native
  }

  @js.native
  trait Text extends Sprite {
    var text: String = js.native
  }

  @js.native
  trait TileSprite extends js.Object {
    val tilePosition: Phaser.Point = js.native
  }

  @js.native
  trait Time extends js.Object {
    val now: Double = js.native
  }

  @js.native
  trait Texture extends js.Object

  @js.native
  trait Tween extends js.Object {

    def to(properties: js.Dictionary[_],
           duration: Int = 1000,
           ease: Any = null,
           autoStart: Boolean = false,
           delay: Int = 0,
           repeat: Int = 0,
           yoyo: Boolean = false): Tween = js.native

    def onLoop: Phaser.Signal = js.native
  }

  /**
    * A game has only one world. The world is an abstract place in which all game objects live. It is not bound by stage
    * limits and can be any size. You look into the world via cameras. All game objects live within the world at
    * world-based coordinates. By default a world is created the same size as your Stage.
    * @param game Reference to the current game instance.
    */
  @js.native
  class World(val game: Game) extends js.Object {

    /**
      * The alive property is useful for Groups that are children of other Groups and need to be included/excluded in
      * checks like forEachAlive.
      */
    var alive: Boolean = js.native

    /**
      * The x coordinate of the center of the Rectangle.
      */
    var centerX: Double = js.native

    /**
      * The y coordinate of the center of the Rectangle.
      */
    var centerY: Double = js.native

    /**
      * The height of the Rectangle. This value should never be set to a negative.
      */
    var height: Double = js.native

    /**
      * The width of the Rectangle. This value should never be set to a negative.
      */
    var width: Double = js.native

  }

}