package io.scalajs.util

import scala.scalajs.js
import scala.scalajs.js.UndefOr

/**
  * Represents an optional type, which is either Full - contains a value - or empty (null or undefined).
  * @author lawrence.daniels@gmail.com
  */
sealed trait Maybe[+A] {

  def filter(p: A => Boolean): Maybe[A]

  def flatMap[B](p: A => Maybe[B]): Maybe[B]

  def forall(p: A => Boolean): Boolean

  def foreach[U](p: A => U): Unit

  def get: A

  def getOrElse[B >: A](default: => B): B

  def isDefined: Boolean

  def isEmpty: Boolean

  def nonEmpty: Boolean

  def map[B](f: A => B): Maybe[B]

  def toOption: Option[A]

  def toUndefOr: js.UndefOr[A]

}

/**
  * Scalajs.io Optional Companion
  * @author lawrence.daniels@gmail.com
  */
object Maybe {

  /**
    * Creates a Maybe monad from the given value
    * @param value the given value
    * @return a Maybe implementation
    */
  def apply[A](value: A): Maybe[A] = {
    value match {
      case v if v == null | js.isUndefined(v) => Empty
      case v => Full(v)
    }
  }

  /**
    * Creates a Maybe monad from the given UndefOr value
    * @param aValue the given value
    * @return a Maybe implementation
    */
  def apply[A](aValue: js.UndefOr[A]): Maybe[A] = {
    aValue match {
      case v if v == null | js.isUndefined(v) => Empty
      case v => Full(v.get)
    }
  }

  /**
    * Creates a Maybe monad from the given Option value
    * @param aValue the given value
    * @return a Maybe implementation
    */
  def apply[A](aValue: Option[A]): Maybe[A] = {
    aValue match {
      case Some(value) => Full(value)
      case None => Empty
    }
  }

  def apply(value: Null) = Empty

  implicit def directValueToMaybe[A](value: A): Maybe[A] = Maybe(value)

  implicit def optionToMaybe[A](aValue: Option[A]): Maybe[A] = Maybe(aValue)

  implicit def undefinedToMaybe[A](aValue: js.UndefOr[A]): Maybe[A] = Maybe(aValue)

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

}

/**
  * Represents an defined value; meaning not null or undefined
  * @param value the given value
  */
case class Full[A](value: A) extends Maybe[A] {

  override def filter(p: A => Boolean): Maybe[A] = if (p(value)) this else Empty

  override def flatMap[B](p: A => Maybe[B]): Maybe[B] = p(value)

  override def forall(p: A => Boolean): Boolean = p(value)

  override def foreach[U](f: A => U): Unit = f(value)

  override def get: A = value

  override def getOrElse[B >: A](default: => B): B = value

  override def isDefined: Boolean = true

  override def isEmpty: Boolean = false

  override def nonEmpty: Boolean = true

  override def map[B](p: A => B): Maybe[B] = Maybe(p(value))

  override def toOption: Option[A] = Some(value)

  override def toUndefOr: UndefOr[A] = value

}

/**
  * Represents the absence of a value (undefined or null)
  */
case object Empty extends Maybe[Nothing] {

  override def filter(p: Nothing => Boolean) = Empty

  override def flatMap[B](p: Nothing => Maybe[B]) = Empty

  override def forall(p: Nothing => Boolean): Boolean = false

  override def foreach[U](p: Nothing => U) {}

  override def get: Nothing = throw new NoSuchElementException("undefined.get")

  override def getOrElse[B >: Nothing](default: => B): B = default

  override def isDefined: Boolean = false

  override def isEmpty: Boolean = true

  override def nonEmpty: Boolean = false

  override def map[B](p: Nothing => B) = Empty

  override def toOption = None

  override def toUndefOr: UndefOr[Nothing] = js.undefined

}
