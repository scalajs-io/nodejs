package com.github.ldaniels528.meansjs.nodejs

import com.github.ldaniels528.meansjs.nodejs.JsIterator.IteratorResult

import scala.scalajs.js

/**
  * JavaScript Iterator
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait JsIterator extends js.Object {

  // TODO replace with offical js.iterator once released - https://github.com/scala-js/scala-js/issues/1141

  def next(): IteratorResult = js.native

}

/**
  * Iterator Companion
  * @author lawrence.daniels@gmail.com
  */
object JsIterator {

  /**
    * Iterator Result
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait IteratorResult extends js.Object {

    def value: js.UndefOr[js.Any] = js.native

    def done: Boolean = js.native

  }

  /**
    * Iterator Result Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class IteratorResultExtensions(val result: IteratorResult) extends AnyVal {

    def valueAs[T <: js.Any]: js.UndefOr[T] = result.value.map(_.asInstanceOf[T])

  }

}