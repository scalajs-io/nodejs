package org.scalajs.browser
package phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

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
  val Easing: Easing = js.native
  val Keyboard: Keyboard = js.native
  val Physics: Physics = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Constants
  /////////////////////////////////////////////////////////////////////////////////

  val SPRITE: js.Any = js.native
  val TEXT: js.Any = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Classes
  /////////////////////////////////////////////////////////////////////////////////

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
  @JSName("Camera")
  class Camera(val game: Game,
               val id: Int = 0,
               val x: Double,
               val y: Double,
               val width: Double,
               val height: Double) extends js.Object {

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
  @JSName("Circle")
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
  @JSName("Game")
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
    * A Point object represents a location in a two-dimensional coordinate system, where x represents the horizontal axis
    * and y represents the vertical axis. The following code creates a point at (0,0):
    * {{{ var myPoint = new Phaser.Point(); }}}
    * You can also use them as 2D Vectors and you'll find different vector related methods in this class.
    * @param x The horizontal position of this Point.
    * @param y The vertical position of this Point.
    */
  @js.native
  @JSName("Point")
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
  @JSName("Point")
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
  @JSName("Rectangle")
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

  /**
    * A game has only one world. The world is an abstract place in which all game objects live. It is not bound by stage
    * limits and can be any size. You look into the world via cameras. All game objects live within the world at
    * world-based coordinates. By default a world is created the same size as your Stage.
    * @param game Reference to the current game instance.
    */
  @js.native
  @JSName("World")
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