package io.scalajs.npm.numeral

import scala.scalajs.js

/**
  * Represents a Numeral Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait NumeralInstance extends js.Object {

  def add(value: Double): this.type = js.native

  override def clone(): NumeralInstance = js.native

  /**
    * Find the difference between your numeral object and a value
    */
  def difference(value: Double): this.type = js.native

  def divide(value: Double): this.type = js.native

  def format(formatString: String = null): String = js.native

  def multiply(value: Double): this.type = js.native

  /**
    * Set the value of your numeral object.
    */
  def set(value: Double): this.type = js.native

  def subtract(value: Double): this.type = js.native

  def unformat(data: String): Double = js.native

  def value(): Double = js.native

  /**
    * Set a custom output when formatting numerals with a value of 0
    */
  def zeroFormat(default: String): String = js.native

}