package com.github.ldaniels528.meansjs.nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Console Dir Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ConsoleDirOptions extends js.Object {

  /** if true then the object's non-enumerable and symbol properties will be shown too. Defaults to false. */
  var showHidden: js.UndefOr[Boolean] = _

  /**
    * tells util.inspect() how many times to recurse while formatting the object. This is useful for inspecting large
    * complicated objects. Defaults to 2. To make it recurse indefinitely, pass null.
    */
  var depth: js.UndefOr[Integer] = _

  /**
    * if true, then the output will be styled with ANSI color codes. Defaults to false. Colors are customizable;
    * see customizing util.inspect() colors.
    */
  var colors: js.UndefOr[Boolean] = _
}

/**
  * Console Dir Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ConsoleDirOptions {

  def apply(showHidden: js.UndefOr[Boolean] = js.undefined,
            depth: js.UndefOr[Integer] = js.undefined,
            colors: js.UndefOr[Boolean] = js.undefined) = {
    val options = new ConsoleDirOptions()
    options.showHidden = showHidden
    options.depth = depth
    options.colors = colors
    options
  }

}