package com.github.ldaniels528.meansjs.angularjs

import com.github.ldaniels528.meansjs.angularjs.core.Attributes

import scala.scalajs.js

/**
  * AngularJS Directive
  * @author lawrence.daniels@gmail.com
  */
trait Directive[ScopeType] {

  def restrict: String = "E"

  def scope: js.Any = new js.Object()

  def transclude: Boolean = true

  def replace: Boolean = false

  def template: String

  def link(scope: ScopeType, element: JQLite, attrs: Attributes)

}