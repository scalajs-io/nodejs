package io.scalajs.dom.html.phaser

import io.scalajs.JsNumber

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * The Weapon Plugin provides the ability to easily create a bullet pool and manager.
  *
  * Weapons fire Phaser.Bullet objects, which are essentially Sprites with a few extra properties.
  * The Bullets are enabled for Arcade Physics. They do not currently work with P2 Physics.
  *
  * The Bullets are created inside of Weapon.bullets, which is a Phaser.Group instance. Anything you
  * can usually do with a Group, such as move it around the display list, iterate it, etc can be done
  * to the bullets Group too.
  *
  * Bullets can have textures and even animations. You can control the speed at which they are fired,
  * the firing rate, the firing angle, and even set things like gravity for them.
  *
  * A small example, assumed to be running from within a Phaser.State create method.
  * @param game   A reference to the current [[Phaser.Game]] instance.
  * @param parent The Phaser Plugin Manager which looks after this plugin.
  * @see http://phaser.io/docs/2.6.2/Phaser.Weapon.html
  */
@js.native
@JSName("Phaser.Weapon")
class Weapon(var game: Phaser.Game, val parent: Phaser.PluginManager) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Should the bullet pool run out of bullets (i.e. they are all in flight) then this
    * boolean controls if the Group will create a brand new bullet object or not.
    */
  var autoExpandBulletsGroup: Boolean = js.native

  /**
    * Will this weapon auto fire? If set to true then a new bullet will be fired based on the `fireRate` value.
    */
  var autofire: Boolean = js.native

  /**
    * This Rectangle defines the bounds that are used when determining if a Bullet should be killed or not.
    * It's used in combination with Weapon.bulletKillType when that is set to either Phaser.Weapon.KILL_WEAPON_BOUNDS
    * or Phaser.Weapon.KILL_STATIC_BOUNDS. If you are not using either of these kill types then the bounds are ignored.
    * If you are tracking a Sprite or Point then the bounds are centered on that object every frame.
    */
  var bounds: Phaser.Rectangle = js.native

  /**
    * The string based name of the animation that the Bullet will be given on launch.
    * This is set via Weapon.addBulletAnimation.
    */
  var bulletAnimation: String = js.native

  /**
    * The Class of the bullets that are launched by this Weapon. Defaults Phaser.Bullet, but can be
    * overridden before calling createBullets and set to your own class type.
    */
  var bulletClass: js.Object = js.native

  /**
    * Should bullets collide with the World bounds or not?
    */
  var bulletCollideWorldBounds: Boolean = js.native

  /**
    * The Texture Frame that the Bullets use when rendering.
    * Changing this has no effect on bullets in-flight, only on newly spawned bullets.
    */
  var bulletFrame: String | Int = js.native

  /**
    * If you've added a set of frames via Weapon.setBulletFrames then you can optionally
    * chose for each Bullet fired to use the next frame in the set. The frame index is then
    * advanced one frame until it reaches the end of the set, then it starts from the start
    * again. Cycling frames like this allows you to create varied bullet effects via
    * sprite sheets.
    */
  var bulletFrameCycle: Boolean = js.native

  /**
    * If you've added a set of frames via Weapon.setBulletFrames then you can optionally
    * chose for each Bullet fired to pick a random frame from the set.
    */
  var bulletFrameRandom: Boolean = js.native

  /**
    * This is the amount of gravity added to the Bullets physics body when fired.
    * Gravity is expressed in pixels / second / second.
    */
  var bulletGravity: Phaser.Point = js.native

  /**
    * When a Bullet is fired it can optionally inherit the velocity of the `trackedSprite` if set.
    */
  var bulletInheritSpriteSpeed: Boolean = js.native

  /**
    * If you've set `bulletKillType` to Phaser.[[Weapon.KILL_DISTANCE]] this controls the distance
    * the Bullet can travel before it is automatically killed. The distance is given in pixels.
    */
  var bulletKey: String = js.native

  /**
    * If you've set bulletKillType to Phaser.[[Weapon.KILL_DISTANCE]] this controls the distance
    * the Bullet can travel before it is automatically killed. The distance is given in pixels.
    */
  var bulletKillDistance: Double = js.native

  /**
    * This controls how the bullets will be killed. The default is Phaser.Weapon.KILL_WORLD_BOUNDS.
    *
    * There are 7 different "kill types" available:
    * @see Phaser.[[Weapon.KILL_NEVER]]
    * @see Phaser.[[Weapon.KILL_LIFESPAN]]
    * @see Phaser.[[Weapon.KILL_DISTANCE]]
    * @see Phaser.[[Weapon.KILL_WEAPON_BOUNDS]]
    * @see Phaser.[[Weapon.KILL_CAMERA_BOUNDS]]
    * @see Phaser.[[Weapon.KILL_WORLD_BOUNDS]]
    * @see Phaser.[[Weapon.KILL_STATIC_BOUNDS]]
    */
  var bulletKillType: Int = js.native

  /**
    * If you've set `bulletKillType` to Phaser.[[Weapon.KILL_LIFESPAN]] this controls the amount
    * of lifespan the Bullets have set on launch. The value is given in milliseconds.
    * When a Bullet hits its lifespan limit it will be automatically killed.
    */
  var bulletLifespan: Double = js.native

  /**
    * Bullets can optionally adjust their rotation in-flight to match their velocity.
    * This can create the effect of a bullet 'pointing' to the path it is following, for example
    * an arrow being fired from a bow, and works especially well when added to `bulletGravity`.
    */
  var bulletRotateToVelocity: Boolean = js.native

  /**
    * This is the Phaser.Group that contains all of the bullets managed by this plugin.
    */
  var bullets: Phaser.Group[Phaser.Bullet] = js.native

  /**
    * The speed at which the bullets are fired. This value is given in pixels per second, and
    * is used to set the starting velocity of the bullets.
    */
  var bulletSpeed: Double = js.native

  /**
    * This is a variance added to the speed of Bullets when they are fired.
    * If bullets have a bulletSpeed value of 200, and a bulletSpeedVariance of 50
    * then the actual speed of the Bullets will be between 150 and 250 pixels per second.
    */
  var bulletSpeedVariance: Double = js.native

  /**
    * Should the Bullets wrap around the world bounds? This automatically calls
    * `World.wrap` on the Bullet each frame. See the docs for that method for details.
    */
  var bulletWorldWrap: Boolean = js.native

  /**
    * If `bulletWorldWrap` is true then you can provide an optional padding value with this
    * property. It's added to the calculations determining when the Bullet should wrap around
    * the world or not. The value is given in pixels.
    */
  var bulletWorldWrapPadding: Int = js.native

  /**
    * The angle at which the bullets are fired. This can be a const such as [[Phaser.ANGLE_UP]]
    * or it can be any number from 0 to 360 inclusive, where 0 degrees is to the right.
    */
  var fireAngle: Double = js.native

  /**
    * This is a Rectangle from within which the bullets are fired. By default it's a 1x1
    * rectangle, the equivalent of a Point. But you can change the width and height, and if
    * larger than 1x1 it'll pick a random point within the rectangle to launch the bullet from.
    */
  var fireFrom: Phaser.Rectangle = js.native

  /**
    * he maximum number of shots that this Weapon is allowed to fire before it stops.
    * When the limit is his the `Weapon.onFireLimit` Signal is dispatched.
    * You can reset the shot counter via `Weapon.resetShots`.
    */
  var fireLimit: Double = js.native

  /**
    * The rate at which this Weapon can fire. The value is given in milliseconds.
    */
  var fireRate: Double = js.native

  /**
    * This is a modifier that is added to the fireRate each update to add variety
    * to the firing rate of the Weapon. The value is given in milliseconds.
    * If you've a fireRate of 200 and a fireRateVariance of 50 then the actual
    * firing rate of the Weapon will be between 150 and 250.
    */
  var fireRateVariance: Double = js.native

  /**
    * The onFire Signal is dispatched each time Weapon.fire is called, and a Bullet is
    * successfully launched. The callback is set two arguments: a reference to the bullet sprite itself,
    * and a reference to the Weapon that fired the bullet.
    */
  var onFire: Phaser.Signal = js.native

  /**
    * The onFireLimit Signal is dispatched if Weapon.fireLimit is > 0, and a bullet launch takes the number
    * of shots fired to equal the fire limit.
    * The callback is sent two arguments: A reference to the Weapon that hit the limit, and the value of
    * `Weapon.fireLimit`.
    */
  var onFireLimit: Phaser.Signal = js.native

  /**
    * The onKill Signal is dispatched each time a Bullet that is in-flight is killed. This can be the result
    * of leaving the Weapon bounds, an expiring lifespan, or exceeding a specified distance.
    * The callback is sent one argument: A reference to the bullet sprite itself.
    */
  var onKill: Phaser.Signal = js.native

  /**
    * The total number of bullets this Weapon has fired so far.
    * You can limit the number of shots allowed (via fireLimit), and reset
    * this total via Weapon.resetShots.
    */
  var shots: Double = js.native

  /**
    * The Pointer currently being tracked by the Weapon, if any.
    * This is set via the Weapon.trackPointer method.
    */
  var trackedPointer: Phaser.Pointer = js.native

  /**
    * The Sprite currently being tracked by the Weapon, if any.
    * This is set via the Weapon.trackSprite method.
    */
  var trackedSprite: Phaser.Sprite = js.native

  /**
    * The Track Offset is a Point object that allows you to specify a pixel offset that bullets use
    * when launching from a tracked Sprite or Pointer. For example if you've got a bullet that is 2x2 pixels
    * in size, but you're tracking a Sprite that is 32x32, then you can set trackOffset.x = 16 to have
    * the bullet launched from the center of the Sprite.
    */
  var trackOffset: Phaser.Point = js.native

  /**
    * If the Weapon is tracking a Sprite, should it also track the Sprites rotation?
    * This is useful for a game such as Asteroids, where you want the weapon to fire based
    * on the sprites rotation.
    */
  var trackRotation: Boolean = js.native

  /**
    * The x coordinate from which bullets are fired. This is the same as Weapon.fireFrom.x, and
    * can be overridden by the Weapon.fire arguments.
    */
  var x: Double = js.native

  /**
    * The y coordinate from which bullets are fired. This is the same as Weapon.fireFrom.y, and
    * can be overridden by the Weapon.fire arguments.
    */
  var y: Double = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Adds a new animation under the given key. Optionally set the frames, frame rate and loop.
    * The arguments are all the same as for Animation.add, and work in the same way.
    * Weapon.bulletAnimation will be set to this animation after it's created. From that point on, all
    *
    * bullets fired will play using this animation. You can swap between animations by calling this method
    * several times, and then just changing the Weapon.bulletAnimation property to the name of the animation
    * you wish to play for the next launched bullet.
    * If you wish to stop using animations at all, set Weapon.bulletAnimation to "" (an empty string).
    * @param name            The unique (within the Weapon instance) name for the animation, i.e. "fire", "blast".
    * @param frames          An array of numbers/strings that correspond to the frames to add to this animation and
    *                        in which order. e.g. [1, 2, 3] or ['run0', 'run1', run2]). If null then all frames will be used.
    * @param frameRate       The speed at which the animation should play. The speed is given in frames per second.
    * @param loop            Whether or not the animation is looped or just plays once.
    * @param useNumericIndex Are the given frames using numeric indexes (default) or strings?
    * @return The Weapon Plugin.
    */
  def addBulletAnimation(name: String, frames: js.Array[String | JsNumber] = js.native, frameRate: Double = js.native, loop: Boolean = js.native, useNumericIndex: Boolean = js.native): Phaser.Weapon = js.native

  /**
    * This method performs two actions: First it will check to see if the Weapon.bullets Group exists or not,
    * and if not it creates it, adding it the group given as the 4th argument.
    * Then it will seed the bullet pool with the quantity number of Bullets, using the texture key and frame
    * provided (if any).
    *
    * If for example you set the quantity to be 10, then this Weapon will only ever be able to have 10 bullets
    * in-flight simultaneously. If you try to fire an 11th bullet then nothing will happen until one, or more, of
    * the in-flight bullets have been killed, freeing them up for use by the Weapon again.
    * If you do not wish to have a limit set, then pass in -1 as the quantity. In this instance the Weapon will
    * keep increasing the size of the bullet pool as needed. It will never reduce the size of the pool however,
    * so be careful it doesn't grow too large.
    *
    * You can either set the texture key and frame here, or via the Weapon.bulletKey and Weapon.bulletFrame
    * properties. You can also animate bullets, or set them to use random frames. All Bullets belonging to a
    * single Weapon instance must share the same texture key however.
    * @param quantity The quantity of bullets to seed the Weapon with. If -1 it will set the pool to automatically expand.
    * @param key      The Game.cache key of the image that this Sprite will use.
    * @param frame    If the Sprite image contains multiple frames you can specify which one to use here.
    * @param group    Optional Group to add the object to. If not specified it will be added to the World group.
    * @return This Weapon instance.
    */
  def createBullets[T](quantity: Int = js.native, key: String = js.native, frame: JsNumber | String = js.native, group: Phaser.Group[T] = js.native): Phaser.Weapon = js.native

  /**
    * Uses Game.Debug to draw some useful information about this Weapon, including the number of bullets
    * both in-flight, and available. And optionally the physics debug bodies of the bullets.
    * @param x           The coordinate, in screen space, at which to draw the Weapon debug data.
    * @param y           The coordinate, in screen space, at which to draw the Weapon debug data.
    * @param debugBodies Optionally draw the physics body of every bullet in-flight.
    */
  def debug(x: Double = js.native, y: Double = js.native, debugBodies: Boolean = js.native): Unit = js.native

  /**
    * Destroys this Weapon. It removes itself from the PluginManager, destroys
    * the bullets Group, and nulls internal references.
    */
  def destroy(): Unit = js.native

  def fire(from: Phaser.Sprite | Phaser.Point = js.native, x: Double = js.native, y: Double = js.native): Phaser.Bullet = js.native


}

/**
  * Weapon Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.Weapon")
object Weapon extends js.Object {

  /**
    * A `bulletKillType` constant that automatically kills the bullets when they leave the `Camera.bounds` rectangle.
    */
  val KILL_CAMERA_BOUNDS: Int = js.native

  /**
    * A `bulletKillType` constant that automatically kills the bullets after they
    * exceed the `bulletDistance` from their original firing position.
    */
  val KILL_DISTANCE: Int = js.native

  /**
    * A `bulletKillType` constant that automatically kills the bullets when their bulletLifespan expires.
    */
  val KILL_LIFESPAN: Int = js.native

  /**
    * A bulletKillType constant that stops the bullets from ever being destroyed automatically.
    */
  val KILL_NEVER: Int = js.native

  /**
    * A `bulletKillType` constant that automatically kills the bullets when they leave the Weapon.bounds rectangle.
    */
  val KILL_STATIC_BOUNDS: Int = js.native

  /**
    * A `bulletKillType` constant that automatically kills the bullets when they leave the Weapon.bounds rectangle
    */
  val KILL_WEAPON_BOUNDS: Int = js.native

  /**
    * A `bulletKillType` constant that automatically kills the bullets when they leave the World.bounds rectangle.
    */
  val KILL_WORLD_BOUNDS: Int = js.native

}