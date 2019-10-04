package io.scalajs.collection

import scala.scalajs.js

/**
  * The iterable protocol allows JavaScript objects to define or customize their iteration behavior,
  * such as what values are looped over in a for..of construct. Some built-in types are built-in iterables
  * with a default iteration behavior, such as Array or Map, while other types (such as Object) are not.
  * @see https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Iteration_protocols
  */
@js.native
trait Iterator[+A] extends js.Iterator[A]

/**
  * Iterator Companion
  */
@deprecated("Use scala.scalajs.js.Iterator", "0.9.0")
object Iterator {

  /**
    * Implicit conversion for a js.Iterator to Scala Iterator
    * @param jsIt the given JavaScript [[Iterator]]
    */
  @deprecated("Use scala.scalajs.js.Iterator.toIterator", "0.9.0")
  implicit def toScalaIterator[T](jsIt: Iterator[T]): scala.Iterator[T] = jsIt.toIterator

  /**
    * Iterator Entry
    */
  @deprecated("Use scala.scalajs.js.Iterator.Entry", "0.9.0")
  @js.native
  type Entry[+A] = js.Iterator.Entry[A]

  /**
    * Iterator Wrapper
    */
  @deprecated("Use scala.scalajs.js.Iterator.toIterator", "0.9.0")
  class IteratorWrapper[T](it: Iterator[T]) extends scala.Iterator[T] {
    private var result = it.next()

    override def hasNext: Boolean = result != null && !result.done

    override def next(): T = {
      val value = result.value
      result = it.next()
      value
    }
  }

}
