package io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * The pixi Matrix class as an object, which makes it a lot faster, here is a representation of it:
  * {{{
  * | a | b | tx|
  * +---+---+---+
  * | c | d | ty|
  * +---+---+---+
  * | 0 | 0 | 1 |
  * }}}
  * @see https://phaser.io/docs/2.2.2/PIXI.Matrix.html
  */
@js.native
@JSName("Matrix")
class Matrix extends js.Object {

  var a: Double = js.native

  var b: Double = js.native

  var c: Double = js.native

  var d: Double = js.native

  var tx: Double = js.native

  var ty: Double = js.native

  /**
    * Appends the given Matrix to this Matrix.
    * @param matrix the given Matrix
    * @return This matrix. Good for chaining method calls.
    */
  def append(matrix: Matrix): this.type = js.native

  /**
    * Get a new position with the current transformation applied. Can be used to go from a child's coordinate space
    * to the world coordinate space. (e.g. rendering)
    * @param pos    The origin
    * @param newPos The point that the new position is assigned to (allowed to be same as input)
    * @return The new point, transformed through this matrix
    */
  def apply(pos: Point, newPos: Point = js.native): Point = js.native

  /**
    * Get a new position with the inverse of the current transformation applied. Can be used to go from the world
    * coordinate space to a child's coordinate space. (e.g. input)
    * @param pos    The origin
    * @param newPos The point that the new position is assigned to (allowed to be same as input)
    * @return The new point, inverse-transformed through this matrix
    */
  def applyInverse(pos: Point, newPos: Point = js.native): Point = js.native

  /**
    * Creates a new Matrix object with the same values as this one.
    * @return A copy of this matrix. Good for chaining method calls.
    */
  override def clone(): this.type = js.native

  /**
    * Changes the values of the given matrix to be the same as the ones in this matrix.
    * @return The matrix given in parameter with its values updated.
    */
  def copy(): Matrix = js.native

  /**
    * Creates a Matrix object based on the given array. The Element to Matrix mapping order is as follows:
    * a = array[0] b = array[1] c = array[3] d = array[4] tx = array[2] ty = array[5]
    * @param array The array that the matrix will be populated from.
    */
  def fromArray(array: js.Array[Double]): Unit = js.native

  /**
    * Resets this Matrix to an identity (default) matrix.
    * @return This matrix. Good for chaining method calls.
    */
  def identity(): this.type = js.native

  /**
    * Inverts this matrix.
    * @return This matrix. Good for chaining method calls.
    */
  def invert(): this.type = js.native

  /**
    * Prepends the given Matrix to this Matrix.
    * @param matrix the given Matrix
    * @return This matrix. Good for chaining method calls.
    */
  def prepend(matrix: Matrix): this.type = js.native

  /**
    * Applies a rotation transformation to the matrix.
    * @param angle The angle in radians.
    * @return This matrix. Good for chaining method calls.
    */
  def rotate(angle: Double): this.type = js.native

  /**
    * Applies a scale transformation to the matrix.
    * @param x The amount to scale horizontally.
    * @param y The amount to scale vertically.
    * @return This matrix. Good for chaining method calls.
    */
  def scale(x: Double, y: Double): this.type = js.native

  /**
    * Creates an array from the current Matrix object.
    * @param transpose Whether we need to transpose the matrix or not.
    * @return The newly created array which contains the matrix.
    */
  def toArray(transpose: Boolean): js.Array[Double] = js.native

  /**
    * Translates the matrix on the x and y.
    * @param x the X-coordinate delta
    * @param y the Y-coordinate delta
    * @return This matrix. Good for chaining method calls.
    */
  def translate(x: Double, y: Double): this.type = js.native

}

/**
  * Matrix Singleton
  */
@js.native
@JSName("Matrix")
object Matrix extends js.Object {

  /**
    * A default (identity) matrix
    */
  def IDENTITY: Matrix = js.native

  /**
    * A temp matrix
    */
  def TEMP_MATRIX: Matrix = js.native

}