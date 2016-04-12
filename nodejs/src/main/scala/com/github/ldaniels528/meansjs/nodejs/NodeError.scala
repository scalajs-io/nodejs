package com.github.ldaniels528.meansjs.nodejs

import scala.scalajs.js

/**
  * Node Error
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait NodeError extends js.Object {
  var message: String
  var code: String
}

