package com.cognitect

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * transducers package object
  * @author lawrence.daniels@gmail.com
  */
package object transducers {

  /**
    * Transducers entry-point for browser-based applications
    */
  @js.native
  @JSName("transducers")
  object transducers extends TransducersJs

  @js.native
  @JSName("com.cognitect.transducers.isArray")
  object isArray extends js.Object {
    def apply(value: js.Any): Boolean = js.native
  }

  @js.native
  @JSName("com.cognitect.transducers.isObject")
  object isObject extends js.Object {
    def apply(value: js.Any): Boolean = js.native
  }

  @js.native
  @JSName("com.cognitect.transducers.isString")
  object isString extends js.Object {
    def apply(value: js.Any): Boolean = js.native
  }

  @js.native
  @JSName("com.cognitect.transducers.wrap")
  object wrap extends js.Object {
    def apply[T <: js.Any](value: T): js.Function0[T] = js.native
  }

}
