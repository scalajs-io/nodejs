package io.scalajs.npm.mongoose

import scala.scalajs.js

/**
  * Schema Property
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SchemaProperty extends js.Object {

  def default(value: js.Function1[Unit, Any]): Unit = js.native

  def get[A](name: String): A = js.native

  def set[A](f: js.Function1[A, A]): Unit = js.native

}
