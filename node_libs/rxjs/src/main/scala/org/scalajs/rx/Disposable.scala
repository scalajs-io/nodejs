package org.scalajs.rx

import scala.scalajs.js

/**
  * Provides a set of static methods for creating Disposables, which defines a method to release allocated resources.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Disposable extends js.Object {

  /**
    * Performs the task of cleaning up resources.
    * @example Rx.Disposable.prototype.dispose()
    */
  def dispose(): Unit = js.native

}
