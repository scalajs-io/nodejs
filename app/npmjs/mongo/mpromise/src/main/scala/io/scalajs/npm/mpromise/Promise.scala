package io.scalajs.npm.mpromise

import io.scalajs.nodejs.Error

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * mpromise - Promises A+ conformant implementation
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mpromise", JSImport.Namespace)
class Promise[T](fn: js.Function = js.native) extends js.Object {

  /**
    * Allows direct promise to promise chaining (especially useful by a outside aggregating function).
    * It doesn't use the asynchronous resolve algorithm and so excepts only another Promise as it's argument.
    * @param promise the promise to chain
    * @return a new promise
    */
  def chain[U](promise: Promise[U]): Promise[U] = js.native

  /**
    * Signifies that this promise was the last in a chain of then()s: if a handler passed to the call to then
    * which produced this promise throws, the exception be rethrown. You can pass an OnReject handler to end
    * so that exceptions will be handled (like a final catch clause); This method returns it's promise for
    * easy use with return.
    */
  def end(): Unit = js.native

  /**
    * Fulfills the promise
    * @param result the given result
    */
  def fulfill(result: T): Unit = js.native

  /**
    * Called when the promise has been fulfilled.
    * @param callback the callback
    */
  def onFulfill(callback: js.Function1[T, Any]): Unit = js.native

  /**
    * Called if the promise has been rejected.
    * @param callback the callback
    */
  def onReject(callback: js.Function1[String, Any]): Unit = js.native

  /**
    * Called when the promise has been resolved.
    * @param callback the callback
    */
  def onResolve(callback: js.Function2[Error, T, Any]): Unit = js.native

  /**
    * Rejects a promise with a reason
    * @param reason the given reason
    */
  def reject(reason: String): Unit = js.native

  /**
    * Resolves the promise
    * @param reason the given reason
    * @param args   the optional arguments
    */
  def resolve(reason: String, args: js.Any*): Unit = js.native

  /**
    * Creates a new promise and returns it. If onFulfill or onReject are passed,
    * they are added as SUCCESS/ERROR callbacks to this promise after the nextTick.
    * @param callback the callback
    */
  def `then`[U](callback: js.Function1[T, U], onFailure: js.Function1[Error, Any] = js.native): this.type = js.native

}
