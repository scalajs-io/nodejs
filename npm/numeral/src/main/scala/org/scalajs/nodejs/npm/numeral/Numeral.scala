package org.scalajs.nodejs.npm.numeral

import org.scalajs.nodejs.NodeRequire
import org.scalajs.nodejs.npm.numeral.Numeral.NumeralInstance

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Numeral - A javascript library for formatting and manipulating numbers.
  * @see [[http://numeraljs.com/]]
  * @version 1.5.3
  * @author Lawrence Daniels <lawrence.daniels@gmail.com>
  */
@js.native
trait Numeral extends js.Object {

  def apply(number: js.Any = null): NumeralInstance = js.native

  def language(code: String): Unit = js.native

  def language(code: String, options: LanguageOptions | js.Any): Unit = js.native

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
  @inline
  def apply()(implicit require: NodeRequire) = require[Numeral]("numeral")

  /**
    * Represents a Numeral Object
    * @author Lawrence Daniels <lawrence.daniels@gmail.com>
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

  /**
    * Numeral Implicit Conversions
    * @author Lawrence Daniels <lawrence.daniels@gmail.com>
    */
  object Implicits {

    /**
      * Numeral: Double Formatter
      * @param value the given numeric value
      */
    implicit class DoubleFormatter(val value: Double) extends AnyVal {

      @inline
      def format(formatString: String)(implicit numeral: Numeral) = {
        numeral(value).format(formatString)
      }
    }

    /**
      * Numeral Integer Formatter
      * @param value the given numeric value
      */
    implicit class IntFormatting(val value: Int) extends AnyVal {

      @inline
      def format(formatString: String)(implicit numeral: Numeral) = {
        numeral(value).format(formatString)
      }
    }

  }

  /**
    * Number Enrichment
    * @param number the given [[NumeralInstance number]]
    */
  implicit class NumberEnrichment(val number: NumeralInstance) extends AnyVal {

    ////////////////////////////////////////////////////////
    //    Math Functions
    ////////////////////////////////////////////////////////

    @inline
    def +(value: Double) = number.value() + value

    @inline
    def -(value: Double) = number.value() - value

    @inline
    def *(value: Double) = number.value() * value

    @inline
    def /(value: Double) = number.value() / value

    @inline
    def +(aNumber: NumeralInstance) = number.value() + aNumber.value()

    @inline
    def -(aNumber: NumeralInstance) = number.value() - aNumber.value()

    @inline
    def *(aNumber: NumeralInstance) = number.value() * aNumber.value()

    @inline
    def /(aNumber: NumeralInstance) = number.value() / aNumber.value()

    ////////////////////////////////////////////////////////
    //    Mutator Functions
    ////////////////////////////////////////////////////////

    @inline
    def +=(value: Double) = number.add(value)

    @inline
    def -=(value: Double) = number.subtract(value)

    @inline
    def *=(value: Double) = number.multiply(value)

    @inline
    def /=(value: Double) = number.divide(value)

    @inline
    def +=(aNumber: NumeralInstance) = number.add(aNumber.value())

    @inline
    def -=(aNumber: NumeralInstance) = number.subtract(aNumber.value())

    @inline
    def *=(aNumber: NumeralInstance) = number.multiply(aNumber.value())

    @inline
    def /=(aNumber: NumeralInstance) = number.divide(aNumber.value())

    ////////////////////////////////////////////////////////
    //    Comparison Functions
    ////////////////////////////////////////////////////////

    @inline
    def >(value: Double): Boolean = number.value() > value

    @inline
    def >=(value: Double): Boolean = number.value() >= value

    @inline
    def <(value: Double): Boolean = number.value() < value

    @inline
    def <=(value: Double): Boolean = number.value() <= value

    @inline
    def >(aNumber: NumeralInstance): Boolean = number.value() > aNumber.value()

    @inline
    def >=(aNumber: NumeralInstance): Boolean = number.value() >= aNumber.value()

    @inline
    def <(aNumber: NumeralInstance): Boolean = number.value() < aNumber.value()

    @inline
    def <=(aNumber: NumeralInstance): Boolean = number.value() <= aNumber.value()

  }

}