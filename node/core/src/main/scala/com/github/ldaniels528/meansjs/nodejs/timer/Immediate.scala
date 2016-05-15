package com.github.ldaniels528.meansjs.nodejs.timer

import scala.scalajs.js

/**
  * Immediate Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Immediate extends js.Object {

  def _onImmediate: js.Function = js.native

}
