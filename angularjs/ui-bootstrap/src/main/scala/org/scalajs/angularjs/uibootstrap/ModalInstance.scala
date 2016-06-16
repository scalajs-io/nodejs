package org.scalajs.angularjs.uibootstrap

import scala.scalajs.js

/**
  * AngularJS Modal Instance ($modalInstance)
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ModalInstance[T] extends js.Object {

  def close(): Unit = js.native

  def close(result: T): Unit = js.native

  def dismiss(reason: js.Any): Unit = js.native

  def result: js.Promise[T] = js.native

  def opened: js.Promise[js.Any] = js.native

}
