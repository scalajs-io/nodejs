package com.github.ldaniels528.nodesjs.angularjs.core

import com.github.ldaniels528.nodesjs.angularjs.Scope

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
