package org.scalajs.rx

import scala.scalajs.js

/**
  * Represents the result of an asynchronous operation. The last value before the OnCompleted notification, or the error
  * received through OnError, is sent to all subscribed observers.
  *
  * This class inherits both from the Rx.Observable and Rx.Observer classes.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AsyncSubject[T] extends Observer with Observable[T] {

  /**
    * Unsubscribe all observers and release resources.
    * @example Rx.AsyncSubject.prototype.dispose()
    */
  def dispose(): Unit = js.native

  /**
    * Indicates whether the subject has observers subscribed to it.
    * @return (Boolean): Returns true if the AsyncSubject has observers, else false.
    * @example Rx.AsyncSubject.prototype.hasObservers()
    */
  def hasObservers(): Boolean = js.native

}
