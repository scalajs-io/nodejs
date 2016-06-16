package org.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Console Dir Options
  * @param showHidden if true then the object's non-enumerable and symbol properties will be shown too. Defaults to false.
  * @param depth      tells util.inspect() how many times to recurse while formatting the object. This is useful for
  *                   inspecting large complicated objects. Defaults to 2. To make it recurse indefinitely, pass null.
  * @param colors     if true, then the output will be styled with ANSI color codes. Defaults to false. Colors are customizable;
  *                   see customizing util.inspect() colors.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ConsoleDirOptions(var showHidden: Boolean = false,
                        var depth: Integer = 2,
                        var colors: Boolean = false) extends js.Object
