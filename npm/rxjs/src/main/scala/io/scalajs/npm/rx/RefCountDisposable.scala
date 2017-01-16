package io.scalajs.npm.rx

import scala.scalajs.js

/**
  * Represents a disposable resource that only disposes its underlying disposable resource when all getDisposable
  * dependent disposable objects have been disposed.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait RefCountDisposable extends Disposable {

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
    * Returns a dependent disposable that when disposed decreases the refcount on the underlying disposable.
    * @return (Disposable): A dependent disposable contributing to the reference count that manages the underlying disposable's lifetime.
    * @example Rx.RefCountDisposable.prototype.getDisposable()
    */
  def getDisposable(): Disposable = js.native

}
