package io.scalajs.npm

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * transducers package object
  * @author lawrence.daniels@gmail.com
  */
package object transducers {

  /**
    * Transducers entry-point for browser-based applications
    */
  @js.native
  @JSGlobal("transducers")
  object transducers extends TransducersJs

  @js.native
  @JSGlobal("com.cognitect.transducers.isArray")
  object isArray extends js.Object {
    def apply(value: js.Any): Boolean = js.native
  }

  @js.native
  @JSGlobal("com.cognitect.transducers.isObject")
  object isObject extends js.Object {
    def apply(value: js.Any): Boolean = js.native
  }

  @js.native
  @JSGlobal("com.cognitect.transducers.isString")
  object isString extends js.Object {
    def apply(value: js.Any): Boolean = js.native
  }

  @js.native
  @JSGlobal("com.cognitect.transducers.wrap")
  object wrap extends js.Object {
    def apply[T <: js.Any](value: T): js.Function0[T] = js.native
  }

}
