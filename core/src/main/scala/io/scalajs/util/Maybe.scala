package io.scalajs.util

import io.scalajs.util.JsUnderOrHelper._

import scala.scalajs.js
import scala.scalajs.js.{Any, |}
import scala.scalajs.js.|.Evidence

/**
  * Represents an optional type, which is either Full - contains a value - or empty (null or undefined).
  * @author lawrence.daniels@gmail.com
  */
sealed trait Maybe[+A]

/**
  * Represents the "presence" of a value
  * @param value the given value of type A
  * @tparam A the value type
  */
case class Full[A](value: A) extends Maybe[A]

/**
  * Represents the "absence" of a value (undefined or null)
  */
case object Empty extends Maybe[Nothing]

/**
  * Low-Priority Implicits
  * @author lawrence.daniels@gmail.com
  */
sealed abstract class MaybeLowerPriorityImplicits {

  /**
    * Upcasts `A` to `Maybe[B1 | B2]`.
    * This needs evidence that `A <: B1 | B2`.
    */
  implicit def anyToMaybeUnion[A, B1, B2](a: A)(implicit ev: Evidence[A, B1 | B2]): Maybe[B1 | B2] = {
    a.asInstanceOf[Maybe[B1 | B2]]
  }

  //implicit def maybeToDirectValue[A](aValue: Maybe[A]): A = aValue.get

  //implicit def directValueToMaybe[A](value: A): Maybe[A] = Maybe(value)

  implicit def optionToMaybe[A](aValue: Option[A]): Maybe[A] = Maybe(aValue)

  implicit def undefinedToMaybe[A](aValue: js.UndefOr[A]): Maybe[A] = Maybe(aValue)

}

/**
  * Scalajs.io Optional Companion
  * @author lawrence.daniels@gmail.com
  */
object Maybe extends MaybeLowerPriorityImplicits {

  implicit def any2Maybe[A](value: A): Maybe[A] = Maybe(value)

  //implicit def undefOr2ops[A](value: Maybe[A]): Maybe[A] = new MaybeOps(value)

  implicit def undefOr2jsAny[A](value: Maybe[A])(implicit ev: A => Any): Any =
    value.map(ev).asInstanceOf[Any]

  /**
    * Creates a Maybe monad from the given value
    * @param value the given value
    * @return a Maybe implementation
    */
  def apply[A](value: A): Maybe[A] = if (isNotDefined(value)) Empty else Full(value)

  /**
    * Creates a Maybe monad from the given UndefOr value
    * @param aValue the given value
    * @return a Maybe implementation
    */
  def apply[A](aValue: js.UndefOr[A]): Maybe[A] = if (aValue.flat.isEmpty) Empty else Full(aValue.get)

  /**
    * Creates a Maybe monad from the given Option value
    * @param aValue the given value
    * @return a Maybe implementation
    */
  def apply[A](aValue: Option[A]): Maybe[A] = if (aValue.isEmpty) Empty else Full(aValue.get)

  def apply(value: Null) = Empty

  def apply(value: Nothing) = Empty

  private def isNotDefined[A](value: A): Boolean = value == null || value == js.undefined || value == None

  private val NULL: Maybe[Nothing] = null

  /**
    * UndefOr[A] to Maybe[A] Explicit Conversion
    * @param aValue the given UndefOr value
    */
  implicit class MaybeFromUndefOr[A](val aValue: js.UndefOr[A]) extends AnyVal {

    @inline
    def toMaybe: Maybe[A] = Maybe(aValue)

  }

  /**
    * Option[A] to Maybe[A] Explicit Conversion
    * @param aValue the given Option value
    */
  implicit class MaybeFromOption[A](val aValue: Option[A]) extends AnyVal {

    @inline
    def toMaybe: Maybe[A] = Maybe(aValue)

  }

  /**
    * Maybe Enrichment
    * @param aValue the given Maybe-wrapped value
    */
  implicit class MaybeEnrichment[A](val aValue: Maybe[A]) extends AnyVal {

    @inline
    def filter(p: A => Boolean): Maybe[A] = if (isEmpty) Empty else if (p(get)) aValue else Empty

    @inline
    def flatMap[B](p: A => Maybe[B]): Maybe[B] = if (isEmpty) Empty else p(get)

    @inline
    def forall(p: A => Boolean): Boolean = if (isEmpty) false else p(get)

    @inline
    def foreach[U](p: A => U): Unit = if (isEmpty) () else p(get)

    @inline
    def filterNot(p: A => Boolean): Maybe[A] = if (isEmpty) Empty else if (p(get)) Empty else aValue

    @inline
    def get: A = aValue match {
      case Full(value) => value
      case _ => throw new IllegalArgumentException("value is null or undefined")
    }

    @inline
    def getOrElse[B >: A](default: => B): B = if (isEmpty) default else get

    @inline
    def isDefined: Boolean = !isEmpty

    @inline
    def isEmpty: Boolean = aValue == Empty || isNotDefined(aValue)

    @inline
    def nonEmpty: Boolean = isDefined

    @inline
    def map[B](p: A => B): Maybe[B] = if (isEmpty) Empty else Maybe(p(get))

    @inline
    def orNull[B >: A](implicit ev: Null <:< B): B = getOrElse(ev(null))

    @inline
    def toLeft[B](right: => B): Either[A, B] = if (isEmpty) Right(right) else Left(get)

    @inline
    def toOption: Option[A] = aValue match {
      case Full(value) => Option(value)
      case _ => None
    }

    @inline
    def toRight[B](left: => B): Either[B, A] = if (isEmpty) Left(left) else Right(get)

    @inline
    def toUndefOr: js.UndefOr[A] = if (isEmpty) js.undefined else get

  }

}
