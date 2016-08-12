package org.scalajs.angularjs

import org.scalajs.angularjs.Compile.CompileObject

import scala.scalajs.js

/**
  * Compiles an HTML string or DOM into a template and produces a template function, which can then be used to
  * link scope and the template together.
  * @see [[https://docs.angularjs.org/api/ng/service/$compile]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Compile extends js.Object {

  def apply(value: Any): CompileObject = js.native

}

/**
  * Compile Companion
  * @author lawrence.daniels@gmail.com
  */
object Compile {

  /**
    * Compile Intermediate
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait CompileObject extends js.Object {

    def apply(scope: Scope): js.Any = js.native

  }

}