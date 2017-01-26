package io.scalajs.dom.html.phaser.utils

import io.scalajs.JsNumber

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Utility functions for dealing with Arrays.
  * @see https://phaser.io/docs/2.6.2/Phaser.ArrayUtils.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
class ArrayUtils extends js.Object {

  /**
    * Snaps a value to the nearest value in an array.
    * @param value The search value
    * @param arr   The input array which must be sorted.
    * @return The nearest value found.
    */
  def findClosest(value: JsNumber, arr: js.Array[JsNumber]): Int = js.native

  /**
    * Fetch a random entry from the given array.
    * Will return null if there are no array items that fall within the specified range or if there is no item
    * for the randomly chosen index.
    * @param objects    An array of objects.
    * @param startIndex Optional offset off the front of the array. Default value is 0, or the beginning of the array.
    * @param length     Optional restriction on the number of values you want to randomly select from.
    * @return The random object that was selected.
    */
  def getRandomItem[T](objects: js.Array[T], startIndex: Int = js.native, length: Int = js.native): T = js.native

  /**
    * Create an array representing the inclusive range of numbers (usually integers) in [start, end].
    * This is equivalent to `numberArrayStep(start, end, 1)`.
    * @param start The minimum value the array starts with.
    * @param end   The maximum value the array contains.
    * @return The array of number values.
    */
  def numberArray[T](start: JsNumber, end: JsNumber): js.Array[T] = js.native

  /**
    * Create an array of numbers (positive and/or negative) progressing from start
    * up to but not including end by advancing by step.
    * If start is less than end a zero-length range is created unless a negative step is specified.
    * Certain values for start and end (eg. NaN/undefined/null) are currently coerced to 0;
    * for forward compatibility make sure to pass in actual numbers.
    * @param start The start of the range.
    * @param end   The end of the range.
    * @param step  The value to increment or decrement by.
    * @return Returns the new array of numbers.
    */
  def numberArrayStep[T](start: JsNumber, end: JsNumber = js.native, step: Int = js.native): js.Array[T] = js.native

  /**
    * Removes a random object from the given array and returns it.
    * Will return null if there are no array items that fall within the specified range or if there is no item
    * for the randomly chosen index.
    * @param objects    An array of objects.
    * @param startIndex Optional offset off the front of the array. Default value is 0, or the beginning of the array.
    * @param length     Optional restriction on the number of values you want to randomly select from.
    * @return The random object that was removed.
    */
  def removeRandomItem[T](objects: js.Array[T], startIndex: Int = js.native, length: Int = js.native): T = js.native

  /**
    * Moves the element from the start of the array to the end, shifting all items in the process.
    * The "rotation" happens to the left.
    * @param array The array to rotate. The array is modified.
    * @return The rotated value.
    */
  @deprecated("This method is deprecated and should not be used. It may be removed in the future.", since = "2.6.2")
  def rotate[T](array: js.Array[T]): js.Array[T] = js.native

  /**
    * Moves the element from the start of the array to the end, shifting all items in the process.
    * The "rotation" happens to the left.
    * @param array The array to rotate. The array is modified.
    * @return The rotated value.
    */
  def rotateLeft[T](array: js.Array[T]): js.Array[T] = js.native

  /**
    * Rotates the given matrix (array of arrays).
    * @see http://jsfiddle.net/MrPolywhirl/NH42z/.
    * @param matrix    The array to rotate; this matrix may be altered.
    * @param direction The amount to rotate: the rotation in degrees (90, -90, 270, -270, 180)
    *                  or a string command ('rotateLeft', 'rotateRight' or 'rotate180').
    * @return The rotated matrix. The source matrix should be discarded for the returned matrix.
    */
  def rotateMatrix[T](matrix: js.Array[T], direction: JsNumber | String): js.Array[T] = js.native

  /**
    * Moves the element from the end of the array to the start, shifting all items in the process.
    * The "rotation" happens to the right.
    * @param array The array to rotate. The array is modified.
    * @return The shifted value.
    */
  def rotateRight[T](array: js.Array[T]): js.Array[T] = js.native

  /**
    * A standard Fisher-Yates Array shuffle implementation which modifies the array in place.
    * @param array The array to shuffle.
    * @return The original array, now shuffled.
    */
  def shuffle[T](array: js.Array[T]): js.Array[T] = js.native

  /**
    * Transposes the elements of the given matrix (array of arrays).
    * @param array The matrix to transpose.
    * @return A new transposed matrix
    */
  def transposeMatrix[T](array: js.Array[T]): js.Array[T] = js.native

}

/**
  * Array Utils Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
object ArrayUtils extends ArrayUtils