package io.scalajs.npm.winston

import scala.scalajs.js

/**
  * Winston Log Message
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait LogMessage extends js.Object {

  var durationMs: Int = js.native

  var level: String = js.native

  var message: String = js.native

  var timestamp: js.Date = js.native

  var transport: js.Array[String] = js.native

}
