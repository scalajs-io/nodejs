package com.github.ldaniels528.nodesjs.angularjs.core

import scala.scalajs.js

/**
 * AngularJS Provider
 */
@js.native
trait Provider[T <: js.Object] extends js.Object {

  def $get(): T = js.native

}
