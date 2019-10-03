package io.scalajs.collection

import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import scala.scalajs.js.annotation.JSBracketAccess

/**
  * JavaScript Collection
  */
@js.native
@deprecated("Use methods in js.Array or other js collections", "0.9.0")
trait JsCollection[A] extends js.Object {

  /**
    * Returns the item at the specified index
    * @param index the specified index
    * @return the item at the specified index
    */
  @JSBracketAccess
  def apply(index: Int): A = js.native

  /**
    * Reference to the number of arguments passed to the function.
    * @return the number of arguments passed
    */
  def length: Int = js.native

}

/**
  * JsCollection Companion
  */
@deprecated("Use methods in js.Array or other js collections", "0.9.0")
object JsCollection {

  /**
    * Implicit conversion for a js.Iterator to Scala Iterator
    */
  @deprecated("Use promise.future", "0.9.0")
  implicit def toIterator[T](collection: JsCollection[T]): scala.Iterator[T] = new JsCollectionWrapper[T](collection)

  /**
    * JavaScript Collection Enrichment
    * @param collection the given [[JsCollection collection]]
    */
  @deprecated("Use methods in js.Array or other js collections", "0.9.0")
  implicit final class JsCollectionEnrichment[T](val collection: JsCollection[T]) extends AnyVal {

    @inline
    def get(index: Int): Option[T] = Option(collection(index))

    @inline
    def headOption: Option[T] = get(0)

    @inline
    def isEmpty: Boolean = collection.length == 0

    @inline
    def nonEmpty: Boolean = collection.length > 0

    @inline
    def toJSArray: js.Array[T] = toSeq.toJSArray

    @inline
    def toSeq: Seq[T] = (0 until collection.length) map collection.apply

  }

  /**
    * JsCollection Iterator Wrapper
    * @param collection the given [[JsCollection]]
    */
  @deprecated("Use methods in js.Array or other js collections", "0.9.0")
  class JsCollectionWrapper[T](collection: JsCollection[T]) extends scala.Iterator[T] {
    private var pos = 0

    override def hasNext: Boolean = pos < collection.length

    override def next(): T = {
      val value = collection(pos)
      pos += 1
      value
    }
  }

}
