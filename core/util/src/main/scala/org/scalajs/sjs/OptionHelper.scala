package org.scalajs.sjs

import org.scalajs.sjs.JsUnderOrHelper._

import scala.scalajs.js

/**
  * Option Helper
  * @author lawrence.daniels@gmail.com
  */
object OptionHelper {

  /**
    * Option Extensions
    * @param valueA the given [[Option optional value]]
    */
  implicit class OptionExtensions[T](val valueA: Option[T]) extends AnyVal {

    @inline def ?==(valueB: js.UndefOr[T]): Boolean = valueA.exists(v => valueB.exists(_ == v))

    @inline def ?==(valueB: Option[T]): Boolean = valueA.exists(valueB.contains)

    @inline def ?!=(valueB: js.UndefOr[T]): Boolean = !valueA.exists(valueB.contains)

    @inline def ?!=(valueB: Option[T]): Boolean = !valueA.exists(valueB.contains)

    @inline def ??(optB: => Option[T]): Option[T] = if (valueA.isDefined) valueA else optB

    @inline def flat = valueA.flatMap(Option(_))

    @inline def isAssigned = valueA.flat.nonEmpty

    @inline def nonAssigned = valueA.flat.isEmpty

    @inline def orDie(message: String): T = valueA getOrElse (throw new IllegalStateException(message))

  }

  /**
    * Option Boolean Extensions
    * @param value the given [[Option value]]
    */
  implicit class OptionBoolExtensions(val value: Option[Boolean]) extends AnyVal {

    @inline def isTrue = value.contains(true)

  }

  /**
    * Option Double Extensions
    * @param value the given [[Option value]]
    */
  implicit class OptionDoubleExtensions(val value: Option[Double]) extends AnyVal {

    @inline def orZero = value getOrElse 0.0

  }

  /**
    * Option Integer Extensions
    * @param value the given [[Option value]]
    */
  implicit class OptionIntExtensions(val value: Option[Int]) extends AnyVal {

    @inline def orZero = value getOrElse 0

  }

}
