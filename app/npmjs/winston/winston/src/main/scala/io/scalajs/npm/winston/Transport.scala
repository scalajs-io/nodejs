package io.scalajs.npm.winston

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Winston Transport
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal("winston.Transport")
abstract class Transport extends js.Object {

  ///////////////////////////////////////////////////////////////////////////////////////////
  //        Properties
  ///////////////////////////////////////////////////////////////////////////////////////////

  var name: String = js.native

  var level: String = js.native

  ///////////////////////////////////////////////////////////////////////////////////////////
  //        Methods
  ///////////////////////////////////////////////////////////////////////////////////////////

  def handleExceptions(): Unit = js.native

  def log(level: String, message: String, meta: js.Any, callback: js.Function2[WinstonError, Boolean, Any]): Unit = js.native

}

