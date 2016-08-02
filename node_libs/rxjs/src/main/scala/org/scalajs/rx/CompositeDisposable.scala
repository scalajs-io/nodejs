package org.scalajs.rx

import scala.scalajs.js

/**
  * Represents a group of disposable resources that are disposed together.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CompositeDisposable extends Disposable {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Gets a value that indicates whether the object is disposed.
    */
  def isDisposed: Boolean = js.native

  /**
    * Gets the number of disposables in the CompositeDisposable.
    */
  def length: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Adds a disposable to the CompositeDisposable or disposes the disposable if the CompositeDisposable is disposed.
    * @param item (Disposable): Disposable to add.
    * @example Rx.CompositeDisposable.prototype.add(item)
    */
  def add(item: Disposable): Unit = js.native

  /**
    * Removes and disposes the first occurrence of a disposable from the CompositeDisposable.
    * @param item (Disposable): Disposable to remove.
    * @return (Boolean): true if the disposable was found and disposed; otherwise, false.
    * @example Rx.CompositeDisposable.prototype.remove(item)
    */
  def remove(item: Disposable): Boolean = js.native

  /**
    * Converts the existing CompositeDisposable to an array of disposables. Does not dispose the objects.
    * @return (Array): An array of disposable objects.
    * @example Rx.CompositeDisposable.prototype.toarray()
    */
  def toarray(): js.Array[Disposable] = js.native

}
