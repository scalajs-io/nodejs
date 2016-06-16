package org.scalajs.angularjs

import scala.scalajs.js

/**
  * AngularJS $compile Service
  * @author lawrence.daniels@gmail.com
  * @see [[https://docs.angularjs.org/api/ng/service/$compile]]
  */
@js.native
trait Compile extends js.Object {

  def apply[T <: Scope](value: Any)(scope: T): Any

  // TODO add other methods here

}
