package com.github.ldaniels528.meansjs.core

import scala.language.implicitConversions
import scala.scalajs.js

/**
  * ECMAScript 6 Iterator
  * @see {{{ https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Iteration_protocols }}}
  */
@js.native
trait JsIterator[+A] extends js.Object {

  // TODO replace with the official js.iterator once released - https://github.com/scala-js/scala-js/issues/1141

  /**
    * A zero arguments function that returns an object with two properties:
    * <ul>
    * <li>done (boolean)</li>
    * <li>value - any JavaScript value returned by the iterator. Can be omitted when done is true.</li>
    * </ul>
    * @return
    */
  def next(): JsIterator.Entry[A] = js.native

}

/**
  * Iterator Companion
  */
object JsIterator {

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
  class IteratorWrapper[T](it: JsIterator[T]) extends Iterator[T] {
    private var result = it.next()

    override def hasNext: Boolean = !result.done

    override def next(): T = {
      val value = result.value
      result = it.next()
      value
    }
  }

  /**
    * Implicit conversion for a js.Iterator to Scala Iterator
    */
  implicit def toIterator[T](jsIt: JsIterator[T]): Iterator[T] = new IteratorWrapper[T](jsIt)

}