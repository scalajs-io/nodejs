package io.scalajs.dom.collection

import io.scalajs.collection.{Iterator, JsCollection}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSBracketAccess

/**
  * The arguments object is an Array-like object corresponding to the arguments passed to a function.
  *
  * The arguments object is a local variable available within all functions. You can refer to a function's
  * arguments within the function by using the arguments object. This object contains an entry for each
  * argument passed to the function, the first entry's index starting at 0.
  * @see https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/arguments
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Arguments[A]() extends JsCollection[A] {

  /**
    * Returns the item at the specified index
    * @param index the specified index
    * @return the item at the specified index
    */
  @JSBracketAccess
  override def apply(index: Int): A = js.native

  /**
    * Returns a new Array Iterator object that contains the values for each index in the arguments.
    * @param it the specified [[Iterator]]
    * @return a new Array Iterator object
    */
  @JSBracketAccess
  def apply[T](it: Iterator[T]): Arguments[T] = js.native

  /**
    * Reference to the currently executing function.
    */
  def callee: js.Any = js.native

  /**
    * Reference to the function that invoked the currently executing function.
    */
  def caller: js.Any = js.native

  /**
    * Reference to the number of arguments passed to the function.
    * @return the number of arguments passed
    */
  override def length: Int = js.native

}
