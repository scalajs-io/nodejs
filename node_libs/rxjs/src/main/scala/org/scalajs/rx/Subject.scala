package org.scalajs.rx

import scala.scalajs.js

/**
  * Represents an object that is both an observable sequence as well as an observer. Each notification is broadcasted
  * to all subscribed observers.
  *
  * This class inherits both from the Rx.Observable and Rx.Observer classes.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Subject[T] extends Observer with Observable[T] {

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
