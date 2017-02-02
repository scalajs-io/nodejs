package io.scalajs.dom.html.phaser.utils

import io.scalajs.JsNumber

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Phaser.Utils
  * @version 2.6.2
  * @see https://phaser.io/docs/2.6.2/Phaser.Utils.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Utils extends js.Object

/**
  * Phaser.Utils Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
object Utils extends js.Object {

  /**
    * This is a slightly modified version of http://api.jquery.com/jQuery.extend/
    * @param deep   Perform a deep copy?
    * @param target The target object to copy to.
    * @return The extended object.
    */
  def extend[A](deep: Boolean, target: js.Any): A = js.native

  /**
    * Gets an objects property by string.
    * @param obj  The object to traverse.
    * @param prop The property whose value will be returned.
    * @return the value of the property or null if property isn"t found.
    */
  def getProperty(obj: js.Any, prop: String): js.Any = js.native

  /**
    * This is a slightly modified version of jQuery.isPlainObject.
    * A plain object is an object whose internal class property is [object Object].
    * @param obj The object to inspect.
    * @return true if the object is plain, otherwise false.
    */
  def isPlainObject(obj: js.Any): Boolean = js.native

  /**
    * Mixes the source object into the destination object, returning the newly modified destination object.
    * @param from The object to copy (the source object).
    * @param to   The object to copy to (the destination object).
    * @return The modified destination object.
    */
  def mixin(from: js.Any, to: js.Any): js.Any = js.native

  /**
    * Mixes in an existing mixin object with the target.
    * Values in the mixin that have either `get` or `set` functions are created as properties via `defineProperty`
    * except if they also define a `clone` method - if a clone method is defined that is called instead and
    * the result is assigned directly.
    * @param target  The target object to receive the new functions.
    * @param mixin   The object to copy the functions from.
    * @param replace If the target object already has a matching function should it be overwritten or not?
    * @return
    */
  def mixinPrototype(target: js.Any, mixin: js.Any, replace: Boolean = js.native): js.Any = js.native

  /**
    *
    * @param str The target string. toString() will be called on the string, which means you can also pass in
    *            common data types like numbers.
    * @param len The number of characters to be added.
    * @param pad The string to pad it out with (defaults to a space).
    * @param dir The direction dir = 1 (left), 2 (right), 3 (both).
    * @return The padded string.
    * @example {{{ pad("bob", 6, "-", 2) }}}
    */
  def pad(str: js.Any | String, len: Int = js.native, pad: String = js.native, dir: Int = js.native): String =
    js.native

  /**
    * Get a unit dimension from a string.
    * @param size      The size to parse.
    * @param dimension The window dimension to check.
    * @return The parsed dimension.
    */
  def parseDimension(size: JsNumber | String, dimension: JsNumber): Int = js.native

  /**
    * Takes the given string and reverses it, returning the reversed string.
    * For example if given the string "Atari 520ST" it would return "TS025 iratA".
    * @param string The string to be reversed.
    * @return The reversed string.
    */
  def reverseString(string: String): String = js.native

  /**
    * Sets an objects property by string.
    * @param obj  The object to traverse
    * @param prop The property whose value will be changed
    * @return The object on which the property was set.
    */
  def setProperty[T](obj: T, prop: String): T = js.native

  /**
    * Generate a random bool result based on the chance value.
    * Returns true or false based on the chance value (default 50%).
    * For example if you wanted a player to have a 30% chance of getting a bonus, call chanceRoll(30)
    * - true means the chance passed,
    * - false means it failed.
    * @param chance The chance of receiving the value. A number between 0 and 100 (effectively 0% to 100%).
    * @return True if the roll passed, or false otherwise.
    */
  def chanceRoll(chance: JsNumber): Boolean = js.native

  /**
    * Choose between one of two values randomly.
    * @param choice1 the first choice
    * @param choice2 the second choice
    * @return The randomly selected choice
    */
  def randomChoice(choice1: js.Any, choice2: js.Any): js.Any = js.native

}
