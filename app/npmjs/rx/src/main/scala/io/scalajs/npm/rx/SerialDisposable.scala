package io.scalajs.npm.rx

import scala.scalajs.js

/**
  * Represents a disposable resource whose underlying disposable resource can be replaced by another disposable resource,
  * causing automatic disposal of the previous underlying disposable resource.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SerialDisposable extends Disposable {

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
    * Gets the underlying disposable.
    * @return (Disposable): The underlying disposable.
    * @example Rx.SerialDisposable.prototype.getDisposable()
    */
  def getDisposable(): Disposable = js.native

  /**
    * Sets the underlying disposable.
    * @param value (Disposable): The new underlying disposable.
    * @example Rx.SerialDisposable.prototype.setDisposable(value)
    */
  def setDisposable(value: Disposable): Unit = js.native

}
