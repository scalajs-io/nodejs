package io.scalajs.npm

/**
  * numeral package object
  * @author lawrence.daniels@gmail.com
  */
package object numeral {

  /**
    * Numeral: Double Formatter
    * @param value the given numeric value
    */
  implicit class DoubleFormatter(val value: Double) extends AnyVal {

    @inline
    def format(formatString: String): String = {
      Numeral(value).format(formatString)
    }
  }

  /**
    * Numeral Integer Formatter
    * @param value the given numeric value
    */
  implicit class IntFormatting(val value: Int) extends AnyVal {

    @inline
    def format(formatString: String): String = {
      Numeral(value).format(formatString)
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
    def +(value: Double): Double = number.value() + value

    @inline
    def -(value: Double): Double = number.value() - value

    @inline
    def *(value: Double): Double = number.value() * value

    @inline
    def /(value: Double): Double = number.value() / value

    @inline
    def +(aNumber: NumeralInstance): Double = number.value() + aNumber.value()

    @inline
    def -(aNumber: NumeralInstance): Double = number.value() - aNumber.value()

    @inline
    def *(aNumber: NumeralInstance): Double = number.value() * aNumber.value()

    @inline
    def /(aNumber: NumeralInstance): Double = number.value() / aNumber.value()

    ////////////////////////////////////////////////////////
    //    Mutator Functions
    ////////////////////////////////////////////////////////

    @inline
    def +=(value: Double): number.type = number.add(value)

    @inline
    def -=(value: Double): number.type = number.subtract(value)

    @inline
    def *=(value: Double): number.type = number.multiply(value)

    @inline
    def /=(value: Double): number.type = number.divide(value)

    @inline
    def +=(aNumber: NumeralInstance): number.type = number.add(aNumber.value())

    @inline
    def -=(aNumber: NumeralInstance): number.type = number.subtract(aNumber.value())

    @inline
    def *=(aNumber: NumeralInstance): number.type = number.multiply(aNumber.value())

    @inline
    def /=(aNumber: NumeralInstance): number.type = number.divide(aNumber.value())

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
