package org.scalajs.rx

import scala.scalajs.js

/**
  * Disposable Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DisposableClass extends js.Object {

  /**
    * Creates a disposable object that invokes the specified action when disposed.
    * @param action (Function): Function to run during the first call to dispose. The action is guaranteed to be run at most once.
    * @return (Disposable): The disposable object that runs the given action upon disposal.
    * @example Rx.Disposable.create(action)
    */
  def create(action: js.Function): Disposable = js.native

  /**
    * Gets the disposable that does nothing when disposed.
    * @return (Disposable): The disposable that does nothing when disposed.
    */
  def empty: Disposable = js.native

  /**
    * Creates a disposable object that invokes the specified action when disposed.
    * @param d (Object): Object to validate whether it has a dispose method.
    * @return (Boolean): true if is a disposable object, else false.
    * @example Rx.Disposable.isDisposable(d)
    */
  def isDisposable(d: js.Any): Boolean = js.native


}
