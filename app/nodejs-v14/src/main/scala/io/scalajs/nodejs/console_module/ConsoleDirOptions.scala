package io.scalajs.nodejs.console_module

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait ConsoleDirOptions extends js.Object {

  /** if true then the object's non-enumerable and symbol properties will be shown too. Defaults to `false`.
    */
  var showHidden: js.UndefOr[Boolean] = js.undefined

  /** tells util.inspect() how many times to recurse while formatting the object.
    * This is useful for inspecting large complicated objects.
    * Defaults to `2`.
    * To make it recurse indefinitely, pass null.
    */
  var depth: js.UndefOr[Int] = js.undefined

  /** if true, then the output will be styled with ANSI color codes.
    * Defaults to `false`.
    * Colors are customizable;see customizing util.inspect() colors.
    */
  var colors: js.UndefOr[Boolean] = js.undefined
}
