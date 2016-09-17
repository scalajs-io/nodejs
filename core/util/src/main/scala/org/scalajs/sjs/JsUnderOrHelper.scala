package org.scalajs.sjs

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

/**
  * js.UnderOr Helper
  * @author lawrence.daniels@gmail.com
  */
object JsUnderOrHelper {

  /**
    * UndefOr Extensions
    * @param valueA the given [[js.UndefOr value]]
    */
  implicit class UndefOrExtensions[T](val valueA: js.UndefOr[T]) extends AnyVal {

    @inline def ?==(valueB: js.UndefOr[T]): Boolean = valueA.exists(valueB.contains)

    @inline def ?==(valueB: Option[T]): Boolean = valueA.exists(valueB.contains)

    @inline def ?!=(valueB: js.UndefOr[T]): Boolean = !valueA.exists(valueB.contains)

    @inline def ?!=(valueB: Option[T]): Boolean = !valueA.exists(valueB.contains)

    @inline def ??(optB: => js.UndefOr[T]): js.UndefOr[T] = if (valueA.isDefined) valueA else optB

    @inline def contains(value: T): Boolean = valueA.exists(_ == value)

    @inline def flat = valueA.flatMap(Option(_).orUndefined)

    @inline def isAssigned = valueA.flat.nonEmpty

    @inline def nonAssigned = valueA.flat.isEmpty

    @inline def orDie(message: String): T = valueA getOrElse(throw new IllegalStateException(message))

  }

  /**
    * UndefOr Boolean Extensions
    * @param value the given [[js.UndefOr value]]
    */
  implicit class UndefOrBoolExtensions(val value: js.UndefOr[Boolean]) extends AnyVal {

    @inline def isTrue = value.flat.contains(true)

  }

  /**
    * UndefOr Double Extensions
    * @param value the given [[js.UndefOr value]]
    */
  implicit class UndefOrDoubleExtensions(val value: js.UndefOr[Double]) extends AnyVal {

    @inline def orZero = value.flat getOrElse 0.0

  }

  /**
    * UndefOr Integer Extensions
    * @param value the given [[js.UndefOr value]]
    */
  implicit class UndefOrIntExtensions(val value: js.UndefOr[Int]) extends AnyVal {

    @inline def orZero = value.flat getOrElse 0

  }

}
