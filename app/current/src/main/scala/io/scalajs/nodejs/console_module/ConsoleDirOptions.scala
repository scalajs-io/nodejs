package io.scalajs.nodejs.console_module

import scala.scalajs.js

/**
  * Console Dir Options
  *
  * @param showHidden if true then the object's non-enumerable and symbol properties will be shown too. Defaults to `false`.
  * @param depth      tells util.inspect() how many times to recurse while formatting the object. This is useful for
  *                   inspecting large complicated objects. Defaults to `2`. To make it recurse indefinitely, pass null.
  * @param colors     if true, then the output will be styled with ANSI color codes. Defaults to `false`. Colors are customizable;
  *                   see customizing util.inspect() colors.
  */
class ConsoleDirOptions(var showHidden: js.UndefOr[Boolean] = js.undefined,
                        var depth: js.UndefOr[Int] = js.undefined,
                        var colors: js.UndefOr[Boolean] = js.undefined
) extends js.Object
