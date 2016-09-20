package org.scalajs.nodejs.npm.numeral

import org.scalajs.nodejs.NodeRequire
import org.scalajs.nodejs.npm.numeral.Numeral.NumeralInstance

import scala.scalajs.js

/**
  * Numeral - A javascript library for formatting and manipulating numbers.
  * @see [[http://numeraljs.com/]]
  * @version 1.5.3
  * @author Lawrence Daniels <lawrence.daniels@gmail.com>
  */
@js.native
trait Numeral extends js.Object {

  def apply(number: js.Any = null): NumeralInstance = js.native

}

/**
  * Numeral Companion
  * @author Lawrence Daniels <lawrence.daniels@gmail.com>
  */
object Numeral {

  /**
    * Convenience method for retrieving the 'numeral' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the [[Numeral numeral]] instance
    */
  def apply()(implicit require: NodeRequire) = {
    require[Numeral]("numeral")
  }

  /**
    * Numeral Instance
    * @author Lawrence Daniels <lawrence.daniels@gmail.com>
    */
  @js.native
  trait NumeralInstance extends js.Object {

    def add(value: Double): this.type = js.native

    def difference(value: Double): this.type = js.native

    def format(formatString: String = null): String = js.native

    def set(value: Double): this.type = js.native

    def unformat(data: String): Double = js.native

    def value(): Double = js.native

    def zeroFormat(default: String): String = js.native

  }

}