package com.github.ldaniels528.meansjs

import com.github.ldaniels528.meansjs.nodejs.timer._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Node.js Pacakage Object
  * @author lawrence.daniels@gmail.com
  */
package object nodejs {

  @JSName("__dirname")
  @js.native
  object __dirname extends js.Object

  @JSName("Error")
  @js.native
  object Error extends NodeError

  @JSName("module")
  @js.native
  object module extends ModuleObject

  @JSName("process")
  @js.native
  object process extends ProcessObject

  @js.native
  @JSName("require")
  object require extends Require

  /////////////////////////////////////////////////////////////////////////////////
  //      Timers
  /////////////////////////////////////////////////////////////////////////////////

  @js.native
  @JSName("clearImmediate")
  object clearImmediate extends ClearImmediate

  @js.native
  @JSName("clearInterval")
  object clearInterval extends ClearInterval

  @js.native
  @JSName("clearTimeout")
  object clearTimeout extends ClearTimeout

  @js.native
  @JSName("ref")
  object ref extends Ref

  @js.native
  @JSName("setImmediate")
  object setImmediate extends SetImmediate

  @js.native
  @JSName("setInterval")
  object setInterval extends SetInterval

  @js.native
  @JSName("setTimeout")
  object setTimeout extends SetTimeout

  @js.native
  @JSName("unref")
  object unref extends UnRef

}
