package io.scalajs.npm.rx

import scala.scalajs.js

/**
  * Represents a disposable resource which only allows a single assignment of its underlying disposable resource.
  * If an underlying disposable resource has already been set, future attempts to set the underlying disposable resource
  * will throw an Error.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SingleAssignmentDisposable extends Disposable {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Gets a value that indicates whether the object is disposed.
    */
  def isDisposed: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Gets the underlying disposable. After disposal, the result of getting this method is undefined.
    * @return (Disposable): The underlying disposable.
    * @example Rx.SingleAssignmentDisposable.prototype.getDisposable()
    */
  def getDisposable(): Disposable = js.native

  /**
    * Sets the underlying disposable.
    * @param value (Disposable): The new underlying disposable.
    * @example Rx.SingleAssignmentDisposable.prototype.setDisposable(value)
    */
  def setDisposable(value: Disposable): Unit = js.native

}
