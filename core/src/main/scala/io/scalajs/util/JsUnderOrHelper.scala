package io.scalajs.util

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

/**
  * js.UnderOr Helper
  */
@deprecated("All members are deprecated", "0.9.0")
object JsUnderOrHelper {

  /**
    * UndefOr Extensions
    * @param valueA the given [[js.UndefOr value]]
    */
  @deprecated("All methods are deprecated", "0.9.0")
  implicit final class UndefOrExtensions[T](private val valueA: js.UndefOr[T]) extends AnyVal {

    @deprecated("Cryptic operator no longer supported", "0.9.0")
    @inline def ?==(valueB: js.UndefOr[T]): Boolean = valueA.exists(valueB.contains)

    @deprecated("Cryptic operator no longer supported", "0.9.0")
    @inline def ?==(valueB: Option[T]): Boolean = valueA.exists(valueB.contains)

    @deprecated("Cryptic operator no longer supported", "0.9.0")
    @inline def ?!=(valueB: js.UndefOr[T]): Boolean = !valueA.exists(valueB.contains)

    @deprecated("Cryptic operator no longer supported", "0.9.0")
    @inline def ?!=(valueB: Option[T]): Boolean = !valueA.exists(valueB.contains)

    @deprecated("Use oeElse(optB)", "0.9.0")
    @inline def ??(optB: => js.UndefOr[T]): js.UndefOr[T] = if (valueA.isDefined) valueA else optB

    @deprecated("Meaningless operation", "0.9.0")
    @inline def flat: js.UndefOr[T] = valueA.flatMap(Option(_).orUndefined)

    @deprecated("Use nonEmpty", "0.9.0")
    @inline def isAssigned: Boolean = valueA.nonEmpty

    @deprecated("Use isEmpty", "0.9.0")
    @inline def nonAssigned: Boolean = valueA.flat.isEmpty

    @deprecated("Use getOrElse(throw ...)", "0.9.0")
    @inline def orDie(message: String): T = valueA getOrElse (throw js.JavaScriptException(message))

  }

  /**
    * UndefOr Boolean Extensions
    * @param value the given [[js.UndefOr value]]
    */
  @deprecated("All methods are deprecated", "0.9.0")
  implicit final class UndefOrBoolExtensions(private val value: js.UndefOr[Boolean]) extends AnyVal {

    @deprecated("Use contains(true)", "0.9.0")
    @inline
    def isTrue: Boolean = value.contains(true)

  }

  /**
    * UndefOr Double Extensions
    * @param value the given [[js.UndefOr value]]
    */
  @deprecated("All methods are deprecated", "0.9.0")
  implicit final class UndefOrDoubleExtensions(val value: js.UndefOr[Double]) extends AnyVal {

    @deprecated("Use getOrElse(0.0)", "0.9.0")
    @inline
    def orZero: Double = value getOrElse 0.0

  }

  /**
    * UndefOr Integer Extensions
    * @param value the given [[js.UndefOr value]]
    */
  @deprecated("All methods are deprecated", "0.9.0")
  implicit final class UndefOrIntExtensions(val value: js.UndefOr[Int]) extends AnyVal {

    @deprecated("Use getOrElse(0)", "0.9.0")
    @inline
    def orZero: Int = value getOrElse 0

  }

}
