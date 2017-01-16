package io.scalajs.npm.angularjs

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.JSBracketAccess

/**
  * AngularJS Attributes
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Attributes extends js.Object {

  def compile: js.Object

  @JSBracketAccess
  def apply(name: String): UndefOr[String] = js.native

  @JSBracketAccess
  def update(name: String, value: String): Unit = js.native

}
