package io.scalajs.collection

import scala.language.implicitConversions
import scala.scalajs.js

/**
  * The iterable protocol allows JavaScript objects to define or customize their iteration behavior,
  * such as what values are looped over in a for..of construct. Some built-in types are built-in iterables
  * with a default iteration behavior, such as Array or Map, while other types (such as Object) are not.
  * @see https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Iteration_protocols
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Iterator[+A] extends js.Object {

  /**
    * A zero arguments function that returns an object with two properties:
    * <ul>
    * <li>done (boolean)</li>
    * <li>value - any JavaScript value returned by the iterator. Can be omitted when done is true.</li>
    * </ul>
    * @return the next value from the iterator
    */
  def next(): Iterator.Entry[A] = js.native

}

/**
  * Iterator Companion
  */
object Iterator {

  /**
    * Implicit conversion for a js.Iterator to Scala Iterator
    * @param jsIt the given JavaScript [[Iterator]]
    */
  implicit def toIterator[T](jsIt: Iterator[T]): scala.Iterator[T] = new IteratorWrapper[T](jsIt)

  /**
    * Iterator Entry
    */
  @js.native
  trait Entry[+A] extends js.Object {

    /**
      * Has the value true if the iterator is past the end of the iterated sequence. In this case value optionally
      * specifies the return value of the iterator. The return values are explained here.
      *
      * Has the value false if the iterator was able to produce the next value in the sequence. This is equivalent of
      * not specifying the done property altogether.
      */
    def done: Boolean = js.native

    /**
      * @return any JavaScript value returned by the iterator.
      */
    def value: A = js.native

  }

  /**
    * Iterator Wrapper
    */
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