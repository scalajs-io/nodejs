package io.scalajs.util

import scala.scalajs.js

/**
  * Option Helper
  */
@deprecated("All members are deprecated", "0.9.0")
object OptionHelper {

  /**
    * Option Extensions
    * @param valueA the given [[Option optional value]]
    */
  @deprecated("All methods are deprecated", "0.9.0")
  implicit final class OptionExtensions[T](val valueA: Option[T]) extends AnyVal {

    @deprecated("Cryptic operator no longer supported", "0.9.0")
    @inline def ?==(valueB: js.UndefOr[T]): Boolean = valueA.exists(v => valueB.exists(_ == v))

    @deprecated("Cryptic operator no longer supported", "0.9.0")
    @inline def ?==(valueB: Option[T]): Boolean = valueA.exists(valueB.contains)

    @deprecated("Cryptic operator no longer supported", "0.9.0")
    @inline def ?!=(valueB: js.UndefOr[T]): Boolean = !valueA.exists(valueB.contains)

    @deprecated("Cryptic operator no longer supported", "0.9.0")
    @inline def ?!=(valueB: Option[T]): Boolean = !valueA.exists(valueB.contains)

    @deprecated("Use orElse(optB)", "0.9.0")
    @inline def ??(optB: => Option[T]): Option[T] = if (valueA.isDefined) valueA else optB

    @deprecated("Meaningless operation", "0.9.0")
    @inline def flat: Option[T] = valueA.flatMap(Option(_))

    @deprecated("Use nonEmpty", "0.9.0")
    @inline def isAssigned: Boolean = valueA.nonEmpty

    @deprecated("Use isEmpty", "0.9.0")
    @inline def nonAssigned: Boolean = valueA.isEmpty

    @deprecated("Use getOrElse(throw ...)", "0.9.0")
    @inline def orDie(message: String): T = {
      valueA getOrElse (throw js.JavaScriptException(message))
    }

  }

  /**
    * Option Boolean Extensions
    * @param value the given [[Option value]]
    */
  @deprecated("All methods are deprecated", "0.9.0")
  implicit final class OptionBoolExtensions(val value: Option[Boolean]) extends AnyVal {

    @deprecated("Use contains(true)", "0.9.0")
    @inline def isTrue: Boolean = value.contains(true)

  }

  /**
    * Option Double Extensions
    * @param value the given [[Option value]]
    */
  @deprecated("All methods are deprecated", "0.9.0")
  implicit final class OptionDoubleExtensions(val value: Option[Double]) extends AnyVal {

    @deprecated("Use getOrElse(0.0)", "0.9.0")
    @inline def orZero: Double = value getOrElse 0.0

  }

  /**
    * Option Integer Extensions
    * @param value the given [[Option value]]
    */
  @deprecated("All methods are deprecated", "0.9.0")
  implicit final class OptionIntExtensions(val value: Option[Int]) extends AnyVal {

    @deprecated("Use getOrElse(0)", "0.9.0")
    @inline def orZero: Int = value getOrElse 0

  }

}
